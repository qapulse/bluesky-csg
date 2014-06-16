package com.pearson.qa.bluesky.csg.collections;

import com.pearson.qa.bluesky.csg.TestBase;
import com.pearson.qa.bluesky.csg.collections.getCollectionNote.contexts.GetCollectionNoteContext;
import com.pearson.qa.bluesky.csg.collections.getCollectionNote.executordrivers.GetCollectionNoteExecutorDriver;
import com.pearson.qa.bluesky.csg.dataproviders.collections.CollectionNotesDataProvider;
import com.pearson.qa.common.configuration.Configuration;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by didiercorrales on 3/29/14.
 */
public class GetCollectionNote extends TestBase{

    @Test(groups = {"collection.getCollectionNote"},
            dependsOnGroups = {"collection.createCollectionNote"},
            dataProvider = "GetCollectionNoteDP",
            dataProviderClass = CollectionNotesDataProvider.class)
    public void CreateCollectionNoteTest (String collectionId, String noteId,  int serverCode) {
        try {



            // prepare context
            GetCollectionNoteContext context = injector.getInstance(GetCollectionNoteContext.class);
            Configuration configuration = injector.getInstance(Configuration.class);
            context.setRequestHost(configuration.getString("com/pearson/qa/bluesky/csg/common/host", "com/pearson/qa/bluesky/csg/common/host"));

            context.setRequestHeaders(this.getRequestHeader());

            if (collectionId.equals("collectionId"))
                collectionId = collectionIdGlobal;


            if (noteId.equals( "noteId"))
                noteId = collectionNoteId;


            context.setRequestPath("/csg/api/v2/content/collections/" + collectionId + "/note/"+noteId);


            context.setExpectedHttpResponseCode(serverCode);

            // perform our test
            GetCollectionNoteExecutorDriver executorDriver = injector.getInstance(GetCollectionNoteExecutorDriver.class);
            executorDriver.execute(context);


        } catch (Exception e) {
            Assert.fail(e.getMessage(), e);
        }
    }
}
