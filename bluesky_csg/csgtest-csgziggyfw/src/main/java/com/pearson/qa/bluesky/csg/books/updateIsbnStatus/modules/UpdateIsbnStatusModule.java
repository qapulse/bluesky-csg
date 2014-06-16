package com.pearson.qa.bluesky.csg.books.updateIsbnStatus.modules;

/**
 * Created by didiercorrales on 3/9/14.
 */


import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.pearson.qa.bluesky.csg.books.updateIsbnStatus.contexts.UpdateIsbnStatusContext;
import com.pearson.qa.bluesky.csg.books.updateIsbnStatus.executors.UpdateIsbnStatusExecutor;
import com.pearson.qa.bluesky.csg.books.updateIsbnStatus.validators.UpdateIsbnStatusValidator;
import com.pearson.qa.common.ziggyfw.executors.Executor;
import com.pearson.qa.common.ziggyfw.validators.Validator;

import java.util.ArrayList;
import java.util.List;


public class UpdateIsbnStatusModule extends AbstractModule {

    @Provides
    public List<Executor<UpdateIsbnStatusContext>> getLoginExecutors(UpdateIsbnStatusExecutor<UpdateIsbnStatusContext> executor)
    {
        List<Executor<UpdateIsbnStatusContext>> executors = new ArrayList<>();
        executors.add(executor);
        return executors;
    }

    @Provides
    public List<Validator<UpdateIsbnStatusContext>> getLoginValidators(UpdateIsbnStatusValidator validator)
    {
        List<Validator<UpdateIsbnStatusContext>> validators = new ArrayList<>();
        validators.add(validator);
        return validators;
    }

    @Override
    protected void configure() {

    }
}
