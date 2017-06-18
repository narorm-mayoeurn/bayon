package com.camhub.antiochschool.repository;

import com.camhub.antiochschool.domain.Program;
import org.bayon.ogm.datastore.DatastoreRepository;

/**
 * Created by nm on 16/6/17.
 */
public interface ProgramRepository extends DatastoreRepository<Program> {

    Program findByName(String name);
}
