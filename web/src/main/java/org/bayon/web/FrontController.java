package org.bayon.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by darith on 6/13/17.
 */
public abstract class FrontController extends HttpServlet {

    private FrontCommand frontCommand;


    public void init() throws ServletException {
        getCommandPackage();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);

        frontCommand = getCommand(req);
        frontCommand.execute();
    }

    private FrontCommand getCommand(HttpServletRequest req) {
        try {
            String name = getCommandName(req);
            return CommandClassMapper.getInstance().getCommandClass(name).asSubclass(FrontCommand.class).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return new UnknownCommand();
    }

    public String getCommandName(HttpServletRequest req) {
        return (String)req.getAttribute("com");
    }


    public abstract String getCommandPackage();
}
