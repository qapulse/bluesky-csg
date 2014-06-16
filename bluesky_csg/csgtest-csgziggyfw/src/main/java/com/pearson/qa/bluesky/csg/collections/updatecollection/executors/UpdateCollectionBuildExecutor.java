package com.pearson.qa.bluesky.csg.collections.updatecollection.executors;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.pearson.qa.bluesky.csg.Utils.datastructures.ErrorResponse;
import com.pearson.qa.bluesky.csg.collections.updatecollection.contexts.UpdateCollectionContext;
import com.pearson.qa.bluesky.csg.collections.updatecollection.datastructures.UpdateCollectionResponsePayload;
import com.pearson.qa.common.ziggyfw.executors.Executor;
import com.pearson.qa.common.ziggyfw.http.executors.HttpExecutor;
import com.pearson.qa.common.ziggyfw.validators.Validator;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by brian on 3/13/14.
 */
@Singleton
public class UpdateCollectionBuildExecutor<T extends UpdateCollectionContext> implements Executor<T> {
    private List<Validator<T>> validators;
    private HttpExecutor<T> httpExecutor;

    public UpdateCollectionBuildExecutor() {
        validators = new ArrayList<>();
    }

    public UpdateCollectionBuildExecutor(List<Validator<T>> validators, HttpExecutor<T> httpExecutor) {
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
                    context.setResponsePayload(new UpdateCollectionResponsePayload(returnMessage)); // solo este.. bookpricerequest =  nombre de la clase que va a recibir los datos ( api response )
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
    public void setValidators(List<Validator<UpdateCollectionContext>> validators) {
        if (validators != null) {
            this.validators.clear();
            for (Validator<UpdateCollectionContext> validator : validators)
                this.validators.add((Validator<T>) validator);
        }
    }

    @Inject
    public void setHttpExecutor(HttpExecutor<T> httpExecutor) {
        this.httpExecutor = httpExecutor;
    }
}