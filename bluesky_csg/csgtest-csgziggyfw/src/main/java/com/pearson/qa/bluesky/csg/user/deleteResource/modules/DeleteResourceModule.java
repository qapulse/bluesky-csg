package com.pearson.qa.bluesky.csg.user.deleteResource.modules;


import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.pearson.qa.bluesky.csg.user.deleteResource.contexts.DeleteResourceContext;
import com.pearson.qa.bluesky.csg.user.deleteResource.executors.DeleteResourceExecutor;
import com.pearson.qa.bluesky.csg.user.deleteResource.validators.DeleteResourceValidator;
import com.pearson.qa.common.ziggyfw.executors.Executor;
import com.pearson.qa.common.ziggyfw.validators.Validator;

import java.util.ArrayList;
import java.util.List;


public class DeleteResourceModule extends AbstractModule {

    @Provides
    public List<Executor<DeleteResourceContext>> getLoginExecutors(DeleteResourceExecutor<DeleteResourceContext> executor) {
        List<Executor<DeleteResourceContext>> executors = new ArrayList<>();
        executors.add(executor);
        return executors;
    }

    @Provides
    public List<Validator<DeleteResourceContext>> getLoginValidators(DeleteResourceValidator validator) {
        List<Validator<DeleteResourceContext>> validators = new ArrayList<>();
        validators.add(validator);
        return validators;
    }

    @Override
    protected void configure() {

    }
}