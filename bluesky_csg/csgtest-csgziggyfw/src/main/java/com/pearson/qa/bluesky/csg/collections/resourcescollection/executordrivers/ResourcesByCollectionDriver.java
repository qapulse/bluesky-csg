package com.pearson.qa.bluesky.csg.collections.resourcescollection.executordrivers;

import com.google.inject.Singleton;
import com.pearson.qa.bluesky.csg.collections.resourcescollection.contexts.ResourcesByCollection;
import com.pearson.qa.common.ziggyfw.executiondrivers.ExecutionDriver;
import com.pearson.qa.common.ziggyfw.executors.Executor;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by brian on 2/27/14.
 */

@Singleton
public class ResourcesByCollectionDriver extends ExecutionDriver<ResourcesByCollection> {
    @Inject
    public ResourcesByCollectionDriver(List<Executor<ResourcesByCollection>> executors)
    {
        super(executors);
    }

}
