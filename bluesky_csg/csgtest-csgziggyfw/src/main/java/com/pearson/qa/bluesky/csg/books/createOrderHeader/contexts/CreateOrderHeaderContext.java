package com.pearson.qa.bluesky.csg.books.createOrderHeader.contexts;

import com.google.inject.Inject;
import com.pearson.qa.bluesky.csg.Utils.datastructures.ErrorResponse;
import com.pearson.qa.bluesky.csg.books.createOrderHeader.datastructures.CreateOrderHeaderRequestPayload;
import com.pearson.qa.bluesky.csg.books.createOrderHeader.datastructures.CreateOrderHeaderResponsePayload;
import com.pearson.qa.common.configuration.Configuration;
import com.pearson.qa.common.ziggyfw.http.contexts.HttpContext;

/**
 * Created with IntelliJ IDEA.
 * User: dcorrales
 * Date: 2/19/14
 * Time: 9:42 AM
 * To change this template use File | Settings | File Templates.
 */
public class CreateOrderHeaderContext extends HttpContext {

    CreateOrderHeaderRequestPayload requestPayload ;
    CreateOrderHeaderResponsePayload responsePayload;

    ErrorResponse errorResponsePayload;

    public CreateOrderHeaderContext() {

        super();

        setRequestPayload (new CreateOrderHeaderRequestPayload());
        this.setRequestMethod("POST");
        this.setRequestContentType("application/json");

    }

    @Inject
    public void setConfiguration(Configuration configuration)
    {
        super.setConfiguration(configuration);
        this.configuration = configuration;


        if (this.configuration != null)
        {
            String configNameSpace = configuration.getConfigNamespace(CreateOrderHeaderContext.class);
            String scheme = configuration.getString(configNameSpace, "scheme", "http");
            this.setRequestScheme(scheme);
            String host = configuration.getString(configNameSpace, "host", "");
            this.setRequestHost(host);
            String path = configuration.getString(configNameSpace, "path", "/books/orders");
            this.setRequestPath(path);
        }
    }

    public ErrorResponse getErrorResponsePayload() {
        return errorResponsePayload;
    }

    public void setErrorResponsePayload(ErrorResponse errorResponsePayload) {
        this.errorResponsePayload = errorResponsePayload;
    }

    public CreateOrderHeaderRequestPayload getRequestPayload() {
        return requestPayload;
    }

    public void setRequestPayload(CreateOrderHeaderRequestPayload requestPayload) {
        this.requestPayload = requestPayload;
    }

    public CreateOrderHeaderResponsePayload getResponsePayload() {
        return responsePayload;
    }

    public void setResponsePayload(CreateOrderHeaderResponsePayload responsePayload) {
        this.responsePayload = responsePayload;
    }


}
