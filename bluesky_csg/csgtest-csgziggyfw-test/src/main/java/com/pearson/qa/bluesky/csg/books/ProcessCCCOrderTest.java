package com.pearson.qa.bluesky.csg.books;

import com.pearson.qa.bluesky.csg.TestBase;
import com.pearson.qa.bluesky.csg.books.processCccOrder.contexts.ProcessCccOrderContext;
import com.pearson.qa.bluesky.csg.books.processCccOrder.executordrivers.ProcessCccOrderExecutorDriver;
import com.pearson.qa.bluesky.csg.dataproviders.books.BookDataProvider;
import com.pearson.qa.common.configuration.Configuration;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by didiercorrales on 3/9/14.
 */
public class ProcessCCCOrderTest extends TestBase {


    /*@Test
            (groups = {"books.ProcessCCCOrder"},
                    dependsOnGroups = {"authentication.login.success"},
                    dataProvider = "processCCCOrderTestDP",
                    dataProviderClass = BookDataProvider.class)
    */public void processCCCOrder(String bookBuildContentId, String issns, String productType, String userInformation, int serverExpectedCodeResponse) {

        try {
            // prepare context
            ProcessCccOrderContext context = injector.getInstance(ProcessCccOrderContext.class);
            Configuration configuration = injector.getInstance(Configuration.class);
            context.setRequestHost(configuration.getString("com/pearson/qa/bluesky/csg/common/host", ""));
            context.setRequestHeaders(this.getRequestHeader());

            context.getRequestPayload().setBookBuildContentId(bookBuildContentId);
            context.getRequestPayload().setIssns(issns);
            context.getRequestPayload().setProductType(productType);
            context.getRequestPayload().setUserInformation(userInformation);

            context.setExpectedHttpResponseCode(serverExpectedCodeResponse);

            // perform our test
            ProcessCccOrderExecutorDriver executorDriver = injector.getInstance(ProcessCccOrderExecutorDriver.class);
            executorDriver.execute(context);

            if (context.getReturnedHttpResponseCode() != 200) {
                Assert.assertNotNull(context.getErrorResponsePayload());
                Assert.assertNotNull(context.getErrorResponsePayload().getMessage());
            }


        } catch (Exception e) {
            Assert.fail(e.getMessage(), e);
        }
    }
}
