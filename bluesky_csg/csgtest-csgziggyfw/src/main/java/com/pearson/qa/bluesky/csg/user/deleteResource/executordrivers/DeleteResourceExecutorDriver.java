package com.pearson.qa.bluesky.csg.user.deleteResource.executordrivers;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.pearson.qa.bluesky.csg.user.deleteResource.contexts.DeleteResourceContext;
import com.pearson.qa.common.ziggyfw.executiondrivers.ExecutionDriver;
import com.pearson.qa.common.ziggyfw.executors.Executor;

import java.util.List;

@Singleton
public class DeleteResourceExecutorDriver extends ExecutionDriver<DeleteResourceContext> {

    @Inject
    public DeleteResourceExecutorDriver(List<Executor<DeleteResourceContext>> executors) {
        super(executors);
    }
}
