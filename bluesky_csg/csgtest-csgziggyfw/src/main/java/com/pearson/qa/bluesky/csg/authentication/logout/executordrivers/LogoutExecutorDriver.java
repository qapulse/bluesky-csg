package com.pearson.qa.bluesky.csg.authentication.logout.executordrivers;

/**
 * Created by dcorrales on 2/27/14.
 */

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.pearson.qa.bluesky.csg.authentication.logout.contexts.LogoutContext;
import com.pearson.qa.common.ziggyfw.executiondrivers.ExecutionDriver;
import com.pearson.qa.common.ziggyfw.executors.Executor;

import java.util.List;

@Singleton
public class LogoutExecutorDriver  extends ExecutionDriver<LogoutContext> {

    @Inject
    public LogoutExecutorDriver(List<Executor<LogoutContext>> executors ){
        super(executors);
    }
}
