package com.pearson.qa.bluesky.csg.books.schoolTerritoryAssociation.contexts;

import com.google.inject.Inject;
import com.pearson.qa.bluesky.csg.Utils.datastructures.ErrorResponse;
import com.pearson.qa.bluesky.csg.books.schoolTerritoryAssociation.dataproviders.SchoolTerritoryAssociationResponsePayload;
import com.pearson.qa.common.configuration.Configuration;
import com.pearson.qa.common.ziggyfw.http.contexts.HttpContext;

/**
 * Created by dcorrales on 2/25/14.
 */
public class  SchoolTerritoryAssociationContext extends HttpContext {
    SchoolTerritoryAssociationResponsePayload responsePayload;
    ErrorResponse errorResponsePayload;

    public SchoolTerritoryAssociationContext() {
        super();
        this.setRequestMethod("Get");
        this.setRequestContentType("application/json");
    }

    @Inject
    public void setConfiguration(Configuration configuration)
    {
        super.setConfiguration(configuration);
        this.configuration = configuration;
        if (this.configuration != null){
            String configNameSpace = configuration.getConfigNamespace(SchoolTerritoryAssociationContext.class);
            String scheme = configuration.getString(configNameSpace, "scheme", "http");
            this.setRequestScheme(scheme);
            String host = configuration.getString(configNameSpace, "host", "");
            this.setRequestHost(host);
            String path = configuration.getString(configNameSpace, "path", "set API url correctly");
            this.setRequestPath(path);
        }
    }


    public SchoolTerritoryAssociationResponsePayload getResponsePayload() {
        return responsePayload;
    }

    public void setResponsePayload(SchoolTerritoryAssociationResponsePayload responsePayload) {
        this.responsePayload = responsePayload;
    }

    public ErrorResponse getErrorResponsePayload() {
        return errorResponsePayload;
    }

    public void setErrorResponsePayload(ErrorResponse errorResponsePayload) {
        this.errorResponsePayload = errorResponsePayload;
    }
}
