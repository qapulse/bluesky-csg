package com.pearson.qa.bluesky.csg.books.resourceMediaContentPrice.modules;

/**
 * Created by didiercorrales on 3/9/14.
 */

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.pearson.qa.bluesky.csg.books.resourceMediaContentPrice.contexts.ResourceMediaContentPriceContext;
import com.pearson.qa.bluesky.csg.books.resourceMediaContentPrice.executors.ResourceMediaContentPriceExecutor;
import com.pearson.qa.bluesky.csg.books.resourceMediaContentPrice.validators.ResourceMediaContentPriceValidator;
import com.pearson.qa.common.ziggyfw.executors.Executor;
import com.pearson.qa.common.ziggyfw.validators.Validator;

import java.util.ArrayList;
import java.util.List;

public class ResourceMediaContentPriceModule extends AbstractModule {

    @Provides
    public List<Executor<ResourceMediaContentPriceContext>> getLoginExecutors(ResourceMediaContentPriceExecutor<ResourceMediaContentPriceContext> executor)
    {
        List<Executor<ResourceMediaContentPriceContext>> executors = new ArrayList<>();
        executors.add(executor);
        return executors;
    }

    @Provides
    public List<Validator<ResourceMediaContentPriceContext>> getLoginValidators(ResourceMediaContentPriceValidator validator)
    {
        List<Validator<ResourceMediaContentPriceContext>> validators = new ArrayList<>();
        validators.add(validator);
        return validators;
    }

    @Override
    protected void configure() {

    }
}
