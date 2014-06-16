package com.pearson.qa.bluesky.csg.books.approveISBNs.executordrivers;

/**
 * Created by didiercorrales on 3/4/14.
 */

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.pearson.qa.bluesky.csg.books.approveISBNs.contexts.ApproveIsbnContext;
import com.pearson.qa.common.ziggyfw.executiondrivers.ExecutionDriver;
import com.pearson.qa.common.ziggyfw.executors.Executor;

import java.util.List;

@Singleton
public class ApproveIsbnExecutorDriver extends ExecutionDriver<ApproveIsbnContext> {

    @Inject
    public ApproveIsbnExecutorDriver(List<Executor<ApproveIsbnContext>> executors) {
        super(executors);
    }
}
