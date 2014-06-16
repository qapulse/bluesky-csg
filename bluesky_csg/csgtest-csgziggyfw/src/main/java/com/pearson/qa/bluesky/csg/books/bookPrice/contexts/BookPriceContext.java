package com.pearson.qa.bluesky.csg.books.bookPrice.contexts;

import com.google.inject.Inject;
import com.pearson.qa.bluesky.csg.Utils.datastructures.ErrorResponse;
import com.pearson.qa.bluesky.csg.books.bookPrice.datastructures.BookPricePayload;
import com.pearson.qa.bluesky.csg.books.bookPrice.datastructures.BookPriceRequest;
import com.pearson.qa.common.configuration.Configuration;
import com.pearson.qa.common.ziggyfw.http.contexts.HttpContext;

/**
 * Created by dcorrales on 2/21/14.
 */
public class BookPriceContext extends HttpContext {

    BookPricePayload requestPayload;
    BookPriceRequest responsePayload;

    ErrorResponse errorResponsePayload;

    public BookPriceContext() {

        super();

       // setRequestPayload(new BookPricePayload());
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
            String configNameSpace = configuration.getConfigNamespace(BookPriceContext.class);
            String scheme = configuration.getString(configNameSpace, "scheme", "http");
            this.setRequestScheme(scheme);
            String host = configuration.getString(configNameSpace, "host", "");
            this.setRequestHost(host);
            String path = configuration.getString(configNameSpace, "path", "/books/{bookId}/price");
            this.setRequestPath(path);
        }
    }

    public ErrorResponse getErrorResponsePayload() {
        return errorResponsePayload;
    }

    public void setErrorResponsePayload(ErrorResponse errorResponsePayload) {
        this.errorResponsePayload = errorResponsePayload;
    }

    public BookPricePayload getRequestPayload() {
        return requestPayload;
    }

    public void setRequestPayload(BookPricePayload requestPayload) {
        this.requestPayload = requestPayload;
    }

    public BookPriceRequest getResponsePayload() {
        return responsePayload;
    }

    public void setResponsePayload(BookPriceRequest responsePayload) {
        this.responsePayload = responsePayload;
    }
}
