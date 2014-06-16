package com.pearson.qa.bluesky.csg.taxonomies.getCollectionByISBN.modules;


import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.pearson.qa.bluesky.csg.taxonomies.getCollectionByISBN.contexts.GetCollectionByISBNContext;
import com.pearson.qa.bluesky.csg.taxonomies.getCollectionByISBN.executors.GetCollectionByISBNExecutor;
import com.pearson.qa.bluesky.csg.taxonomies.getCollectionByISBN.validators.GetCollectionByISBNValidator;
import com.pearson.qa.common.ziggyfw.executors.Executor;
import com.pearson.qa.common.ziggyfw.validators.Validator;

import java.util.ArrayList;
import java.util.List;


public class GetCollectionByISBNModule extends AbstractModule {

    @Provides
    public List<Executor<GetCollectionByISBNContext>> getLoginExecutors(GetCollectionByISBNExecutor<GetCollectionByISBNContext> executor)
    {
        List<Executor<GetCollectionByISBNContext>> executors = new ArrayList<>();
        executors.add(executor);
        return executors;
    }

    @Provides
    public List<Validator<GetCollectionByISBNContext>> getLoginValidators(GetCollectionByISBNValidator validator)
    {
        List<Validator<GetCollectionByISBNContext>> validators = new ArrayList<>();
        validators.add(validator);
        return validators;
    }

    @Override
    protected void configure() {

    }
}
