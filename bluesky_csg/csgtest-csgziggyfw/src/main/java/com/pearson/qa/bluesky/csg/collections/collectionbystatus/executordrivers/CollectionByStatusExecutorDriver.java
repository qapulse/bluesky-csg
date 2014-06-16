package com.pearson.qa.bluesky.csg.collections.collectionbystatus.executordrivers;

import com.pearson.qa.bluesky.csg.collections.collectionbystatus.contexts.CollectionByStatusContexts;
import com.pearson.qa.common.ziggyfw.executiondrivers.ExecutionDriver;
import com.pearson.qa.common.ziggyfw.executors.Executor;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

/**
 * Created by brian on 3/22/14.
 */

@Singleton
public class CollectionByStatusExecutorDriver  extends ExecutionDriver<CollectionByStatusContexts> {

    @Inject
    public CollectionByStatusExecutorDriver(List<Executor<CollectionByStatusContexts>> executors ){
        super(executors);
    }
}