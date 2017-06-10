package org.bayon.ogm.datastore.mapper.factory;

import org.bayon.ogm.datastore.mapper.DataGridMapper;
import org.bayon.ogm.datastore.mapper.JPADataGridMapper;
import org.bayon.ogm.datastore.mapper.ReflectionDataGridMapper;

/**
 * Created by nm on 7/6/17.
 */
public final class DefaultDataGridMapperFactory implements DataGridMapperFactory {

    private static final DataGridMapperFactory INSTANCE = new DefaultDataGridMapperFactory();

    private DefaultDataGridMapperFactory() {}

    public static DataGridMapperFactory getFactory() {
        return INSTANCE;
    }

    @Override
    public <T> DataGridMapper<T> getDataGridMapper(Class<T> clazz) {
        if (clazz.isAnnotationPresent(javax.persistence.Entity.class)) {
            return new JPADataGridMapper<>();
        } else {
            return new ReflectionDataGridMapper<>();
        }
    }
}
