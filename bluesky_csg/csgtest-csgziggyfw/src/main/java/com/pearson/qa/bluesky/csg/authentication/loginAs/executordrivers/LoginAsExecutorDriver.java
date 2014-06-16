package com.pearson.qa.bluesky.csg.authentication.loginAs.executordrivers;

/**
 * Created by dcorrales on 2/27/14.
 */
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.pearson.qa.bluesky.csg.authentication.loginAs.contexts.LoginAsContext;
import com.pearson.qa.common.ziggyfw.executiondrivers.ExecutionDriver;
import com.pearson.qa.common.ziggyfw.executors.Executor;

import java.util.List;

@Singleton
public class LoginAsExecutorDriver  extends ExecutionDriver<LoginAsContext> {

    @Inject
    public LoginAsExecutorDriver(List<Executor<LoginAsContext>> executors ){
        super(executors);
    }
}
