package com.pearson.qa.bluesky.csg.books.oplUrl.validators;

/**
 * Created by didiercorrales on 3/9/14.
 */
import com.pearson.qa.bluesky.csg.books.oplUrl.contexts.OplUrlContext;
import com.pearson.qa.common.ziggyfw.exceptions.ValidationException;
import com.pearson.qa.common.ziggyfw.validators.Validator;

public class OplUrlValidator implements Validator<OplUrlContext> {

    @Override
    public boolean canValidate(OplUrlContext context) {
        return context != null;
    }

    @Override
    public void validate(OplUrlContext context) throws ValidationException {
        if (context.getExpectedHttpResponseCode() != 200)
        {
            context.getErrorResponsePayload().validateState();
        }
        if (context.getExpectedHttpResponseCode() == 200){
            context.getResponsePayload().validateState();
        }

    }
}
