package org.bayon.ogm.datastore.mapper;

import com.google.appengine.api.datastore.Entity;

/**
 * Created by nm on 7/6/17.
 */
public class JPADomainMapper<T> implements Mapper<T> {

    @Override
    public T mapToDomain(Entity entity, Class<T> clazz) {
        return null;
    }

    @Override
    public Entity mapToEntity(T domain, Class<T> clazz) {
        return null;
    }
}
