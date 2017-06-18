package org.bayon.web.security.http;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * Created by nm on 18/6/17.
 */
public class TrimmingParametersHttpServletRequest extends HttpServletRequestWrapper {

    public TrimmingParametersHttpServletRequest(HttpServletRequest request) {
        super(request);
    }

    @Override
    public String getParameter(String name) {
        String parameter = super.getParameter(name);
        if (parameter == null) {
            return parameter;
        }
        return parameter.trim();
    }

    @Override
    public String[] getParameterValues(String name) {
        String[] parameters = super.getParameterValues(name);
        if (parameters == null || parameters.length == 0) {
            return parameters;
        }

        String[] trimmingParameters = new String[parameters.length];
        for (int i = 0; i < trimmingParameters.length; i++) {
            trimmingParameters[i] = parameters[i].trim();
        }
        return trimmingParameters;
    }
}
