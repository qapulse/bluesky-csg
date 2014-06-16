package com.pearson.qa.bluesky.csg.collections.deleteCollectionChapter.executordrivers;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.pearson.qa.bluesky.csg.collections.deleteCollectionChapter.contexts.DeleteCollectionChapterContext;
import com.pearson.qa.common.ziggyfw.executiondrivers.ExecutionDriver;
import com.pearson.qa.common.ziggyfw.executors.Executor;

import java.util.List;

@Singleton
public class DeleteCollectionChapterExecutorDriver  extends ExecutionDriver<DeleteCollectionChapterContext> {

    @Inject
    public DeleteCollectionChapterExecutorDriver(List<Executor<DeleteCollectionChapterContext>> executors ){
        super(executors);
    }
}