package com.camhub.antiochschool.command;

import org.bayon.web.FrontCommand;

import java.io.IOException;

/**
 * Created by darith on 6/14/17.
 */
public class HomeCommand extends FrontCommand {

    @Override
    public void execute() {
        try {
            response.getWriter().print("hello hello");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
