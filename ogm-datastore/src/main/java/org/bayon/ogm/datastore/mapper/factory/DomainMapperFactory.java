package org.bayon.ogm.datastore.mapper.factory;

import org.bayon.ogm.datastore.mapper.Mapper;
import org.bayon.ogm.datastore.mapper.DomainMapper;

/**
 * Created by nm on 7/6/17.
 */
public final class DomainMapperFactory<T> implements MapperFactory<T> {

    @Override
    public Mapper<T> getMapper() {
        return new DomainMapper<>();
    }
}
