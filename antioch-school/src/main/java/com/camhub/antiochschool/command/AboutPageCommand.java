package com.camhub.antiochschool.command;

import org.bayon.web.FrontCommand;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Created by darith on 6/14/17.
 */
public class AboutPageCommand extends FrontCommand {

    @Override
    public void execute() throws ServletException, IOException {
        forward("about");
    }

}
