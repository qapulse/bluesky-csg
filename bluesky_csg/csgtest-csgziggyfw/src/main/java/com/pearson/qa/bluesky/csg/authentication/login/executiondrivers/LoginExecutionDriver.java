package com.pearson.qa.bluesky.csg.authentication.login.executiondrivers;

import com.google.inject.Singleton;

import com.pearson.qa.bluesky.csg.authentication.login.contexts.LoginContext;
import com.pearson.qa.bluesky.csg.collections.createcollection.contexts.CreateCollectionContexts;
import com.pearson.qa.common.ziggyfw.executiondrivers.ExecutionDriver;
import com.pearson.qa.common.ziggyfw.executors.Executor;

import javax.inject.Inject;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: dcorrales
 * Date: 2/5/14
 * Time: 4:57 PM
 * To change this template use File | Settings | File Templates.
 */
@Singleton
public class LoginExecutionDriver  extends ExecutionDriver<LoginContext> {

    @Inject
    public LoginExecutionDriver(List<Executor<LoginContext>> executors)
    {
        super(executors);
    }

}
