package com.pearson.qa.bluesky.csg.books;

import com.pearson.qa.bluesky.csg.TestBase;
import com.pearson.qa.bluesky.csg.books.bookRegisteredDetails.contexts.BookRegisteredDetailsContext;
import com.pearson.qa.bluesky.csg.books.bookRegisteredDetails.executorDrivers.BookRegisteredDetailsExecutorDriver;
import com.pearson.qa.bluesky.csg.dataproviders.books.BookDataProvider;
import com.pearson.qa.common.configuration.Configuration;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by dcorrales on 2/27/14.
 */
public class BookRegisteredDetailsTest extends TestBase {

    @Test (groups = {"books.bookRegistered"},
            dependsOnGroups = {"authentication.login.success"},
            dataProvider = "BookRegisteredDetailsDP",
            dataProviderClass = BookDataProvider.class)
    public void bookRegisteredDetails(String productId, int expectedServerCode){

        try {
            // prepare context
            BookRegisteredDetailsContext context = injector.getInstance(BookRegisteredDetailsContext.class);
            Configuration configuration = injector.getInstance(Configuration.class);
            context.setRequestHost(configuration.getString("com/pearson/qa/bluesky/csg/common/host", ""));
            context.setRequestHeaders(this.getRequestHeader());

            context.setRequestPath("/csg/api/v2/books/registered/details/" + productId);

            context.setExpectedHttpResponseCode(expectedServerCode);

            // perform our test
            BookRegisteredDetailsExecutorDriver executorDriver = injector.getInstance(BookRegisteredDetailsExecutorDriver.class);
            executorDriver.execute(context);

            if (context.getReturnedHttpResponseCode()!=200) {
                Assert.assertNotNull(context.getErrorResponsePayload());
                Assert.assertNotNull(context.getErrorResponsePayload().getMessage());
            }
            else
            {
                // TODO Add validation to get the correct answer
                // If the response is different than array empty, the correct information muct be returned
                Assert.assertTrue(!StringUtils.isBlank(context.getResponsePayload().getResult().toString()));
            }

        } catch (Exception e) {
            Assert.fail(e.getMessage(), e);
        }

    }
}
