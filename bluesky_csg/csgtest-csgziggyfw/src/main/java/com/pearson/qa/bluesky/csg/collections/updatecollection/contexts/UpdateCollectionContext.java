package com.pearson.qa.bluesky.csg.collections.updatecollection.contexts;

import com.google.inject.Inject;
import com.pearson.qa.bluesky.csg.Utils.datastructures.ErrorResponse;
import com.pearson.qa.bluesky.csg.collections.updatecollection.datastructures.UpdateCollectionRequestPayload;
import com.pearson.qa.bluesky.csg.collections.updatecollection.datastructures.UpdateCollectionResponsePayload;
import com.pearson.qa.common.configuration.Configuration;
import com.pearson.qa.common.ziggyfw.http.contexts.HttpContext;

/**
 * Created by brian on 3/13/14.
 */
public class  UpdateCollectionContext extends HttpContext {
    UpdateCollectionRequestPayload requestPayload;
    UpdateCollectionResponsePayload responsePayload;
    ErrorResponse errorResponsePayload;

    public UpdateCollectionContext() {
        super();
        setRequestPayload(new UpdateCollectionRequestPayload());
        this.setRequestMethod("PUT");
        this.setRequestContentType("application/json");
    }

    

    @Inject
    public void setConfiguration(Configuration configuration)
    {
        super.setConfiguration(configuration);
        this.configuration = configuration;
        if (this.configuration != null){
            String configNameSpace = configuration.getConfigNamespace(UpdateCollectionContext.class);
            String scheme = configuration.getString(configNameSpace, "scheme", "http");
            this.setRequestScheme(scheme);
            String host = configuration.getString(configNameSpace, "host", "");
            this.setRequestHost(host);
            String path = configuration.getString(configNameSpace, "path", "set API url correctly");
            this.setRequestPath(path);
        }
    }


    public void setRequestPayload(UpdateCollectionRequestPayload requestPayload) {
        this.requestPayload = requestPayload;
    }

    public void setResponsePayload(UpdateCollectionResponsePayload responsePayload) {
        this.responsePayload = responsePayload;
    }

    public void setErrorResponsePayload(ErrorResponse errorResponsePayload) {
        this.errorResponsePayload = errorResponsePayload;
    }

    public ErrorResponse getErrorResponsePayload() {
        return errorResponsePayload;
    }

    public UpdateCollectionResponsePayload getResponsePayload() {
        return responsePayload;
    }

    public UpdateCollectionRequestPayload getRequestPayload() {
        return requestPayload;
    }
    

}
