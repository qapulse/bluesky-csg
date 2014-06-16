package com.pearson.qa.bluesky.csg.taxonomies.getTaxonomies.executordrivers;

/**
 * Created with IntelliJ IDEA.
 * User: didiercorrales
 * Date: 3/19/14
 * Time: 10:22 PM
 * To change this template use File | Settings | File Templates.
 */

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.pearson.qa.bluesky.csg.taxonomies.getTaxonomies.contexts.TaxonimiesContext;
import com.pearson.qa.common.ziggyfw.executiondrivers.ExecutionDriver;
import com.pearson.qa.common.ziggyfw.executors.Executor;

import java.util.List;

@Singleton
public class TaxonimiesExecutorDriver  extends ExecutionDriver<TaxonimiesContext> {

    @Inject
    public TaxonimiesExecutorDriver(List<Executor<TaxonimiesContext>> executors ){
        super(executors);
    }
}