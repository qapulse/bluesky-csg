package com.pearson.qa.bluesky.csg.books.chapterPrice.validators;

import com.pearson.qa.bluesky.csg.books.chapterPrice.contexts.ChapterPriceContext;
import com.pearson.qa.common.ziggyfw.exceptions.ValidationException;
import com.pearson.qa.common.ziggyfw.validators.Validator;

/**
 * Created by Game on 2/23/14.
 */
public class ChapterPriceValidator implements Validator<ChapterPriceContext> {

    @Override
    public boolean canValidate(ChapterPriceContext context) {
        return context != null;
    }

    @Override
    public void validate(ChapterPriceContext context) throws ValidationException {
        if (context.getExpectedHttpResponseCode() != 200)
        {
            context.getErrorResponsePayload().validateState();
        }
        if (context.getExpectedHttpResponseCode() == 200){
            context.getResponsePayload().validateState();
        }

    }
}
