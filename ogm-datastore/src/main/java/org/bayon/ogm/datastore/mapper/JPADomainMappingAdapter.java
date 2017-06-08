package org.bayon.ogm.datastore.mapper;

import com.google.appengine.api.datastore.Entity;

/**
 * Created by nm on 7/6/17.
 */
public class JPADomainMappingAdapter<T> implements MappingAdapter<T> {

    @Override
    public T map(Entity entity, Class<T> clazz) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Entity map(T domain, Class<T> clazz) {
        throw new UnsupportedOperationException();
    }
}
