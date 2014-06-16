package com.pearson.qa.bluesky.csg.collections.getcollection.validators;

import com.pearson.qa.bluesky.csg.collections.getcollection.contexts.GetCollectionContext;
import com.pearson.qa.common.ziggyfw.exceptions.ValidationException;
import com.pearson.qa.common.ziggyfw.validators.Validator;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by brian on 3/9/14.
 */
public class GetCollectionValidator implements Validator<GetCollectionContext> {

    @Override
    public boolean canValidate(GetCollectionContext context) {
    return context != null;//  && context.getResponsePayload() != null;
}

    @Override
    public void validate(GetCollectionContext context) throws ValidationException {
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