package com.pearson.qa.bluesky.csg.taxonomies.getCollectionByISBN.validators;


import com.pearson.qa.bluesky.csg.taxonomies.getCollectionByISBN.contexts.GetCollectionByISBNContext;
import com.pearson.qa.common.ziggyfw.exceptions.ValidationException;
import com.pearson.qa.common.ziggyfw.validators.Validator;

public class GetCollectionByISBNValidator implements Validator<GetCollectionByISBNContext> {

    @Override
    public boolean canValidate(GetCollectionByISBNContext context) {
        return context != null;
    }

    @Override
    public void validate(GetCollectionByISBNContext context) throws ValidationException {
        if (context.getExpectedHttpResponseCode() != 200)
        {
            context.getErrorResponsePayload().validateState();
        }
        if (context.getExpectedHttpResponseCode() == 200){
            context.getResponsePayload().validateState();
        }

    }
}