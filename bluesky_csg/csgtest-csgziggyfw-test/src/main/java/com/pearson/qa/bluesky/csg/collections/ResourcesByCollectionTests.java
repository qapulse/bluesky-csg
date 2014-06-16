package com.pearson.qa.bluesky.csg.collections;

import com.pearson.qa.bluesky.csg.TestBase;
import com.pearson.qa.bluesky.csg.collections.resourcescollection.datastructures.ResourcesByCollectionResponse;
import com.pearson.qa.bluesky.csg.collections.resourcescollection.executordrivers.ResourcesByCollectionDriver;
import com.pearson.qa.bluesky.csg.collections.resourcescollection.contexts.ResourcesByCollection;
import com.pearson.qa.bluesky.csg.dataproviders.CollectionsDataProvider;
//import com.pearson.qa.bluesky.csg.dataproviders.books.
import com.pearson.qa.common.configuration.Configuration;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by brian on 2/28/14.
 */
public class ResourcesByCollectionTests extends TestBase {

    @Test(groups = {"collection.ResoucesByCollection"},
            dependsOnGroups = {"authentication.login.success"},
            dataProvider = "ResourcesByCollectionDP",
            dataProviderClass = CollectionsDataProvider.class)

    public void ResoucesByCollectionTest(String CollectionIdDataProvider, String title, boolean isNegativeTest, int serverCode) {
        try {
            // prepare context
            ResourcesByCollection context = injector.getInstance(ResourcesByCollection.class);
            Configuration configuration = injector.getInstance(Configuration.class);
            context.setRequestHost(configuration.getString("com/pearson/qa/bluesky/csg/common/host", "com/pearson/qa/bluesky/csg/common/host"));

            context.setRequestHeaders(this.getRequestHeader());

            //context.getRequestPayload().setTitle(collectionTitle);
            context.setRequestPath("/csg/api/v2/content/collections/" + CollectionIdDataProvider + "/resources");

                context.setExpectedHttpResponseCode(serverCode);

            // perform our test
            ResourcesByCollectionDriver resoucesByCollectionDriver = injector.getInstance(ResourcesByCollectionDriver.class);
            resoucesByCollectionDriver.execute(context);

            if (context.getReturnedHttpResponseCode()==200)

            {
            Assert.assertEquals(context.getCollectionId(), CollectionIdDataProvider);
            Assert.assertEquals(context.getCollectionId(),title);
            }
        } catch (Exception e) {
            Assert.fail(e.getMessage(), e);
        }


    }

    @Test(groups = {"collection.ResoucesByCollection"},
            dependsOnGroups = {"collection.createcollection"})
    public void ResoucesByCollectionTestPositive() {
        try {
            // prepare context
            ResourcesByCollection context = injector.getInstance(ResourcesByCollection.class);
            Configuration configuration = injector.getInstance(Configuration.class);
            context.setRequestHost(configuration.getString("com/pearson/qa/bluesky/csg/common/host", "com/pearson/qa/bluesky/csg/common/host"));

            context.setRequestHeaders(this.getRequestHeader());

            //context.getRequestPayload().setTitle(collectionTitle);
            context.setRequestPath("/csg/api/v2/content/collections/" + collectionIdGlobal + "/resources");

            //context.setExpectedHttpResponseCode(serverCode);

            // perform our test
            ResourcesByCollectionDriver resoucesByCollectionDriver = injector.getInstance(ResourcesByCollectionDriver.class);
            resoucesByCollectionDriver.execute(context);

            if (context.getReturnedHttpResponseCode()==200)

            {
                //Assert.assertNotEquals(context.getCollectionId(), collectionIdGlobal);
                Assert.assertNotEquals(context.getTitle(),"Collection Title Automation");
            }
        } catch (Exception e) {
            Assert.fail(e.getMessage(), e);
        }
    }
}
