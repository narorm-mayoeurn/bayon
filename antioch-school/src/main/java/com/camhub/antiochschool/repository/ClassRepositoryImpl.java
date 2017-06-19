package com.camhub.antiochschool.repository;

import com.camhub.antiochschool.domain.Class;
import com.camhub.antiochschool.domain.Teacher;
import com.camhub.antiochschool.service.TeacherObserver;
import org.bayon.ogm.datastore.DatastoreRepositoryAdapter;
import org.bayon.ogm.datastore.query.Filter;
import org.bayon.ogm.datastore.query.QueryBuilder;

import java.util.List;

/**
 * Created by nm on 9/6/17.
 */
public class ClassRepositoryImpl extends DatastoreRepositoryAdapter<Class> implements ClassRepository, TeacherObserver {

    ClassRepositoryImpl() {
    }

    @Override
    public void updateInvoice(Teacher teacher) {

        if (teacher.getArchived()) {

            QueryBuilder builder = createQueryBuilder();
            builder.and("teacherId", Filter.Operator.EQUAL, teacher.getId());

            List<Class> classes = find(builder.toQuery());

            if (!classes.isEmpty()) {
                for (Class cls : classes) {
                    cls.setTeacherId(null);
                    update(cls);

                }
            }
        }

    }
}
