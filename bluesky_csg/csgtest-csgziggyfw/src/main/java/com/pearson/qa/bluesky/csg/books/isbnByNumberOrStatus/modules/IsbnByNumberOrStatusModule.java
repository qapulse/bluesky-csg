package com.pearson.qa.bluesky.csg.books.isbnByNumberOrStatus.modules;

/**
 * Created by didiercorrales on 2/26/14.
 */

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.pearson.qa.bluesky.csg.books.isbnByNumberOrStatus.contexts.IsbnByNumberOrStatusContext;
import com.pearson.qa.bluesky.csg.books.isbnByNumberOrStatus.executors.IsbnByNumberOrStatusExecutor;
import com.pearson.qa.bluesky.csg.books.isbnByNumberOrStatus.validators.IsbnByNumberOrStatusValidator;
import com.pearson.qa.common.ziggyfw.executors.Executor;
import com.pearson.qa.common.ziggyfw.validators.Validator;

import java.util.ArrayList;
import java.util.List;

public class IsbnByNumberOrStatusModule extends AbstractModule {

    @Provides
    public List<Executor<IsbnByNumberOrStatusContext>> getLoginExecutors(IsbnByNumberOrStatusExecutor<IsbnByNumberOrStatusContext> executor) {
        List<Executor<IsbnByNumberOrStatusContext>> executors = new ArrayList<>();
        executors.add(executor);
        return executors;
    }

    @Provides
    public List<Validator<IsbnByNumberOrStatusContext>> getLoginValidators(IsbnByNumberOrStatusValidator validator) {
        List<Validator<IsbnByNumberOrStatusContext>> validators = new ArrayList<>();
        validators.add(validator);
        return validators;
    }

    @Override
    protected void configure() {

    }
}
