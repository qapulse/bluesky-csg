package com.pearson.qa.bluesky.csg.taxonomies.collectionsByTaxonomyCourse.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.pearson.qa.bluesky.csg.taxonomies.collectionsByTaxonomyCourse.contexts.CollectionsByTaxonomyCourseContext;
import com.pearson.qa.bluesky.csg.taxonomies.collectionsByTaxonomyCourse.executors.CollectionsByTaxonomyCourseExecutor;
import com.pearson.qa.bluesky.csg.taxonomies.collectionsByTaxonomyCourse.validators.CollectionsByTaxonomyCourseValidator;
import com.pearson.qa.common.ziggyfw.executors.Executor;
import com.pearson.qa.common.ziggyfw.validators.Validator;

import java.util.ArrayList;
import java.util.List;


public class CollectionsByTaxonomyCourseModule extends AbstractModule {

    @Provides
    public List<Executor<CollectionsByTaxonomyCourseContext>> getLoginExecutors(CollectionsByTaxonomyCourseExecutor<CollectionsByTaxonomyCourseContext> executor)
    {
        List<Executor<CollectionsByTaxonomyCourseContext>> executors = new ArrayList<>();
        executors.add(executor);
        return executors;
    }

    @Provides
    public List<Validator<CollectionsByTaxonomyCourseContext>> getLoginValidators(CollectionsByTaxonomyCourseValidator validator)
    {
        List<Validator<CollectionsByTaxonomyCourseContext>> validators = new ArrayList<>();
        validators.add(validator);
        return validators;
    }

    @Override
    protected void configure() {

    }
}
