package com.pearson.qa.bluesky.csg.books.bookPrice.validators;

import com.pearson.qa.bluesky.csg.books.bookPrice.contexts.BookPriceContext;
import com.pearson.qa.common.ziggyfw.exceptions.ValidationException;
import com.pearson.qa.common.ziggyfw.validators.Validator;

/**
 * Created by dcorrales on 2/21/14.
 */
public class BookPriceValidator implements Validator<BookPriceContext> {

    @Override
    public boolean canValidate(BookPriceContext context) {
        return context != null;//  && context.getResponsePayload() != null;
    }

    @Override
    public void validate(BookPriceContext context) throws ValidationException {
        if (context.getExpectedHttpResponseCode() != 200)
        {
            context.getErrorResponsePayload().validateState();
        }
        if (context.getExpectedHttpResponseCode() == 200){
            context.getResponsePayload().validateState();
        }

    }
}
