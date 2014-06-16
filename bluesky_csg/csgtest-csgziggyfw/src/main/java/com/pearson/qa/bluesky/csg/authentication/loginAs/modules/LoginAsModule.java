package com.pearson.qa.bluesky.csg.authentication.loginAs.modules;

/**
 * Created by dcorrales on 2/27/14.
 */

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.pearson.qa.bluesky.csg.authentication.loginAs.contexts.LoginAsContext;
import com.pearson.qa.bluesky.csg.authentication.loginAs.executors.LoginAsExecutor;
import com.pearson.qa.bluesky.csg.authentication.loginAs.validators.LoginAsValidator;
import com.pearson.qa.common.ziggyfw.executors.Executor;
import com.pearson.qa.common.ziggyfw.validators.Validator;

import java.util.ArrayList;
import java.util.List;

public class LoginAsModule extends AbstractModule {

    @Provides
    public List<Executor<LoginAsContext>> getLoginExecutors(LoginAsExecutor<LoginAsContext> executor)
    {
        List<Executor<LoginAsContext>> executors = new ArrayList<>();
        executors.add(executor);
        return executors;
    }

    @Provides
    public List<Validator<LoginAsContext>> getLoginValidators(LoginAsValidator validator)
    {
        List<Validator<LoginAsContext>> validators = new ArrayList<>();
        validators.add(validator);
        return validators;
    }

    @Override
    protected void configure() {

    }
}
