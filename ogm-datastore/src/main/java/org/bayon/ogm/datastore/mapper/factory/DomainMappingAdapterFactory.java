package org.bayon.ogm.datastore.mapper.factory;

import org.bayon.ogm.datastore.mapper.MappingAdapter;
import org.bayon.ogm.datastore.mapper.DomainMappingAdapter;

/**
 * Created by nm on 7/6/17.
 */
public class DomainMappingAdapterFactory<T> implements MappingAdapterFactory<T> {

    @Override
    public MappingAdapter<T> getMappingAdapter() {
        return new DomainMappingAdapter<>();
    }
}
