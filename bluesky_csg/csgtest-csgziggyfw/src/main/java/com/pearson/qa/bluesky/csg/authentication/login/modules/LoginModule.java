package com.pearson.qa.bluesky.csg.authentication.login.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.pearson.qa.bluesky.csg.authentication.login.contexts.LoginContext;
import com.pearson.qa.bluesky.csg.authentication.login.executors.LoginExecutor;
import com.pearson.qa.bluesky.csg.authentication.login.validators.LoginValidator;
import com.pearson.qa.common.ziggyfw.executors.Executor;
import com.pearson.qa.common.ziggyfw.validators.Validator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: dcorrales
 * Date: 2/5/14
 * Time: 4:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class LoginModule  extends AbstractModule {

    @Provides
    public List<Executor<LoginContext>> getLoginExecutors(LoginExecutor<LoginContext> loginExecutor)
    {
        List<Executor<LoginContext>> executors = new ArrayList<>();
        executors.add(loginExecutor);
        return executors;
    }

    @Provides
    public List<Validator<LoginContext>> getLoginValidators(LoginValidator loginValidator)
    {
        List<Validator<LoginContext>> validators = new ArrayList<>();
        validators.add(loginValidator);
        return validators;
    }

    @Override
    protected void configure()
    {
        // binding
    }
}
