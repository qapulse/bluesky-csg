package com.pearson.qa.bluesky.csg.books.generateSalesRepReport.validators;

/**
 * Created by dcorrales on 2/27/14.
 */
import com.pearson.qa.bluesky.csg.books.generateSalesRepReport.contexts.GenerateSalesRepReportContexts;
import com.pearson.qa.common.ziggyfw.exceptions.ValidationException;
import com.pearson.qa.common.ziggyfw.validators.Validator;

public class GenerateSalesRepReportValidator implements Validator<GenerateSalesRepReportContexts> {

    @Override
    public boolean canValidate(GenerateSalesRepReportContexts context) {
        return context != null;
    }

    @Override
    public void validate(GenerateSalesRepReportContexts context) throws ValidationException {
        if (context.getExpectedHttpResponseCode() != 200)
        {
            context.getErrorResponsePayload().validateState();
        }
        if (context.getExpectedHttpResponseCode() == 200){
            context.getResponsePayload().validateState();
        }

    }
}
