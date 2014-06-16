package com.pearson.qa.bluesky.csg.books.isbnByNumberOrStatus.executordrivers;

/**
 * Created by didiercorrales on 2/26/14.
 */

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.pearson.qa.bluesky.csg.books.isbnByNumberOrStatus.contexts.IsbnByNumberOrStatusContext;
import com.pearson.qa.common.ziggyfw.executiondrivers.ExecutionDriver;
import com.pearson.qa.common.ziggyfw.executors.Executor;

import java.util.List;

@Singleton
public class IsbnByNumberOrStatusExecutorDriver extends ExecutionDriver<IsbnByNumberOrStatusContext> {

    @Inject
    public IsbnByNumberOrStatusExecutorDriver(List<Executor<IsbnByNumberOrStatusContext>> executors) {
        super(executors);
    }
}
