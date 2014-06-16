package com.pearson.qa.bluesky.csg.collections.collectionbystatus.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.pearson.qa.bluesky.csg.collections.collectionbystatus.contexts.CollectionByStatusContexts;
import com.pearson.qa.bluesky.csg.collections.collectionbystatus.executors.CollectionByStatusExecutor;
import com.pearson.qa.bluesky.csg.collections.collectionbystatus.validators.CollectionByStatusValidator;
import com.pearson.qa.common.ziggyfw.executors.Executor;
import com.pearson.qa.common.ziggyfw.validators.Validator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by brian on 3/22/14.
 */
public class CollectionByStatusModule extends AbstractModule {

    @Provides
    public List<Executor<CollectionByStatusContexts>> getLoginExecutors(CollectionByStatusExecutor<CollectionByStatusContexts> executor)
    {
        List<Executor<CollectionByStatusContexts>> executors = new ArrayList<>();
        executors.add(executor);
        return executors;
    }

    @Provides
    public List<Validator<CollectionByStatusContexts>> getLoginValidators(CollectionByStatusValidator validator)
    {
        List<Validator<CollectionByStatusContexts>> validators = new ArrayList<>();
        validators.add(validator);
        return validators;
    }

    @Override
    protected void configure() {
    }
}