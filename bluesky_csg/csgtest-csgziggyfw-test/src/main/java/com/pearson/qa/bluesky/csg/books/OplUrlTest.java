package com.pearson.qa.bluesky.csg.books;

import com.pearson.qa.bluesky.csg.TestBase;
import com.pearson.qa.bluesky.csg.books.oplUrl.contexts.OplUrlContext;
import com.pearson.qa.bluesky.csg.books.oplUrl.executordrivers.OplUrlExecutorDriver;
import com.pearson.qa.bluesky.csg.dataproviders.books.BookDataProvider;
import com.pearson.qa.common.configuration.Configuration;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by didiercorrales on 3/9/14.
 */
public class OplUrlTest extends TestBase {

    /*@Test
           (groups = {"books.OplUrl"},
                   dependsOnGroups = {"authentication.login.success"},
                   dataProvider = "oplUrlDP",
                   dataProviderClass = BookDataProvider.class)
   */public void oplUrl(String isbn, int serverExpectedCodeResponse) {

        try {
            // prepare context
            OplUrlContext context = injector.getInstance(OplUrlContext.class);
            Configuration configuration = injector.getInstance(Configuration.class);
            context.setRequestHost(configuration.getString("com/pearson/qa/bluesky/csg/common/host", ""));
            context.setRequestHeaders(this.getRequestHeader());

            context.setRequestPath("/csg/api/v2/books/olp/"+isbn+"/url");

            context.setExpectedHttpResponseCode(serverExpectedCodeResponse);

            // perform our test
            OplUrlExecutorDriver executorDriver = injector.getInstance(OplUrlExecutorDriver.class);
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
