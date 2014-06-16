package com.pearson.qa.bluesky.csg.collections.updatecollection.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.pearson.qa.bluesky.csg.collections.updatecollection.contexts.UpdateCollectionContext;
import com.pearson.qa.bluesky.csg.collections.updatecollection.executors.UpdateCollectionBuildExecutor;
import com.pearson.qa.bluesky.csg.collections.updatecollection.validators.UpdateCollectionBuildValidator;
import com.pearson.qa.common.ziggyfw.executors.Executor;
import com.pearson.qa.common.ziggyfw.validators.Validator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by brian on 3/13/14.
 */

public class UpdateCollectionBuildModule extends AbstractModule {

    @Provides
    public List<Executor<UpdateCollectionContext>> getLoginExecutors(UpdateCollectionBuildExecutor<UpdateCollectionContext> executor)
    {
        List<Executor<UpdateCollectionContext>> executors = new ArrayList<>();
        executors.add(executor);
        return executors;
    }

    @Provides
    public List<Validator<UpdateCollectionContext>> getLoginValidators(UpdateCollectionBuildValidator validator)
    {
        List<Validator<UpdateCollectionContext>> validators = new ArrayList<>();
        validators.add(validator);
        return validators;
    }

    @Override
    protected void configure() {

    }
}