package com.pearson.qa.bluesky.csg.books.createOrderDetail.validators;

import com.pearson.qa.bluesky.csg.books.createOrderDetail.contexts.CreateOrderDetailContext;
import com.pearson.qa.common.ziggyfw.exceptions.ValidationException;
import com.pearson.qa.common.ziggyfw.validators.Validator;

/**
 * Created by didiercorrales on 2/26/14.
 */
public class CreateOrderDetailValidator implements Validator<CreateOrderDetailContext> {

    @Override
    public boolean canValidate(CreateOrderDetailContext context) {
        return context != null;
    }

    @Override
    public void validate(CreateOrderDetailContext context) throws ValidationException {
        if (context.getExpectedHttpResponseCode() != 200)
        {
            context.getErrorResponsePayload().validateState();
        }
        if (context.getExpectedHttpResponseCode() == 200){
            context.getResponsePayload().validateState();
        }

    }
}
