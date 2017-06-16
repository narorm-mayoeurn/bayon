package com.camhub.antiochschool.command.teacher;

import org.bayon.web.FrontCommand;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Created by darith on 6/14/17.
 */
public class TeacherListCommand extends FrontCommand {

    @Override
    public void execute() throws ServletException, IOException {

    }

    @Override
    protected void responseAsHtml() throws ServletException, IOException {
        super.responseAsHtml();
        forward("teacher-list");
    }
}
