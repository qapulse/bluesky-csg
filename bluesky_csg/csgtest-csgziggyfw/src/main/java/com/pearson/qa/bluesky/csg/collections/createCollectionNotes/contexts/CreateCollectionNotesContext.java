package com.pearson.qa.bluesky.csg.collections.createCollectionNotes.contexts;

import com.google.inject.Inject;
import com.pearson.qa.bluesky.csg.Utils.datastructures.ErrorResponse;
import com.pearson.qa.bluesky.csg.collections.createCollectionNotes.datastructures.CreateCollectionNoteRequestPayload;
import com.pearson.qa.bluesky.csg.collections.createCollectionNotes.datastructures.CreateCollectionNoteResponsePayload;
import com.pearson.qa.common.configuration.Configuration;
import com.pearson.qa.common.ziggyfw.http.contexts.HttpContext;

public class  CreateCollectionNotesContext extends HttpContext {
    CreateCollectionNoteRequestPayload requestPayload;
    CreateCollectionNoteResponsePayload responsePayload;
    ErrorResponse errorResponsePayload;

    public CreateCollectionNotesContext() {
        super();
        setRequestPayload(new CreateCollectionNoteRequestPayload());
        this.setRequestMethod("POST");
        this.setRequestContentType("application/json");
    }

    @Inject
    public void setConfiguration(Configuration configuration)
    {
        super.setConfiguration(configuration);
        this.configuration = configuration;
        if (this.configuration != null){
            String configNameSpace = configuration.getConfigNamespace(CreateCollectionNotesContext.class);
            String scheme = configuration.getString(configNameSpace, "scheme", "http");
            this.setRequestScheme(scheme);
            String host = configuration.getString(configNameSpace, "host", "");
            this.setRequestHost(host);
            String path = configuration.getString(configNameSpace, "path", "set API url correctly");
            this.setRequestPath(path);
        }
    }

    public CreateCollectionNoteRequestPayload getRequestPayload() {
        return requestPayload;
    }

    public void setRequestPayload(CreateCollectionNoteRequestPayload requestPayload) {
        this.requestPayload = requestPayload;
    }

    public CreateCollectionNoteResponsePayload getResponsePayload() {
        return responsePayload;
    }

    public void setResponsePayload(CreateCollectionNoteResponsePayload responsePayload) {
        this.responsePayload = responsePayload;
    }

    public ErrorResponse getErrorResponsePayload() {
        return errorResponsePayload;
    }

    public void setErrorResponsePayload(ErrorResponse errorResponsePayload) {
        this.errorResponsePayload = errorResponsePayload;
    }
}