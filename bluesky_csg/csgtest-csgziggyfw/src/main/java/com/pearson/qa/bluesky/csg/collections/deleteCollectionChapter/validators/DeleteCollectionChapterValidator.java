package com.pearson.qa.bluesky.csg.collections.deleteCollectionChapter.validators;


import com.pearson.qa.bluesky.csg.collections.deleteCollectionChapter.contexts.DeleteCollectionChapterContext;
import com.pearson.qa.common.ziggyfw.exceptions.ValidationException;
import com.pearson.qa.common.ziggyfw.validators.Validator;

public class DeleteCollectionChapterValidator implements Validator<DeleteCollectionChapterContext> {

    @Override
    public boolean canValidate(DeleteCollectionChapterContext context) {
        return context != null;
    }

    @Override
    public void validate(DeleteCollectionChapterContext context) throws ValidationException {
        if (context.getExpectedHttpResponseCode() != 200)
        {
            context.getErrorResponsePayload().validateState();
        }
        if (context.getExpectedHttpResponseCode() == 200){
            context.getResponsePayload().validateState();
        }

    }
}
