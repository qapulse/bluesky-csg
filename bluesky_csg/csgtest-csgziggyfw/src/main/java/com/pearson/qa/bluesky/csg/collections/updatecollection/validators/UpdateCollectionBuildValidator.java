package com.pearson.qa.bluesky.csg.collections.updatecollection.validators;

import com.pearson.qa.bluesky.csg.collections.updatecollection.contexts.UpdateCollectionContext;
import com.pearson.qa.common.ziggyfw.exceptions.ValidationException;
import com.pearson.qa.common.ziggyfw.validators.Validator;

/**
 * Created by brian on 3/13/14.
 */
public class UpdateCollectionBuildValidator implements Validator<UpdateCollectionContext> {

    @Override
    public boolean canValidate(UpdateCollectionContext context) {
        return context != null;//  && context.getResponsePayload() != null;
    }

    @Override
    public void validate(UpdateCollectionContext context) throws ValidationException {
        if (context.getExpectedHttpResponseCode() != 200)
        {
            context.getErrorResponsePayload().validateState();
        }
        if (context.getExpectedHttpResponseCode() == 200){
            context.getResponsePayload().validateState();
        }

    }
}
