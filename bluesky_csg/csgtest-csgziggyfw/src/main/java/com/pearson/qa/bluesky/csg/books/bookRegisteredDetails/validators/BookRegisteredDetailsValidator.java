package com.pearson.qa.bluesky.csg.books.bookRegisteredDetails.validators;

/**
 * Created by dcorrales on 2/27/14.
 */
import com.pearson.qa.bluesky.csg.books.bookRegisteredDetails.contexts.BookRegisteredDetailsContext;
import com.pearson.qa.common.ziggyfw.exceptions.ValidationException;
import com.pearson.qa.common.ziggyfw.validators.Validator;

public class BookRegisteredDetailsValidator implements Validator<BookRegisteredDetailsContext> {

    @Override
    public boolean canValidate(BookRegisteredDetailsContext context) {
        return context != null;
    }

    @Override
    public void validate(BookRegisteredDetailsContext context) throws ValidationException {
        if (context.getExpectedHttpResponseCode() != 200)
        {
            context.getErrorResponsePayload().validateState();
        }
        if (context.getExpectedHttpResponseCode() == 200){
            context.getResponsePayload().validateState();
        }

    }
}
