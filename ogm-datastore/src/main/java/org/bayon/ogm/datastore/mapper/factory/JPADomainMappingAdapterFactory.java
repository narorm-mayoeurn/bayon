package org.bayon.ogm.datastore.mapper.factory;

import org.bayon.ogm.datastore.mapper.MappingAdapter;
import org.bayon.ogm.datastore.mapper.JPAMappingAdapter;

/**
 * Created by nm on 7/6/17.
 */
public class JPADomainMappingAdapterFactory<T> implements MappingAdapterFactory<T> {

    @Override
    public MappingAdapter<T> getMappingAdapter() {
        return new JPAMappingAdapter<>();
    }
}
