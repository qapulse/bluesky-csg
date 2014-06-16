package com.pearson.qa.bluesky.csg.collections;

import com.pearson.qa.bluesky.csg.TestBase;
import com.pearson.qa.bluesky.csg.collections.deleteCollectionNote.contexts.DeleteCollectionNoteContext;
import com.pearson.qa.bluesky.csg.collections.deleteCollectionNote.executordrivers.DeleteCollectionNoteExecutorDriver;
import com.pearson.qa.bluesky.csg.dataproviders.collections.CollectionNotesDataProvider;
import com.pearson.qa.common.configuration.Configuration;
import org.testng.Assert;
import org.testng.annotations.Test;


public class DeleteCollectionNote extends TestBase {

    /*@Test(groups = {"collection.deleteCollectionNote"},
            dependsOnGroups = {"collection.createCollectionNote"},
            dataProvider = "deleteCollectionNoteDP",
            dataProviderClass = CollectionNotesDataProvider.class)
    */public void deleteCollectionNoteTest (String collectionId, String noteId,  int serverCode) {
        try {



            // prepare context
            DeleteCollectionNoteContext context = injector.getInstance(DeleteCollectionNoteContext.class);
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
            DeleteCollectionNoteExecutorDriver executorDriver = injector.getInstance(DeleteCollectionNoteExecutorDriver.class);
            executorDriver.execute(context);


        } catch (Exception e) {
            Assert.fail(e.getMessage(), e);
        }
    }
}
