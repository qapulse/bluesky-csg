package com.pearson.qa.bluesky.csg.books.createOrderDetail.executordrivers;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.pearson.qa.bluesky.csg.books.createOrderDetail.contexts.CreateOrderDetailContext;
import com.pearson.qa.common.ziggyfw.executiondrivers.ExecutionDriver;
import com.pearson.qa.common.ziggyfw.executors.Executor;

import java.util.List;

/**
 * Created by didiercorrales on 2/26/14.
 */

@Singleton
public class CreateOrderDetailExecutorDriver  extends ExecutionDriver<CreateOrderDetailContext> {

    @Inject
    public CreateOrderDetailExecutorDriver(List<Executor<CreateOrderDetailContext>> executors ){
        super(executors);
    }
}
