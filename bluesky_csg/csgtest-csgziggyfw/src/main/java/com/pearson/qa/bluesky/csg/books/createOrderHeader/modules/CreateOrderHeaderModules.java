package com.pearson.qa.bluesky.csg.books.createOrderHeader.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.pearson.qa.bluesky.csg.books.createOrderHeader.contexts.CreateOrderHeaderContext;
import com.pearson.qa.bluesky.csg.books.createOrderHeader.executors.CreateOrderHeaderExecutor;
import com.pearson.qa.bluesky.csg.books.createOrderHeader.validators.CreateOrderHeaderValidator;
import com.pearson.qa.common.ziggyfw.executors.Executor;
import com.pearson.qa.common.ziggyfw.validators.Validator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: dcorrales
 * Date: 2/19/14
 * Time: 10:01 AM
 * To change this template use File | Settings | File Templates.
 */
public class CreateOrderHeaderModules extends AbstractModule {

    @Provides
    public List<Executor<CreateOrderHeaderContext>> getLoginExecutors(CreateOrderHeaderExecutor<CreateOrderHeaderContext> executor)
    {
        List<Executor<CreateOrderHeaderContext>> executors = new ArrayList<>();
        executors.add(executor);
        return executors;
    }

    @Provides
    public List<Validator<CreateOrderHeaderContext>> getLoginValidators(CreateOrderHeaderValidator validator)
    {
        List<Validator<CreateOrderHeaderContext>> validators = new ArrayList<>();
        validators.add(validator);
        return validators;
    }

    @Override
    protected void configure() {

    }
}
