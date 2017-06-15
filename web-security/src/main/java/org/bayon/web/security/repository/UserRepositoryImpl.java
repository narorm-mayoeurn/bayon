package org.bayon.web.security.repository;

import org.bayon.ogm.datastore.DatastoreRepositoryAdapter;
import org.bayon.ogm.datastore.query.Filter;
import org.bayon.ogm.datastore.query.QueryBuilder;
import org.bayon.web.security.domain.User;

/**
 * Created by nm on 14/6/17.
 */
public class UserRepositoryImpl extends DatastoreRepositoryAdapter<User> implements UserRepository {

    @Override
    public User findByUsername(String username) {
        QueryBuilder queryBuilder = createQueryBuilder();
        queryBuilder.and("username", Filter.Operator.EQUAL, username);
        return findOne(queryBuilder.toQuery());
    }
}
