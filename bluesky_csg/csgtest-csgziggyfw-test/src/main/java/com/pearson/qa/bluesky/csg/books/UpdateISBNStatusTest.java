package com.pearson.qa.bluesky.csg.books;

import com.pearson.qa.bluesky.csg.TestBase;
import com.pearson.qa.bluesky.csg.books.updateBookBuild.contexts.UpdateBookBuildContext;
import com.pearson.qa.bluesky.csg.books.updateIsbnStatus.contexts.UpdateIsbnStatusContext;
import com.pearson.qa.bluesky.csg.books.updateIsbnStatus.executordrivers.UpdateIsbnStatusExecutorDriver;
import com.pearson.qa.bluesky.csg.dataproviders.books.BookDataProvider;
import com.pearson.qa.common.configuration.Configuration;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by didiercorrales on 3/9/14.
 */
public class UpdateISBNStatusTest extends TestBase {

    @Test
            (groups = {"books.UpdateISBNStatus"},
                    dependsOnGroups = {"authentication.login.success"},
                    dataProvider = "updateISBNStatustDP",
                    dataProviderClass = BookDataProvider.class)
    public void updateISBNStatus(String isbn, String status,  String statusModifier , int serverExpectedCodeResponse) {

        try {
            // prepare context
            UpdateIsbnStatusContext context = injector.getInstance(UpdateIsbnStatusContext.class);
            Configuration configuration = injector.getInstance(Configuration.class);
            context.setRequestHost(configuration.getString("com/pearson/qa/bluesky/csg/common/host", ""));
            context.setRequestHeaders(this.getRequestHeader());

            context.getRequestPayload().setIsbn(isbn);
            context.getRequestPayload().setStatus(status);
            context.getRequestPayload().setStatusModifier(statusModifier);

            context.setExpectedHttpResponseCode(serverExpectedCodeResponse);

            // perform our test
            UpdateIsbnStatusExecutorDriver executorDriver = injector.getInstance(UpdateIsbnStatusExecutorDriver.class);
            executorDriver.execute(context);

            if (context.getReturnedHttpResponseCode() != 200) {
                Assert.assertNotNull(context.getErrorResponsePayload());
                Assert.assertNotNull(context.getErrorResponsePayload().getMessage());
            }
            else
                Assert.assertEquals("The ISBN was updated",context.getResponsePayload().getResult());


        } catch (Exception e) {
            Assert.fail(e.getMessage(), e);
        }
    }

}
