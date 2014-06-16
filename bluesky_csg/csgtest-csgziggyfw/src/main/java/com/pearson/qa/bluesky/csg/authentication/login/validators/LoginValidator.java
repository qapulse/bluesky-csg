package com.pearson.qa.bluesky.csg.authentication.login.validators;

import com.pearson.qa.bluesky.csg.authentication.login.contexts.LoginContext;
import com.pearson.qa.common.ziggyfw.exceptions.ValidationException;
import com.pearson.qa.common.ziggyfw.validators.Validator;
import org.apache.commons.lang3.StringUtils;

/**
 * Created with IntelliJ IDEA.
 * User: dcorrales
 * Date: 2/5/14
 * Time: 4:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class LoginValidator implements Validator<LoginContext> {
    @Override
    public boolean canValidate(LoginContext context) {
        return context != null && context.getLoginResponsePayload() != null;
    }

    @Override
    public void validate(LoginContext context) throws ValidationException {

        if (context.getExpectedHttpResponseCode() != 200)
        {
            if(!StringUtils.isBlank( context.getLoginResponsePayload().getSessionToken()) ||context.getLoginResponsePayload().getSessionToken() != null ){
                throw new ValidationException("If the response is not success, there must not be session token in the response");
            }

        }

        // Validate the response
        context.getLoginResponsePayload().validateState();
    }
}
