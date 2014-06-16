package com.pearson.qa.bluesky.csg.collections.deleteCollectionNote.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.pearson.qa.bluesky.csg.collections.deleteCollectionNote.contexts.DeleteCollectionNoteContext;
import com.pearson.qa.bluesky.csg.collections.deleteCollectionNote.executors.DeleteCollectionNoteExecutor;
import com.pearson.qa.bluesky.csg.collections.deleteCollectionNote.validators.DeleteCollectionNoteValidator;
import com.pearson.qa.common.ziggyfw.executors.Executor;
import com.pearson.qa.common.ziggyfw.validators.Validator;

import java.util.ArrayList;
import java.util.List;


public class DeleteCollectionNoteModule extends AbstractModule {

    @Provides
    public List<Executor<DeleteCollectionNoteContext>> getLoginExecutors(DeleteCollectionNoteExecutor<DeleteCollectionNoteContext> executor)
    {
        List<Executor<DeleteCollectionNoteContext>> executors = new ArrayList<>();
        executors.add(executor);
        return executors;
    }

    @Provides
    public List<Validator<DeleteCollectionNoteContext>> getLoginValidators(DeleteCollectionNoteValidator validator)
    {
        List<Validator<DeleteCollectionNoteContext>> validators = new ArrayList<>();
        validators.add(validator);
        return validators;
    }

    @Override
    protected void configure() {

    }
}