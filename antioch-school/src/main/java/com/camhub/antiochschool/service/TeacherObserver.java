package com.camhub.antiochschool.service;

import com.camhub.antiochschool.domain.Invoice;
import com.camhub.antiochschool.domain.Teacher;

/**
 * Created by darith on 6/15/17.
 */
public interface TeacherObserver {
    public void updateInvoice(Teacher teacher);
}
