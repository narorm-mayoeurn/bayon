package org.bayon.ogm.datastore.mapper.factory;

import org.bayon.ogm.datastore.mapper.MappingAdapter;

/**
 * Created by nm on 7/6/17.
 */
public interface MappingAdapterFactory<T> {

    MappingAdapter<T> getMappingAdapter();
}
