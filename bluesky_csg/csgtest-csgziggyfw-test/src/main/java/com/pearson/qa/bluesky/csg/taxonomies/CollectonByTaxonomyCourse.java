package com.pearson.qa.bluesky.csg.taxonomies;

import com.pearson.qa.bluesky.csg.TestBase;
import com.pearson.qa.bluesky.csg.dataproviders.taxonomies.TaxonomyDataProvider;
import com.pearson.qa.bluesky.csg.taxonomies.collectionsByTaxonomyCourse.contexts.CollectionsByTaxonomyCourseContext;
import com.pearson.qa.bluesky.csg.taxonomies.collectionsByTaxonomyCourse.executordrivers.CollectionsByTaxonomyCourseExecutorDriver;
import com.pearson.qa.bluesky.csg.taxonomies.collectionsByTaxonomyCourse.executors.CollectionsByTaxonomyCourseExecutor;
import com.pearson.qa.common.configuration.Configuration;
import org.codehaus.jettison.json.JSONArray;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by didiercorrales on 3/29/14.
 */
public class CollectonByTaxonomyCourse extends TestBase {

    @Test(groups = {"taxonomies.getCollectionByTaxonomyCourse"},
            dependsOnGroups = {"authentication.login.success"})
    public void getCollectionByTaxonomiescourseTest() {
        try {

            // TODO Brian I couldn't find any collection in a taxonomy, so could you check with the team which taxonmies course has collecton associated and add them here
            CollectionsByTaxonomyCourseContext context = injector.getInstance(CollectionsByTaxonomyCourseContext.class);
            Configuration configuration = injector.getInstance(Configuration.class);
            context.setRequestHost(configuration.getString("com/pearson/qa/bluesky/csg/common/host", "com/pearson/qa/bluesky/csg/common/host"));

            context.setRequestHeaders(this.getRequestHeader());

            context.setRequestPath("/csg/api/v2/content/collections/taxonomy/" + "40288183-4397b585-0143-97b5b041-0002"); //taxonomyCourseId);

            context.setExpectedHttpResponseCode(200);

            // perform our test
            //CollectionsByTaxonomyCourseExecutorDriver createCollectionExecutorDriver = injector.getInstance(CollectionsByTaxonomyCourseExecutorDriver.class);
            //createCollectionExecutorDriver.execute(context);



        } catch (Exception e) {
            Assert.fail(e.getMessage(), e);
        }
    }

    @Test(groups = {"taxonomies.getCollectionByTaxonomyCourse"},
            dependsOnGroups = {"authentication.login.success"},
            dataProvider = "collectionsByTaxonomiesCourseDP",
            dataProviderClass = TaxonomyDataProvider.class
    )
    public void getCollectionByTaxonomiescourseNegativesTestTest(String courseId, String hasPrecurated, int serverCode) {
        try {

            // TODO Brian I couldn't find any collection in a taxonomy, so could you check with the team which taxonmies course has collecton associated and add them here

            CollectionsByTaxonomyCourseContext context = injector.getInstance(CollectionsByTaxonomyCourseContext.class);
            Configuration configuration = injector.getInstance(Configuration.class);
            context.setRequestHost(configuration.getString("com/pearson/qa/bluesky/csg/common/host", "com/pearson/qa/bluesky/csg/common/host"));

            context.setRequestHeaders(this.getRequestHeader());

            context.setRequestPath("/csg/api/v2/content/collections/taxonomy/"+ courseId+"?hasPrecurated="+hasPrecurated); //taxonomyCourseId);

            context.setExpectedHttpResponseCode(serverCode);

            // perform our test
            CollectionsByTaxonomyCourseExecutorDriver createCollectionExecutorDriver = injector.getInstance(CollectionsByTaxonomyCourseExecutorDriver.class);
            createCollectionExecutorDriver.execute(context);



        } catch (Exception e) {
            Assert.fail(e.getMessage(), e);
        }
    }
}
