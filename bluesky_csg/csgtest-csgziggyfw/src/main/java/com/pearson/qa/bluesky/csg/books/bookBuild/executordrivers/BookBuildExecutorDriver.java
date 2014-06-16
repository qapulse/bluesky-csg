package com.pearson.qa.bluesky.csg.books.bookBuild.executordrivers;

/**
 * Created by dcorrales on 2/27/14.
 */
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.pearson.qa.bluesky.csg.books.bookBuild.contexts.BookBuildContext;
import com.pearson.qa.common.ziggyfw.executiondrivers.ExecutionDriver;
import com.pearson.qa.common.ziggyfw.executors.Executor;

import java.util.List;

@Singleton
public class BookBuildExecutorDriver  extends ExecutionDriver<BookBuildContext> {

    @Inject
    public BookBuildExecutorDriver(List<Executor<BookBuildContext>> executors ){
        super(executors);
    }
}
