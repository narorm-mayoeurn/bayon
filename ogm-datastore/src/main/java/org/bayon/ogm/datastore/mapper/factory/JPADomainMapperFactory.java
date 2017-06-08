package org.bayon.ogm.datastore.mapper.factory;

import org.bayon.ogm.datastore.mapper.Mapper;
import org.bayon.ogm.datastore.mapper.JPADomainMapper;

/**
 * Created by nm on 7/6/17.
 */
public class JPADomainMapperFactory<T> implements MapperFactory<T> {

    @Override
    public Mapper<T> getMapper() {
        return new JPADomainMapper<>();
    }
}
