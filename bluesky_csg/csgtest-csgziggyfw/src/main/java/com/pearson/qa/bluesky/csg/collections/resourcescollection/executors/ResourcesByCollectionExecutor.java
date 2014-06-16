package com.pearson.qa.bluesky.csg.collections.resourcescollection.executors;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.pearson.qa.bluesky.csg.Utils.datastructures.ErrorResponse;
import com.pearson.qa.bluesky.csg.collections.resourcescollection.contexts.ResourcesByCollection;
import com.pearson.qa.bluesky.csg.collections.resourcescollection.datastructures.ResourcesByCollectionResponse;
import com.pearson.qa.common.ziggyfw.executors.Executor;
import com.pearson.qa.common.ziggyfw.http.executors.HttpExecutor;
import com.pearson.qa.common.ziggyfw.validators.Validator;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by brian on 2/27/14.
 */
@Singleton
public class ResourcesByCollectionExecutor <T extends ResourcesByCollection> implements Executor<T> {

    private List<Validator<T>> validators;
    private HttpExecutor<T> httpExecutor;

    public ResourcesByCollectionExecutor()
    {
        validators = new ArrayList<>();
    }

    public ResourcesByCollectionExecutor(List<Validator<T>> validators, HttpExecutor<T> httpExecutor) {
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

        //TODO use this line if JSONPayload is needed.
        //context.setRequestBody(context.getRequestPayload().toJSONString());
        context.setTimeoutSeconds(20);
        this.httpExecutor.execute(context);
        Object rawMessage = JSONValue.parse(context.getReturnedResponseBody());
        if (rawMessage != null && rawMessage.getClass() == JSONObject.class)
        {
            if(context.getReturnedHttpResponseCode() == 200){

                JSONObject returnMessage = (JSONObject) rawMessage;
                context.setResponsePayload(new ResourcesByCollectionResponse(returnMessage));
            }
            else
            {
                JSONObject returnMessage = (JSONObject) rawMessage;
                context.setErrorResponsePayload(new ErrorResponse(returnMessage));
            }
        }
    }

    @Inject
    public void setValidators(List<Validator<ResourcesByCollection>> validators)
    {
        if (validators != null)
        {
            this.validators.clear();
            for (Validator<ResourcesByCollection> validator : validators)
                this.validators.add((Validator<T>) validator);
        }
    }

    @Inject
    public void setHttpExecutor(HttpExecutor<T> httpExecutor)
    {
        this.httpExecutor = httpExecutor;
    }
}
