package com.pearson.qa.bluesky.csg.users;

import com.pearson.qa.bluesky.csg.TestBase;
import com.pearson.qa.bluesky.csg.dataproviders.users.UsersDataProvider;
import com.pearson.qa.bluesky.csg.user.deleteResource.contexts.DeleteResourceContext;
import com.pearson.qa.bluesky.csg.user.deleteResource.executordrivers.DeleteResourceExecutorDriver;
import com.pearson.qa.common.configuration.Configuration;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by didiercorrales on 3/30/14.
 */
public class UserFavorites extends TestBase {
    @Test(groups = {"users.userFavorites"},
            dependsOnGroups = {"authentication.login.success"},
            dataProvider = "userFavoritesDP",
            dataProviderClass = UsersDataProvider.class)
    public void createUserResourcesTEst (String userResourceId, String user , int serverCode) {



        try {

            // prepare context
            DeleteResourceContext context = injector.getInstance(DeleteResourceContext.class);
            Configuration configuration = injector.getInstance(Configuration.class);
            context.setRequestHost(configuration.getString("com/pearson/qa/bluesky/csg/common/host", "com/pearson/qa/bluesky/csg/common/host"));

            context.setRequestHeaders(this.getRequestHeader());

            // TODO Brian This value must be replaced with the correct newUserResourceID when the correct resource id is set on the createResource test on line 46
            if (userResourceId.equals("resourceId") && StringUtils.isBlank(newUserResourceId))
                userResourceId = newUserResourceId;

            if (user.equals("userId"))
                user = userId;

            context.setRequestPath("/csg/api/v2/user/content/"+user+"/resources/"+userResourceId);

            context.setExpectedHttpResponseCode(serverCode);

            // perform our test
            DeleteResourceExecutorDriver executorDriver = injector.getInstance(DeleteResourceExecutorDriver.class);
            executorDriver.execute(context);

        } catch (Exception e) {
            Assert.fail(e.getMessage(), e);
        }
    }
}
