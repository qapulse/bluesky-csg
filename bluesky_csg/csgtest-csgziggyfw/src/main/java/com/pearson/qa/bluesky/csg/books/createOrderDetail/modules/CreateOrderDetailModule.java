package com.pearson.qa.bluesky.csg.books.createOrderDetail.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.pearson.qa.bluesky.csg.books.createOrderDetail.contexts.CreateOrderDetailContext;
import com.pearson.qa.bluesky.csg.books.createOrderDetail.executors.CreateOrderDetailExecutor;
import com.pearson.qa.bluesky.csg.books.createOrderDetail.validators.CreateOrderDetailValidator;
import com.pearson.qa.common.ziggyfw.executors.Executor;
import com.pearson.qa.common.ziggyfw.validators.Validator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by didiercorrales on 2/26/14.
 */
public class CreateOrderDetailModule extends AbstractModule {

    @Provides
    public List<Executor<CreateOrderDetailContext>> getLoginExecutors(CreateOrderDetailExecutor<CreateOrderDetailContext> executor)
    {
        List<Executor<CreateOrderDetailContext>> executors = new ArrayList<>();
        executors.add(executor);
        return executors;
    }

    @Provides
    public List<Validator<CreateOrderDetailContext>> getLoginValidators(CreateOrderDetailValidator validator)
    {
        List<Validator<CreateOrderDetailContext>> validators = new ArrayList<>();
        validators.add(validator);
        return validators;
    }

    @Override
    protected void configure() {

    }
}

