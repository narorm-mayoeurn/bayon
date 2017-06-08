package org.bayon.ogm.datastore.mapper;

import com.google.appengine.api.datastore.Entity;

/**
 * Created by nm on 7/6/17.
 */
public class JPAMappingAdapter<T> extends ReflectionMappingAdapter<T> {

    @Override
    public T map(Entity entity, Class<T> clazz) {
        return super.map(entity, clazz);
    }

    @Override
    public Entity map(T domain, Class<T> clazz) {
        return super.map(domain, clazz);
    }
}
