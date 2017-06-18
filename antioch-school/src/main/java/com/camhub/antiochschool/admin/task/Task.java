package com.camhub.antiochschool.admin.task;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by nm on 17/6/17.
 */
public interface Task {
    void doTask(HttpServletRequest req, HttpServletResponse res);
}
