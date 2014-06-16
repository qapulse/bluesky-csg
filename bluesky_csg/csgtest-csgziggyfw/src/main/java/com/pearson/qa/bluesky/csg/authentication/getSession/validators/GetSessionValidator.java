package com.pearson.qa.bluesky.csg.authentication.getSession.validators;

/**
 * Created by dcorrales on 2/27/14.
 */
import com.pearson.qa.bluesky.csg.authentication.getSession.contexts.GetSessionContext;
import com.pearson.qa.common.ziggyfw.exceptions.ValidationException;
import com.pearson.qa.common.ziggyfw.validators.Validator;

public class GetSessionValidator implements Validator<GetSessionContext> {

    @Override
    public boolean canValidate(GetSessionContext context) {
        return context != null;
    }

    @Override
    public void validate(GetSessionContext context) throws ValidationException {
        if (context.getExpectedHttpResponseCode() != 200)
        {
            context.getErrorResponsePayload().validateState();
        }
        if (context.getExpectedHttpResponseCode() == 200){
            context.getResponsePayload().validateState();
        }

    }
}
