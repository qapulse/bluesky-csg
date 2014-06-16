package com.pearson.qa.bluesky.csg.collections.collectionChapters.executordrivers;


import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.pearson.qa.bluesky.csg.collections.collectionChapters.contexts.CollectionChapterContext;
import com.pearson.qa.common.ziggyfw.executiondrivers.ExecutionDriver;
import com.pearson.qa.common.ziggyfw.executors.Executor;

import java.util.List;

@Singleton
public class CollectionChapterExecutorDriver extends ExecutionDriver<CollectionChapterContext> {

    @Inject
    public CollectionChapterExecutorDriver(List<Executor<CollectionChapterContext>> executors) {
        super(executors);
    }
}