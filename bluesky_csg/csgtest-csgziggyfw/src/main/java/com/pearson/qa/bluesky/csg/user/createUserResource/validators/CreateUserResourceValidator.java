package com.pearson.qa.bluesky.csg.user.createUserResource.validators;

import com.pearson.qa.bluesky.csg.user.createUserResource.contexts.CreateUserResourceContext;
import com.pearson.qa.common.ziggyfw.exceptions.ValidationException;
import com.pearson.qa.common.ziggyfw.validators.Validator;

public class CreateUserResourceValidator implements Validator<CreateUserResourceContext> {

    @Override
    public boolean canValidate(CreateUserResourceContext context) {
        return context != null;
    }

    @Override
    public void validate(CreateUserResourceContext context) throws ValidationException {
        if (context.getExpectedHttpResponseCode() != 200)
        {
            context.getErrorResponsePayload().validateState();
        }
        if (context.getExpectedHttpResponseCode() == 200){
            context.getResponsePayload().validateState();
        }

    }
}
