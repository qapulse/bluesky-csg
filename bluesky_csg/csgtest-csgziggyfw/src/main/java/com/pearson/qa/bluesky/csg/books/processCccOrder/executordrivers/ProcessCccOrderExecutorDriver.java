package com.pearson.qa.bluesky.csg.books.processCccOrder.executordrivers;

/**
 * Created by didiercorrales on 3/9/14.
 */
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.pearson.qa.bluesky.csg.books.processCccOrder.contexts.ProcessCccOrderContext;
import com.pearson.qa.common.ziggyfw.executiondrivers.ExecutionDriver;
import com.pearson.qa.common.ziggyfw.executors.Executor;

import java.util.List;

@Singleton
public class ProcessCccOrderExecutorDriver  extends ExecutionDriver<ProcessCccOrderContext> {

    @Inject
    public ProcessCccOrderExecutorDriver(List<Executor<ProcessCccOrderContext>> executors ){
        super(executors);
    }
}
