package com.pearson.qa.bluesky.csg.books.bookPrice.executordrivers;

import com.google.inject.Singleton;
import com.pearson.qa.bluesky.csg.books.bookPrice.contexts.BookPriceContext;
import com.pearson.qa.common.ziggyfw.executiondrivers.ExecutionDriver;
import com.pearson.qa.common.ziggyfw.executors.Executor;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by dcorrales on 2/21/14.
 */
@Singleton
public class BookPriceExecutorDriver  extends ExecutionDriver<BookPriceContext> {

    @Inject
    public BookPriceExecutorDriver(List<Executor<BookPriceContext>> executors ){
        super(executors);
    }
}
