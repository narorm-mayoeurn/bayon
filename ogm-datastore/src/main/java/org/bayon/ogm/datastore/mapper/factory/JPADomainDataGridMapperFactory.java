package org.bayon.ogm.datastore.mapper.factory;

import org.bayon.ogm.datastore.mapper.DataGridMapper;
import org.bayon.ogm.datastore.mapper.JPADataGridMapper;

/**
 * Created by nm on 7/6/17.
 */
public class JPADomainDataGridMapperFactory<T> implements DataGridMapperFactory<T> {

    @Override
    public DataGridMapper<T> getDataGridMapper() {
        return new JPADataGridMapper<>();
    }
}
