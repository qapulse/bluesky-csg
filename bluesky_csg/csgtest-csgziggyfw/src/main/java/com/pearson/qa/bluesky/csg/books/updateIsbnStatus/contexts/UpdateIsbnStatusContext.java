package com.pearson.qa.bluesky.csg.books.updateIsbnStatus.contexts;

import com.google.inject.Inject;
import com.pearson.qa.bluesky.csg.Utils.datastructures.ErrorResponse;
import com.pearson.qa.bluesky.csg.books.updateIsbnStatus.datastructures.UpdateIsbnStatusRequestPayload;
import com.pearson.qa.bluesky.csg.books.updateIsbnStatus.datastructures.UpdateIsbnStatusResponsePayload;
import com.pearson.qa.common.configuration.Configuration;
import com.pearson.qa.common.ziggyfw.http.contexts.HttpContext;

/**
 * Created by didiercorrales on 3/9/14.
 */
public class  UpdateIsbnStatusContext extends HttpContext {
    UpdateIsbnStatusRequestPayload requestPayload;
    UpdateIsbnStatusResponsePayload responsePayload;
    ErrorResponse errorResponsePayload;

    public UpdateIsbnStatusContext() {
        super();
        setRequestPayload(new UpdateIsbnStatusRequestPayload());
        this.setRequestMethod("PUT");
        this.setRequestContentType("application/json");
    }

    @Inject
    public void setConfiguration(Configuration configuration)
    {
        super.setConfiguration(configuration);
        this.configuration = configuration;
        if (this.configuration != null){
            String configNameSpace = configuration.getConfigNamespace(UpdateIsbnStatusContext.class);
            String scheme = configuration.getString(configNameSpace, "scheme", "http");
            this.setRequestScheme(scheme);
            String host = configuration.getString(configNameSpace, "host", "");
            this.setRequestHost(host);
            String path = configuration.getString(configNameSpace, "path", "set API url correctly");
            this.setRequestPath(path);
        }
    }


    public UpdateIsbnStatusRequestPayload getRequestPayload() {
        return requestPayload;
    }

    public void setRequestPayload(UpdateIsbnStatusRequestPayload requestPayload) {
        this.requestPayload = requestPayload;
    }

    public UpdateIsbnStatusResponsePayload getResponsePayload() {
        return responsePayload;
    }

    public void setResponsePayload(UpdateIsbnStatusResponsePayload responsePayload) {
        this.responsePayload = responsePayload;
    }

    public ErrorResponse getErrorResponsePayload() {
        return errorResponsePayload;
    }

    public void setErrorResponsePayload(ErrorResponse errorResponsePayload) {
        this.errorResponsePayload = errorResponsePayload;
    }
}