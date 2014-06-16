package com.pearson.qa.bluesky.csg.books.bookRegisteredDetails.executorDrivers;

/**
 * Created by dcorrales on 2/27/14.
 */

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.pearson.qa.bluesky.csg.books.bookRegisteredDetails.contexts.BookRegisteredDetailsContext;
import com.pearson.qa.common.ziggyfw.executiondrivers.ExecutionDriver;
import com.pearson.qa.common.ziggyfw.executors.Executor;

import java.util.List;

@Singleton
public class BookRegisteredDetailsExecutorDriver extends ExecutionDriver<BookRegisteredDetailsContext> {

    @Inject
    public BookRegisteredDetailsExecutorDriver(List<Executor<BookRegisteredDetailsContext>> executors) {
        super(executors);
    }
}

