package com.pearson.qa.bluesky.csg.user.createUserResource.contexts;

import com.google.inject.Inject;
import com.pearson.qa.bluesky.csg.Utils.datastructures.ErrorResponse;
import com.pearson.qa.bluesky.csg.user.createUserResource.datastructures.CreateUserResourceRequestPayload;
import com.pearson.qa.bluesky.csg.user.createUserResource.datastructures.CreateUserResourceResponsePayload;
import com.pearson.qa.common.configuration.Configuration;
import com.pearson.qa.common.ziggyfw.http.contexts.HttpContext;

public class CreateUserResourceContext extends HttpContext {
    CreateUserResourceRequestPayload requestPayload;
    CreateUserResourceResponsePayload responsePayload;
    ErrorResponse errorResponsePayload;

    public CreateUserResourceContext() {
        super();
        setRequestPayload(new CreateUserResourceRequestPayload());
        this.setRequestMethod("POST");
        this.setRequestContentType("application/json");
    }

    @Inject
    public void setConfiguration(Configuration configuration) {
        super.setConfiguration(configuration);
        this.configuration = configuration;
        if (this.configuration != null) {
            String configNameSpace = configuration.getConfigNamespace(CreateUserResourceContext.class);
            String scheme = configuration.getString(configNameSpace, "scheme", "http");
            this.setRequestScheme(scheme);
            String host = configuration.getString(configNameSpace, "host", "");
            this.setRequestHost(host);
            String path = configuration.getString(configNameSpace, "path", "set API url correctly");
            this.setRequestPath(path);
        }
    }

    public CreateUserResourceRequestPayload getRequestPayload() {
        return requestPayload;
    }

    public void setRequestPayload(CreateUserResourceRequestPayload requestPayload) {
        this.requestPayload = requestPayload;
    }

    public CreateUserResourceResponsePayload getResponsePayload() {
        return responsePayload;
    }

    public void setResponsePayload(CreateUserResourceResponsePayload responsePayload) {
        this.responsePayload = responsePayload;
    }

    public ErrorResponse getErrorResponsePayload() {
        return errorResponsePayload;
    }

    public void setErrorResponsePayload(ErrorResponse errorResponsePayload) {
        this.errorResponsePayload = errorResponsePayload;
    }
}