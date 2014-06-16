package com.pearson.qa.bluesky.csg.user.userResources.executordrivers;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.pearson.qa.bluesky.csg.user.userResources.contexts.UserResourcesContext;
import com.pearson.qa.common.ziggyfw.executiondrivers.ExecutionDriver;
import com.pearson.qa.common.ziggyfw.executors.Executor;

import java.util.List;

@Singleton
public class UserResourcesExecutorDriver extends ExecutionDriver<UserResourcesContext> {

    @Inject
    public UserResourcesExecutorDriver(List<Executor<UserResourcesContext>> executors) {
        super(executors);
    }
}