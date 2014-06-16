package com.pearson.qa.bluesky.csg.user.createUserResource.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.pearson.qa.bluesky.csg.user.createUserResource.contexts.CreateUserResourceContext;
import com.pearson.qa.bluesky.csg.user.createUserResource.executors.CreateUserResourceExecutor;
import com.pearson.qa.bluesky.csg.user.createUserResource.validators.CreateUserResourceValidator;
import com.pearson.qa.common.ziggyfw.executors.Executor;
import com.pearson.qa.common.ziggyfw.validators.Validator;

import java.util.ArrayList;
import java.util.List;


public class CreateUserResourceModule extends AbstractModule {

    @Provides
    public List<Executor<CreateUserResourceContext>> getLoginExecutors(CreateUserResourceExecutor<CreateUserResourceContext> executor) {
        List<Executor<CreateUserResourceContext>> executors = new ArrayList<>();
        executors.add(executor);
        return executors;
    }

    @Provides
    public List<Validator<CreateUserResourceContext>> getLoginValidators(CreateUserResourceValidator validator) {
        List<Validator<CreateUserResourceContext>> validators = new ArrayList<>();
        validators.add(validator);
        return validators;
    }

    @Override
    protected void configure() {

    }
}
