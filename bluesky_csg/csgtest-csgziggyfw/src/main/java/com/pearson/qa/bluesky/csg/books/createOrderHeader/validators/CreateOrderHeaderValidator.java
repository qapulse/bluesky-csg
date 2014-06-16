package com.pearson.qa.bluesky.csg.books.createOrderHeader.validators;

import com.pearson.qa.bluesky.csg.books.createOrderHeader.contexts.CreateOrderHeaderContext;
import com.pearson.qa.common.ziggyfw.exceptions.ValidationException;
import com.pearson.qa.common.ziggyfw.validators.Validator;

/**
 * Created with IntelliJ IDEA.
 * User: dcorrales
 * Date: 2/19/14
 * Time: 10:02 AM
 * To change this template use File | Settings | File Templates.
 */
public class CreateOrderHeaderValidator  implements Validator<CreateOrderHeaderContext> {

    @Override
    public boolean canValidate(CreateOrderHeaderContext context) {
        return context != null && context.getResponsePayload() != null;
    }

    @Override
    public void validate(CreateOrderHeaderContext context) throws ValidationException {
        if (context.getExpectedHttpResponseCode() != 200)
        {
            context.getErrorResponsePayload().validateState();
        }
        if (context.getExpectedHttpResponseCode() == 200){
            context.getResponsePayload().validateState();
        }

    }
}
