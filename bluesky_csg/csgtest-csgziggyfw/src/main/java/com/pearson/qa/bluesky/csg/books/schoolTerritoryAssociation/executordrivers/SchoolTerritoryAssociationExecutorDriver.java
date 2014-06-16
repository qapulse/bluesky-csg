package com.pearson.qa.bluesky.csg.books.schoolTerritoryAssociation.executordrivers;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.pearson.qa.bluesky.csg.books.schoolTerritoryAssociation.contexts.SchoolTerritoryAssociationContext;
import com.pearson.qa.common.ziggyfw.executiondrivers.ExecutionDriver;
import com.pearson.qa.common.ziggyfw.executors.Executor;

import java.util.List;

/**
 * Created by dcorrales on 2/25/14.
 */
@Singleton
public class SchoolTerritoryAssociationExecutorDriver  extends ExecutionDriver<SchoolTerritoryAssociationContext> {

    @Inject
    public SchoolTerritoryAssociationExecutorDriver(List<Executor<SchoolTerritoryAssociationContext>> executors ){
        super(executors);
    }
}
