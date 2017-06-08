package org.bayon.ogm.datastore;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import org.bayon.ogm.datastore.mapper.factory.JPADomainDataGridMapperFactory;
import org.bayon.ogm.datastore.mapper.factory.DataGridMapperFactory;
import org.bayon.ogm.datastore.mapper.factory.ReflectionDataGridMapperFactory;

import java.lang.reflect.ParameterizedType;

public class DatastoreRepositoryAdapter<T> implements DatastoreRepository<T> {

    protected Class<T> clazz;
    protected DataGridMapperFactory<T> dataGridMapperFactory;
    protected DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

    public DatastoreRepositoryAdapter() {
        ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
        clazz = (Class<T>) type.getActualTypeArguments()[0];

        if (clazz.isAnnotationPresent(javax.persistence.Entity.class)) {
            dataGridMapperFactory = new JPADomainDataGridMapperFactory<>();
        } else {
            dataGridMapperFactory = new ReflectionDataGridMapperFactory<>();
        }
    }

    public void setDataGridMapperFactory(DataGridMapperFactory<T> dataGridMapperFactory) {
        this.dataGridMapperFactory = dataGridMapperFactory;
    }

    public T findById(Long id)  {
        try {
            Key key = KeyFactory.createKey(clazz.getSimpleName(), id);
            return dataGridMapperFactory.getDataGridMapper().map(datastore.get(key), clazz);
        } catch (EntityNotFoundException e) {
            return null;
        }
    }

    public Long create(T domain) {
        Entity entity = dataGridMapperFactory.getDataGridMapper().map(domain, clazz);
        datastore.put(entity);
        return entity.getKey().getId();
    }

    public void update(T domain) {
        Entity entity = dataGridMapperFactory.getDataGridMapper().map(domain, clazz);
        datastore.put(entity);
    }

    public void remove(Long id) {
        datastore.delete(KeyFactory.createKey(clazz.getSimpleName(), id));
    }
}
