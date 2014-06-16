package com.pearson.qa.bluesky.csg.collections.createcollection.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

import com.pearson.qa.bluesky.csg.collections.createcollection.contexts.CreateCollectionContexts;
import com.pearson.qa.bluesky.csg.collections.createcollection.executors.CreateCollectionExecutor;
import com.pearson.qa.bluesky.csg.collections.createcollection.validators.CreateCollectionValidator;
import com.pearson.qa.common.ziggyfw.executors.Executor;
import com.pearson.qa.common.ziggyfw.validators.Validator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: dcorrales
 * Date: 2/10/14
 * Time: 3:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class CreateCollectionModule extends AbstractModule {

    @Provides
    public List<Executor<CreateCollectionContexts>> getLoginExecutors(CreateCollectionExecutor<CreateCollectionContexts> executor)
    {
        List<Executor<CreateCollectionContexts>> executors = new ArrayList<>();
        executors.add(executor);
        return executors;
    }

    @Provides
    public List<Validator<CreateCollectionContexts>> getLoginValidators(CreateCollectionValidator validator)
    {
        List<Validator<CreateCollectionContexts>> validators = new ArrayList<>();
        validators.add(validator);
        return validators;
    }

    @Override
    protected void configure()
    {
        // binding
    }
}
