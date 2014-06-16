package com.pearson.qa.bluesky.csg.taxonomies.collectionsByTaxonomyCourse.validators;

import com.pearson.qa.bluesky.csg.taxonomies.collectionsByTaxonomyCourse.contexts.CollectionsByTaxonomyCourseContext;
import com.pearson.qa.common.ziggyfw.exceptions.ValidationException;
import com.pearson.qa.common.ziggyfw.validators.Validator;

public class CollectionsByTaxonomyCourseValidator implements Validator<CollectionsByTaxonomyCourseContext> {

    @Override
    public boolean canValidate(CollectionsByTaxonomyCourseContext context) {
        return context != null;
    }

    @Override
    public void validate(CollectionsByTaxonomyCourseContext context) throws ValidationException {
        if (context.getExpectedHttpResponseCode() != 200)
        {
            context.getErrorResponsePayload().validateState();
        }
        if (context.getExpectedHttpResponseCode() == 200){
            context.getResponsePayload().validateState();
        }

    }
}
