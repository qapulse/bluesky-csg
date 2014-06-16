package com.pearson.qa.bluesky.csg.taxonomies.collectionsByTaxonomyCourse.contexts;

import com.google.inject.Inject;
import com.pearson.qa.bluesky.csg.Utils.datastructures.ErrorResponse;
import com.pearson.qa.bluesky.csg.taxonomies.collectionsByTaxonomyCourse.datastructures.CollectionsByTaxonomyCourseResponsePayload;
import com.pearson.qa.common.configuration.Configuration;
import com.pearson.qa.common.ziggyfw.http.contexts.HttpContext;

/**
 * Created by didiercorrales on 3/29/14.
 */
public class  CollectionsByTaxonomyCourseContext extends HttpContext {
    CollectionsByTaxonomyCourseResponsePayload responsePayload;
    ErrorResponse errorResponsePayload;

    public CollectionsByTaxonomyCourseContext() {
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
            String configNameSpace = configuration.getConfigNamespace(CollectionsByTaxonomyCourseContext.class);
            String scheme = configuration.getString(configNameSpace, "scheme", "http");
            this.setRequestScheme(scheme);
            String host = configuration.getString(configNameSpace, "host", "");
            this.setRequestHost(host);
            String path = configuration.getString(configNameSpace, "path", "set API url correctly");
            this.setRequestPath(path);
        }
    }


    public CollectionsByTaxonomyCourseResponsePayload getResponsePayload() {
        return responsePayload;
    }

    public void setResponsePayload(CollectionsByTaxonomyCourseResponsePayload responsePayload) {
        this.responsePayload = responsePayload;
    }

    public ErrorResponse getErrorResponsePayload() {
        return errorResponsePayload;
    }

    public void setErrorResponsePayload(ErrorResponse errorResponsePayload) {
        this.errorResponsePayload = errorResponsePayload;
    }
}

