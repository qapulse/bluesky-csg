package com.pearson.qa.bluesky.csg.books.createOrderHeader.executordrivers;

import com.google.inject.Singleton;
import com.pearson.qa.bluesky.csg.books.createOrderHeader.contexts.CreateOrderHeaderContext;
import com.pearson.qa.common.ziggyfw.executiondrivers.ExecutionDriver;
import com.pearson.qa.common.ziggyfw.executors.Executor;

import javax.inject.Inject;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: dcorrales
 * Date: 2/19/14
 * Time: 10:01 AM
 * To change this template use File | Settings | File Templates.
 */
@Singleton
public class CreateOrderHeaderExecutorDriver extends ExecutionDriver<CreateOrderHeaderContext> {

    @Inject
    public CreateOrderHeaderExecutorDriver(List<Executor<CreateOrderHeaderContext>> executors ){
        super(executors);
    }
}
