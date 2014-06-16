package com.pearson.qa.bluesky.csg.books.booksCCCOrders.executordrivers;

/**
 * Created by didiercorrales on 2/26/14.
 */
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.pearson.qa.bluesky.csg.books.booksCCCOrders.contexts.BooksCCCOrdersContext;
import com.pearson.qa.common.ziggyfw.executiondrivers.ExecutionDriver;
import com.pearson.qa.common.ziggyfw.executors.Executor;

import java.util.List;

@Singleton
public class BooksCCCOrdersExecutorDriver  extends ExecutionDriver<BooksCCCOrdersContext> {

    @Inject
    public BooksCCCOrdersExecutorDriver(List<Executor<BooksCCCOrdersContext>> executors ){
        super(executors);
    }
}
