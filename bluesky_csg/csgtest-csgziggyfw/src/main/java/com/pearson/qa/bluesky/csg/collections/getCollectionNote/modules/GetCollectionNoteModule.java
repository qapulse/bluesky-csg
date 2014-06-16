package com.pearson.qa.bluesky.csg.collections.getCollectionNote.modules;


import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.pearson.qa.bluesky.csg.collections.getCollectionNote.contexts.GetCollectionNoteContext;
import com.pearson.qa.bluesky.csg.collections.getCollectionNote.executors.GetCollectionNoteExecutor;
import com.pearson.qa.bluesky.csg.collections.getCollectionNote.validators.GetCollectionNoteValidator;
import com.pearson.qa.common.ziggyfw.executors.Executor;
import com.pearson.qa.common.ziggyfw.validators.Validator;

import java.util.ArrayList;
import java.util.List;


public class GetCollectionNoteModule extends AbstractModule {

    @Provides
    public List<Executor<GetCollectionNoteContext>> getLoginExecutors(GetCollectionNoteExecutor<GetCollectionNoteContext> executor)
    {
        List<Executor<GetCollectionNoteContext>> executors = new ArrayList<>();
        executors.add(executor);
        return executors;
    }

    @Provides
    public List<Validator<GetCollectionNoteContext>> getLoginValidators(GetCollectionNoteValidator validator)
    {
        List<Validator<GetCollectionNoteContext>> validators = new ArrayList<>();
        validators.add(validator);
        return validators;
    }

    @Override
    protected void configure() {

    }
}