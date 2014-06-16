package com.pearson.qa.bluesky.csg.books.bookBuild.modules;

/**
 * Created by dcorrales on 2/27/14.
 */

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.pearson.qa.bluesky.csg.books.bookBuild.contexts.BookBuildContext;
import com.pearson.qa.bluesky.csg.books.bookBuild.executors.BookBuildExecutor;
import com.pearson.qa.bluesky.csg.books.bookBuild.validators.BookBuildValidator;
import com.pearson.qa.common.ziggyfw.executors.Executor;
import com.pearson.qa.common.ziggyfw.validators.Validator;

import java.util.ArrayList;
import java.util.List;

public class BookBuildModule extends AbstractModule {

    @Provides
    public List<Executor<BookBuildContext>> getLoginExecutors(BookBuildExecutor<BookBuildContext> executor)
    {
        List<Executor<BookBuildContext>> executors = new ArrayList<>();
        executors.add(executor);
        return executors;
    }

    @Provides
    public List<Validator<BookBuildContext>> getLoginValidators(BookBuildValidator validator)
    {
        List<Validator<BookBuildContext>> validators = new ArrayList<>();
        validators.add(validator);
        return validators;
    }

    @Override
    protected void configure() {

    }
}
