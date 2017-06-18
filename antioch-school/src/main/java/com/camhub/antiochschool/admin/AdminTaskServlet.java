package com.camhub.antiochschool.admin;

import com.camhub.antiochschool.admin.task.SingletonTaskFactory;
import com.camhub.antiochschool.admin.task.TaskFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by nm on 16/6/17.
 */
public class AdminTaskServlet extends HttpServlet {

    private TaskFactory factory;

    @Override
    public void init() throws ServletException {
        factory = SingletonTaskFactory.getInstance();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        factory.getTask(req.getParameter("task")).doTask(req, resp);
    }
}
