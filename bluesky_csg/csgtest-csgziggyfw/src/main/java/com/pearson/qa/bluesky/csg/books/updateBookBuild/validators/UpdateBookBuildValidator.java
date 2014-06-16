package com.pearson.qa.bluesky.csg.books.updateBookBuild.validators;

/**
 * Created by didiercorrales on 3/9/14.
 */

import com.pearson.qa.bluesky.csg.books.updateBookBuild.contexts.UpdateBookBuildContext;
import com.pearson.qa.common.ziggyfw.exceptions.ValidationException;
import com.pearson.qa.common.ziggyfw.validators.Validator;

public class UpdateBookBuildValidator implements Validator<UpdateBookBuildContext> {

    @Override
    public boolean canValidate(UpdateBookBuildContext context) {
        return context != null;
    }

    @Override
    public void validate(UpdateBookBuildContext context) throws ValidationException {
        if (context.getExpectedHttpResponseCode() != 200)
        {
            context.getErrorResponsePayload().validateState();
        }
        if (context.getExpectedHttpResponseCode() == 200){
            context.getResponsePayload().validateState();
        }

    }
}