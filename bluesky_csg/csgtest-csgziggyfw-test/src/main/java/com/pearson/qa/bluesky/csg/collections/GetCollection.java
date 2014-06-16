package com.pearson.qa.bluesky.csg.collections;

import com.pearson.qa.bluesky.csg.TestBase;
import com.pearson.qa.bluesky.csg.collections.getcollection.contexts.GetCollectionContext;
import com.pearson.qa.bluesky.csg.collections.getcollection.executordrivers.GetCollectionExecutorDriver;
import com.pearson.qa.bluesky.csg.dataproviders.CollectionsDataProvider;
import com.pearson.qa.common.configuration.Configuration;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by brian on 3/17/14.
 */
public class GetCollection extends TestBase {

    @Test(groups = {"collection.GetCollection"},
            dependsOnGroups = {"authentication.login.success"},
            dataProvider = "GetCollectionDP",
            dataProviderClass = CollectionsDataProvider.class)

    public void GetCollection(String CollectionIdDataProvider, String title, boolean isNegativeTest, int serverCode) {
        try {
            // prepare context
            GetCollectionContext context = injector.getInstance(GetCollectionContext.class);
            Configuration configuration = injector.getInstance(Configuration.class);
            context.setRequestHost(configuration.getString("com/pearson/qa/bluesky/csg/common/host", "com/pearson/qa/bluesky/csg/common/host"));

            context.setRequestHeaders(this.getRequestHeader());

            //context.getRequestPayload().setTitle(collectionTitle);
            context.setRequestPath("/csg/api/v2/content/collections/" + collectionIdGlobal);
            //context.setExpectedHttpResponseCode(serverCode);
            // perform our test
            GetCollectionExecutorDriver getCollectionDriver = injector.getInstance(GetCollectionExecutorDriver.class);
            getCollectionDriver.execute(context);

            if (context.getReturnedHttpResponseCode()==200)

            {
                Assert.assertNotEquals(title,"Collection Title Automation");
            }
        } catch (Exception e) {
            Assert.fail(e.getMessage(), e);
        }
    }

    @Test(groups = {"collection.GetCollection"},
            dependsOnGroups = {"collection.createcollection"})
    public void GetCollectionTestPositive() {
        try {
            // prepare context
            GetCollectionContext context = injector.getInstance(GetCollectionContext.class);
            Configuration configuration = injector.getInstance(Configuration.class);
            context.setRequestHost(configuration.getString("com/pearson/qa/bluesky/csg/common/host", "com/pearson/qa/bluesky/csg/common/host"));

            context.setRequestHeaders(this.getRequestHeader());

            //context.getRequestPayload().setTitle(collectionTitle);
            context.setRequestPath("/csg/api/v2/content/collections/" + collectionIdGlobal );

            //context.setExpectedHttpResponseCode(serverCode);

            // perform our test
            GetCollectionExecutorDriver getCollectionDriver = injector.getInstance(GetCollectionExecutorDriver.class);
            getCollectionDriver.execute(context);

            if (context.getReturnedHttpResponseCode()==200)

            {
               //Assert.assertEquals(context.getCollectionId(), collectionIdGlobal);
               Assert.assertNotEquals(context.getTitle(),"Collection Title Automation");
            }
        } catch (Exception e) {
            Assert.fail(e.getMessage(), e);
        }

    }
}
    

