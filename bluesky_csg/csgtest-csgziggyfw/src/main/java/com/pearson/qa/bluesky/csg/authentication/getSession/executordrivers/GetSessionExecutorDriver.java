package com.pearson.qa.bluesky.csg.authentication.getSession.executordrivers;

/**
 * Created by dcorrales on 2/27/14.
 */

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.pearson.qa.bluesky.csg.authentication.getSession.contexts.GetSessionContext;
import com.pearson.qa.common.ziggyfw.executiondrivers.ExecutionDriver;
import com.pearson.qa.common.ziggyfw.executors.Executor;

import java.util.List;

@Singleton
public class GetSessionExecutorDriver  extends ExecutionDriver<GetSessionContext> {

    @Inject
    public GetSessionExecutorDriver(List<Executor<GetSessionContext>> executors ){
        super(executors);
    }
}
