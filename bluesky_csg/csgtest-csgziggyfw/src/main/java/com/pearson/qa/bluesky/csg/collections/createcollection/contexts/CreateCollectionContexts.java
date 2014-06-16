package com.pearson.qa.bluesky.csg.collections.createcollection.contexts;

import com.google.inject.Inject;
import com.pearson.qa.bluesky.csg.Utils.datastructures.ErrorResponse;
import com.pearson.qa.bluesky.csg.authentication.login.datastructures.Login;
import com.pearson.qa.bluesky.csg.collections.createcollection.datastructures.CreateCollectionPayload;
import com.pearson.qa.bluesky.csg.collections.createcollection.datastructures.CreateCollectionResponse;
import com.pearson.qa.common.configuration.Configuration;
import com.pearson.qa.common.ziggyfw.http.contexts.HttpContext;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: dcorrales
 * Date: 2/10/14
 * Time: 3:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class CreateCollectionContexts extends HttpContext {

    CreateCollectionPayload createCollectionPayload;

    CreateCollectionResponse createCollectionResponse;

    ErrorResponse errorResponsePayload;



    public CreateCollectionContexts() {

        super();

        setCreateCollectionPayload(new CreateCollectionPayload());
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
            String configNameSpace = configuration.getConfigNamespace(CreateCollectionContexts.class);
            String scheme = configuration.getString(configNameSpace, "scheme", "http");
            this.setRequestScheme(scheme);
            String host = configuration.getString(configNameSpace, "host", "");
            this.setRequestHost(host);
            String path = configuration.getString(configNameSpace, "path", "/authentication/login");
            this.setRequestPath(path);
        }
    }


    public CreateCollectionPayload getCreateCollectionPayload() {
        return createCollectionPayload;
    }

    public void setCreateCollectionPayload(CreateCollectionPayload createCollectionPayload) {
        this.createCollectionPayload = createCollectionPayload;
    }

    public CreateCollectionResponse getCreateCollectionResponse() {
        return createCollectionResponse;
    }

    public void setCreateCollectionResponse(CreateCollectionResponse createCollectionResponse) {
        this.createCollectionResponse = createCollectionResponse;
    }
    public void setCreateCollectionResponse(ErrorResponse createCollectionResponse) {

        this.setErrorResponsePayload ( createCollectionResponse);
    }

    public ErrorResponse getErrorResponsePayload() {
        return errorResponsePayload;
    }

    public void setErrorResponsePayload(ErrorResponse errorResponsePayload) {
        this.errorResponsePayload = errorResponsePayload;
    }

}
