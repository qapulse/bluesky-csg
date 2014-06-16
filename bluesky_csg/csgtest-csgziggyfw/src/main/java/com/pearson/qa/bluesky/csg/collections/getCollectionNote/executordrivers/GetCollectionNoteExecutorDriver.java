package com.pearson.qa.bluesky.csg.collections.getCollectionNote.executordrivers;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.pearson.qa.bluesky.csg.collections.getCollectionNote.contexts.GetCollectionNoteContext;
import com.pearson.qa.common.ziggyfw.executiondrivers.ExecutionDriver;
import com.pearson.qa.common.ziggyfw.executors.Executor;

import java.util.List;

@Singleton
public class GetCollectionNoteExecutorDriver  extends ExecutionDriver<GetCollectionNoteContext> {

    @Inject
    public GetCollectionNoteExecutorDriver(List<Executor<GetCollectionNoteContext>> executors ){
        super(executors);
    }
}
