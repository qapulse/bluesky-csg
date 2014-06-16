package com.pearson.qa.bluesky.csg.collections.getCollectionNotes.executordrivers;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.pearson.qa.bluesky.csg.collections.getCollectionNotes.contexts.GetCollectionNotesContext;
import com.pearson.qa.common.ziggyfw.executiondrivers.ExecutionDriver;
import com.pearson.qa.common.ziggyfw.executors.Executor;

import java.util.List;

@Singleton
public class GetCollectionNotesExecutorDriver extends ExecutionDriver<GetCollectionNotesContext> {

    @Inject
    public GetCollectionNotesExecutorDriver(List<Executor<GetCollectionNotesContext>> executors) {
        super(executors);
    }
}
