package com.camhub.antiochschool.repository;

import com.camhub.antiochschool.domain.Invoice;
import com.camhub.antiochschool.domain.Teacher;
import com.camhub.antiochschool.service.InvoiceObserver;
import com.camhub.antiochschool.service.ObserverSubject;
import com.camhub.antiochschool.service.TeacherObserver;
import org.bayon.ogm.datastore.DatastoreRepositoryAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chandara Leang on 6/15/2017.
 */
public class TeacherRepositoryImpl extends DatastoreRepositoryAdapter<Teacher> implements TeacherRepository, ObserverSubject<TeacherObserver> {

    private Teacher teacher;
    private List<TeacherObserver> observers = new ArrayList<>();

    TeacherRepositoryImpl() {
    }


    @Override
    public synchronized void remove(Long id) {
        teacher = findById(id);
        teacher.setArchived(true);
        update(teacher);
        notifyObservers();
    }

    @Override
    public void attach(TeacherObserver observer) {
        if(!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    @Override
    public void detach(TeacherObserver observer) {
        if(observers.contains(observer)) {
            observers.remove(observer);
        }
    }

    @Override
    public void notifyObservers() {
        for(TeacherObserver observer : observers) {
            observer.updateTeacher(teacher);
        }
    }
}
