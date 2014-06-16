package com.pearson.qa.bluesky.csg.collections.collectionbystatus.validators;

import com.pearson.qa.bluesky.csg.collections.collectionbystatus.contexts.CollectionByStatusContexts;
import com.pearson.qa.common.ziggyfw.exceptions.ValidationException;
import com.pearson.qa.common.ziggyfw.validators.Validator;

/**
 * Created by brian on 3/22/14.
 */
public class CollectionByStatusValidator implements Validator<CollectionByStatusContexts> {

    @Override
    public boolean canValidate(CollectionByStatusContexts context) {
        return context != null;//  && context.getResponsePayload() != null;
    }

    @Override
    public void validate(CollectionByStatusContexts context) throws ValidationException {
        if (context.getExpectedHttpResponseCode() != 200)
        {
            context.getErrorResponsePayload().validateState();
        }
        if (context.getExpectedHttpResponseCode() == 200){
            context.getResponsePayload().validateState();
        }

    }
}