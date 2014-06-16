package com.pearson.qa.bluesky.csg.books.updateIsbnStatus.validators;

/**
 * Created by didiercorrales on 3/9/14.
 */
import com.pearson.qa.bluesky.csg.books.updateIsbnStatus.contexts.UpdateIsbnStatusContext;
import com.pearson.qa.common.ziggyfw.exceptions.ValidationException;
import com.pearson.qa.common.ziggyfw.validators.Validator;

public class UpdateIsbnStatusValidator implements Validator<UpdateIsbnStatusContext> {

    @Override
    public boolean canValidate(UpdateIsbnStatusContext context) {
        return context != null;
    }

    @Override
    public void validate(UpdateIsbnStatusContext context) throws ValidationException {
        if (context.getExpectedHttpResponseCode() != 200)
        {
            context.getErrorResponsePayload().validateState();
        }
        if (context.getExpectedHttpResponseCode() == 200){
            context.getResponsePayload().validateState();
        }

    }
}
