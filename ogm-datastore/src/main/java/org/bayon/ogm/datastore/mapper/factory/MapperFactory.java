package org.bayon.ogm.datastore.mapper.factory;

import org.bayon.ogm.datastore.mapper.Mapper;

/**
 * Created by nm on 7/6/17.
 */
public interface MapperFactory<T> {

    Mapper<T> getMapper();
}
