package com.pearson.qa.bluesky.csg.books.schoolTerritoryAssociation.validators;

import com.pearson.qa.bluesky.csg.books.schoolTerritoryAssociation.contexts.SchoolTerritoryAssociationContext;
import com.pearson.qa.common.ziggyfw.exceptions.ValidationException;
import com.pearson.qa.common.ziggyfw.validators.Validator;

/**
 * Created by dcorrales on 2/25/14.
 */
public class SchoolTerritoryAssociationValidator implements Validator<SchoolTerritoryAssociationContext> {

    @Override
    public boolean canValidate(SchoolTerritoryAssociationContext context) {
        return context != null;//  && context.getResponsePayload() != null;
    }

    @Override
    public void validate(SchoolTerritoryAssociationContext context) throws ValidationException {
        if (context.getExpectedHttpResponseCode() != 200)
        {
            context.getErrorResponsePayload().validateState();
        }
        if (context.getExpectedHttpResponseCode() == 200){
            context.getResponsePayload().validateState();
        }

    }
}
