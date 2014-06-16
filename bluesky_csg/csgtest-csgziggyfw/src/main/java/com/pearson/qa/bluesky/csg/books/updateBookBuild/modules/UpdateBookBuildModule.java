package com.pearson.qa.bluesky.csg.books.updateBookBuild.modules;

/**
 * Created by didiercorrales on 3/9/14.
 */
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.pearson.qa.bluesky.csg.books.updateBookBuild.contexts.UpdateBookBuildContext;
import com.pearson.qa.bluesky.csg.books.updateBookBuild.executors.UpdateBookBuildExecutor;
import com.pearson.qa.bluesky.csg.books.updateBookBuild.validators.UpdateBookBuildValidator;
import com.pearson.qa.common.ziggyfw.executors.Executor;
import com.pearson.qa.common.ziggyfw.validators.Validator;

import java.util.ArrayList;
import java.util.List;


public class UpdateBookBuildModule extends AbstractModule {

    @Provides
    public List<Executor<UpdateBookBuildContext>> getLoginExecutors(UpdateBookBuildExecutor<UpdateBookBuildContext> executor)
    {
        List<Executor<UpdateBookBuildContext>> executors = new ArrayList<>();
        executors.add(executor);
        return executors;
    }

    @Provides
    public List<Validator<UpdateBookBuildContext>> getLoginValidators(UpdateBookBuildValidator validator)
    {
        List<Validator<UpdateBookBuildContext>> validators = new ArrayList<>();
        validators.add(validator);
        return validators;
    }

    @Override
    protected void configure() {

    }
}
