package com.pearson.qa.bluesky.csg.books.chapterPrice.executordrivers;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.pearson.qa.bluesky.csg.books.chapterPrice.contexts.ChapterPriceContext;
import com.pearson.qa.common.ziggyfw.executiondrivers.ExecutionDriver;
import com.pearson.qa.common.ziggyfw.executors.Executor;

import java.util.List;

/**
 * Created by Game on 2/23/14.
 */

@Singleton
public class ChapterPriceExecutorDriver  extends ExecutionDriver<ChapterPriceContext> {

    @Inject
    public ChapterPriceExecutorDriver(List<Executor<ChapterPriceContext>> executors ){
        super(executors);
    }
}