package com.pearson.qa.bluesky.csg.user.userResources.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.pearson.qa.bluesky.csg.user.userResources.contexts.UserResourcesContext;
import com.pearson.qa.bluesky.csg.user.userResources.executors.UserResourcesExecutor;
import com.pearson.qa.bluesky.csg.user.userResources.validators.UserResourcesValidator;
import com.pearson.qa.common.ziggyfw.executors.Executor;
import com.pearson.qa.common.ziggyfw.validators.Validator;

import java.util.ArrayList;
import java.util.List;


public class UserResourcesModule extends AbstractModule {

    @Provides
    public List<Executor<UserResourcesContext>> getLoginExecutors(UserResourcesExecutor<UserResourcesContext> executor)
    {
        List<Executor<UserResourcesContext>> executors = new ArrayList<>();
        executors.add(executor);
        return executors;
    }

    @Provides
    public List<Validator<UserResourcesContext>> getLoginValidators(UserResourcesValidator validator)
    {
        List<Validator<UserResourcesContext>> validators = new ArrayList<>();
        validators.add(validator);
        return validators;
    }

    @Override
    protected void configure() {

    }
}