package com.pearson.qa.bluesky.csg.user.createUserResource.executordrivers;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.pearson.qa.bluesky.csg.user.createUserResource.contexts.CreateUserResourceContext;
import com.pearson.qa.common.ziggyfw.executiondrivers.ExecutionDriver;
import com.pearson.qa.common.ziggyfw.executors.Executor;

import java.util.List;

@Singleton
public class CreateUserResourceExecutorDriver extends ExecutionDriver<CreateUserResourceContext> {

    @Inject
    public CreateUserResourceExecutorDriver(List<Executor<CreateUserResourceContext>> executors) {
        super(executors);
    }
}
