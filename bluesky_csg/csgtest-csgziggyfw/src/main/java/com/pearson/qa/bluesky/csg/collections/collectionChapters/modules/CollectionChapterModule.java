package com.pearson.qa.bluesky.csg.collections.collectionChapters.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.pearson.qa.bluesky.csg.collections.collectionChapters.contexts.CollectionChapterContext;
import com.pearson.qa.bluesky.csg.collections.collectionChapters.executors.CollectionChapterExecutor;
import com.pearson.qa.bluesky.csg.collections.collectionChapters.validators.CollectionChapterValidator;
import com.pearson.qa.common.ziggyfw.executors.Executor;
import com.pearson.qa.common.ziggyfw.validators.Validator;

import java.util.ArrayList;
import java.util.List;


public class CollectionChapterModule extends AbstractModule {

    @Provides
    public List<Executor<CollectionChapterContext>> getLoginExecutors(CollectionChapterExecutor<CollectionChapterContext> executor) {
        List<Executor<CollectionChapterContext>> executors = new ArrayList<>();
        executors.add(executor);
        return executors;
    }

    @Provides
    public List<Validator<CollectionChapterContext>> getLoginValidators(CollectionChapterValidator validator) {
        List<Validator<CollectionChapterContext>> validators = new ArrayList<>();
        validators.add(validator);
        return validators;
    }

    @Override
    protected void configure() {

    }
}
