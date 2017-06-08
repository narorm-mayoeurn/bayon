package org.bayon.ogm.datastore;

import java.util.Collection;

public interface DatastoreRepository<T> {

    T findById(Long id);

    Long create(T domain);

    void update(T domain);

    void remove(Long id);

    Collection<T> findByFields(T domain);
}