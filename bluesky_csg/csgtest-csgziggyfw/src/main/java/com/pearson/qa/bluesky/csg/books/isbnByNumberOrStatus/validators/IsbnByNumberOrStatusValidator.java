package com.pearson.qa.bluesky.csg.books.isbnByNumberOrStatus.validators;

/**
 * Created by didiercorrales on 2/26/14.
 */

import com.pearson.qa.bluesky.csg.books.isbnByNumberOrStatus.contexts.IsbnByNumberOrStatusContext;
import com.pearson.qa.common.ziggyfw.exceptions.ValidationException;
import com.pearson.qa.common.ziggyfw.validators.Validator;

public class IsbnByNumberOrStatusValidator implements Validator<IsbnByNumberOrStatusContext> {

    @Override
    public boolean canValidate(IsbnByNumberOrStatusContext context) {
        return context != null;
    }

    @Override
    public void validate(IsbnByNumberOrStatusContext context) throws ValidationException {
        if (context.getExpectedHttpResponseCode() != 200) {
            context.getErrorResponsePayload().validateState();
        }
        if (context.getExpectedHttpResponseCode() == 200) {
            context.getResponsePayload().validateState();
        }

    }
}
