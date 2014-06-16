package com.pearson.qa.bluesky.csg.taxonomies.getTaxonomies.validators;

/**
 * Created with IntelliJ IDEA.
 * User: didiercorrales
 * Date: 3/19/14
 * Time: 10:23 PM
 * To change this template use File | Settings | File Templates.
 */

import com.pearson.qa.bluesky.csg.taxonomies.getTaxonomies.contexts.TaxonimiesContext;
import com.pearson.qa.common.ziggyfw.exceptions.ValidationException;
import com.pearson.qa.common.ziggyfw.validators.Validator;

public class TaxonomiesValidator implements Validator<TaxonimiesContext> {

    @Override
    public boolean canValidate(TaxonimiesContext context) {
        return context != null;
    }

    @Override
    public void validate(TaxonimiesContext context) throws ValidationException {
        if (context.getExpectedHttpResponseCode() != 200)
        {
            context.getErrorResponsePayload().validateState();
        }
        if (context.getExpectedHttpResponseCode() == 200){
            context.getResponsePayload().validateState();
        }

    }
}
