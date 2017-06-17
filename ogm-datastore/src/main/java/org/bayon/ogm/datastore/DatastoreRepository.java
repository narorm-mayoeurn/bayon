package org.bayon.ogm.datastore;

import com.google.appengine.api.datastore.Query;
import org.bayon.ogm.datastore.query.Page;
import org.bayon.ogm.datastore.query.QueryBuilder;
import org.bayon.ogm.datastore.query.TypeQuery;

import java.util.List;

public interface DatastoreRepository<T> {

    T findById(Long id);

    Long create(T domain);

    void update(T domain);

    void remove(Long id);

    QueryBuilder<T> createQueryBuilder();

    T findOne(TypeQuery query);

    List<T> find(TypeQuery query);

    Page<T> find(int offset, int limit);

    Page<T> find(TypeQuery query, int offset, int limit);
}