package org.bayon.ogm.datastore;

public interface DatastoreRepository<T> {

    T findById(Long id);

    Long create(T domain);

    void update(T domain);

    void remove(Long id);
}