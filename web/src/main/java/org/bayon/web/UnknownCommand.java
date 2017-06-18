package org.bayon.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by darith on 6/13/17.
 */

public class UnknownCommand extends FrontCommand {


    @Override
    public void execute() {

    }

    @Override
    protected void responseAsHtml() throws ServletException, IOException {
        super.responseAsHtml();

        forward("404");
    }
}
