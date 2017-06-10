package org.bayon.ogm.datastore;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import org.bayon.ogm.datastore.mapper.DataGridMapper;
import org.bayon.ogm.datastore.mapper.factory.DataGridMapperFactory;
import org.bayon.ogm.datastore.mapper.factory.DefaultDataGridMapperFactory;

import java.lang.reflect.ParameterizedType;

public class DatastoreRepositoryAdapter<T> implements DatastoreRepository<T> {

    protected Class<T> clazz;
    protected DataGridMapper<T> dataGridMapper;
    protected DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

    public DatastoreRepositoryAdapter() {
        ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
        clazz = (Class<T>) type.getActualTypeArguments()[0];

        DataGridMapperFactory factory = DefaultDataGridMapperFactory.getFactory();
        dataGridMapper = factory.getDataGridMapper(clazz);
    }

    public void setDataGridMapper(DataGridMapper<T> dataGridMapper) {
        this.dataGridMapper = dataGridMapper;
    }

    public T findById(Long id)  {
        try {
            Key key = KeyFactory.createKey(clazz.getSimpleName(), id);
            return dataGridMapper.map(datastore.get(key), clazz);
        } catch (EntityNotFoundException e) {
            return null;
        }
    }

    public Long create(T domain) {
        Entity entity = dataGridMapper.map(domain, clazz);
        datastore.put(entity);
        return entity.getKey().getId();
    }

    public void update(T domain) {
        Entity entity = dataGridMapper.map(domain, clazz);
        datastore.put(entity);
    }

    public void remove(Long id) {
        datastore.delete(KeyFactory.createKey(clazz.getSimpleName(), id));
    }
}
