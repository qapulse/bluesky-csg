package com.pearson.qa.bluesky.csg.books;

import com.pearson.qa.bluesky.csg.TestBase;
import com.pearson.qa.bluesky.csg.books.owrContentFee.contexts.OwrContentFeeContext;
import com.pearson.qa.bluesky.csg.books.owrContentFee.executordrivers.OwrContentFeeExecutorDriver;
import com.pearson.qa.bluesky.csg.dataproviders.books.BookDataProvider;
import com.pearson.qa.common.configuration.Configuration;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by didiercorrales on 3/9/14.
 */
public class OWRContentFeeTest extends TestBase {

    @Test
            (groups = {"books.owrContentFee"},
                    dependsOnGroups = {"authentication.login.success"},
                    dataProvider = "owrContentFeeDP",
                    dataProviderClass = BookDataProvider.class)
    public void owrContentFee(String resourceId, String publicationYear, String numCopies, String numPages, String  type,  int serverExpectedCodeResponse) {

        try {
            // prepare context
            OwrContentFeeContext context = injector.getInstance(OwrContentFeeContext.class);
            Configuration configuration = injector.getInstance(Configuration.class);
            context.setRequestHost(configuration.getString("com/pearson/qa/bluesky/csg/common/host", ""));
            context.setRequestHeaders(this.getRequestHeader());

            context.setRequestPath("/csg/api/v2/books/owr/" + resourceId + "/fee?publicationYear=" + publicationYear +
                                                                                        "&numCopies="+numCopies+"&numPages="+numPages+"&type="+type);

            context.setExpectedHttpResponseCode(serverExpectedCodeResponse);

            // perform our test
            OwrContentFeeExecutorDriver executorDriver = injector.getInstance(OwrContentFeeExecutorDriver.class);
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
