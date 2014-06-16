package com.pearson.qa.bluesky.csg.books.orderDetailStatus.modules;

/**
 * Created by didiercorrales on 2/26/14.
 */
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.pearson.qa.bluesky.csg.books.orderDetailStatus.contexts.OrderDetailStatusContext;
import com.pearson.qa.bluesky.csg.books.orderDetailStatus.executors.OrderDetailStatusExecutor;
import com.pearson.qa.bluesky.csg.books.orderDetailStatus.validators.OrderDetailStatusValidator;
import com.pearson.qa.common.ziggyfw.executors.Executor;
import com.pearson.qa.common.ziggyfw.validators.Validator;

import java.util.ArrayList;
import java.util.List;

public class OrderDetailStatusModule extends AbstractModule {

    @Provides
    public List<Executor<OrderDetailStatusContext>> getLoginExecutors(OrderDetailStatusExecutor<OrderDetailStatusContext> executor)
    {
        List<Executor<OrderDetailStatusContext>> executors = new ArrayList<>();
        executors.add(executor);
        return executors;
    }

    @Provides
    public List<Validator<OrderDetailStatusContext>> getLoginValidators(OrderDetailStatusValidator validator)
    {
        List<Validator<OrderDetailStatusContext>> validators = new ArrayList<>();
        validators.add(validator);
        return validators;
    }

    @Override
    protected void configure() {

    }
}
