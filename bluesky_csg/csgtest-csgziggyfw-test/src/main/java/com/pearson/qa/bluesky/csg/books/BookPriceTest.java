package com.pearson.qa.bluesky.csg.books;

import com.pearson.qa.bluesky.csg.TestBase;
import com.pearson.qa.bluesky.csg.books.bookPrice.contexts.BookPriceContext;
import com.pearson.qa.bluesky.csg.books.bookPrice.executordrivers.BookPriceExecutorDriver;
import com.pearson.qa.bluesky.csg.dataproviders.books.BookDataProvider;
import com.pearson.qa.common.configuration.Configuration;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by dcorrales on 2/21/14.
 */
public class BookPriceTest extends TestBase {

    @Test(groups = {"books.bookPrice"},
            dependsOnGroups = {"authentication.login.success"},
            dataProvider = "BookPriceDP",
            dataProviderClass = BookDataProvider.class)
    public void bookPrice(String bookPrice,String type, boolean isNegativeTest, int expectedServerCode) {

        try {
            // prepare context
            BookPriceContext context = injector.getInstance(BookPriceContext.class);
            Configuration configuration = injector.getInstance(Configuration.class);
            context.setRequestHost(configuration.getString("com/pearson/qa/bluesky/csg/common/host", ""));
            context.setRequestHeaders(this.getRequestHeader());

            context.setRequestPath("/csg/api/v2/books/" + bookPrice + "/price?type="+type);

            context.setExpectedHttpResponseCode(expectedServerCode);

            // perform our test
            BookPriceExecutorDriver executorDriver = injector.getInstance(BookPriceExecutorDriver.class);
            executorDriver.execute(context);

            if (isNegativeTest) {
                Assert.assertNotEquals(200,context.getReturnedHttpResponseCode());
                Assert.assertNotNull(context.getErrorResponsePayload());
                Assert.assertNotNull(context.getErrorResponsePayload().getMessage());
            }


        } catch (Exception e) {
            Assert.fail(e.getMessage(), e);
        }
    }
}
