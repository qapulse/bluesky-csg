package com.pearson.qa.bluesky.csg.books.bookPrice.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.pearson.qa.bluesky.csg.books.bookPrice.contexts.BookPriceContext;
import com.pearson.qa.bluesky.csg.books.bookPrice.executors.BookPriceExecutor;
import com.pearson.qa.bluesky.csg.books.bookPrice.validators.BookPriceValidator;
import com.pearson.qa.common.ziggyfw.executors.Executor;
import com.pearson.qa.common.ziggyfw.validators.Validator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dcorrales on 2/21/14.
 */
public class BookPriceModule extends AbstractModule {

        @Provides
        public List<Executor<BookPriceContext>> getExecutors(BookPriceExecutor<BookPriceContext> executor)
        {
            List<Executor<BookPriceContext>> executors = new ArrayList<>();
            executors.add(executor);
            return executors;
        }

        @Provides
        public List<Validator<BookPriceContext>> getValidators(BookPriceValidator validator)
        {
            List<Validator<BookPriceContext>> validators = new ArrayList<>();
            validators.add(validator);
            return validators;
        }

        @Override
        protected void configure() {

        }
}
