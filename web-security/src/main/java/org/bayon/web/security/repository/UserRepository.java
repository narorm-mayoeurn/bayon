package org.bayon.web.security.repository;

import org.bayon.ogm.datastore.DatastoreRepository;
import org.bayon.web.security.domain.User;

/**
 * Created by nm on 14/6/17.
 */
public interface UserRepository extends DatastoreRepository<User> {

    User findByUsername(String username);
}
