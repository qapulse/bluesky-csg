package com.pearson.qa.bluesky.csg.books.territories.validators;

import com.pearson.qa.bluesky.csg.books.territories.contexts.TerritoriesContext;
import com.pearson.qa.common.ziggyfw.exceptions.ValidationException;
import com.pearson.qa.common.ziggyfw.validators.Validator;

/**
 * Created by dcorrales on 2/24/14.
 */
public class TerritoriesValidator implements Validator<TerritoriesContext> {

    @Override
    public boolean canValidate(TerritoriesContext context) {
        return context != null;//  && context.getResponsePayload() != null;
    }

    @Override
    public void validate(TerritoriesContext context) throws ValidationException {
        if (context.getExpectedHttpResponseCode() != 200)
        {
            context.getErrorResponsePayload().validateState();
        }
        if (context.getExpectedHttpResponseCode() == 200){
            context.getResponsePayload().validateState();
        }

    }
}
