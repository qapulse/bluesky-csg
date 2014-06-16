package com.pearson.qa.bluesky.csg.taxonomies.collectionsByTaxonomyCourse.executordrivers;


import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.pearson.qa.bluesky.csg.taxonomies.collectionsByTaxonomyCourse.contexts.CollectionsByTaxonomyCourseContext;
import com.pearson.qa.common.ziggyfw.executiondrivers.ExecutionDriver;
import com.pearson.qa.common.ziggyfw.executors.Executor;

import java.util.List;

@Singleton
public class CollectionsByTaxonomyCourseExecutorDriver  extends ExecutionDriver<CollectionsByTaxonomyCourseContext> {

    @Inject
    public CollectionsByTaxonomyCourseExecutorDriver(List<Executor<CollectionsByTaxonomyCourseContext>> executors ){
        super(executors);
    }
}
