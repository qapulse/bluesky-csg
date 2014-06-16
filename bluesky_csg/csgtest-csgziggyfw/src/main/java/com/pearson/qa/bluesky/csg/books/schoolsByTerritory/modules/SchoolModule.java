package com.pearson.qa.bluesky.csg.books.schoolsByTerritory.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.pearson.qa.bluesky.csg.books.schoolsByTerritory.contexts.SchoolContext;
import com.pearson.qa.bluesky.csg.books.schoolsByTerritory.executors.SchoolExecutor;
import com.pearson.qa.bluesky.csg.books.schoolsByTerritory.validators.SchoolValidator;
import com.pearson.qa.common.ziggyfw.executors.Executor;
import com.pearson.qa.common.ziggyfw.validators.Validator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dcorrales on 2/24/14.
 */
public class SchoolModule extends AbstractModule {

    @Provides
    public List<Executor<SchoolContext>> getExecutors(SchoolExecutor<SchoolContext> executor)
    {
        List<Executor<SchoolContext>> executors = new ArrayList<>();
        executors.add(executor);
        return executors;
    }

    @Provides
    public List<Validator<SchoolContext>> getValidators(SchoolValidator validator)
    {
        List<Validator<SchoolContext>> validators = new ArrayList<>();
        validators.add(validator);
        return validators;
    }

    @Override
    protected void configure() {

    }
}
