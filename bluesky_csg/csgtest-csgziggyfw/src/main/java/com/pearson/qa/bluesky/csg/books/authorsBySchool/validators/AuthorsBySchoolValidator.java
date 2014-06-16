package com.pearson.qa.bluesky.csg.books.authorsBySchool.validators;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.pearson.qa.bluesky.csg.books.authorsBySchool.contexts.AuthorsBySchoolContext;
import com.pearson.qa.bluesky.csg.books.authorsBySchool.executors.AuthorsBySchoolExecutor;

import com.pearson.qa.common.ziggyfw.exceptions.ValidationException;
import com.pearson.qa.common.ziggyfw.executors.Executor;
import com.pearson.qa.common.ziggyfw.validators.Validator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dcorrales on 2/24/14.
 */
public class AuthorsBySchoolValidator implements Validator<AuthorsBySchoolContext> {

    @Override
    public boolean canValidate(AuthorsBySchoolContext context) {
        return context != null;
    }

    @Override
    public void validate(AuthorsBySchoolContext context) throws ValidationException {
        if (context.getExpectedHttpResponseCode() != 200)
        {
            context.getErrorResponsePayload().validateState();
        }
        if (context.getExpectedHttpResponseCode() == 200){
            if(context.getResponsePayload() != null)
            context.getResponsePayload().validateState();
        }

    }
}
