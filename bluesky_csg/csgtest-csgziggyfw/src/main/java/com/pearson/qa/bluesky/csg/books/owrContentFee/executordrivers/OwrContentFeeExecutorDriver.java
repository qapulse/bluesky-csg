package com.pearson.qa.bluesky.csg.books.owrContentFee.executordrivers;

/**
 * Created by didiercorrales on 3/9/14.
 */

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.pearson.qa.bluesky.csg.books.owrContentFee.contexts.OwrContentFeeContext;
import com.pearson.qa.common.ziggyfw.executiondrivers.ExecutionDriver;
import com.pearson.qa.common.ziggyfw.executors.Executor;

import java.util.List;

@Singleton
public class OwrContentFeeExecutorDriver extends ExecutionDriver<OwrContentFeeContext> {

    @Inject
    public OwrContentFeeExecutorDriver(List<Executor<OwrContentFeeContext>> executors) {
        super(executors);
    }
}
