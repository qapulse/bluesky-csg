package com.pearson.qa.bluesky.csg.books.oplUrl.modules;

/**
 * Created by didiercorrales on 3/9/14.
 */
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.pearson.qa.bluesky.csg.books.oplUrl.contexts.OplUrlContext;
import com.pearson.qa.bluesky.csg.books.oplUrl.executors.OplUrlExecutor;
import com.pearson.qa.bluesky.csg.books.oplUrl.validators.OplUrlValidator;
import com.pearson.qa.common.ziggyfw.executors.Executor;
import com.pearson.qa.common.ziggyfw.validators.Validator;

import java.util.ArrayList;
import java.util.List;


public class OplUrlModule extends AbstractModule {

    @Provides
    public List<Executor<OplUrlContext>> getLoginExecutors(OplUrlExecutor<OplUrlContext> executor)
    {
        List<Executor<OplUrlContext>> executors = new ArrayList<>();
        executors.add(executor);
        return executors;
    }

    @Provides
    public List<Validator<OplUrlContext>> getLoginValidators(OplUrlValidator validator)
    {
        List<Validator<OplUrlContext>> validators = new ArrayList<>();
        validators.add(validator);
        return validators;
    }

    @Override
    protected void configure() {

    }
}