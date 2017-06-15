package org.bayon.ogm.datastore;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import org.bayon.ogm.datastore.mapper.DataGridMapper;
import org.bayon.ogm.datastore.mapper.factory.DataGridMapperFactory;
import org.bayon.ogm.datastore.mapper.factory.DefaultDataGridMapperFactory;
import org.bayon.ogm.datastore.query.Page;
import org.bayon.ogm.datastore.query.QueryBuilder;
import org.bayon.ogm.datastore.query.TypeQuery;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

public class DatastoreRepositoryAdapter<T> implements DatastoreRepository<T> {

    protected Class<T> clazz;
    protected DataGridMapper<T> dataGridMapper;
    protected DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

    public DatastoreRepositoryAdapter() {
        ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
        clazz = (Class<T>) type.getActualTypeArguments()[0];

        DataGridMapperFactory factory = DefaultDataGridMapperFactory.getFactory();
        dataGridMapper = factory.getDataGridMapper(clazz);
    }

    public void setDataGridMapper(DataGridMapper<T> dataGridMapper) {
        this.dataGridMapper = dataGridMapper;
    }

    public T findById(Long id)  {
        try {
            Key key = KeyFactory.createKey(clazz.getSimpleName(), id);
            return dataGridMapper.map(datastore.get(key), clazz);
        } catch (EntityNotFoundException e) {
            return null;
        }
    }

    public Long create(T domain) {
        Entity entity = dataGridMapper.map(domain, clazz);
        datastore.put(entity);
        return entity.getKey().getId();
    }

    public void update(T domain) {
        Entity entity = dataGridMapper.map(domain, clazz);
        datastore.put(entity);
    }

    public void remove(Long id) {
        datastore.delete(KeyFactory.createKey(clazz.getSimpleName(), id));
    }

    public QueryBuilder<T> createQueryBuilder() {
        return new QueryBuilder<>(clazz);
    }

    @Override
    public T findOne(TypeQuery query) {
        return dataGridMapper.map(datastore.prepare(query.getQuery()).asSingleEntity(), clazz);
    }

    @Override
    public List<T> find(TypeQuery query) {
        List<T> domains = new ArrayList<>();
        for (Entity entity : datastore.prepare(query.getQuery()).asIterable()) {
            domains.add(dataGridMapper.map(entity, clazz));
        }
        return domains;
    }

    @Override
    public Page<T> find(TypeQuery query, int offset, int limit) {
        List<T> domains = new ArrayList<>();
        for (Entity entity : datastore.prepare(query.getQuery()).asList(FetchOptions.Builder.withOffset(offset).limit(limit))) {
            domains.add(dataGridMapper.map(entity, clazz));
        }

        int total = 0;
        try {
            TypeQuery keyOnlyTypeQuery = (TypeQuery) query.clone();
            keyOnlyTypeQuery.setKeyOnly(true);
            total = datastore.prepare(keyOnlyTypeQuery.getQuery()).asList(FetchOptions.Builder.withDefaults()).size();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return new Page<>(domains, offset, limit, total);
    }
}
