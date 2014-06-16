package com.pearson.qa.bluesky.csg.books.processCccOrder.validators;

/**
 * Created by didiercorrales on 3/9/14.
 */

import com.pearson.qa.bluesky.csg.books.processCccOrder.contexts.ProcessCccOrderContext;
import com.pearson.qa.common.ziggyfw.exceptions.ValidationException;
import com.pearson.qa.common.ziggyfw.validators.Validator;

public class ProcessCccOrderValidator implements Validator<ProcessCccOrderContext> {

    @Override
    public boolean canValidate(ProcessCccOrderContext context) {
        return context != null;
    }

    @Override
    public void validate(ProcessCccOrderContext context) throws ValidationException {
        if (context.getExpectedHttpResponseCode() != 200)
        {
            context.getErrorResponsePayload().validateState();
        }
        if (context.getExpectedHttpResponseCode() == 200){
            context.getResponsePayload().validateState();
        }

    }
}
