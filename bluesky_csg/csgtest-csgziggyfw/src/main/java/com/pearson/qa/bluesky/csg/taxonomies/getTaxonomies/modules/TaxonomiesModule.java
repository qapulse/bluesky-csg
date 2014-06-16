package com.pearson.qa.bluesky.csg.taxonomies.getTaxonomies.modules;

/**
 * Created with IntelliJ IDEA.
 * User: didiercorrales
 * Date: 3/19/14
 * Time: 10:23 PM
 * To change this template use File | Settings | File Templates.
 */

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.pearson.qa.bluesky.csg.taxonomies.getTaxonomies.contexts.TaxonimiesContext;
import com.pearson.qa.bluesky.csg.taxonomies.getTaxonomies.executors.TaxonomiesExecutor;
import com.pearson.qa.bluesky.csg.taxonomies.getTaxonomies.validators.TaxonomiesValidator;
import com.pearson.qa.common.ziggyfw.executors.Executor;
import com.pearson.qa.common.ziggyfw.validators.Validator;

import java.util.ArrayList;
import java.util.List;


public class TaxonomiesModule extends AbstractModule {

    @Provides
    public List<Executor<TaxonimiesContext>> getLoginExecutors(TaxonomiesExecutor<TaxonimiesContext> executor)
    {
        List<Executor<TaxonimiesContext>> executors = new ArrayList<>();
        executors.add(executor);
        return executors;
    }

    @Provides
    public List<Validator<TaxonimiesContext>> getLoginValidators(TaxonomiesValidator validator)
    {
        List<Validator<TaxonimiesContext>> validators = new ArrayList<>();
        validators.add(validator);
        return validators;
    }

    @Override
    protected void configure() {

    }
}
