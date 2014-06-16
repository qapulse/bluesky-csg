package com.pearson.qa.bluesky.csg.collections.getCollectionNote.validators;

import com.pearson.qa.bluesky.csg.collections.getCollectionNote.contexts.GetCollectionNoteContext;
import com.pearson.qa.common.ziggyfw.exceptions.ValidationException;
import com.pearson.qa.common.ziggyfw.validators.Validator;

public class GetCollectionNoteValidator implements Validator<GetCollectionNoteContext> {

    @Override
    public boolean canValidate(GetCollectionNoteContext context) {
        return context != null;
    }

    @Override
    public void validate(GetCollectionNoteContext context) throws ValidationException {
        if (context.getExpectedHttpResponseCode() != 200)
        {
            context.getErrorResponsePayload().validateState();
        }
        if (context.getExpectedHttpResponseCode() == 200){
            if(context.getResponsePayload() != null)
            context.getResponsePayload().validateState();
        }

    }
}
