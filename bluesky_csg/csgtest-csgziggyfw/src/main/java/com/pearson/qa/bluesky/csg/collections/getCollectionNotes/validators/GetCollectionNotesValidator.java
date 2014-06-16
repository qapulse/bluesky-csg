package com.pearson.qa.bluesky.csg.collections.getCollectionNotes.validators;

/**
 * Created by didiercorrales on 3/29/14.
 */

import com.pearson.qa.bluesky.csg.collections.getCollectionNotes.contexts.GetCollectionNotesContext;
import com.pearson.qa.common.ziggyfw.exceptions.ValidationException;
import com.pearson.qa.common.ziggyfw.validators.Validator;

public class GetCollectionNotesValidator implements Validator<GetCollectionNotesContext> {

    @Override
    public boolean canValidate(GetCollectionNotesContext context) {
        return context != null;
    }

    @Override
    public void validate(GetCollectionNotesContext context) throws ValidationException {
        if (context.getExpectedHttpResponseCode() != 200)
        {
            context.getErrorResponsePayload().validateState();
        }
        if (context.getExpectedHttpResponseCode() == 200){
            context.getResponsePayload().validateState();
        }

    }
}
