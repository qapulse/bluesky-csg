package com.pearson.qa.bluesky.csg.collections.updatecollection.executordrivers;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.pearson.qa.bluesky.csg.collections.updatecollection.contexts.UpdateCollectionContext;
import com.pearson.qa.common.ziggyfw.executiondrivers.ExecutionDriver;
import com.pearson.qa.common.ziggyfw.executors.Executor;

import java.util.List;

/**
 * Created by brian on 3/13/14.
 */

@Singleton
public class UpdateCollectionBuildExecutorDriver  extends ExecutionDriver<UpdateCollectionContext> {

    @Inject
    public UpdateCollectionBuildExecutorDriver(List<Executor<UpdateCollectionContext>> executors ){
        super(executors);
    }
}
