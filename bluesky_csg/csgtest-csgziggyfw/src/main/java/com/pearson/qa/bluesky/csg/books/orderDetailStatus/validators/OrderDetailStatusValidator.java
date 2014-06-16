package com.pearson.qa.bluesky.csg.books.orderDetailStatus.validators;

/**
 * Created by didiercorrales on 2/26/14.
 */

import com.pearson.qa.bluesky.csg.books.orderDetailStatus.contexts.OrderDetailStatusContext;
import com.pearson.qa.common.ziggyfw.exceptions.ValidationException;
import com.pearson.qa.common.ziggyfw.validators.Validator;

public class OrderDetailStatusValidator implements Validator<OrderDetailStatusContext> {

    @Override
    public boolean canValidate(OrderDetailStatusContext context) {
        return context != null;
    }

    @Override
    public void validate(OrderDetailStatusContext context) throws ValidationException {
        if (context.getExpectedHttpResponseCode() != 200)
        {
            context.getErrorResponsePayload().validateState();
        }
        if (context.getExpectedHttpResponseCode() == 200){
            context.getResponsePayload().validateState();
        }

    }
}
