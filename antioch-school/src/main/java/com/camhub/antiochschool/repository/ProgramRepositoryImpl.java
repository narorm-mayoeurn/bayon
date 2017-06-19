package com.camhub.antiochschool.repository;

import com.camhub.antiochschool.domain.Program;
import org.bayon.ogm.datastore.DatastoreRepositoryAdapter;
import org.bayon.ogm.datastore.query.Filter;
import org.bayon.ogm.datastore.query.QueryBuilder;
import org.bayon.ogm.datastore.query.QueryBuilderImpl;

/**
 * Created by nm on 16/6/17.
 */
public class ProgramRepositoryImpl extends DatastoreRepositoryAdapter<Program> implements ProgramRepository {

    ProgramRepositoryImpl() {

    }

    @Override
    public Program findByName(String name) {
        QueryBuilder builder = createQueryBuilder();
        builder.and("name", Filter.Operator.EQUAL, name);
        return findOne(builder.toQuery());
    }
}
