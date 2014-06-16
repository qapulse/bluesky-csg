package com.pearson.qa.bluesky.csg.authentication.login.executors;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.pearson.qa.bluesky.csg.authentication.login.contexts.LoginContext;
import com.pearson.qa.bluesky.csg.authentication.login.datastructures.LoginResponse;
import com.pearson.qa.common.ziggyfw.executors.Executor;
import com.pearson.qa.common.ziggyfw.http.executors.HttpExecutor;
import com.pearson.qa.common.ziggyfw.validators.Validator;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import com.pearson.qa.bluesky.csg.Utils.datastructures.ErrorResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: dcorrales
 * Date: 2/6/14
 * Time: 4:01 PM
 * To change this template use File | Settings | File Templates.
 */
@Singleton
    public class LoginExecutor<T extends LoginContext> implements Executor<T> {

        private List<Validator<T>> validators;
        private HttpExecutor<T> httpExecutor;

    public LoginExecutor()
    {
        validators = new ArrayList<>();
    }

    public LoginExecutor(List<Validator<T>> validators, HttpExecutor<T> httpExecutor) {
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

        context.setRequestBody(context.getLoginPayload().toJSONString());
        context.setTimeoutSeconds(20);
        this.httpExecutor.execute(context);
        Object rawMessage = JSONValue.parse(context.getReturnedResponseBody());
        if (rawMessage != null && rawMessage.getClass() == JSONObject.class)
        {
            if(context.getReturnedHttpResponseCode() == 200){

            JSONObject returnMessage = (JSONObject) rawMessage;
            context.setLoginResponsePayload(new LoginResponse(returnMessage));
            }
            else
            {
                JSONObject returnMessage = (JSONObject) rawMessage;
                context.setLoginResponsePayload(new ErrorResponse(returnMessage));
            }
        }
}

    @Inject
    public void setValidators(List<Validator<LoginContext>> validators)
    {
        if (validators != null)
        {
            this.validators.clear();
            for (Validator<LoginContext> validator : validators)
                this.validators.add((Validator<T>) validator);
        }
    }

    @Inject
    public void setHttpExecutor(HttpExecutor<T> httpExecutor)
    {
        this.httpExecutor = httpExecutor;
    }
}
