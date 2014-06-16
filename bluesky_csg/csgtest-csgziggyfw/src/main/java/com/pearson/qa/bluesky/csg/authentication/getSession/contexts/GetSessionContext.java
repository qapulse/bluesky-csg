package com.pearson.qa.bluesky.csg.authentication.getSession.contexts;

import com.google.inject.Inject;
import com.pearson.qa.bluesky.csg.Utils.datastructures.ErrorResponse;
import com.pearson.qa.bluesky.csg.authentication.getSession.datastructures.GetSessionResponsePayload;
import com.pearson.qa.common.configuration.Configuration;
import com.pearson.qa.common.ziggyfw.http.contexts.HttpContext;

/**
 * Created by dcorrales on 2/27/14.
 */
public class GetSessionContext  extends HttpContext{
    GetSessionResponsePayload responsePayload;
    ErrorResponse errorResponsePayload;

    public GetSessionContext() {

        super();
        this.setRequestMethod("GET");
        this.setRequestContentType("application/json");
    }



    @Inject
    public void setConfiguration(Configuration configuration)
    {
        super.setConfiguration(configuration);
        this.configuration = configuration;


        if (this.configuration != null)
        {
            String configNameSpace = configuration.getConfigNamespace(GetSessionContext.class);
            String scheme = configuration.getString(configNameSpace, "scheme", "http");
            this.setRequestScheme(scheme);
            String host = configuration.getString(configNameSpace, "host", "");
            this.setRequestHost(host);
            String path = configuration.getString(configNameSpace, "path", "/authentication/login");
            this.setRequestPath(path);
        }
    }

    public GetSessionResponsePayload getResponsePayload() {
        return responsePayload;
    }

    public void setResponsePayload(GetSessionResponsePayload responsePayload) {
        this.responsePayload = responsePayload;
    }

    public ErrorResponse getErrorResponsePayload() {
        return errorResponsePayload;
    }

    public void setErrorResponsePayload(ErrorResponse errorResponsePayload) {
        this.errorResponsePayload = errorResponsePayload;
    }
}
