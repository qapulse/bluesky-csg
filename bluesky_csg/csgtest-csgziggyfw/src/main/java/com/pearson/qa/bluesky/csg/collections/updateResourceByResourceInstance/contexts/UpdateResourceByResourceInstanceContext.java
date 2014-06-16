package com.pearson.qa.bluesky.csg.collections.updateResourceByResourceInstance.contexts;

import com.google.inject.Inject;
import com.pearson.qa.bluesky.csg.Utils.datastructures.ErrorResponse;
import com.pearson.qa.bluesky.csg.collections.updateResourceByResourceInstance.datastructures.UpdateResourceByResourceInstanceRequestPayload;
import com.pearson.qa.bluesky.csg.collections.updateResourceByResourceInstance.datastructures.UpdateResourceByResourceInstanceResponsePayload;
import com.pearson.qa.common.configuration.Configuration;
import com.pearson.qa.common.ziggyfw.http.contexts.HttpContext;

public class UpdateResourceByResourceInstanceContext extends HttpContext {
    UpdateResourceByResourceInstanceRequestPayload requestPayload;
    UpdateResourceByResourceInstanceResponsePayload responsePayload;
    ErrorResponse errorResponsePayload;

    public UpdateResourceByResourceInstanceContext() {
        super();
        setRequestPayload(new UpdateResourceByResourceInstanceRequestPayload());
        this.setRequestMethod("PUT");
        this.setRequestContentType("application/json");
    }

    @Inject
    public void setConfiguration(Configuration configuration) {
        super.setConfiguration(configuration);
        this.configuration = configuration;
        if (this.configuration != null) {
            String configNameSpace = configuration.getConfigNamespace(UpdateResourceByResourceInstanceContext.class);
            String scheme = configuration.getString(configNameSpace, "scheme", "http");
            this.setRequestScheme(scheme);
            String host = configuration.getString(configNameSpace, "host", "");
            this.setRequestHost(host);
            String path = configuration.getString(configNameSpace, "path", "set API url correctly");
            this.setRequestPath(path);
        }
    }


    public UpdateResourceByResourceInstanceRequestPayload getRequestPayload() {
        return requestPayload;
    }

    public void setRequestPayload(UpdateResourceByResourceInstanceRequestPayload requestPayload) {
        this.requestPayload = requestPayload;
    }

    public UpdateResourceByResourceInstanceResponsePayload getResponsePayload() {
        return responsePayload;
    }

    public void setResponsePayload(UpdateResourceByResourceInstanceResponsePayload responsePayload) {
        this.responsePayload = responsePayload;
    }

    public ErrorResponse getErrorResponsePayload() {
        return errorResponsePayload;
    }

    public void setErrorResponsePayload(ErrorResponse errorResponsePayload) {
        this.errorResponsePayload = errorResponsePayload;
    }
}
