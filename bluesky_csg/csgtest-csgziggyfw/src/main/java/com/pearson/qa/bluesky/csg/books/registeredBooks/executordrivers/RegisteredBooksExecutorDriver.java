package com.pearson.qa.bluesky.csg.books.registeredBooks.executordrivers;

import com.google.inject.Inject;
import com.pearson.qa.bluesky.csg.Utils.datastructures.ErrorResponse;
import com.pearson.qa.bluesky.csg.books.registeredBooks.contexts.RegisteredBooksContext;
import com.pearson.qa.bluesky.csg.books.registeredBooks.datastructures.RegisteredBooksResponsePayload;
import com.pearson.qa.common.ziggyfw.executiondrivers.ExecutionDriver;
import com.pearson.qa.common.ziggyfw.executors.Executor;
import com.pearson.qa.common.ziggyfw.http.executors.HttpExecutor;
import com.pearson.qa.common.ziggyfw.validators.Validator;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dcorrales on 2/24/14.
 */
@Singleton
public class RegisteredBooksExecutorDriver  extends ExecutionDriver<RegisteredBooksContext> {

    @Inject
    public RegisteredBooksExecutorDriver(List<Executor<RegisteredBooksContext>> executors ){
        super(executors);
    }
}
