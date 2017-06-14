package com.camhub.antiochschool;

import com.camhub.antiochschool.command.HomeCommand;
import org.bayon.web.CommandClassMapper;
import org.bayon.web.FrontController;

/**
 * Created by darith on 6/14/17.
 */
public class FrontControllerImp extends FrontController {

    @Override
    public void registerCommandClass() {
        register("home", HomeCommand.class);
    }

    @Override
    public String getCommandPackage() {
        return "com.comhub.antiochschool";
    }

}
