package com.pearson.qa.bluesky.csg.authentication.profile.executordrivers;

/**
 * Created by dcorrales on 2/27/14.
 */

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.pearson.qa.bluesky.csg.authentication.profile.contexts.ProfileContext;
import com.pearson.qa.common.ziggyfw.executiondrivers.ExecutionDriver;
import com.pearson.qa.common.ziggyfw.executors.Executor;

import java.util.List;

@Singleton
public class ProfileExecutorDriver  extends ExecutionDriver<ProfileContext> {

    @Inject
    public ProfileExecutorDriver(List<Executor<ProfileContext>> executors ){
        super(executors);
    }
}
