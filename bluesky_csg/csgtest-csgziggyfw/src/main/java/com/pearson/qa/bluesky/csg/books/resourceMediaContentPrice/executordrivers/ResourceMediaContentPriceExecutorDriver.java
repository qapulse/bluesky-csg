package com.pearson.qa.bluesky.csg.books.resourceMediaContentPrice.executordrivers;

/**
 * Created by didiercorrales on 3/9/14.
 */
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.pearson.qa.bluesky.csg.books.resourceMediaContentPrice.contexts.ResourceMediaContentPriceContext;
import com.pearson.qa.common.ziggyfw.executiondrivers.ExecutionDriver;
import com.pearson.qa.common.ziggyfw.executors.Executor;

import java.util.List;

@Singleton
public class ResourceMediaContentPriceExecutorDriver  extends ExecutionDriver<ResourceMediaContentPriceContext> {

    @Inject
    public ResourceMediaContentPriceExecutorDriver(List<Executor<ResourceMediaContentPriceContext>> executors ){
        super(executors);
    }
}
