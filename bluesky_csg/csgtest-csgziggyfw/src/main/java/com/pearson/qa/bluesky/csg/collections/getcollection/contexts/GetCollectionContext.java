package com.pearson.qa.bluesky.csg.collections.getcollection.contexts;


import com.google.inject.Inject;
import com.pearson.qa.bluesky.csg.Utils.datastructures.ErrorResponse;
import com.pearson.qa.bluesky.csg.collections.getcollection.datastructures.GetCollectionResponsePayload;
import com.pearson.qa.common.configuration.Configuration;
import com.pearson.qa.common.ziggyfw.http.contexts.HttpContext;


/**
 * Created by brian on 3/9/14.
 */
public class  GetCollectionContext extends HttpContext {
    GetCollectionResponsePayload responsePayload;
    ErrorResponse errorResponsePayload;

    public GetCollectionContext() {
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
            String configNameSpace = configuration.getConfigNamespace(GetCollectionContext.class);
            String scheme = configuration.getString(configNameSpace, "scheme", "http");
            this.setRequestScheme(scheme);
            String host = configuration.getString(configNameSpace, "host", "");
            this.setRequestHost(host);
            String path = configuration.getString(configNameSpace, "path", "set API url correctly");
            this.setRequestPath(path);
        }
    }


    public String getCollectionId(){

        return   responsePayload.getCollectionId();
    }

    public String getTitle(){

        return responsePayload.getTitle();
    }


    public void setErrorResponsePayload(ErrorResponse errorResponsePayload) {
        this.errorResponsePayload = errorResponsePayload;
    }

    public void setResponsePayload(GetCollectionResponsePayload responsePayload) {
        this.responsePayload = responsePayload;
    }

    public GetCollectionResponsePayload getResponsePayload() {
        return responsePayload;
    }
}