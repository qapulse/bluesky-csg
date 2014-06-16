package com.pearson.qa.bluesky.csg.authentication.logout.validators;

/**
 * Created by dcorrales on 2/27/14.
 */
import com.pearson.qa.bluesky.csg.authentication.logout.contexts.LogoutContext;
import com.pearson.qa.common.ziggyfw.exceptions.ValidationException;
import com.pearson.qa.common.ziggyfw.validators.Validator;

public class LogoutValidator implements Validator<LogoutContext> {

    @Override
    public boolean canValidate(LogoutContext context) {
        return context != null;
    }

    @Override
    public void validate(LogoutContext context) throws ValidationException {
        if (context.getExpectedHttpResponseCode() != 200)
        {
            context.getErrorResponsePayload().validateState();
        }
    }
}
