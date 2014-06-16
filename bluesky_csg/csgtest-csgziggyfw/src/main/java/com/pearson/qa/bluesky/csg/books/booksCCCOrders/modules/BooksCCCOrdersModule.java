package com.pearson.qa.bluesky.csg.books.booksCCCOrders.modules;

/**
 * Created by didiercorrales on 2/26/14.
 */
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.pearson.qa.bluesky.csg.books.booksCCCOrders.contexts.BooksCCCOrdersContext;
import com.pearson.qa.bluesky.csg.books.booksCCCOrders.executors.BooksCCCOrdersExecutor;
import com.pearson.qa.bluesky.csg.books.booksCCCOrders.validators.BooksCCCOrdersValidator;
import com.pearson.qa.common.ziggyfw.executors.Executor;
import com.pearson.qa.common.ziggyfw.validators.Validator;

import java.util.ArrayList;
import java.util.List;

public class BooksCCCOrdersModule extends AbstractModule {

    @Provides
    public List<Executor<BooksCCCOrdersContext>> getLoginExecutors(BooksCCCOrdersExecutor<BooksCCCOrdersContext> executor)
    {
        List<Executor<BooksCCCOrdersContext>> executors = new ArrayList<>();
        executors.add(executor);
        return executors;
    }

    @Provides
    public List<Validator<BooksCCCOrdersContext>> getLoginValidators(BooksCCCOrdersValidator validator)
    {
        List<Validator<BooksCCCOrdersContext>> validators = new ArrayList<>();
        validators.add(validator);
        return validators;
    }

    @Override
    protected void configure() {

    }
}
