package com.pearson.qa.bluesky.csg.books.bookRegisteredDetails.modules;

/**
 * Created by dcorrales on 2/27/14.
 */
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.pearson.qa.bluesky.csg.books.bookRegisteredDetails.contexts.BookRegisteredDetailsContext;
import com.pearson.qa.bluesky.csg.books.bookRegisteredDetails.executors.BookRegisteredDetailsExecutor;
import com.pearson.qa.bluesky.csg.books.bookRegisteredDetails.validators.BookRegisteredDetailsValidator;
import com.pearson.qa.common.ziggyfw.executors.Executor;
import com.pearson.qa.common.ziggyfw.validators.Validator;

import java.util.ArrayList;
import java.util.List;

public class BookRegisteredDetailsModule extends AbstractModule {

    @Provides
    public List<Executor<BookRegisteredDetailsContext>> getLoginExecutors(BookRegisteredDetailsExecutor<BookRegisteredDetailsContext> executor)
    {
        List<Executor<BookRegisteredDetailsContext>> executors = new ArrayList<>();
        executors.add(executor);
        return executors;
    }

    @Provides
    public List<Validator<BookRegisteredDetailsContext>> getLoginValidators(BookRegisteredDetailsValidator validator)
    {
        List<Validator<BookRegisteredDetailsContext>> validators = new ArrayList<>();
        validators.add(validator);
        return validators;
    }

    @Override
    protected void configure() {

    }
}
