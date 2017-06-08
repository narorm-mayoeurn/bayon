package org.bayon.ogm.datastore.mapper.factory;

import org.bayon.ogm.datastore.mapper.DataGridMapper;

/**
 * Created by nm on 7/6/17.
 */
public interface DataGridMapperFactory<T> {

    DataGridMapper<T> getDataGridMapper();
}
