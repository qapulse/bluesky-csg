package com.pearson.qa.bluesky.csg.books.authorsBySchool.executorDrivers;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.pearson.qa.bluesky.csg.books.authorsBySchool.contexts.AuthorsBySchoolContext;
import com.pearson.qa.common.ziggyfw.executiondrivers.ExecutionDriver;
import com.pearson.qa.common.ziggyfw.executors.Executor;

import java.util.List;

/**
 * Created by dcorrales on 2/24/14.
 */
@Singleton
public class AuthorsBySchoolExecutorDriver  extends ExecutionDriver<AuthorsBySchoolContext> {

    @Inject
    public AuthorsBySchoolExecutorDriver(List<Executor<AuthorsBySchoolContext>> executors ){
        super(executors);
    }
}
