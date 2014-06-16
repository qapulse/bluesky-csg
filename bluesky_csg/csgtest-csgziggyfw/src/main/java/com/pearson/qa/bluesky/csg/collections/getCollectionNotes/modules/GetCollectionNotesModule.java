package com.pearson.qa.bluesky.csg.collections.getCollectionNotes.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.pearson.qa.bluesky.csg.collections.getCollectionNotes.contexts.GetCollectionNotesContext;
import com.pearson.qa.bluesky.csg.collections.getCollectionNotes.executors.GetCollectionNotesExecutor;
import com.pearson.qa.bluesky.csg.collections.getCollectionNotes.validators.GetCollectionNotesValidator;
import com.pearson.qa.common.ziggyfw.executors.Executor;
import com.pearson.qa.common.ziggyfw.validators.Validator;

import java.util.ArrayList;
import java.util.List;


public class GetCollectionNotesModule extends AbstractModule {

    @Provides
    public List<Executor<GetCollectionNotesContext>> getLoginExecutors(GetCollectionNotesExecutor<GetCollectionNotesContext> executor)
    {
        List<Executor<GetCollectionNotesContext>> executors = new ArrayList<>();
        executors.add(executor);
        return executors;
    }

    @Provides
    public List<Validator<GetCollectionNotesContext>> getLoginValidators(GetCollectionNotesValidator validator)
    {
        List<Validator<GetCollectionNotesContext>> validators = new ArrayList<>();
        validators.add(validator);
        return validators;
    }

    @Override
    protected void configure() {

    }
}
