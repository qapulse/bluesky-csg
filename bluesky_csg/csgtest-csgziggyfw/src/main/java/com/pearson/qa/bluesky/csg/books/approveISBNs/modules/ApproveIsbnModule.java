package com.pearson.qa.bluesky.csg.books.approveISBNs.modules;

/**
 * Created by didiercorrales on 3/4/14.
 */

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.pearson.qa.bluesky.csg.books.approveISBNs.contexts.ApproveIsbnContext;
import com.pearson.qa.bluesky.csg.books.approveISBNs.executors.ApproveIsbnExecutor;
import com.pearson.qa.bluesky.csg.books.approveISBNs.validators.ApproveIsbnValidator;
import com.pearson.qa.common.ziggyfw.executors.Executor;
import com.pearson.qa.common.ziggyfw.validators.Validator;

import java.util.ArrayList;
import java.util.List;

public class ApproveIsbnModule extends AbstractModule {

    @Provides
    public List<Executor<ApproveIsbnContext>> getLoginExecutors(ApproveIsbnExecutor<ApproveIsbnContext> executor)
    {
        List<Executor<ApproveIsbnContext>> executors = new ArrayList<>();
        executors.add(executor);
        return executors;
    }

    @Provides
    public List<Validator<ApproveIsbnContext>> getLoginValidators(ApproveIsbnValidator validator)
    {
        List<Validator<ApproveIsbnContext>> validators = new ArrayList<>();
        validators.add(validator);
        return validators;
    }

    @Override
    protected void configure() {

    }
}
