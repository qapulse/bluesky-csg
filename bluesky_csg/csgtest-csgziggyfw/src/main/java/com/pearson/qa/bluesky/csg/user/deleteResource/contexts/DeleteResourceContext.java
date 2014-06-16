package com.pearson.qa.bluesky.csg.user.deleteResource.contexts;

import com.google.inject.Inject;
import com.pearson.qa.bluesky.csg.Utils.datastructures.ErrorResponse;
import com.pearson.qa.common.configuration.Configuration;
import com.pearson.qa.common.ziggyfw.http.contexts.HttpContext;

public class DeleteResourceContext extends HttpContext {

    ErrorResponse errorResponsePayload;

    public DeleteResourceContext() {
        super();
        this.setRequestMethod("Delete");
        this.setRequestContentType("application/json");
    }

    @Inject
    public void setConfiguration(Configuration configuration) {
        super.setConfiguration(configuration);
        this.configuration = configuration;
        if (this.configuration != null) {
            String configNameSpace = configuration.getConfigNamespace(DeleteResourceContext.class);
            String scheme = configuration.getString(configNameSpace, "scheme", "http");
            this.setRequestScheme(scheme);
            String host = configuration.getString(configNameSpace, "host", "");
            this.setRequestHost(host);
            String path = configuration.getString(configNameSpace, "path", "set API url correctly");
            this.setRequestPath(path);
        }
    }

    public ErrorResponse getErrorResponsePayload() {
        return errorResponsePayload;
    }

    public void setErrorResponsePayload(ErrorResponse errorResponsePayload) {
        this.errorResponsePayload = errorResponsePayload;
    }
}
