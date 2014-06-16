package com.pearson.qa.bluesky.csg.books.commitOrderDetail.modules;

/**
 * Created by didiercorrales on 2/26/14.
 */
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.pearson.qa.bluesky.csg.books.commitOrderDetail.contexts.CommitOrderDetailContext;
import com.pearson.qa.bluesky.csg.books.commitOrderDetail.executors.CommitOrderDetailExecutor;
import com.pearson.qa.bluesky.csg.books.commitOrderDetail.validators.CommitOrderDetailValidator;
import com.pearson.qa.common.ziggyfw.executors.Executor;
import com.pearson.qa.common.ziggyfw.validators.Validator;

import java.util.ArrayList;
import java.util.List;

public class CommitOrderDetailModule extends AbstractModule {

    @Provides
    public List<Executor<CommitOrderDetailContext>> getLoginExecutors(CommitOrderDetailExecutor<CommitOrderDetailContext> executor)
    {
        List<Executor<CommitOrderDetailContext>> executors = new ArrayList<>();
        executors.add(executor);
        return executors;
    }

    @Provides
    public List<Validator<CommitOrderDetailContext>> getLoginValidators(CommitOrderDetailValidator validator)
    {
        List<Validator<CommitOrderDetailContext>> validators = new ArrayList<>();
        validators.add(validator);
        return validators;
    }

    @Override
    protected void configure() {

    }
}
