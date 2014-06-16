package com.pearson.qa.bluesky.csg.collections;

import com.pearson.qa.bluesky.csg.TestBase;
import com.pearson.qa.bluesky.csg.collections.deletecollection.contexts.DeleteCollectionContext;
import com.pearson.qa.bluesky.csg.collections.deletecollection.executordrivers.DeleteCollectionExecutorDriver;
import com.pearson.qa.bluesky.csg.dataproviders.CollectionsDataProvider;

import com.pearson.qa.common.configuration.Configuration;

import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by didiercorrales on 3/4/14.
 */
public class DeleteCollection extends TestBase {

    /*@Test(groups = {"collection.deleteCollection"},
           dependsOnGroups = {"collection.createcollection"})
   */ public void deleteCollectionTest() {
        try {
            // prepare context
            DeleteCollectionContext contexts = injector.getInstance(DeleteCollectionContext.class);
            Configuration configuration = injector.getInstance(Configuration.class);
            contexts.setRequestHost(configuration.getString("com/pearson/qa/bluesky/csg/common/host", "com/pearson/qa/bluesky/csg/common/host"));

            contexts.setRequestPath("/csg/api/v2/" + "content/collections/" + collectionIdGlobal);

            contexts.setRequestHeaders(this.getRequestHeader());

            // perform our test
            DeleteCollectionExecutorDriver createCollectionExecutorDriver = injector.getInstance(DeleteCollectionExecutorDriver.class);
            createCollectionExecutorDriver.execute(contexts);


        } catch (Exception e) {
            Assert.fail(e.getMessage(), e);
        }
    }


   /*@Test(groups = {"collection.deleteCollection"},
            dependsOnGroups = {"collection.deleteCollectionNote"},
            dataProvider = "deleteCollectionDPNegativeScenarios",
            dataProviderClass = CollectionsDataProvider.class)
    */public void deleteCollectionTestNegative(String collectionIdToTest, int serverCodeExpected) {
        try {
            // prepare context
            DeleteCollectionContext contexts = injector.getInstance(DeleteCollectionContext.class);
            Configuration configuration = injector.getInstance(Configuration.class);
            contexts.setRequestHost(configuration.getString("com/pearson/qa/bluesky/csg/common/host", "com/pearson/qa/bluesky/csg/common/host"));

            contexts.setRequestPath("/csg/api/v2/" + "content/collections/"+ collectionIdToTest);

            contexts.setRequestHeaders(this.getRequestHeader());

            contexts.setExpectedHttpResponseCode(serverCodeExpected);

            DeleteCollectionExecutorDriver createCollectionExecutorDriver = injector.getInstance(DeleteCollectionExecutorDriver.class);
            createCollectionExecutorDriver.execute(contexts);

            if(contexts.getExpectedHttpResponseCode()!=200)
                Assert.assertTrue( !StringUtils.isBlank(contexts.getErrorResponsePayload().getMessage()));

        } catch (Exception e) {
            Assert.fail(e.getMessage(), e);
        }
    }
}
