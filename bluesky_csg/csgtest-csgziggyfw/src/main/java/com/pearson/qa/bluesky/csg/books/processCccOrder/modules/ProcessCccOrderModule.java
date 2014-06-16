package com.pearson.qa.bluesky.csg.books.processCccOrder.modules;

/**
 * Created by didiercorrales on 3/9/14.
 */
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.pearson.qa.bluesky.csg.books.processCccOrder.contexts.ProcessCccOrderContext;
import com.pearson.qa.bluesky.csg.books.processCccOrder.executors.ProcessCccOrderExecutor;
import com.pearson.qa.bluesky.csg.books.processCccOrder.validators.ProcessCccOrderValidator;
import com.pearson.qa.common.ziggyfw.executors.Executor;
import com.pearson.qa.common.ziggyfw.validators.Validator;

import java.util.ArrayList;
import java.util.List;


public class ProcessCccOrderModule extends AbstractModule {

    @Provides
    public List<Executor<ProcessCccOrderContext>> getLoginExecutors(ProcessCccOrderExecutor<ProcessCccOrderContext> executor)
    {
        List<Executor<ProcessCccOrderContext>> executors = new ArrayList<>();
        executors.add(executor);
        return executors;
    }

    @Provides
    public List<Validator<ProcessCccOrderContext>> getLoginValidators(ProcessCccOrderValidator validator)
    {
        List<Validator<ProcessCccOrderContext>> validators = new ArrayList<>();
        validators.add(validator);
        return validators;
    }

    @Override
    protected void configure() {

    }
}