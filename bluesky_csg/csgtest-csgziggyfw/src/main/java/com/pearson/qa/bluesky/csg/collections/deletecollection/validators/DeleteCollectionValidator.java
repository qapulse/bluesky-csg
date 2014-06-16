package com.pearson.qa.bluesky.csg.collections.deletecollection.validators;

/**
 * Created by didiercorrales on 3/4/14.
 */
import com.pearson.qa.bluesky.csg.collections.deletecollection.contexts.DeleteCollectionContext;
import com.pearson.qa.common.ziggyfw.exceptions.ValidationException;
import com.pearson.qa.common.ziggyfw.validators.Validator;

public class DeleteCollectionValidator implements Validator<DeleteCollectionContext> {

    @Override
    public boolean canValidate(DeleteCollectionContext context) {
        return context != null;
    }

    @Override
    public void validate(DeleteCollectionContext context) throws ValidationException {
        if (context.getExpectedHttpResponseCode() != 200)
        {
            context.getErrorResponsePayload().validateState();
        }
    }
}
