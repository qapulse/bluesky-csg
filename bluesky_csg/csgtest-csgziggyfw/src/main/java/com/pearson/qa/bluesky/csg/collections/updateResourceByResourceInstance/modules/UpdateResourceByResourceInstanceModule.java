package com.pearson.qa.bluesky.csg.collections.updateResourceByResourceInstance.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.pearson.qa.bluesky.csg.collections.updateResourceByResourceInstance.contexts.UpdateResourceByResourceInstanceContext;
import com.pearson.qa.bluesky.csg.collections.updateResourceByResourceInstance.executors.UpdateResourceByResourceInstanceExecutor;
import com.pearson.qa.bluesky.csg.collections.updateResourceByResourceInstance.validators.UpdateResourceByResourceInstanceValidator;
import com.pearson.qa.common.ziggyfw.executors.Executor;
import com.pearson.qa.common.ziggyfw.validators.Validator;

import java.util.ArrayList;
import java.util.List;


public class UpdateResourceByResourceInstanceModule extends AbstractModule {

    @Provides
    public List<Executor<UpdateResourceByResourceInstanceContext>> getLoginExecutors(UpdateResourceByResourceInstanceExecutor<UpdateResourceByResourceInstanceContext> executor) {
        List<Executor<UpdateResourceByResourceInstanceContext>> executors = new ArrayList<>();
        executors.add(executor);
        return executors;
    }

    @Provides
    public List<Validator<UpdateResourceByResourceInstanceContext>> getLoginValidators(UpdateResourceByResourceInstanceValidator validator) {
        List<Validator<UpdateResourceByResourceInstanceContext>> validators = new ArrayList<>();
        validators.add(validator);
        return validators;
    }

    @Override
    protected void configure() {

    }
}
