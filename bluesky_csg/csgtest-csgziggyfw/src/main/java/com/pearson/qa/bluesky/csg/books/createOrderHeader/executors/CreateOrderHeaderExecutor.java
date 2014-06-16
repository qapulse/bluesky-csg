package com.pearson.qa.bluesky.csg.books.createOrderHeader.executors;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.pearson.qa.bluesky.csg.Utils.datastructures.ErrorResponse;
import com.pearson.qa.bluesky.csg.books.createOrderHeader.contexts.CreateOrderHeaderContext;
import com.pearson.qa.bluesky.csg.books.createOrderHeader.datastructures.CreateOrderHeaderResponsePayload;
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
 * Date: 2/19/14
 * Time: 10:01 AM
 * To change this template use File | Settings | File Templates.
 */
@Singleton
public class CreateOrderHeaderExecutor <T extends CreateOrderHeaderContext> implements Executor<T> {

    private List<Validator<T>> validators;
    private HttpExecutor<T> httpExecutor;

    public CreateOrderHeaderExecutor()
    {
        validators = new ArrayList<>();
    }

    public CreateOrderHeaderExecutor(List<Validator<T>> validators, HttpExecutor<T> httpExecutor) {
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

        context.setRequestBody(context.getRequestPayload().toJSONString());
        System.out.print("HOLA");
        System.out.print(context.getRequestPayload().toString());
        System.out.print("Adios");
        context.setTimeoutSeconds(20);
        this.httpExecutor.execute(context);
        Object rawMessage = JSONValue.parse(context.getReturnedResponseBody());
        if (rawMessage != null && rawMessage.getClass() == JSONObject.class)
        {
            if(context.getReturnedHttpResponseCode() == 200){

                JSONObject returnMessage = (JSONObject) rawMessage;
                context.setResponsePayload(new CreateOrderHeaderResponsePayload(returnMessage));
            }
            else
            {
                JSONObject returnMessage = (JSONObject) rawMessage;
                context.setErrorResponsePayload(new ErrorResponse(returnMessage));
            }
        }
    }

    @Inject
    public void setValidators(List<Validator<CreateOrderHeaderContext>> validators)
    {
        if (validators != null)
        {
            this.validators.clear();
            for (Validator<CreateOrderHeaderContext> validator : validators)
                this.validators.add((Validator<T>) validator);
        }
    }

    @Inject
    public void setHttpExecutor(HttpExecutor<T> httpExecutor)
    {
        this.httpExecutor = httpExecutor;
    }
}
