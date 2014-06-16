package com.pearson.qa.bluesky.csg.collections.getcollection.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.pearson.qa.bluesky.csg.collections.getcollection.contexts.GetCollectionContext;
import com.pearson.qa.bluesky.csg.collections.getcollection.executors.GetCollectionExecutor;
import com.pearson.qa.bluesky.csg.collections.getcollection.validators.GetCollectionValidator;
import com.pearson.qa.common.ziggyfw.executors.Executor;
import com.pearson.qa.common.ziggyfw.validators.Validator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by brian on 3/9/14.
 */
public class GetCollectionModule extends AbstractModule {

    @Provides
    public List<Executor<GetCollectionContext>> getLoginExecutors(GetCollectionExecutor<GetCollectionContext> executor)
    {
        List<Executor<GetCollectionContext>> executors = new ArrayList<>();
        executors.add(executor);
        return executors;
    }

    @Provides
    public List<Validator<GetCollectionContext>> getLoginValidators(GetCollectionValidator validator)
    {
        List<Validator<GetCollectionContext>> validators = new ArrayList<>();
        validators.add(validator);
        return validators;
    }

    @Override
    protected void configure() {

    }
}