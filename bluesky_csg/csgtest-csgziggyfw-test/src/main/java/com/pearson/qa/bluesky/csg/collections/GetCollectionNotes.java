package com.pearson.qa.bluesky.csg.collections;

import com.pearson.qa.bluesky.csg.TestBase;
import com.pearson.qa.bluesky.csg.collections.getCollectionNotes.contexts.GetCollectionNotesContext;
import com.pearson.qa.bluesky.csg.collections.getCollectionNotes.executordrivers.GetCollectionNotesExecutorDriver;
import com.pearson.qa.bluesky.csg.dataproviders.collections.CollectionNotesDataProvider;
import com.pearson.qa.common.configuration.Configuration;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by didiercorrales on 3/29/14.
 */
public class GetCollectionNotes extends TestBase {
    @Test(groups = {"collection.getCollectionNotes"},
            dependsOnGroups = {"collection.createCollectionNote"},
            dataProvider = "GetCollectionNotesDP",
            dataProviderClass = CollectionNotesDataProvider.class)
    public void CreateCollectionNoteTest(String collectionId,  String pageNumber,  String pageSize ,  String sort_by , String sort,  int serverCode) {
        try {

            // TODO @BRIAN this api is throwing some error 500

            // prepare context
            GetCollectionNotesContext context = injector.getInstance(GetCollectionNotesContext.class);
            Configuration configuration = injector.getInstance(Configuration.class);
            context.setRequestHost(configuration.getString("com/pearson/qa/bluesky/csg/common/host", "com/pearson/qa/bluesky/csg/common/host"));

            context.setRequestHeaders(this.getRequestHeader());

            if (collectionId.equals("collectionId"))
                collectionId = collectionIdGlobal;

            context.setRequestPath("/csg/api/v2/content/collections/" + collectionId + "/notes/?pageNumber="+pageNumber
                                                                                              +"&pageSize="+pageSize+"&sort-by="+sort
                                                                                              + "sort="+sort);


            context.setExpectedHttpResponseCode(serverCode);

            // perform our test
            GetCollectionNotesExecutorDriver executorDriver = injector.getInstance(GetCollectionNotesExecutorDriver.class);
            executorDriver.execute(context);


        } catch (Exception e) {
            Assert.fail(e.getMessage(), e);
        }
    }
}
