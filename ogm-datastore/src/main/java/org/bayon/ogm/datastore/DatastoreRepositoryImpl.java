package org.bayon.ogm.datastore;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import org.bayon.ogm.datastore.mapper.factory.JPADomainMappingAdapterFactory;
import org.bayon.ogm.datastore.mapper.factory.MappingAdapterFactory;
import org.bayon.ogm.datastore.mapper.factory.DomainMappingAdapterFactory;

import java.lang.reflect.ParameterizedType;

public class DatastoreRepositoryImpl<T> implements DatastoreRepository<T> {

    private Class<T> clazz;
    private MappingAdapterFactory<T> mapperFactory;
    private DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

    public DatastoreRepositoryImpl() {
        ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
        clazz = (Class<T>) type.getActualTypeArguments()[0];

        if (clazz.isAnnotationPresent(javax.persistence.Entity.class)) {
            mapperFactory = new JPADomainMappingAdapterFactory<>();
        } else {
            mapperFactory = new DomainMappingAdapterFactory<>();
        }
    }

    public void setMapperFactory(MappingAdapterFactory<T> mappingAdapterFactory) {
        this.mapperFactory = mappingAdapterFactory;
    }

    public T findById(Long id)  {
        try {
            Key key = KeyFactory.createKey(clazz.getSimpleName(), id);
            return mapperFactory.getMappingAdapter().map(datastore.get(key), clazz);
        } catch (EntityNotFoundException e) {
            return null;
        }
    }

    public Long create(T domain) {
        Entity entity = mapperFactory.getMappingAdapter().map(domain, clazz);
        datastore.put(entity);
        return entity.getKey().getId();
    }

    public void update(T domain) {
        Entity entity = mapperFactory.getMappingAdapter().map(domain, clazz);
        datastore.put(entity);
    }

    public void remove(Long id) {
        datastore.delete(KeyFactory.createKey(clazz.getSimpleName(), id));
    }
}
