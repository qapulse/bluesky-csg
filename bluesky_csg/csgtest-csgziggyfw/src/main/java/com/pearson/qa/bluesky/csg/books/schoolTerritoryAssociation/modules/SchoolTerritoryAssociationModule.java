package com.pearson.qa.bluesky.csg.books.schoolTerritoryAssociation.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.pearson.qa.bluesky.csg.books.schoolTerritoryAssociation.contexts.SchoolTerritoryAssociationContext;
import com.pearson.qa.bluesky.csg.books.schoolTerritoryAssociation.executors.SchoolTerritoryAssociationExecutor;
import com.pearson.qa.bluesky.csg.books.schoolTerritoryAssociation.validators.SchoolTerritoryAssociationValidator;
import com.pearson.qa.common.ziggyfw.executors.Executor;
import com.pearson.qa.common.ziggyfw.validators.Validator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dcorrales on 2/25/14.
 */
public class SchoolTerritoryAssociationModule extends AbstractModule {

    @Provides
    public List<Executor<SchoolTerritoryAssociationContext>> getExecutors(SchoolTerritoryAssociationExecutor<SchoolTerritoryAssociationContext> executor)
    {
        List<Executor<SchoolTerritoryAssociationContext>> executors = new ArrayList<>();
        executors.add(executor);
        return executors;
    }

    @Provides
    public List<Validator<SchoolTerritoryAssociationContext>> getValidators(SchoolTerritoryAssociationValidator validator)
    {
        List<Validator<SchoolTerritoryAssociationContext>> validators = new ArrayList<>();
        validators.add(validator);
        return validators;
    }

    @Override
    protected void configure() {

    }
}

