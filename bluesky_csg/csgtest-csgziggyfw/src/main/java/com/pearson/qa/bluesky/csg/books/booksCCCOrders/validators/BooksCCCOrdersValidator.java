package com.pearson.qa.bluesky.csg.books.booksCCCOrders.validators;

/**
 * Created by didiercorrales on 2/26/14.
 */
import com.pearson.qa.bluesky.csg.books.booksCCCOrders.contexts.BooksCCCOrdersContext;
import com.pearson.qa.common.ziggyfw.exceptions.ValidationException;
import com.pearson.qa.common.ziggyfw.validators.Validator;

public class BooksCCCOrdersValidator implements Validator<BooksCCCOrdersContext> {

    @Override
    public boolean canValidate(BooksCCCOrdersContext context) {
        return context != null;
    }

    @Override
    public void validate(BooksCCCOrdersContext context) throws ValidationException {
        if (context.getExpectedHttpResponseCode() != 200)
        {
            context.getErrorResponsePayload().validateState();
        }
        if (context.getExpectedHttpResponseCode() == 200){
            context.getResponsePayload().validateState();
        }

    }
}
