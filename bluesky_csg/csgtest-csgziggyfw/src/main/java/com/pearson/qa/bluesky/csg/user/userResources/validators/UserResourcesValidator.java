package com.pearson.qa.bluesky.csg.user.userResources.validators;

import com.pearson.qa.bluesky.csg.user.userResources.contexts.UserResourcesContext;
import com.pearson.qa.common.ziggyfw.exceptions.ValidationException;
import com.pearson.qa.common.ziggyfw.validators.Validator;

public class UserResourcesValidator implements Validator<UserResourcesContext> {

    @Override
    public boolean canValidate(UserResourcesContext context) {
        return context != null;
    }

    @Override
    public void validate(UserResourcesContext context) throws ValidationException {
        if (context.getExpectedHttpResponseCode() != 200)
        {
            context.getErrorResponsePayload().validateState();
        }
        if (context.getExpectedHttpResponseCode() == 200){
            context.getResponsePayload().validateState();
        }

    }
}
