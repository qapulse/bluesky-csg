package com.pearson.qa.bluesky.csg.books.bookBuild.validators;

/**
 * Created by dcorrales on 2/27/14.
 */
import com.pearson.qa.bluesky.csg.books.bookBuild.contexts.BookBuildContext;
import com.pearson.qa.common.ziggyfw.exceptions.ValidationException;
import com.pearson.qa.common.ziggyfw.validators.Validator;

public class BookBuildValidator implements Validator<BookBuildContext> {

    @Override
    public boolean canValidate(BookBuildContext context) {
        return context != null;
    }

    @Override
    public void validate(BookBuildContext context) throws ValidationException {
        if (context.getExpectedHttpResponseCode() != 200)
        {
            context.getErrorResponsePayload().validateState();
        }
        if (context.getExpectedHttpResponseCode() == 200){

            context.getResponsePayload().validateState();
        }
    }
}
