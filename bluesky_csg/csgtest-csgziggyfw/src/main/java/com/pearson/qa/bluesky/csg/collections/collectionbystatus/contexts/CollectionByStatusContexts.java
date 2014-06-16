package com.pearson.qa.bluesky.csg.collections.collectionbystatus.contexts;

import com.pearson.qa.bluesky.csg.Utils.datastructures.ErrorResponse;
import com.pearson.qa.bluesky.csg.collections.collectionbystatus.datastructures.CollectionByStatusRequestPayload;
import com.pearson.qa.bluesky.csg.collections.collectionbystatus.datastructures.CollectionByStatusResponsePayload;
import com.pearson.qa.common.configuration.Configuration;
import com.pearson.qa.common.ziggyfw.http.contexts.HttpContext;

import javax.inject.Inject;

/**
 * Created by brian on 3/22/14.
 */
public class  CollectionByStatusContexts extends HttpContext {
    CollectionByStatusResponsePayload responsePayload;
    ErrorResponse errorResponsePayload;

    public CollectionByStatusContexts() {
        super();
        this.setRequestMethod("GET");
        this.setRequestContentType("application/json");
    }

    @Inject
    public void setConfiguration(Configuration configuration)
    {
        super.setConfiguration(configuration);
        this.configuration = configuration;
        if (this.configuration != null){
            String configNameSpace = configuration.getConfigNamespace(CollectionByStatusContexts.class);
            String scheme = configuration.getString(configNameSpace, "scheme", "http");
            this.setRequestScheme(scheme);
            String host = configuration.getString(configNameSpace, "host", "");
            this.setRequestHost(host);
            String path = configuration.getString(configNameSpace, "path", "set API url correctly");
            this.setRequestPath(path);
        }
    }

    public void setErrorResponsePayload(ErrorResponse errorResponsePayload) {
        this.errorResponsePayload = errorResponsePayload;
    }

    public void setResponsePayload(CollectionByStatusResponsePayload responsePayload) {
        this.responsePayload = responsePayload;
    }

    public ErrorResponse getErrorResponsePayload() {
        return errorResponsePayload;
    }

    public CollectionByStatusResponsePayload getResponsePayload() {
        return responsePayload;


    }

    public String getStatus(){

        return responsePayload.getStatus();
    }

}