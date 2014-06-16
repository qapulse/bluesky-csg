package com.pearson.qa.bluesky.csg.collections.deleteCollectionNote.executordrivers;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.pearson.qa.bluesky.csg.collections.deleteCollectionNote.contexts.DeleteCollectionNoteContext;
import com.pearson.qa.common.ziggyfw.executiondrivers.ExecutionDriver;
import com.pearson.qa.common.ziggyfw.executors.Executor;

import java.util.List;

@Singleton
public class DeleteCollectionNoteExecutorDriver  extends ExecutionDriver<DeleteCollectionNoteContext> {

    @Inject
    public DeleteCollectionNoteExecutorDriver(List<Executor<DeleteCollectionNoteContext>> executors ){
        super(executors);
    }
}