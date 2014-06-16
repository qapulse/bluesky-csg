package com.pearson.qa.bluesky.csg.collections.resourcescollection.contexts;

import com.google.inject.Inject;
import com.pearson.qa.bluesky.csg.Utils.datastructures.ErrorResponse;
import com.pearson.qa.bluesky.csg.collections.resourcescollection.datastructures.ResourcesByCollectionPayload;
import com.pearson.qa.bluesky.csg.collections.resourcescollection.datastructures.ResourcesByCollectionResponse;
import com.pearson.qa.common.configuration.Configuration;
import com.pearson.qa.common.ziggyfw.http.contexts.HttpContext;


/**
 * Created by brian on 2/26/14.
 */
public class ResourcesByCollection extends HttpContext {

    ResourcesByCollectionPayload requestPayload;

    ResourcesByCollectionResponse responsePayload;

    ErrorResponse errorResponsePayload;



    public ResourcesByCollection() {

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
            String configNameSpace = configuration.getConfigNamespace(ResourcesByCollection.class);
            String scheme = configuration.getString(configNameSpace, "scheme", "http");
            this.setRequestScheme(scheme);
            String host = configuration.getString(configNameSpace, "host", "");
            this.setRequestHost(host);
            String path = configuration.getString(configNameSpace, "path", "/authentication/login");
            this.setRequestPath(path);
        }
    }

    public String getCollectionId(){

      return   responsePayload.getCollectionId();
    }

    public String getTitle(){

        return responsePayload.getTitle();
    }

    public ResourcesByCollectionPayload getRequestPayload() {
        return requestPayload;
    }

    public void setRequestPayload(ResourcesByCollectionPayload requestPayload) {
        this.requestPayload = requestPayload;
    }

    public ResourcesByCollectionResponse getResponsePayload() {
        return responsePayload;
    }

    public void setResponsePayload(ResourcesByCollectionResponse responsePayload) {
        this.responsePayload = responsePayload;
    }

    public ErrorResponse getErrorResponsePayload() {
        return errorResponsePayload;
    }

    public void setErrorResponsePayload(ErrorResponse errorResponsePayload) {
        this.errorResponsePayload = errorResponsePayload;
    }
}


