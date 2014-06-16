package com.pearson.qa.bluesky.csg.collections.createcollection.executors;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.pearson.qa.bluesky.csg.Utils.datastructures.ErrorResponse;

import com.pearson.qa.bluesky.csg.collections.createcollection.contexts.CreateCollectionContexts;
import com.pearson.qa.bluesky.csg.collections.createcollection.datastructures.CreateCollectionResponse;
import com.pearson.qa.common.ziggyfw.executors.Executor;
import com.pearson.qa.common.ziggyfw.http.executors.HttpExecutor;
import com.pearson.qa.common.ziggyfw.validators.Validator;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: dcorrales
 * Date: 2/10/14
 * Time: 3:02 PM
 * To change this template use File | Settings | File Templates.
 */
@Singleton
public class CreateCollectionExecutor <T extends CreateCollectionContexts> implements Executor<T> {

    private List<Validator<T>> validators;
    private HttpExecutor<T> httpExecutor;

    public CreateCollectionExecutor()
    {
        validators = new ArrayList<>();
    }

    public CreateCollectionExecutor(List<Validator<T>> validators, HttpExecutor<T> httpExecutor) {
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

        context.setRequestBody(context.getCreateCollectionPayload().toJSONString());
        context.setTimeoutSeconds(20);
        this.httpExecutor.execute(context);
        Object rawMessage = JSONValue.parse(context.getReturnedResponseBody());
        if (rawMessage != null && rawMessage.getClass() == JSONObject.class)
        {
            if(context.getReturnedHttpResponseCode() == 200){

                JSONObject returnMessage = (JSONObject) rawMessage;
                context.setCreateCollectionResponse(new CreateCollectionResponse(returnMessage));
            }
            else
            {
                JSONObject returnMessage = (JSONObject) rawMessage;
                context.setCreateCollectionResponse(new ErrorResponse(returnMessage));
            }
        }
    }

    @Inject
    public void setValidators(List<Validator<CreateCollectionContexts>> validators)
    {
        if (validators != null)
        {
            this.validators.clear();
            for (Validator<CreateCollectionContexts> validator : validators)
                this.validators.add((Validator<T>) validator);
        }
    }

    @Inject
    public void setHttpExecutor(HttpExecutor<T> httpExecutor)
    {
        this.httpExecutor = httpExecutor;
    }
}
