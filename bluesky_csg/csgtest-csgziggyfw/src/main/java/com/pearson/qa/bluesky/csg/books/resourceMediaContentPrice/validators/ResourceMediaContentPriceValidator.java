package com.pearson.qa.bluesky.csg.books.resourceMediaContentPrice.validators;

/**
 * Created by didiercorrales on 3/9/14.
 */
import com.pearson.qa.bluesky.csg.books.resourceMediaContentPrice.contexts.ResourceMediaContentPriceContext;
import com.pearson.qa.common.ziggyfw.exceptions.ValidationException;
import com.pearson.qa.common.ziggyfw.validators.Validator;

public class ResourceMediaContentPriceValidator implements Validator<ResourceMediaContentPriceContext> {

    @Override
    public boolean canValidate(ResourceMediaContentPriceContext context) {
        return context != null;
    }

    @Override
    public void validate(ResourceMediaContentPriceContext context) throws ValidationException {
        if (context.getExpectedHttpResponseCode() != 200)
        {
            context.getErrorResponsePayload().validateState();
        }
        if (context.getExpectedHttpResponseCode() == 200){
            context.getResponsePayload().validateState();
        }

    }
}
