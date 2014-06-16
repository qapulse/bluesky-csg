package com.pearson.qa.bluesky.csg.users;

import com.pearson.qa.bluesky.csg.TestBase;
import com.pearson.qa.bluesky.csg.dataproviders.users.UsersDataProvider;
import com.pearson.qa.bluesky.csg.user.createUserResource.contexts.CreateUserResourceContext;
import com.pearson.qa.bluesky.csg.user.createUserResource.executordrivers.CreateUserResourceExecutorDriver;
import com.pearson.qa.common.configuration.Configuration;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by didiercorrales on 3/30/14.
 */
public class CreateResource extends TestBase {

    @Test(groups = {"users.createUserResources"},
            dependsOnGroups = {"authentication.login.success"},
            dataProvider = "createUserResourcesDP",
            dataProviderClass = UsersDataProvider.class)
    public void createUserResourcesTEst (String userResourceId,String json, int serverCode) {
        try {

            // prepare context
            CreateUserResourceContext context = injector.getInstance(CreateUserResourceContext.class);
            Configuration configuration = injector.getInstance(Configuration.class);
            context.setRequestHost(configuration.getString("com/pearson/qa/bluesky/csg/common/host", "com/pearson/qa/bluesky/csg/common/host"));
            context.setRequestHeaders(this.getRequestHeader());

            if (userResourceId.equals("userId"))
                userResourceId = userId;

            context.setRequestPath("/csg/api/v2/user/content/"+userResourceId+"/resources");
            context.getRequestPayload().setJson(json);
            context.setExpectedHttpResponseCode(serverCode);

            // perform our test
            CreateUserResourceExecutorDriver executorDriver = injector.getInstance(CreateUserResourceExecutorDriver.class);
            executorDriver.execute(context);

            if (context.getReturnedHttpResponseCode() == 200)
            newUserResourceId = context.getResponsePayload().getResourceId().toString();

        } catch (Exception e) {
            Assert.fail(e.getMessage(), e);
        }
    }
}
