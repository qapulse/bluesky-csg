package com.pearson.qa.bluesky.csg.books.commitOrderDetail.executordrivers;

/**
 * Created by didiercorrales on 2/26/14.
 */
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.pearson.qa.bluesky.csg.books.commitOrderDetail.contexts.CommitOrderDetailContext;
import com.pearson.qa.common.ziggyfw.executiondrivers.ExecutionDriver;
import com.pearson.qa.common.ziggyfw.executors.Executor;

import java.util.List;

@Singleton
public class CommitOrderDetailExecutorDriver  extends ExecutionDriver<CommitOrderDetailContext> {

    @Inject
    public CommitOrderDetailExecutorDriver(List<Executor<CommitOrderDetailContext>> executors ){
        super(executors);
    }
}

