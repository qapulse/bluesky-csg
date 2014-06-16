package com.pearson.qa.bluesky.csg.authentication;

import com.pearson.qa.bluesky.csg.TestBase;
import com.pearson.qa.bluesky.csg.authentication.getSession.contexts.GetSessionContext;
import com.pearson.qa.bluesky.csg.authentication.getSession.executordrivers.GetSessionExecutorDriver;
import com.pearson.qa.bluesky.csg.dataproviders.StaticProvider;
import com.pearson.qa.bluesky.csg.dataproviders.books.BookDataProvider;
import com.pearson.qa.common.configuration.Configuration;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by didiercorrales on 2/27/14.
 */
public class GetSessionTest extends TestBase {

    @Test(groups = {"authentication.getSeccionToken"},
            dependsOnGroups = {"authentication.login.success"},
            dataProvider = "GetSessionTokenDP",
            dataProviderClass = StaticProvider.class)
    public void getSessionToken(String sessionToken , boolean isNegativeTest, int expectedServerCode) {

        try {
            // prepare context
            GetSessionContext context = injector.getInstance(GetSessionContext.class);
            Configuration configuration = injector.getInstance(Configuration.class);
            context.setRequestHost(configuration.getString("com/pearson/qa/bluesky/csg/common/host", ""));
            context.setRequestHeaders(this.getRequestHeader());


            context.setExpectedHttpResponseCode(expectedServerCode);

            if (isNegativeTest)
                context.setRequestPath("/csg/api/v2/authentication/session/" + sessionToken);
            else
                context.setRequestPath("/csg/api/v2/authentication/session/" + sessionTokenToTest);

            // perform our test
            GetSessionExecutorDriver executorDriver = injector.getInstance(GetSessionExecutorDriver.class);
            executorDriver.execute(context);

            if (isNegativeTest) {
                Assert.assertNotEquals(200, context.getReturnedHttpResponseCode());
                Assert.assertNotNull(context.getErrorResponsePayload());
                Assert.assertNotNull(context.getErrorResponsePayload().getMessage());
            }


        } catch (Exception e) {
            Assert.fail(e.getMessage(), e);
        }
    }
}
