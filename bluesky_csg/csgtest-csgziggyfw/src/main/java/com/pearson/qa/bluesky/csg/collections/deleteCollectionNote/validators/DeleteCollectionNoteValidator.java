package com.pearson.qa.bluesky.csg.collections.deleteCollectionNote.validators;

import com.pearson.qa.bluesky.csg.collections.deleteCollectionNote.contexts.DeleteCollectionNoteContext;
import com.pearson.qa.common.ziggyfw.exceptions.ValidationException;
import com.pearson.qa.common.ziggyfw.validators.Validator;

public class DeleteCollectionNoteValidator implements Validator<DeleteCollectionNoteContext> {

    @Override
    public boolean canValidate(DeleteCollectionNoteContext context) {
        return context != null;
    }

    @Override
    public void validate(DeleteCollectionNoteContext context) throws ValidationException {
        if (context.getExpectedHttpResponseCode() != 200)
        {
            context.getErrorResponsePayload().validateState();
        }
        if (context.getExpectedHttpResponseCode() == 200){
            context.getResponsePayload().validateState();
        }

    }
}
