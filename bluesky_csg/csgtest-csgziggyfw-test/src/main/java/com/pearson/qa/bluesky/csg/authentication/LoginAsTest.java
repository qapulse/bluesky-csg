package com.pearson.qa.bluesky.csg.authentication;

import com.pearson.qa.bluesky.csg.TestBase;
import com.pearson.qa.bluesky.csg.authentication.loginAs.contexts.LoginAsContext;
import com.pearson.qa.bluesky.csg.authentication.loginAs.executordrivers.LoginAsExecutorDriver;
import com.pearson.qa.bluesky.csg.dataproviders.StaticProvider;
import com.pearson.qa.common.configuration.Configuration;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by didiercorrales on 2/27/14.
 */
public class LoginAsTest extends TestBase {

    @Test(groups = {"authentication.loginAs"},
            dependsOnGroups = {"collection.createcollection"},
            dataProvider = "loginAsDP",
            dataProviderClass = StaticProvider.class
    )
    public void loginAs(String collectionId, boolean isNegativeTest, int expectedServerCode) {

        try {
            // prepare context
            LoginAsContext context = injector.getInstance(LoginAsContext.class);
            Configuration configuration = injector.getInstance(Configuration.class);
            context.setRequestHost(configuration.getString("com/pearson/qa/bluesky/csg/common/host", ""));
            context.setRequestHeaders(this.getRequestHeader());

            if (isNegativeTest)
                context.getRequestPayload().setCollectionId(collectionId);
            else
                context.getRequestPayload().setCollectionId(collectionIdGlobal);

            // perform our test
            LoginAsExecutorDriver executorDriver = injector.getInstance(LoginAsExecutorDriver.class);
            executorDriver.execute(context);

            Assert.assertEquals(200, context.getExpectedHttpResponseCode());

        } catch (Exception e) {
            Assert.fail(e.getMessage(), e);
        }
    }
}
