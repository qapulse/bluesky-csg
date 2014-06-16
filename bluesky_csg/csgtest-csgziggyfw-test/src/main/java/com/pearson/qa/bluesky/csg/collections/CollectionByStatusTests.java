package com.pearson.qa.bluesky.csg.collections;
/**
 * Created by brian on 3/22/14.
 */


import com.pearson.qa.bluesky.csg.TestBase;
import com.pearson.qa.bluesky.csg.collections.collectionbystatus.contexts.CollectionByStatusContexts;
import com.pearson.qa.bluesky.csg.collections.collectionbystatus.executordrivers.CollectionByStatusExecutorDriver;
import com.pearson.qa.bluesky.csg.dataproviders.CollectionsDataProvider;
import com.pearson.qa.common.configuration.Configuration;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by brian on 2/28/14.
 */
public class CollectionByStatusTests extends TestBase {

    @Test(groups = {"collection.CollectionByStatus"},
            dependsOnGroups = {"authentication.login.success"},
            dataProvider = "CollectionByStatusDP",
            dataProviderClass = CollectionsDataProvider.class)

    public void CollectionByStatusTests(String CollectionIdDataProvider, Integer title, boolean isNegativeTest, int serverCode) {
        try {
            // prepare context
            CollectionByStatusContexts context = injector.getInstance(CollectionByStatusContexts.class);
            Configuration configuration = injector.getInstance(Configuration.class);
            context.setRequestHost(configuration.getString("com/pearson/qa/bluesky/csg/common/host", "com/pearson/qa/bluesky/csg/common/host"));

            context.setRequestHeaders(this.getRequestHeader());

            //context.getRequestPayload().setTitle(collectionTitle);
            context.setRequestPath("/csg/api/v2/content/collections/statusCollection/InProgress");// + CollectionIdDataProvider);

            //context.setExpectedHttpResponseCode(serverCode);

            // perform our test
            CollectionByStatusExecutorDriver resoucesByCollectionDriver = injector.getInstance(CollectionByStatusExecutorDriver.class);
            resoucesByCollectionDriver.execute(context);

            if (context.getReturnedHttpResponseCode()==200)

            {
                Assert.assertEquals(context.getStatus(), title.toString());

                //Assert.assertEquals(context.getCollectionId(),title);
            }
        } catch (Exception e) {
            Assert.fail(e.getMessage(), e);
        }


    }

    @Test(groups = {"collection.CollectionByStatus"},
            dependsOnGroups = {"collection.createcollection"})
    public void CollectionByStatusTestPositive() {
        try {
            // prepare context
            CollectionByStatusContexts context = injector.getInstance(CollectionByStatusContexts.class);
            Configuration configuration = injector.getInstance(Configuration.class);
            context.setRequestHost(configuration.getString("com/pearson/qa/bluesky/csg/common/host", "com/pearson/qa/bluesky/csg/common/host"));

            context.setRequestHeaders(this.getRequestHeader());

            //context.getRequestPayload().setTitle(collectionTitle);
            context.setRequestPath("/csg/api/v2/content/collections/statusCollection/InProgress");// + collectionIdGlobal);

            //context.setExpectedHttpResponseCode(serverCode);

            // perform our test
            CollectionByStatusExecutorDriver resoucesByCollectionDriver = injector.getInstance(CollectionByStatusExecutorDriver.class);
            resoucesByCollectionDriver.execute(context);

            if (context.getReturnedHttpResponseCode()==200)

            {
                Assert.assertEquals(context.getStatus(), "0");
                //Assert.assertEquals(context.getTitle(),"Collection Title Automation");
            }
        } catch (Exception e) {
            Assert.fail(e.getMessage(), e);
        }

    }
}