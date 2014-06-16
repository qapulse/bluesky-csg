package com.pearson.qa.bluesky.csg.collections.deletecollection.modules;

/**
 * Created by didiercorrales on 3/4/14.
 */

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.pearson.qa.bluesky.csg.collections.deletecollection.contexts.DeleteCollectionContext;
import com.pearson.qa.bluesky.csg.collections.deletecollection.executors.DeleteCollectionExecutor;
import com.pearson.qa.bluesky.csg.collections.deletecollection.validators.DeleteCollectionValidator;
import com.pearson.qa.common.ziggyfw.executors.Executor;
import com.pearson.qa.common.ziggyfw.validators.Validator;

import java.util.ArrayList;
import java.util.List;

public class DeleteCollectionModule extends AbstractModule {

    @Provides
    public List<Executor<DeleteCollectionContext>> getLoginExecutors(DeleteCollectionExecutor<DeleteCollectionContext> executor)
    {
        List<Executor<DeleteCollectionContext>> executors = new ArrayList<>();
        executors.add(executor);
        return executors;
    }

    @Provides
    public List<Validator<DeleteCollectionContext>> getLoginValidators(DeleteCollectionValidator validator)
    {
        List<Validator<DeleteCollectionContext>> validators = new ArrayList<>();
        validators.add(validator);
        return validators;
    }

    @Override
    protected void configure() {

    }
}
