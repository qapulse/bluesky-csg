package com.pearson.qa.bluesky.csg.collections.resourcescollection.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.pearson.qa.bluesky.csg.collections.resourcescollection.contexts.ResourcesByCollection;
import com.pearson.qa.bluesky.csg.collections.resourcescollection.executors.ResourcesByCollectionExecutor;
import com.pearson.qa.bluesky.csg.collections.resourcescollection.validators.ResourcesByCollectionValidator;
import com.pearson.qa.common.ziggyfw.executors.Executor;
import com.pearson.qa.common.ziggyfw.validators.Validator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by brian on 2/27/14.
 */
public class ResourcesByCollectionModule extends AbstractModule {

    @Provides
    public List<Executor<ResourcesByCollection>> getLoginExecutors(ResourcesByCollectionExecutor<ResourcesByCollection> executor)
    {
        List<Executor<ResourcesByCollection>> executors = new ArrayList<>();
        executors.add(executor);
        return executors;
    }

    @Provides
    public List<Validator<ResourcesByCollection>> getLoginValidators(ResourcesByCollectionValidator validator)
    {
        List<Validator<ResourcesByCollection>> validators = new ArrayList<>();
        validators.add(validator);
        return validators;
    }

    @Override
    protected void configure()
    {
        // binding
    }

}
