package com.camhub.antiochschool.repository;

import com.camhub.antiochschool.domain.Invoice;
import com.camhub.antiochschool.domain.Student;
import com.camhub.antiochschool.service.InvoiceObserver;
import org.bayon.ogm.datastore.DatastoreRepositoryAdapter;
import org.bayon.ogm.datastore.query.Filter;
import org.bayon.ogm.datastore.query.QueryBuilder;
import org.bayon.ogm.datastore.query.QueryBuilderImpl;

/**
 * Created by nm on 9/6/17.
 */
public class StudentRepositoryImpl extends DatastoreRepositoryAdapter<Student> implements StudentRepository, InvoiceObserver {

    StudentRepositoryImpl() {

    }


    @Override
    public void updateInvoice(Invoice invoice) {

        if(invoice.getArchived()) {
            QueryBuilder builder = createQueryBuilder();
            builder.and("invoiceId", Filter.Operator.EQUAL, invoice.getId());

            Student student = findOne(builder.toQuery());

            if (student != null) {
                student.setInvoiceId(null);
                update(student);

            }
        }
    }
}
