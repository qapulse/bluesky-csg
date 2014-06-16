package com.pearson.qa.bluesky.csg.collections.updateResourceByResourceInstance.executordrivers;


import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.pearson.qa.bluesky.csg.collections.updateResourceByResourceInstance.contexts.UpdateResourceByResourceInstanceContext;
import com.pearson.qa.common.ziggyfw.executiondrivers.ExecutionDriver;
import com.pearson.qa.common.ziggyfw.executors.Executor;

import java.util.List;

@Singleton
public class UpdateResourceByResourceInstanceExecutorDriver extends ExecutionDriver<UpdateResourceByResourceInstanceContext> {

    @Inject
    public UpdateResourceByResourceInstanceExecutorDriver(List<Executor<UpdateResourceByResourceInstanceContext>> executors) {
        super(executors);
    }
}