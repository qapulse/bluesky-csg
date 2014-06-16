package com.pearson.qa.bluesky.csg.books.updateBookBuild.contexts;

import com.google.inject.Inject;
import com.pearson.qa.bluesky.csg.Utils.datastructures.ErrorResponse;
import com.pearson.qa.bluesky.csg.books.updateBookBuild.datastructures.UpdateBookBuildRequestPayload;
import com.pearson.qa.bluesky.csg.books.updateBookBuild.datastructures.UpdateBookBuildResponsePayload;
import com.pearson.qa.common.configuration.Configuration;
import com.pearson.qa.common.ziggyfw.http.contexts.HttpContext;

/**
 * Created by didiercorrales on 3/9/14.
 */
public class  UpdateBookBuildContext extends HttpContext {
    UpdateBookBuildRequestPayload requestPayload;
    UpdateBookBuildResponsePayload responsePayload;
    ErrorResponse errorResponsePayload;

    public UpdateBookBuildContext() {
        super();
        setRequestPayload(new UpdateBookBuildRequestPayload());
        this.setRequestMethod("PUT");
        this.setRequestContentType("application/json");
    }

    @Inject
    public void setConfiguration(Configuration configuration)
    {
        super.setConfiguration(configuration);
        this.configuration = configuration;
        if (this.configuration != null){
            String configNameSpace = configuration.getConfigNamespace(UpdateBookBuildContext.class);
            String scheme = configuration.getString(configNameSpace, "scheme", "http");
            this.setRequestScheme(scheme);
            String host = configuration.getString(configNameSpace, "host", "");
            this.setRequestHost(host);
            String path = configuration.getString(configNameSpace, "path", "set API url correctly");
            this.setRequestPath(path);
        }
    }

    public UpdateBookBuildRequestPayload getRequestPayload() {
        return requestPayload;
    }

    public void setRequestPayload(UpdateBookBuildRequestPayload requestPayload) {
        this.requestPayload = requestPayload;
    }

    public UpdateBookBuildResponsePayload getResponsePayload() {
        return responsePayload;
    }

    public void setResponsePayload(UpdateBookBuildResponsePayload responsePayload) {
        this.responsePayload = responsePayload;
    }

    public ErrorResponse getErrorResponsePayload() {
        return errorResponsePayload;
    }

    public void setErrorResponsePayload(ErrorResponse errorResponsePayload) {
        this.errorResponsePayload = errorResponsePayload;
    }
}
