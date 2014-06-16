package com.pearson.qa.bluesky.csg.collections.resourcescollection.validators;

import com.pearson.qa.bluesky.csg.collections.resourcescollection.contexts.ResourcesByCollection;
import com.pearson.qa.common.ziggyfw.exceptions.ValidationException;
import com.pearson.qa.common.ziggyfw.validators.Validator;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by brian on 2/27/14.
 */
public class ResourcesByCollectionValidator implements Validator<ResourcesByCollection> {

    @Override
    public boolean canValidate(ResourcesByCollection context) {
        return context != null && context.getResponsePayload() != null;
    }

    @Override
    public void validate(ResourcesByCollection context) throws ValidationException {
        if (context.getExpectedHttpResponseCode() != 200)
        {
            if(!StringUtils.isBlank(context.getResponsePayload().getCollectionId())) {
                throw new ValidationException("If the response is not success, there must not be collection Id in the response");
            }
        }
        if (context.getExpectedHttpResponseCode() == 200)
        {
            if(StringUtils.isBlank(context.getResponsePayload().getCollectionId())) {
                throw new ValidationException("If the response is success, there must  be collection Id in the response");
            }
        }
    }

}
