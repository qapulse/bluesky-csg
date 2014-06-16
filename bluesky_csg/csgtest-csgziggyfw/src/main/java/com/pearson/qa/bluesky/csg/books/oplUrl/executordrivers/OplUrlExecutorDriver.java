package com.pearson.qa.bluesky.csg.books.oplUrl.executordrivers;

/**
 * Created by didiercorrales on 3/9/14.
 */

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.pearson.qa.bluesky.csg.books.oplUrl.contexts.OplUrlContext;
import com.pearson.qa.common.ziggyfw.executiondrivers.ExecutionDriver;
import com.pearson.qa.common.ziggyfw.executors.Executor;

import java.util.List;

@Singleton
public class OplUrlExecutorDriver  extends ExecutionDriver<OplUrlContext> {

    @Inject
    public OplUrlExecutorDriver(List<Executor<OplUrlContext>> executors ){
        super(executors);
    }
}
