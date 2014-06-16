package com.pearson.qa.bluesky.csg.user.deleteResource.validators;


import com.pearson.qa.bluesky.csg.user.deleteResource.contexts.DeleteResourceContext;
import com.pearson.qa.common.ziggyfw.exceptions.ValidationException;
import com.pearson.qa.common.ziggyfw.validators.Validator;

public class DeleteResourceValidator implements Validator<DeleteResourceContext> {

    @Override
    public boolean canValidate(DeleteResourceContext context) {
        return context != null;
    }

    @Override
    public void validate(DeleteResourceContext context) throws ValidationException {
        if (context.getExpectedHttpResponseCode() != 200) {
            context.getErrorResponsePayload().validateState();
        }
    }
}