package com.pearson.qa.bluesky.csg.books.approveISBNs.contexts;

import com.google.inject.Inject;
import com.pearson.qa.bluesky.csg.Utils.datastructures.ErrorResponse;
import com.pearson.qa.bluesky.csg.books.approveISBNs.datastructures.ApproveISBNRequestPayload;
import com.pearson.qa.bluesky.csg.books.approveISBNs.datastructures.ApproveIsbnResponsePayload;
import com.pearson.qa.common.configuration.Configuration;
import com.pearson.qa.common.ziggyfw.http.contexts.HttpContext;

/**
 * Created by didiercorrales on 3/4/14.
 */
public class  ApproveIsbnContext extends HttpContext {
    ApproveIsbnResponsePayload responsePayload;
    ApproveISBNRequestPayload requestPayload;
    ErrorResponse errorResponsePayload;

    public ApproveIsbnContext() {
        super();

        setRequestPayload(new ApproveISBNRequestPayload());
        this.setRequestMethod("PUT");
        this.setRequestContentType("application/json");
    }

    @Inject
    public void setConfiguration(Configuration configuration)
    {
        super.setConfiguration(configuration);
        this.configuration = configuration;
        if (this.configuration != null){
            String configNameSpace = configuration.getConfigNamespace(ApproveIsbnContext.class);
            String scheme = configuration.getString(configNameSpace, "scheme", "http");
            this.setRequestScheme(scheme);
            String host = configuration.getString(configNameSpace, "host", "");
            this.setRequestHost(host);
            String path = configuration.getString(configNameSpace, "path", "set API url correctly");
            this.setRequestPath(path);
        }
    }

    public ApproveISBNRequestPayload getRequestPayload() {
        return requestPayload;
    }

    public void setRequestPayload(ApproveISBNRequestPayload requestPayload) {
        this.requestPayload = requestPayload;
    }

    public ApproveIsbnResponsePayload getResponsePayload() {
        return responsePayload;
    }

    public void setResponsePayload(ApproveIsbnResponsePayload responsePayload) {
        this.responsePayload = responsePayload;
    }

    public ErrorResponse getErrorResponsePayload() {
        return errorResponsePayload;
    }

    public void setErrorResponsePayload(ErrorResponse errorResponsePayload) {
        this.errorResponsePayload = errorResponsePayload;
    }
}