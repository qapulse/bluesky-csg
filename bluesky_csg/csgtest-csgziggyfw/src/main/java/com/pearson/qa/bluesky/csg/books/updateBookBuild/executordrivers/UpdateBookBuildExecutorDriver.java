package com.pearson.qa.bluesky.csg.books.updateBookBuild.executordrivers;

/**
 * Created by didiercorrales on 3/9/14.
 */
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.pearson.qa.bluesky.csg.books.updateBookBuild.contexts.UpdateBookBuildContext;
import com.pearson.qa.common.ziggyfw.executiondrivers.ExecutionDriver;
import com.pearson.qa.common.ziggyfw.executors.Executor;

import java.util.List;

@Singleton
public class UpdateBookBuildExecutorDriver  extends ExecutionDriver<UpdateBookBuildContext> {

    @Inject
    public UpdateBookBuildExecutorDriver(List<Executor<UpdateBookBuildContext>> executors ){
        super(executors);
    }
}
