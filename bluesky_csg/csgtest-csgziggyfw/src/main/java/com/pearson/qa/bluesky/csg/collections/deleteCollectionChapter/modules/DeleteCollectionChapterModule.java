package com.pearson.qa.bluesky.csg.collections.deleteCollectionChapter.modules;


import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.pearson.qa.bluesky.csg.collections.deleteCollectionChapter.contexts.DeleteCollectionChapterContext;
import com.pearson.qa.bluesky.csg.collections.deleteCollectionChapter.executors.DeleteCollectionChapterExecutor;
import com.pearson.qa.bluesky.csg.collections.deleteCollectionChapter.validators.DeleteCollectionChapterValidator;
import com.pearson.qa.common.ziggyfw.executors.Executor;
import com.pearson.qa.common.ziggyfw.validators.Validator;

import java.util.ArrayList;
import java.util.List;


public class DeleteCollectionChapterModule extends AbstractModule {

    @Provides
    public List<Executor<DeleteCollectionChapterContext>> getLoginExecutors(DeleteCollectionChapterExecutor<DeleteCollectionChapterContext> executor)
    {
        List<Executor<DeleteCollectionChapterContext>> executors = new ArrayList<>();
        executors.add(executor);
        return executors;
    }

    @Provides
    public List<Validator<DeleteCollectionChapterContext>> getLoginValidators(DeleteCollectionChapterValidator validator)
    {
        List<Validator<DeleteCollectionChapterContext>> validators = new ArrayList<>();
        validators.add(validator);
        return validators;
    }

    @Override
    protected void configure() {

    }
}
