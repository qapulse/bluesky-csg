package com.pearson.qa.bluesky.csg.authentication.login.contexts;

import com.google.inject.Inject;
import com.pearson.qa.common.configuration.Configuration;
import com.pearson.qa.bluesky.csg.authentication.login.datastructures.Login;
import com.pearson.qa.bluesky.csg.authentication.login.datastructures.LoginResponse;
import com.pearson.qa.common.ziggyfw.http.contexts.HttpContext;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.ParseException;
import org.apache.http.message.BasicHeader;
import com.pearson.qa.bluesky.csg.Utils.datastructures.ErrorResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: dcorrales
 * Date: 2/5/14
 * Time: 4:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class LoginContext extends HttpContext {



    /*
     * Login data structure
     */
     Login loginPayload;

    /*
     * Login response data structure
     */
    LoginResponse loginResponsePayload;
    ErrorResponse errorResponsePayload;

    public LoginContext() {

        super();

        setLoginPayload(new Login());
        this.setRequestMethod("POST");
        this.setRequestContentType("application/json");
    }

    public ErrorResponse getErrorResponsePayload() {
        return errorResponsePayload;
    }

    public void setErrorResponsePayload(ErrorResponse errorResponsePayload) {
        this.errorResponsePayload = errorResponsePayload;
    }


    @Inject
    public void setConfiguration(Configuration configuration)
    {
        super.setConfiguration(configuration);
        this.configuration = configuration;


        if (this.configuration != null)
        {
            String configNameSpace = configuration.getConfigNamespace(LoginContext.class);
            String scheme = configuration.getString(configNameSpace, "scheme", "http");
            this.setRequestScheme(scheme);
            String host = configuration.getString(configNameSpace, "host", "");
            this.setRequestHost(host);
            String path = configuration.getString(configNameSpace, "path", "/authentication/login");
            this.setRequestPath(path);
        }
    }

    public Login getLoginPayload() {
        return loginPayload;
    }

    public void setLoginPayload(Login loginPayload) {
        this.loginPayload = loginPayload;
    }

    public LoginResponse getLoginResponsePayload() {
        return loginResponsePayload;
    }

    public void setLoginResponsePayload(LoginResponse loginResponsePayload) {
        this.loginResponsePayload = loginResponsePayload;
    }
    public void setLoginResponsePayload(ErrorResponse loginResponsePayload) {
        this.errorResponsePayload = loginResponsePayload;
    }
}
