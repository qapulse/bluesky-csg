package com.pearson.qa.bluesky.csg.books.approveISBNs.validators;

/**
 * Created by didiercorrales on 3/4/14.
 */
import com.pearson.qa.bluesky.csg.books.approveISBNs.contexts.ApproveIsbnContext;
import com.pearson.qa.common.ziggyfw.exceptions.ValidationException;
import com.pearson.qa.common.ziggyfw.validators.Validator;

public class ApproveIsbnValidator implements Validator<ApproveIsbnContext> {

    @Override
    public boolean canValidate(ApproveIsbnContext context) {
        return context != null;
    }

    @Override
    public void validate(ApproveIsbnContext context) throws ValidationException {
        if (context.getExpectedHttpResponseCode() != 200)
        {
            context.getErrorResponsePayload().validateState();
        }
        if (context.getExpectedHttpResponseCode() == 200){
            context.getResponsePayload().validateState();
        }

    }
}
