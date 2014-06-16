package com.pearson.qa.bluesky.csg.collections.deletecollection.executordrivers;

/**
 * Created by didiercorrales on 3/4/14.
 */

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.pearson.qa.bluesky.csg.collections.deletecollection.contexts.DeleteCollectionContext;
import com.pearson.qa.common.ziggyfw.executiondrivers.ExecutionDriver;
import com.pearson.qa.common.ziggyfw.executors.Executor;

import java.util.List;

@Singleton
public class DeleteCollectionExecutorDriver  extends ExecutionDriver<DeleteCollectionContext> {

    @Inject
    public DeleteCollectionExecutorDriver(List<Executor<DeleteCollectionContext>> executors ){
        super(executors);
    }
}
