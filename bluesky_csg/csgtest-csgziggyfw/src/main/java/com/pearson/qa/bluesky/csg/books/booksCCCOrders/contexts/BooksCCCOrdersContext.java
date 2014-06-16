package com.pearson.qa.bluesky.csg.books.booksCCCOrders.contexts;

import com.google.inject.Inject;
import com.pearson.qa.bluesky.csg.Utils.datastructures.ErrorResponse;
import com.pearson.qa.bluesky.csg.books.booksCCCOrders.datastructures.BooksCCCOrdersResponsePayload;
import com.pearson.qa.common.configuration.Configuration;
import com.pearson.qa.common.ziggyfw.http.contexts.HttpContext;

/**
 * Created by didiercorrales on 2/26/14.
 */
public class  BooksCCCOrdersContext extends HttpContext {
    BooksCCCOrdersResponsePayload responsePayload;
    ErrorResponse errorResponsePayload;

    public BooksCCCOrdersContext() {
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
            String configNameSpace = configuration.getConfigNamespace(BooksCCCOrdersContext.class);
            String scheme = configuration.getString(configNameSpace, "scheme", "http");
            this.setRequestScheme(scheme);
            String host = configuration.getString(configNameSpace, "host", "");
            this.setRequestHost(host);
            String path = configuration.getString(configNameSpace, "path", "set API url correctly");
            this.setRequestPath(path);
        }
    }


    public BooksCCCOrdersResponsePayload getResponsePayload() {
        return responsePayload;
    }

    public void setResponsePayload(BooksCCCOrdersResponsePayload responsePayload) {
        this.responsePayload = responsePayload;
    }

    public ErrorResponse getErrorResponsePayload() {
        return errorResponsePayload;
    }

    public void setErrorResponsePayload(ErrorResponse errorResponsePayload) {
        this.errorResponsePayload = errorResponsePayload;
    }
}