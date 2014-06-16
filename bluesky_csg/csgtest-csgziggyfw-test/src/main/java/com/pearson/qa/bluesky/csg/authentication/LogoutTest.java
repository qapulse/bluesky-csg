package com.pearson.qa.bluesky.csg.authentication;

import com.pearson.qa.bluesky.csg.TestBase;
import com.pearson.qa.bluesky.csg.authentication.logout.contexts.LogoutContext;
import com.pearson.qa.bluesky.csg.authentication.logout.executordrivers.LogoutExecutorDriver;
import com.pearson.qa.common.configuration.Configuration;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;


/**
 * Created by didiercorrales on 2/27/14.
 */
public class LogoutTest extends TestBase{

   /* TODO Add the logout at the end of the suite execution
    @Test (groups = {"authentication.logout"},
            dependsOnGroups = {"authentication.login.success"})
    */public void logout() {

        try {
            // prepare context
            LogoutContext context = injector.getInstance(LogoutContext.class);
            Configuration configuration = injector.getInstance(Configuration.class);
            context.setRequestHost(configuration.getString("com/pearson/qa/bluesky/csg/common/host", ""));
            context.setRequestHeaders(this.getRequestHeader());

            // perform our test
            LogoutExecutorDriver executorDriver = injector.getInstance(LogoutExecutorDriver.class);
            executorDriver.execute(context);

            Assert.assertEquals(200, context.getExpectedHttpResponseCode());

        } catch (Exception e) {
            Assert.fail(e.getMessage(), e);
        }
    }
}
