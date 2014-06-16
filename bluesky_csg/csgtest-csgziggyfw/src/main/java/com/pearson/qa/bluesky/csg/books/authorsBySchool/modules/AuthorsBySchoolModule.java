package com.pearson.qa.bluesky.csg.books.authorsBySchool.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.pearson.qa.bluesky.csg.books.authorsBySchool.contexts.AuthorsBySchoolContext;
import com.pearson.qa.bluesky.csg.books.authorsBySchool.executors.AuthorsBySchoolExecutor;
import com.pearson.qa.bluesky.csg.books.authorsBySchool.validators.AuthorsBySchoolValidator;
import com.pearson.qa.common.ziggyfw.executors.Executor;
import com.pearson.qa.common.ziggyfw.validators.Validator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dcorrales on 2/24/14.
 */
public class AuthorsBySchoolModule extends AbstractModule {

    @Provides
    public List<Executor<AuthorsBySchoolContext>> getExecutors(AuthorsBySchoolExecutor<AuthorsBySchoolContext> executor)
    {
        List<Executor<AuthorsBySchoolContext>> executors = new ArrayList<>();
        executors.add(executor);
        return executors;
    }

    @Provides
    public List<Validator<AuthorsBySchoolContext>> getValidators(AuthorsBySchoolValidator validator)
    {
        List<Validator<AuthorsBySchoolContext>> validators = new ArrayList<>();
        validators.add(validator);
        return validators;
    }

    @Override
    protected void configure() {

    }
}
