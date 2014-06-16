package com.pearson.qa.bluesky.csg.books.chapterPrice.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.pearson.qa.bluesky.csg.books.chapterPrice.contexts.ChapterPriceContext;
import com.pearson.qa.bluesky.csg.books.chapterPrice.executors.ChapterPriceExecutor;
import com.pearson.qa.bluesky.csg.books.chapterPrice.validators.ChapterPriceValidator;
import com.pearson.qa.common.ziggyfw.executors.Executor;
import com.pearson.qa.common.ziggyfw.validators.Validator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Game on 2/23/14.
 */
public class ChapterPriceModule extends AbstractModule {

    @Provides
    public List<Executor<ChapterPriceContext>> getExecutors(ChapterPriceExecutor<ChapterPriceContext> executor)
    {
        List<Executor<ChapterPriceContext>> executors = new ArrayList<>();
        executors.add(executor);
        return executors;
    }

    @Provides
    public List<Validator<ChapterPriceContext>> getValidators(ChapterPriceValidator validator)
    {
        List<Validator<ChapterPriceContext>> validators = new ArrayList<>();
        validators.add(validator);
        return validators;
    }

    @Override
    protected void configure() {

    }
}
