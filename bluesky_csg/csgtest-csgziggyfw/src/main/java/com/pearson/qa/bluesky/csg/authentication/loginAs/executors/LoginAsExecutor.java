package com.pearson.qa.bluesky.csg.authentication.loginAs.executors;

/**
 * Created by dcorrales on 2/27/14.
 */


import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.pearson.qa.bluesky.csg.Utils.datastructures.ErrorResponse;
import com.pearson.qa.bluesky.csg.authentication.loginAs.contexts.LoginAsContext;
import com.pearson.qa.common.ziggyfw.executors.Executor;
import com.pearson.qa.common.ziggyfw.http.executors.HttpExecutor;
import com.pearson.qa.common.ziggyfw.validators.Validator;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.util.ArrayList;
import java.util.List;


@Singleton
public class LoginAsExecutor<T extends LoginAsContext> implements Executor<T> {
    private List<Validator<T>> validators;
    private HttpExecutor<T> httpExecutor;

    public LoginAsExecutor() {
        validators = new ArrayList<>();
    }

    public LoginAsExecutor(List<Validator<T>> validators, HttpExecutor<T> httpExecutor) {
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
        context.setTimeoutSeconds(20);

        this.httpExecutor.execute(context);

        if (context.getReturnedHttpResponseCode() != 200) {
            Object rawMessage = JSONValue.parse(context.getReturnedResponseBody());

            if (rawMessage != null && rawMessage.getClass() == JSONObject.class) {

                JSONObject returnMessage = (JSONObject) rawMessage;
                context.setErrorResponsePayload(new ErrorResponse(returnMessage));

            }
        }

    }

    @Inject
    public void setValidators(List<Validator<LoginAsContext>> validators) {
        if (validators != null) {
            this.validators.clear();
            for (Validator<LoginAsContext> validator : validators)
                this.validators.add((Validator<T>) validator);
        }
    }

    @Inject
    public void setHttpExecutor(HttpExecutor<T> httpExecutor) {
        this.httpExecutor = httpExecutor;
    }
}
