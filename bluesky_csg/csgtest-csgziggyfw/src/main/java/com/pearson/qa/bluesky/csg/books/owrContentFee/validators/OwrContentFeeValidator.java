package com.pearson.qa.bluesky.csg.books.owrContentFee.validators;

/**
 * Created by didiercorrales on 3/9/14.
 */
import com.pearson.qa.bluesky.csg.books.owrContentFee.contexts.OwrContentFeeContext;
import com.pearson.qa.common.ziggyfw.exceptions.ValidationException;
import com.pearson.qa.common.ziggyfw.validators.Validator;

public class OwrContentFeeValidator implements Validator<OwrContentFeeContext> {

    @Override
    public boolean canValidate(OwrContentFeeContext context) {
        return context != null;
    }

    @Override
    public void validate(OwrContentFeeContext context) throws ValidationException {
        if (context.getExpectedHttpResponseCode() != 200)
        {
            context.getErrorResponsePayload().validateState();
        }
        if (context.getExpectedHttpResponseCode() == 200){
          // TODO Validate is not working  context.getResponsePayload().validateState();
        }

    }
}