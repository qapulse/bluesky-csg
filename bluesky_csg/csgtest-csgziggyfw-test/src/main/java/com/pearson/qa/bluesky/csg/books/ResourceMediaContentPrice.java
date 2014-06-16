package com.pearson.qa.bluesky.csg.books;

import com.pearson.qa.bluesky.csg.TestBase;
import com.pearson.qa.bluesky.csg.books.resourceMediaContentPrice.contexts.ResourceMediaContentPriceContext;
import com.pearson.qa.bluesky.csg.books.resourceMediaContentPrice.executordrivers.ResourceMediaContentPriceExecutorDriver;
import com.pearson.qa.bluesky.csg.dataproviders.books.BookDataProvider;
import com.pearson.qa.common.configuration.Configuration;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by didiercorrales on 3/9/14.
 */
public class ResourceMediaContentPrice extends TestBase {

    /*@Test
            (groups = {"books.ResourceMediaContentPrice"},
                    dependsOnGroups = {"authentication.login.success"},
                    dataProvider = "resourceMediaContentPriceDP",
                    dataProviderClass = BookDataProvider.class)
    */public void resourceMediaContentPrice(String isbn, String type, int serverExpectedCodeResponse) {

        try {
            // prepare context
            ResourceMediaContentPriceContext context = injector.getInstance(ResourceMediaContentPriceContext.class);
            Configuration configuration = injector.getInstance(Configuration.class);
            context.setRequestHost(configuration.getString("com/pearson/qa/bluesky/csg/common/host", ""));
            context.setRequestHeaders(this.getRequestHeader());

            context.setRequestPath("/csg/api/v2/books/rmc/" + isbn + "/price?type=" + type);

            context.setExpectedHttpResponseCode(serverExpectedCodeResponse);

            // perform our test
            ResourceMediaContentPriceExecutorDriver executorDriver = injector.getInstance(ResourceMediaContentPriceExecutorDriver.class);
            executorDriver.execute(context);

            if (context.getReturnedHttpResponseCode() != 200) {
                Assert.assertNotNull(context.getErrorResponsePayload());
                Assert.assertNotNull(context.getErrorResponsePayload().getMessage());
            }


        } catch (Exception e) {
            Assert.fail(e.getMessage(), e);
        }
    }


    /*@Test
            (groups = {"books.ResourceMediaContentPrice"},
                    dependsOnGroups = {"authentication.login.success"},
                    dataProvider = "resourceMediaContentPriceNegativeScenariosDP",
                    dataProviderClass = BookDataProvider.class)
    */public void resourceMediaContentPriceNegativeScenarios(String isbn, String type, int serverExpectedCodeResponse) {

        try {
            // prepare context
            ResourceMediaContentPriceContext context = injector.getInstance(ResourceMediaContentPriceContext.class);
            Configuration configuration = injector.getInstance(Configuration.class);
            context.setRequestHost(configuration.getString("com/pearson/qa/bluesky/csg/common/host", ""));
            context.setRequestHeaders(this.getRequestHeader());

            context.setRequestPath("/csg/api/v2/books/rmc/" + isbn + "/price");

            context.setExpectedHttpResponseCode(serverExpectedCodeResponse);

            // perform our test
            ResourceMediaContentPriceExecutorDriver executorDriver = injector.getInstance(ResourceMediaContentPriceExecutorDriver.class);
            executorDriver.execute(context);

            if (context.getReturnedHttpResponseCode() == 200) {
                Assert.assertNull(context.getErrorResponsePayload());
                Assert.assertNull(context.getErrorResponsePayload().getMessage());
            }


        } catch (Exception e) {
            Assert.fail(e.getMessage(), e);
        }
    }
}



