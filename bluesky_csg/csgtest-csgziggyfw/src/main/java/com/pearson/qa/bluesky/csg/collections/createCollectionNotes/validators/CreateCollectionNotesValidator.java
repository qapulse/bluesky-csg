package com.pearson.qa.bluesky.csg.collections.createCollectionNotes.validators;

import com.pearson.qa.bluesky.csg.collections.createCollectionNotes.contexts.CreateCollectionNotesContext;
import com.pearson.qa.common.ziggyfw.exceptions.ValidationException;
import com.pearson.qa.common.ziggyfw.validators.Validator;

public class CreateCollectionNotesValidator implements Validator<CreateCollectionNotesContext> {

    @Override
    public boolean canValidate(CreateCollectionNotesContext context) {
        return context != null;
    }

    @Override
    public void validate(CreateCollectionNotesContext context) throws ValidationException {
        if (context.getExpectedHttpResponseCode() != 200)
        {
            context.getErrorResponsePayload().validateState();
        }
        if (context.getExpectedHttpResponseCode() == 200){
            context.getResponsePayload().validateState();
        }

    }
}
