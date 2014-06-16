package com.pearson.qa.bluesky.csg.books.schoolsByTerritory.validators;

import com.pearson.qa.bluesky.csg.books.schoolsByTerritory.contexts.SchoolContext;
import com.pearson.qa.common.ziggyfw.exceptions.ValidationException;
import com.pearson.qa.common.ziggyfw.validators.Validator;

/**
 * Created by dcorrales on 2/24/14.
 */
public class SchoolValidator implements Validator<SchoolContext> {

    @Override
    public boolean canValidate(SchoolContext context) {
        return context != null;//  && context.getResponsePayload() != null;
    }

    @Override
    public void validate(SchoolContext context) throws ValidationException {
        if (context.getExpectedHttpResponseCode() != 200)
        {
            context.getErrorResponsePayload().validateState();
        }
        if (context.getExpectedHttpResponseCode() == 200){
            context.getResponsePayload().validateState();
        }

    }
}

