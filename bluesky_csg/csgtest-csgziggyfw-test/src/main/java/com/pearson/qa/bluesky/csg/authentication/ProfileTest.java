package com.pearson.qa.bluesky.csg.authentication;

import com.pearson.qa.bluesky.csg.TestBase;
import com.pearson.qa.bluesky.csg.authentication.profile.contexts.ProfileContext;
import com.pearson.qa.bluesky.csg.authentication.profile.executordrivers.ProfileExecutorDriver;
import com.pearson.qa.common.configuration.Configuration;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by didiercorrales on 2/27/14.
 */
public class ProfileTest extends TestBase {

    @Test(groups = {"authentication.profile"},
            dependsOnGroups = {"authentication.login.success"})
    public void profile() {

        try {
            // prepare context
            ProfileContext context = injector.getInstance(ProfileContext.class);
            Configuration configuration = injector.getInstance(Configuration.class);
            context.setRequestHost(configuration.getString("com/pearson/qa/bluesky/csg/common/host", ""));
            context.setRequestHeaders(this.getRequestHeader());

            // perform our test
            ProfileExecutorDriver executorDriver = injector.getInstance(ProfileExecutorDriver.class);
            executorDriver.execute(context);

            Assert.assertEquals(200,context.getExpectedHttpResponseCode());

        } catch (Exception e) {
            Assert.fail(e.getMessage(), e);
        }
    }
}
