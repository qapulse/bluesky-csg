package com.pearson.qa.bluesky.csg.books.schoolsByTerritory.executorDrivers;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.pearson.qa.bluesky.csg.books.schoolsByTerritory.contexts.SchoolContext;
import com.pearson.qa.common.ziggyfw.executiondrivers.ExecutionDriver;
import com.pearson.qa.common.ziggyfw.executors.Executor;

import java.util.List;

/**
 * Created by dcorrales on 2/24/14.
 */
@Singleton
public class SchoolExecutorDriver  extends ExecutionDriver<SchoolContext> {

    @Inject
    public SchoolExecutorDriver(List<Executor<SchoolContext>> executors ){
        super(executors);
    }
}
