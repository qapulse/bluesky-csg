package com.pearson.qa.bluesky.csg.authentication.logout.modules;

/**
 * Created by dcorrales on 2/27/14.
 */

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.pearson.qa.bluesky.csg.authentication.logout.contexts.LogoutContext;
import com.pearson.qa.bluesky.csg.authentication.logout.executors.LogoutExecutor;
import com.pearson.qa.bluesky.csg.authentication.logout.validators.LogoutValidator;
import com.pearson.qa.common.ziggyfw.executors.Executor;
import com.pearson.qa.common.ziggyfw.validators.Validator;

import java.util.ArrayList;
import java.util.List;

public class LogoutModule extends AbstractModule {

    @Provides
    public List<Executor<LogoutContext>> getLoginExecutors(LogoutExecutor<LogoutContext> executor)
    {
        List<Executor<LogoutContext>> executors = new ArrayList<>();
        executors.add(executor);
        return executors;
    }

    @Provides
    public List<Validator<LogoutContext>> getLoginValidators(LogoutValidator validator)
    {
        List<Validator<LogoutContext>> validators = new ArrayList<>();
        validators.add(validator);
        return validators;
    }

    @Override
    protected void configure() {

    }
}
