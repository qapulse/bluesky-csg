package com.pearson.qa.bluesky.csg.books.territories.executordrivers;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.pearson.qa.bluesky.csg.books.territories.contexts.TerritoriesContext;
import com.pearson.qa.common.ziggyfw.executiondrivers.ExecutionDriver;
import com.pearson.qa.common.ziggyfw.executors.Executor;

import java.util.List;

/**
 * Created by dcorrales on 2/24/14.
 */
@Singleton
public class TerritoriesExecutorDriver  extends ExecutionDriver<TerritoriesContext> {

    @Inject
    public TerritoriesExecutorDriver(List<Executor<TerritoriesContext>> executors ){
        super(executors);
    }
}
