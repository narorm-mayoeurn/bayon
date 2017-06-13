package org.bayon.ogm.datastore;

import com.google.appengine.api.datastore.Query;
import org.bayon.ogm.datastore.query.QueryBuilder;

import java.util.List;

public interface DatastoreRepository<T> {

    T findById(Long id);

    Long create(T domain);

    void update(T domain);

    void remove(Long id);

    QueryBuilder<T> createQueryBuilder();

    T findOne(Query query);

    List<T> find(Query query);

    List<T> find(Query query, int offset, int limit);
}