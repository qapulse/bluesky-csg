package com.pearson.qa.bluesky.csg.collections;

import com.pearson.qa.bluesky.csg.TestBase;
import com.pearson.qa.bluesky.csg.collections.createcollection.contexts.CreateCollectionContexts;
import com.pearson.qa.bluesky.csg.collections.createcollection.executordrivers.CreateCollectionExecutorDriver;
import com.pearson.qa.bluesky.csg.dataproviders.StaticProvider;
import com.pearson.qa.common.configuration.Configuration;
import org.testng.Assert;
import org.testng.annotations.Test;


/**
 * <p>
 * <b>Create Collections</b>
 * </p>
 * <p>
 * <p/>
 * </p>
 *
 * @author Jake Campbell <jake.campbell@pearson.com>
 */
public class CreateCollectionTests extends TestBase {


    @Test(   groups = {"collection.createcollection"},
            dependsOnGroups = {"authentication.login.success"},
            dataProvider = "CreateCollectionDP",
            dataProviderClass = StaticProvider.class)
    public void CreateCollectionTest(String collectionTitle, boolean isNegativeTest)
    {
        try
        {
            // prepare context
            CreateCollectionContexts createCollectionContexts = injector.getInstance(CreateCollectionContexts.class);
            Configuration configuration = injector.getInstance(Configuration.class);
            createCollectionContexts.setRequestHost(configuration.getString("com/pearson/qa/bluesky/csg/common/host","com/pearson/qa/bluesky/csg/common/host"));

            createCollectionContexts.setRequestHeaders(this.getRequestHeader());

            createCollectionContexts.getCreateCollectionPayload().setTitle(collectionTitle);

            if (isNegativeTest)
                createCollectionContexts.setExpectedHttpResponseCode(400);
            else
                createCollectionContexts.setExpectedHttpResponseCode(200);

            // perform our test
            CreateCollectionExecutorDriver createCollectionExecutorDriver = injector.getInstance(CreateCollectionExecutorDriver.class);
            createCollectionExecutorDriver.execute(createCollectionContexts);

            if(createCollectionContexts.getExpectedHttpResponseCode() == 200)
                collectionIdGlobal = createCollectionContexts.getCreateCollectionResponse().getCollectionId();

        } catch (Exception e)
        {
            Assert.fail(e.getMessage(), e);
        }

    }

}
