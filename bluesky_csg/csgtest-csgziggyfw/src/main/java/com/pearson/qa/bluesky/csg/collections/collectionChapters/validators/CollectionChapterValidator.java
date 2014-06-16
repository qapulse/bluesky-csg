package com.pearson.qa.bluesky.csg.collections.collectionChapters.validators;

import com.pearson.qa.bluesky.csg.collections.collectionChapters.contexts.CollectionChapterContext;
import com.pearson.qa.common.ziggyfw.exceptions.ValidationException;
import com.pearson.qa.common.ziggyfw.validators.Validator;

public class CollectionChapterValidator implements Validator<CollectionChapterContext> {

    @Override
    public boolean canValidate(CollectionChapterContext context) {
        return context != null;
    }

    @Override
    public void validate(CollectionChapterContext context) throws ValidationException {
        if (context.getExpectedHttpResponseCode() != 200) {
            context.getErrorResponsePayload().validateState();
        }
        if (context.getExpectedHttpResponseCode() == 200) {
            context.getResponsePayload().validateState();
        }

    }
}
