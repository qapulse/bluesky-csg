package com.pearson.qa.bluesky.csg.collections;

import com.pearson.qa.bluesky.csg.TestBase;
import com.pearson.qa.bluesky.csg.collections.updateResourceByResourceInstance.contexts.UpdateResourceByResourceInstanceContext;
import com.pearson.qa.bluesky.csg.collections.updateResourceByResourceInstance.executordrivers.UpdateResourceByResourceInstanceExecutorDriver;
import com.pearson.qa.bluesky.csg.dataproviders.collections.CollectionNotesDataProvider;
import com.pearson.qa.bluesky.csg.dataproviders.users.UsersDataProvider;
import com.pearson.qa.common.configuration.Configuration;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;


public class UpdateResourcebyResourceInstance extends TestBase {

    /*@Test(groups = {"collections.updateResourceByResourceInstance"},
            dependsOnGroups = {"authentication.login.success"},
            dataProvider = "updateResourceByResourceInstanceDP",
            dataProviderClass = CollectionNotesDataProvider.class)
    */public void updateResourceByResourceInstanceTest (String resourceInstanceId, String description, String  status , int serverCode) {

        try {

            // prepare context
            UpdateResourceByResourceInstanceContext context = injector.getInstance(UpdateResourceByResourceInstanceContext.class);
            Configuration configuration = injector.getInstance(Configuration.class);
            context.setRequestHost(configuration.getString("com/pearson/qa/bluesky/csg/common/host", "com/pearson/qa/bluesky/csg/common/host"));

            context.setRequestHeaders(this.getRequestHeader());

            context.setRequestPath("/csg/api/v2/content/collections/resourceInstance/" + resourceInstanceId);
            context.getRequestPayload().setDescription(description);
            context.getRequestPayload().setStatus(status);

            //context.setExpectedHttpResponseCode(serverCode);

            // perform our test
            UpdateResourceByResourceInstanceExecutorDriver executorDriver = injector.getInstance(UpdateResourceByResourceInstanceExecutorDriver.class);
            executorDriver.execute(context);

        } catch (Exception e) {
            Assert.fail(e.getMessage(), e);
        }
    }
}
