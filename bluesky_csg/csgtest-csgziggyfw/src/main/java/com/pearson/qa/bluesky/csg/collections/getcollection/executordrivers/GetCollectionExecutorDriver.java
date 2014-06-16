package com.pearson.qa.bluesky.csg.collections.getcollection.executordrivers;


import com.pearson.qa.bluesky.csg.collections.getcollection.contexts.GetCollectionContext;
import com.pearson.qa.common.ziggyfw.executiondrivers.ExecutionDriver;
import com.pearson.qa.common.ziggyfw.executors.Executor;


import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

/**
 * Created by brian on 3/9/14.
 */

@Singleton
public class GetCollectionExecutorDriver  extends ExecutionDriver<GetCollectionContext> {

    @Inject
    public GetCollectionExecutorDriver(List<Executor<GetCollectionContext>> executors ){
        super(executors);
    }
}
