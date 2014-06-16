package com.pearson.qa.bluesky.csg.books.generateSalesRepReport.executordrivers;

/**
 * Created by dcorrales on 2/27/14.
 */
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.pearson.qa.bluesky.csg.books.generateSalesRepReport.contexts.GenerateSalesRepReportContexts;
import com.pearson.qa.common.ziggyfw.executiondrivers.ExecutionDriver;
import com.pearson.qa.common.ziggyfw.executors.Executor;

import java.util.List;

@Singleton
public class GenerateSalesRepReportExecutorDriver  extends ExecutionDriver<GenerateSalesRepReportContexts> {

    @Inject
    public GenerateSalesRepReportExecutorDriver(List<Executor<GenerateSalesRepReportContexts>> executors ){
        super(executors);
    }
}
