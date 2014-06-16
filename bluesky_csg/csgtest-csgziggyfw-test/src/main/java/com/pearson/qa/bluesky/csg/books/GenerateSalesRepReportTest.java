package com.pearson.qa.bluesky.csg.books;

import com.pearson.qa.bluesky.csg.TestBase;
import com.pearson.qa.bluesky.csg.books.generateSalesRepReport.contexts.GenerateSalesRepReportContexts;
import com.pearson.qa.bluesky.csg.books.generateSalesRepReport.executordrivers.GenerateSalesRepReportExecutorDriver;
import com.pearson.qa.bluesky.csg.dataproviders.books.BookDataProvider;
import com.pearson.qa.common.configuration.Configuration;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by didiercorrales on 3/9/14.
 */
public class GenerateSalesRepReportTest extends TestBase {

    /*@Test(
            groups = {"books.generateSalesReport"},
            dependsOnGroups = {"authentication.login.success"}
    )
    */public void generateSalesRepReport(){
        try {
            // prepare context
            GenerateSalesRepReportContexts context = injector.getInstance(GenerateSalesRepReportContexts.class);
            Configuration configuration = injector.getInstance(Configuration.class);
            context.setRequestHost(configuration.getString("com/pearson/qa/bluesky/csg/common/host", ""));
            context.setRequestHeaders(this.getRequestHeader());

            String territoryId="2";
            String schoolId="1";
            String author="Public,User";


            context.setRequestPath("/csg/api/v2/books/salesRepReport?territoryId=" + territoryId + "&schoolId=" + schoolId +"&author=" +author );



            // perform our test
            GenerateSalesRepReportExecutorDriver executorDriver = injector.getInstance(GenerateSalesRepReportExecutorDriver.class);
            executorDriver.execute(context);

            if (context.getReturnedHttpResponseCode()==400) {
                Assert.assertNull(context.getErrorResponsePayload());
                Assert.assertNull(context.getErrorResponsePayload().getMessage());
            }

        } catch (Exception e) {
            Assert.fail(e.getMessage(), e);
        }
    }

    /*@Test(
            groups = {"books.generateSalesReport"},
            dependsOnGroups = {"authentication.login.success"},
            dataProvider = "generateSalesReportDP",
            dataProviderClass = BookDataProvider.class
    )
    */public void generateSalesRepReportNegativeScenarios(String territoryId, String schoolId, String author, int expectedServerCode){

        try {
            // prepare context
            GenerateSalesRepReportContexts context = injector.getInstance(GenerateSalesRepReportContexts.class);
            Configuration configuration = injector.getInstance(Configuration.class);
            context.setRequestHost(configuration.getString("com/pearson/qa/bluesky/csg/common/host", ""));
            context.setRequestHeaders(this.getRequestHeader());

            // Set API PATH
            context.setRequestPath("/csg/api/v2/books/salesRepReport?territoryId=" + territoryId + "&schoolId=" + schoolId +"&author=" +author );

            context.setExpectedHttpResponseCode(expectedServerCode);

            // perform our test
            GenerateSalesRepReportExecutorDriver executorDriver = injector.getInstance(GenerateSalesRepReportExecutorDriver.class);
            executorDriver.execute(context);

            if (context.getReturnedHttpResponseCode()!=200) {
                Assert.assertNotNull(context.getErrorResponsePayload());
                Assert.assertNotNull(context.getErrorResponsePayload().getMessage());
            }
        } catch (Exception e) {
            Assert.fail(e.getMessage(), e);
        }

    }
}
