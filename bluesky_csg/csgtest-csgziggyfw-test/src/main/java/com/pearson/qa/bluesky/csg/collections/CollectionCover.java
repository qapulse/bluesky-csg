package com.pearson.qa.bluesky.csg.collections;


import com.pearson.qa.bluesky.csg.TestBase;
import com.pearson.qa.bluesky.csg.collections.createCollectionNotes.contexts.CreateCollectionNotesContext;
import com.pearson.qa.bluesky.csg.collections.createCollectionNotes.executordrivers.CreateCollectionNotesExecutorDriver;
import com.pearson.qa.bluesky.csg.dataproviders.collections.CollectionNotesDataProvider;
import com.pearson.qa.common.configuration.Configuration;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CollectionCover extends TestBase {
    boolean correctNoteIsSet = false;

    @Test(groups = {"collection.createCollectionNote"},
            dependsOnGroups = {"collection.createcollection"},
            dataProvider = "CreateCollectionNoteDP",
            dataProviderClass = CollectionNotesDataProvider.class)
    public void CreateCollectionNoteTest(String body, String resourceTitle, String collectionId, int serverCode) {
        try {



            // prepare context
            CreateCollectionNotesContext context = injector.getInstance(CreateCollectionNotesContext.class);
            Configuration configuration = injector.getInstance(Configuration.class);
            context.setRequestHost(configuration.getString("com/pearson/qa/bluesky/csg/common/host", "com/pearson/qa/bluesky/csg/common/host"));

            context.setRequestHeaders(this.getRequestHeader());

            if (collectionId == "collectionId")
                context.setRequestPath("/csg/api/v2/content/collections/" + collectionIdGlobal + "/note");
            else
                context.setRequestPath("/csg/api/v2/content/collections/" + collectionId + "/note");

            if (!body.equals(""))
                context.getRequestPayload().setBody(body);

            if (!resourceTitle.equals(""))
                context.getRequestPayload().setResourceTitle(resourceTitle);

            context.setExpectedHttpResponseCode(serverCode);

            // perform our test
            CreateCollectionNotesExecutorDriver createCollectionExecutorDriver = injector.getInstance(CreateCollectionNotesExecutorDriver.class);
            createCollectionExecutorDriver.execute(context);

            if (!correctNoteIsSet) {
                collectionNoteId = context.getResponsePayload().getNoteId();
                correctNoteIsSet = true;
            }

        } catch (Exception e) {
            Assert.fail(e.getMessage(), e);
        }
    }
}
