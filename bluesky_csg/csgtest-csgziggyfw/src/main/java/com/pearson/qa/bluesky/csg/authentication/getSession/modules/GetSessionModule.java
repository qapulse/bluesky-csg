package com.pearson.qa.bluesky.csg.authentication.getSession.modules;

/**
 * Created by dcorrales on 2/27/14.
 */
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.pearson.qa.bluesky.csg.authentication.getSession.contexts.GetSessionContext;
import com.pearson.qa.bluesky.csg.authentication.getSession.executors.GetSessionExecutor;
import com.pearson.qa.bluesky.csg.authentication.getSession.validators.GetSessionValidator;
import com.pearson.qa.common.ziggyfw.executors.Executor;
import com.pearson.qa.common.ziggyfw.validators.Validator;

import java.util.ArrayList;
import java.util.List;

public class GetSessionModule extends AbstractModule {

    @Provides
    public List<Executor<GetSessionContext>> getLoginExecutors(GetSessionExecutor<GetSessionContext> executor)
    {
        List<Executor<GetSessionContext>> executors = new ArrayList<>();
        executors.add(executor);
        return executors;
    }

    @Provides
    public List<Validator<GetSessionContext>> getLoginValidators(GetSessionValidator validator)
    {
        List<Validator<GetSessionContext>> validators = new ArrayList<>();
        validators.add(validator);
        return validators;
    }

    @Override
    protected void configure() {

    }
}
