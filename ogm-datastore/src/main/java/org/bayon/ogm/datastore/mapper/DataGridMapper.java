package org.bayon.ogm.datastore.mapper;

import com.google.appengine.api.datastore.Entity;

/**
 * Created by nm on 7/6/17.
 */
public interface DataGridMapper<T> {
    String __ID_PROPERTY__ = "id";

    T map(Entity entity, Class<T> clazz);
    Entity map(T domain, Class<T> clazz);
}
