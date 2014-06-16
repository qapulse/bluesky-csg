package com.pearson.qa.bluesky.csg.collections.deleteCollectionChapter.contexts;

import com.google.inject.Inject;
import com.pearson.qa.bluesky.csg.Utils.datastructures.ErrorResponse;
import com.pearson.qa.bluesky.csg.collections.deleteCollectionChapter.datastructures.DeleteCollectionChapterResponsePayload;
import com.pearson.qa.common.configuration.Configuration;
import com.pearson.qa.common.ziggyfw.http.contexts.HttpContext;

public class DeleteCollectionChapterContext extends HttpContext {
    DeleteCollectionChapterResponsePayload responsePayload;
    ErrorResponse errorResponsePayload;

    public DeleteCollectionChapterContext() {
        super();
        this.setRequestMethod("DELETE");
        this.setRequestContentType("application/json");
    }

    @Inject
    public void setConfiguration(Configuration configuration) {
        super.setConfiguration(configuration);
        this.configuration = configuration;
        if (this.configuration != null) {
            String configNameSpace = configuration.getConfigNamespace(DeleteCollectionChapterContext.class);
            String scheme = configuration.getString(configNameSpace, "scheme", "http");
            this.setRequestScheme(scheme);
            String host = configuration.getString(configNameSpace, "host", "");
            this.setRequestHost(host);
            String path = configuration.getString(configNameSpace, "path", "set API url correctly");
            this.setRequestPath(path);
        }
    }


    public DeleteCollectionChapterResponsePayload getResponsePayload() {
        return responsePayload;
    }

    public void setResponsePayload(DeleteCollectionChapterResponsePayload responsePayload) {
        this.responsePayload = responsePayload;
    }

    public ErrorResponse getErrorResponsePayload() {
        return errorResponsePayload;
    }

    public void setErrorResponsePayload(ErrorResponse errorResponsePayload) {
        this.errorResponsePayload = errorResponsePayload;
    }
}

