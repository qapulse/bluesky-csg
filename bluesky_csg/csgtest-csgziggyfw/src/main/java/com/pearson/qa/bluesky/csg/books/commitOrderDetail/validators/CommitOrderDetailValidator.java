package com.pearson.qa.bluesky.csg.books.commitOrderDetail.validators;

/**
 * Created by didiercorrales on 2/26/14.
 */

import com.pearson.qa.bluesky.csg.books.commitOrderDetail.contexts.CommitOrderDetailContext;
import com.pearson.qa.common.ziggyfw.exceptions.ValidationException;
import com.pearson.qa.common.ziggyfw.validators.Validator;

public class CommitOrderDetailValidator implements Validator<CommitOrderDetailContext> {

    @Override
    public boolean canValidate(CommitOrderDetailContext context) {
        return context != null;
    }

    @Override
    public void validate(CommitOrderDetailContext context) throws ValidationException {
        if (context.getExpectedHttpResponseCode() != 200)
        {
            context.getErrorResponsePayload().validateState();
        }
        if (context.getExpectedHttpResponseCode() == 200){
            context.getResponsePayload().validateState();
        }

    }
}
