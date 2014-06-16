package com.pearson.qa.bluesky.csg.collections.createCollectionNotes.executordrivers;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.pearson.qa.bluesky.csg.collections.createCollectionNotes.contexts.CreateCollectionNotesContext;
import com.pearson.qa.common.ziggyfw.executiondrivers.ExecutionDriver;
import com.pearson.qa.common.ziggyfw.executors.Executor;

import java.util.List;

@Singleton
public class CreateCollectionNotesExecutorDriver  extends ExecutionDriver<CreateCollectionNotesContext> {

    @Inject
    public CreateCollectionNotesExecutorDriver(List<Executor<CreateCollectionNotesContext>> executors ){
        super(executors);
    }
}
