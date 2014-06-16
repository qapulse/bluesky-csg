package com.pearson.qa.bluesky.csg.authentication.loginAs.validators;

import com.pearson.qa.bluesky.csg.authentication.loginAs.contexts.LoginAsContext;
import com.pearson.qa.common.ziggyfw.exceptions.ValidationException;
import com.pearson.qa.common.ziggyfw.validators.Validator;

/**
 * Created by dcorrales on 2/27/14.
 */

public class LoginAsValidator implements Validator<LoginAsContext> {

    @Override
    public boolean canValidate(LoginAsContext context) {
        return context != null;
    }

    @Override
    public void validate(LoginAsContext context) throws ValidationException {
        if (context.getExpectedHttpResponseCode() != 200) {
            context.getErrorResponsePayload().validateState();
        }

    }
}
