package com.pearson.qa.bluesky.csg.authentication.profile.modules;

/**
 * Created by dcorrales on 2/27/14.
 */
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.pearson.qa.bluesky.csg.authentication.profile.contexts.ProfileContext;
import com.pearson.qa.bluesky.csg.authentication.profile.executors.ProfileExecutor;
import com.pearson.qa.bluesky.csg.authentication.profile.validators.ProfileValidator;
import com.pearson.qa.common.ziggyfw.executors.Executor;
import com.pearson.qa.common.ziggyfw.validators.Validator;

import java.util.ArrayList;
import java.util.List;

public class ProfileModule extends AbstractModule {

    @Provides
    public List<Executor<ProfileContext>> getLoginExecutors(ProfileExecutor<ProfileContext> executor)
    {
        List<Executor<ProfileContext>> executors = new ArrayList<>();
        executors.add(executor);
        return executors;
    }

    @Provides
    public List<Validator<ProfileContext>> getLoginValidators(ProfileValidator validator)
    {
        List<Validator<ProfileContext>> validators = new ArrayList<>();
        validators.add(validator);
        return validators;
    }

    @Override
    protected void configure() {

    }
}
