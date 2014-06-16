package com.pearson.qa.bluesky.csg.books.owrContentFee.modules;

/**
 * Created by didiercorrales on 3/9/14.
 */
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.pearson.qa.bluesky.csg.books.owrContentFee.contexts.OwrContentFeeContext;
import com.pearson.qa.bluesky.csg.books.owrContentFee.executors.OwrContentFeeExecutor;
import com.pearson.qa.bluesky.csg.books.owrContentFee.validators.OwrContentFeeValidator;
import com.pearson.qa.common.ziggyfw.executors.Executor;
import com.pearson.qa.common.ziggyfw.validators.Validator;

import java.util.ArrayList;
import java.util.List;


public class OwrContentFeeModule extends AbstractModule {

    @Provides
    public List<Executor<OwrContentFeeContext>> getLoginExecutors(OwrContentFeeExecutor<OwrContentFeeContext> executor)
    {
        List<Executor<OwrContentFeeContext>> executors = new ArrayList<>();
        executors.add(executor);
        return executors;
    }

    @Provides
    public List<Validator<OwrContentFeeContext>> getLoginValidators(OwrContentFeeValidator validator)
    {
        List<Validator<OwrContentFeeContext>> validators = new ArrayList<>();
        validators.add(validator);
        return validators;
    }

    @Override
    protected void configure() {

    }
}
