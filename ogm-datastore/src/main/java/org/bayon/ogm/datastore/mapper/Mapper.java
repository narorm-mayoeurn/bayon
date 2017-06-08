package org.bayon.ogm.datastore.mapper;

import com.google.appengine.api.datastore.Entity;

/**
 * Created by nm on 7/6/17.
 */
public interface Mapper<T> {
    String __ID_PROPERTY__ = "id";

    T mapToDomain(Entity entity, Class<T> clazz);
    Entity mapToEntity(T domain, Class<T> clazz);
}
