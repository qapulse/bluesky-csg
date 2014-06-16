package com.pearson.qa.bluesky.csg.books.updateIsbnStatus.executordrivers;

/**
 * Created by didiercorrales on 3/9/14.
 */
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.pearson.qa.bluesky.csg.books.updateIsbnStatus.contexts.UpdateIsbnStatusContext;
import com.pearson.qa.common.ziggyfw.executiondrivers.ExecutionDriver;
import com.pearson.qa.common.ziggyfw.executors.Executor;

import java.util.List;

@Singleton
public class UpdateIsbnStatusExecutorDriver  extends ExecutionDriver<UpdateIsbnStatusContext> {

    @Inject
    public UpdateIsbnStatusExecutorDriver(List<Executor<UpdateIsbnStatusContext>> executors ){
        super(executors);
    }
}