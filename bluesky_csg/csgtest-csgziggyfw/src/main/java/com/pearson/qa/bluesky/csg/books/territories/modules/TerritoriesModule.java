package com.pearson.qa.bluesky.csg.books.territories.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.pearson.qa.bluesky.csg.books.territories.contexts.TerritoriesContext;
import com.pearson.qa.bluesky.csg.books.territories.executors.TerritoriesExecutor;
import com.pearson.qa.bluesky.csg.books.territories.validators.TerritoriesValidator;
import com.pearson.qa.common.ziggyfw.executors.Executor;
import com.pearson.qa.common.ziggyfw.validators.Validator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dcorrales on 2/24/14.
 */
public class TerritoriesModule extends AbstractModule {

    @Provides
    public List<Executor<TerritoriesContext>> getExecutors(TerritoriesExecutor<TerritoriesContext> executor)
    {
        List<Executor<TerritoriesContext>> executors = new ArrayList<>();
        executors.add(executor);
        return executors;
    }

    @Provides
    public List<Validator<TerritoriesContext>> getValidators(TerritoriesValidator validator)
    {
        List<Validator<TerritoriesContext>> validators = new ArrayList<>();
        validators.add(validator);
        return validators;
    }

    @Override
    protected void configure() {

    }
}
