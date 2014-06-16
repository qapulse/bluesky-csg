package com.pearson.qa.bluesky.csg.collections.createCollectionNotes.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.pearson.qa.bluesky.csg.collections.createCollectionNotes.contexts.CreateCollectionNotesContext;
import com.pearson.qa.bluesky.csg.collections.createCollectionNotes.executors.CreateCollectionNotesExecutor;
import com.pearson.qa.bluesky.csg.collections.createCollectionNotes.validators.CreateCollectionNotesValidator;
import com.pearson.qa.common.ziggyfw.executors.Executor;
import com.pearson.qa.common.ziggyfw.validators.Validator;

import java.util.ArrayList;
import java.util.List;


public class CreateCollectionNotesModule extends AbstractModule {

    @Provides
    public List<Executor<CreateCollectionNotesContext>> getLoginExecutors(CreateCollectionNotesExecutor<CreateCollectionNotesContext> executor)
    {
        List<Executor<CreateCollectionNotesContext>> executors = new ArrayList<>();
        executors.add(executor);
        return executors;
    }

    @Provides
    public List<Validator<CreateCollectionNotesContext>> getLoginValidators(CreateCollectionNotesValidator validator)
    {
        List<Validator<CreateCollectionNotesContext>> validators = new ArrayList<>();
        validators.add(validator);
        return validators;
    }

    @Override
    protected void configure() {

    }
}
