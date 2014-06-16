package com.pearson.qa.bluesky.csg.books.registeredBooks.validators;

import com.pearson.qa.bluesky.csg.books.registeredBooks.contexts.RegisteredBooksContext;
import com.pearson.qa.common.ziggyfw.exceptions.ValidationException;
import com.pearson.qa.common.ziggyfw.validators.Validator;

/**
 * Created by dcorrales on 2/24/14.
 */
public class RegisteredBooksValidator implements Validator<RegisteredBooksContext> {

    @Override
    public boolean canValidate(RegisteredBooksContext context) {
        return context != null;//  && context.getResponsePayload() != null;
    }

    @Override
    public void validate(RegisteredBooksContext context) throws ValidationException {
        if (context.getExpectedHttpResponseCode() != 200)
        {
            context.getErrorResponsePayload().validateState();
        }
        if (context.getExpectedHttpResponseCode() == 200){
            context.getResponsePayload().validateState();
        }

    }
}
