package com.pearson.qa.bluesky.csg.books.orderDetailStatus.executordrivers;

/**
 * Created by didiercorrales on 2/26/14.
 */
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.pearson.qa.bluesky.csg.books.orderDetailStatus.contexts.OrderDetailStatusContext;
import com.pearson.qa.common.ziggyfw.executiondrivers.ExecutionDriver;
import com.pearson.qa.common.ziggyfw.executors.Executor;

import java.util.List;

@Singleton
public class OrderDetailStatusExecutorDriver  extends ExecutionDriver<OrderDetailStatusContext> {

    @Inject
    public OrderDetailStatusExecutorDriver(List<Executor<OrderDetailStatusContext>> executors ){
        super(executors);
    }
}
