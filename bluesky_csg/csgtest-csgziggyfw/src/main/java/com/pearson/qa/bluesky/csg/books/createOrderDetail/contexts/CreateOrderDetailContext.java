package com.pearson.qa.bluesky.csg.books.createOrderDetail.contexts;

import com.google.inject.Inject;
import com.pearson.qa.bluesky.csg.Utils.datastructures.ErrorResponse;
import com.pearson.qa.bluesky.csg.books.createOrderDetail.datastructures.CreateOrderDetailRequestPayload;
import com.pearson.qa.bluesky.csg.books.createOrderDetail.datastructures.CreateOrderDetailResponsePayload;
import com.pearson.qa.common.configuration.Configuration;
import com.pearson.qa.common.ziggyfw.http.contexts.HttpContext;

/**
 * Created by didiercorrales on 2/26/14.
 */
public class  CreateOrderDetailContext extends HttpContext {
    CreateOrderDetailRequestPayload requestPayload;
    CreateOrderDetailResponsePayload responsePayload;
    ErrorResponse errorResponsePayload;

    public CreateOrderDetailContext() {
        super();
        setRequestPayload(new CreateOrderDetailRequestPayload());
        this.setRequestMethod("POST");
        this.setRequestContentType("application/json");
    }

    @Inject
    public void setConfiguration(Configuration configuration)
    {
        super.setConfiguration(configuration);
        this.configuration = configuration;
        if (this.configuration != null){
            String configNameSpace = configuration.getConfigNamespace(CreateOrderDetailContext.class);
            String scheme = configuration.getString(configNameSpace, "scheme", "http");
            this.setRequestScheme(scheme);
            String host = configuration.getString(configNameSpace, "host", "");
            this.setRequestHost(host);
            String path = configuration.getString(configNameSpace, "path", "set API url correctly");
            this.setRequestPath(path);
        }
    }


    public CreateOrderDetailRequestPayload getRequestPayload() {
        return requestPayload;
    }

    public void setRequestPayload(CreateOrderDetailRequestPayload requestPayload) {
        this.requestPayload = requestPayload;
    }

    public CreateOrderDetailResponsePayload getResponsePayload() {
        return responsePayload;
    }

    public void setResponsePayload(CreateOrderDetailResponsePayload responsePayload) {
        this.responsePayload = responsePayload;
    }

    public ErrorResponse getErrorResponsePayload() {
        return errorResponsePayload;
    }

    public void setErrorResponsePayload(ErrorResponse errorResponsePayload) {
        this.errorResponsePayload = errorResponsePayload;
    }
}
