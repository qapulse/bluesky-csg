package com.pearson.qa.bluesky.csg.collections.createcollection.validators;

import com.pearson.qa.bluesky.csg.collections.createcollection.contexts.CreateCollectionContexts;
import com.pearson.qa.common.ziggyfw.exceptions.ValidationException;
import com.pearson.qa.common.ziggyfw.validators.Validator;
import org.apache.commons.lang3.StringUtils;

/**
 * Created with IntelliJ IDEA.
 * User: dcorrales
 * Date: 2/10/14
 * Time: 3:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class CreateCollectionValidator implements Validator<CreateCollectionContexts> {

    @Override
    public boolean canValidate(CreateCollectionContexts context) {
        return context != null && context.getCreateCollectionResponse() != null;
    }

    @Override
    public void validate(CreateCollectionContexts context) throws ValidationException {
        if (context.getExpectedHttpResponseCode() != 200)
        {
            if(!StringUtils.isBlank(context.getCreateCollectionResponse().getCollectionId())) {
                throw new ValidationException("If the response is not success, there must not be collection Id in the response");
            }
        }
        if (context.getExpectedHttpResponseCode() == 200)
        {
            if(StringUtils.isBlank(context.getCreateCollectionResponse().getCollectionId())) {
                throw new ValidationException("If the response is success, there must  be collection Id in the response");
            }
        }
    }
}
