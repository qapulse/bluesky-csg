package com.pearson.qa.bluesky.csg.collections;

import com.pearson.qa.bluesky.csg.TestBase;
import com.pearson.qa.bluesky.csg.collections.collectionChapters.contexts.CollectionChapterContext;
import com.pearson.qa.bluesky.csg.collections.collectionChapters.executordrivers.CollectionChapterExecutorDriver;
import com.pearson.qa.bluesky.csg.dataproviders.collections.CollectionNotesDataProvider;
import com.pearson.qa.common.configuration.Configuration;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by didiercorrales on 3/30/14.
 */
public class CollectionChaptersTest extends TestBase {

    // TODO Brian this endpoint must depends on the the collection create chapter, so it must be run after that api
    @Test(groups = {"collections.collectionChapters"},
            dependsOnGroups = {"collection.createcollection"}, // Change it for create chapter in collection API
            dataProvider = "collectionChaptersDP",
            dataProviderClass = CollectionNotesDataProvider.class)
    public void getCollectionChaptersTest (String collectionId, int serverCode) {

        try {

            // prepare context
            CollectionChapterContext context = injector.getInstance(CollectionChapterContext.class);
            Configuration configuration = injector.getInstance(Configuration.class);
            context.setRequestHost(configuration.getString("com/pearson/qa/bluesky/csg/common/host", "com/pearson/qa/bluesky/csg/common/host"));

            context.setRequestHeaders(this.getRequestHeader());

            if(collectionId.equals("collectionId"))
                collectionId = collectionIdGlobal;

            context.setRequestPath("/csg/api/v2/content/collections/"+collectionId+"/chapters");


            context.setExpectedHttpResponseCode(serverCode);

            // perform our test
            CollectionChapterExecutorDriver executorDriver = injector.getInstance(CollectionChapterExecutorDriver.class);
            executorDriver.execute(context);

        } catch (Exception e) {
            Assert.fail(e.getMessage(), e);
        }
    }
}
