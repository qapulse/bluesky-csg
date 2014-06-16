package com.pearson.qa.bluesky.csg.authentication.profile.contexts;

import com.google.inject.Inject;
import com.pearson.qa.bluesky.csg.Utils.datastructures.ErrorResponse;
import com.pearson.qa.bluesky.csg.authentication.profile.datastructures.ProfileResponsePayload;
import com.pearson.qa.common.configuration.Configuration;
import com.pearson.qa.common.ziggyfw.http.contexts.HttpContext;

/**
 * Created with IntelliJ IDEA.
 * User: dcorrales
 * Date: 2/5/14
 * Time: 4:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class ProfileContext extends HttpContext {


    ProfileResponsePayload responsePayload;
    ErrorResponse errorResponsePayload;

    public ProfileContext() {

        super();
        this.setRequestMethod("POST");
        this.setRequestContentType("application/json");
    }



    @Inject
    public void setConfiguration(Configuration configuration)
    {
        super.setConfiguration(configuration);
        this.configuration = configuration;


        if (this.configuration != null)
        {
            String configNameSpace = configuration.getConfigNamespace(ProfileContext.class);
            String scheme = configuration.getString(configNameSpace, "scheme", "http");
            this.setRequestScheme(scheme);
            String host = configuration.getString(configNameSpace, "host", "");
            this.setRequestHost(host);
            String path = configuration.getString(configNameSpace, "path", "/authentication/login");
            this.setRequestPath(path);
        }
    }

    public ProfileResponsePayload getResponsePayload() {
        return responsePayload;
    }

    public void setResponsePayload(ProfileResponsePayload responsePayload) {
        this.responsePayload = responsePayload;
    }

    public ErrorResponse getErrorResponsePayload() {
        return errorResponsePayload;
    }

    public void setErrorResponsePayload(ErrorResponse errorResponsePayload) {
        this.errorResponsePayload = errorResponsePayload;
    }
}
