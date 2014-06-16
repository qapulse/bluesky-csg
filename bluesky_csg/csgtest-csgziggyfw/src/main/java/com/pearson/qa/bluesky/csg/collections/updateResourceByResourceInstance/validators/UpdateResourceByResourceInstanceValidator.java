package com.pearson.qa.bluesky.csg.collections.updateResourceByResourceInstance.validators;


import com.pearson.qa.bluesky.csg.collections.updateResourceByResourceInstance.contexts.UpdateResourceByResourceInstanceContext;
import com.pearson.qa.common.ziggyfw.exceptions.ValidationException;
import com.pearson.qa.common.ziggyfw.validators.Validator;

public class UpdateResourceByResourceInstanceValidator implements Validator<UpdateResourceByResourceInstanceContext> {

    @Override
    public boolean canValidate(UpdateResourceByResourceInstanceContext context) {
        return context != null;
    }

    @Override
    public void validate(UpdateResourceByResourceInstanceContext context) throws ValidationException {
        if (context.getExpectedHttpResponseCode() != 200) {
            context.getErrorResponsePayload().validateState();
        }
        if (context.getExpectedHttpResponseCode() == 200) {
            context.getResponsePayload().validateState();
        }

    }
}