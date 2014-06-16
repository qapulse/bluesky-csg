package com.pearson.qa.bluesky.csg.books.generateSalesRepReport.modules;

/**
 * Created by dcorrales on 2/27/14.
 */
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.pearson.qa.bluesky.csg.books.generateSalesRepReport.contexts.GenerateSalesRepReportContexts;
import com.pearson.qa.bluesky.csg.books.generateSalesRepReport.executor.GenerateSalesRepReportExecutor;
import com.pearson.qa.bluesky.csg.books.generateSalesRepReport.validators.GenerateSalesRepReportValidator;
import com.pearson.qa.common.ziggyfw.executors.Executor;
import com.pearson.qa.common.ziggyfw.validators.Validator;

import java.util.ArrayList;
import java.util.List;

public class GenerateSalesRepReportModule extends AbstractModule {

    @Provides
    public List<Executor<GenerateSalesRepReportContexts>> getLoginExecutors(GenerateSalesRepReportExecutor<GenerateSalesRepReportContexts> executor)
    {
        List<Executor<GenerateSalesRepReportContexts>> executors = new ArrayList<>();
        executors.add(executor);
        return executors;
    }

    @Provides
    public List<Validator<GenerateSalesRepReportContexts>> getLoginValidators(GenerateSalesRepReportValidator validator)
    {
        List<Validator<GenerateSalesRepReportContexts>> validators = new ArrayList<>();
        validators.add(validator);
        return validators;
    }

    @Override
    protected void configure() {

    }
}

