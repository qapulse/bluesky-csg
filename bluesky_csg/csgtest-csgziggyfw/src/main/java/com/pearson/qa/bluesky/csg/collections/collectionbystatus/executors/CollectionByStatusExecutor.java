package com.pearson.qa.bluesky.csg.collections.collectionbystatus.executors;

import com.pearson.qa.bluesky.csg.Utils.datastructures.ErrorResponse;
import com.pearson.qa.bluesky.csg.books.bookPrice.datastructures.BookPriceRequest;
import com.pearson.qa.bluesky.csg.collections.collectionbystatus.contexts.CollectionByStatusContexts;
import com.pearson.qa.bluesky.csg.collections.collectionbystatus.datastructures.CollectionByStatusRequestPayload;
import com.pearson.qa.bluesky.csg.collections.collectionbystatus.datastructures.CollectionByStatusResponsePayload;
import com.pearson.qa.common.ziggyfw.executors.Executor;
import com.pearson.qa.common.ziggyfw.http.executors.HttpExecutor;
import com.pearson.qa.common.ziggyfw.validators.Validator;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by brian on 3/22/14.
 */

@Singleton
public class CollectionByStatusExecutor<T extends CollectionByStatusContexts> implements Executor<T> {
    private List<Validator<T>> validators;
    private HttpExecutor<T> httpExecutor;

    public CollectionByStatusExecutor() {
        validators = new ArrayList<>();
    }

    public CollectionByStatusExecutor(List<Validator<T>> validators, HttpExecutor<T> httpExecutor) {
        this.validators = validators;
        this.httpExecutor = httpExecutor;
    }

    @Override
    public List<Validator<T>> getValidators() {
        List<Validator<T>> allValidators = new ArrayList<>();
        allValidators.addAll(this.validators);
        allValidators.addAll(this.httpExecutor.getValidators());
        return allValidators;
    }

    @Override
    public boolean canExecute(T context) {
        return (context != null) && (httpExecutor != null) && httpExecutor.canExecute(context);
    }

    @Override
    public void execute(T context) throws Exception {
        try {

            // context.setRequestBody(context.getRequestPayload().toJSONString());  //si ocupo mandar datos por json a webo descomentar esta linea
            context.setTimeoutSeconds(20);

            this.httpExecutor.execute(context);

            Object rawMessage = JSONValue.parse(context.getReturnedResponseBody());

            if (rawMessage != null && rawMessage.getClass() == JSONObject.class) {
                if (context.getReturnedHttpResponseCode() == 200) {

                    JSONObject returnMessage = (JSONObject) rawMessage;
                    context.setResponsePayload(new CollectionByStatusResponsePayload(returnMessage)); // solo este.. bookpricerequest =  nombre de la clase que va a recibir los datos ( api response )
                } else {
                    JSONObject returnMessage = (JSONObject) rawMessage;
                    context.setErrorResponsePayload(new ErrorResponse(returnMessage));
                }
            }
        }   catch (Exception e){
            System.out.print(e.getStackTrace());
            System.out.print(e.getMessage());
        }

    }

    @Inject
    public void setValidators(List<Validator<CollectionByStatusContexts>> validators) {
        if (validators != null) {
            this.validators.clear();
            for (Validator<CollectionByStatusContexts> validator : validators)
                this.validators.add((Validator<T>) validator);
        }
    }

    @Inject
    public void setHttpExecutor(HttpExecutor<T> httpExecutor) {
        this.httpExecutor = httpExecutor;
    }

    public HttpExecutor<T> getHttpExecutor() {
        return httpExecutor;
    }
}