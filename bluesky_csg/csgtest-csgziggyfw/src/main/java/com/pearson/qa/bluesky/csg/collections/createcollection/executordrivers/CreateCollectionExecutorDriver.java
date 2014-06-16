package com.pearson.qa.bluesky.csg.collections.createcollection.executordrivers;

import com.google.inject.Singleton;
import com.pearson.qa.bluesky.csg.collections.createcollection.contexts.CreateCollectionContexts;
import com.pearson.qa.common.ziggyfw.executiondrivers.ExecutionDriver;
import com.pearson.qa.common.ziggyfw.executors.Executor;

import javax.inject.Inject;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: dcorrales
 * Date: 2/10/14
 * Time: 3:01 PM
 * To change this template use File | Settings | File Templates.
 */


@Singleton
public class CreateCollectionExecutorDriver  extends ExecutionDriver<CreateCollectionContexts> {
    @Inject
    public CreateCollectionExecutorDriver(List<Executor<CreateCollectionContexts>> executors)
    {
        super(executors);
    }

}
