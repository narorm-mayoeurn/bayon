package org.bayon.ogm.datastore;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import org.bayon.ogm.datastore.mapper.factory.JPADomainMapperFactory;
import org.bayon.ogm.datastore.mapper.factory.MapperFactory;
import org.bayon.ogm.datastore.mapper.factory.DomainMapperFactory;

import java.lang.reflect.ParameterizedType;
import java.util.Collection;

public class DatastoreRepositoryImpl<T> implements DatastoreRepository<T> {

    private Class<T> clazz;
    private MapperFactory<T> mapperFactory;
    private DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

    public DatastoreRepositoryImpl() {
        ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
        clazz = (Class<T>) type.getActualTypeArguments()[0];


        if (clazz.isAnnotationPresent(javax.persistence.Entity.class)) {
            mapperFactory = new JPADomainMapperFactory<>();
        } else {
            mapperFactory = new DomainMapperFactory<>();
        }
    }

    public void setMapperFactory(MapperFactory<T> mapperFactory) {
        this.mapperFactory = mapperFactory;
    }

    public T findById(Long id)  {
        try {
            Key key = KeyFactory.createKey(clazz.getSimpleName(), id);
            return mapperFactory.getMapper().mapToDomain(datastore.get(key), clazz);
        } catch (EntityNotFoundException e) {
            return null;
        }
    }

    public Long create(T domain) {
        Entity entity = mapperFactory.getMapper().mapToEntity(domain, clazz);
        datastore.put(entity);
        return entity.getKey().getId();
    }

    public void update(T domain) {
        Entity entity = mapperFactory.getMapper().mapToEntity(domain, clazz);
        datastore.put(entity);
    }

    public void remove(Long id) {
        datastore.delete(KeyFactory.createKey(clazz.getSimpleName(), id));
    }

    public Collection<T> findByFields(T domain) {
        return null;
    }
}
