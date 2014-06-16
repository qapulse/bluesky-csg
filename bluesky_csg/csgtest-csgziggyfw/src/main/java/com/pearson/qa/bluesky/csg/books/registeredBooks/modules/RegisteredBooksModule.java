package com.pearson.qa.bluesky.csg.books.registeredBooks.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.pearson.qa.bluesky.csg.books.registeredBooks.contexts.RegisteredBooksContext;
import com.pearson.qa.bluesky.csg.books.registeredBooks.validators.RegisteredBooksValidator;
import com.pearson.qa.bluesky.csg.books.registeredBooks.executors.RegisteredBooksExecutor;
import com.pearson.qa.common.ziggyfw.executors.Executor;
import com.pearson.qa.common.ziggyfw.validators.Validator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dcorrales on 2/24/14.
 */
public class RegisteredBooksModule extends AbstractModule {

    @Provides
    public List<Executor<RegisteredBooksContext>> getExecutors(RegisteredBooksExecutor<RegisteredBooksContext> executor)
    {
        List<Executor<RegisteredBooksContext>> executors = new ArrayList<>();
        executors.add(executor);
        return executors;
    }

    @Provides
    public List<Validator<RegisteredBooksContext>> getValidators(RegisteredBooksValidator validator)
    {
        List<Validator<RegisteredBooksContext>> validators = new ArrayList<>();
        validators.add(validator);
        return validators;
    }

    @Override
    protected void configure() {

    }
}
