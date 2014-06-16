package com.pearson.qa.bluesky.csg.taxonomies.getCollectionByISBN.executordrivers;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.pearson.qa.bluesky.csg.taxonomies.getCollectionByISBN.contexts.GetCollectionByISBNContext;
import com.pearson.qa.common.ziggyfw.executiondrivers.ExecutionDriver;
import com.pearson.qa.common.ziggyfw.executors.Executor;

import java.util.List;

@Singleton
public class GetCollectionByISBNExecutorDriver  extends ExecutionDriver<GetCollectionByISBNContext> {

    @Inject
    public GetCollectionByISBNExecutorDriver(List<Executor<GetCollectionByISBNContext>> executors ){
        super(executors);
    }
}