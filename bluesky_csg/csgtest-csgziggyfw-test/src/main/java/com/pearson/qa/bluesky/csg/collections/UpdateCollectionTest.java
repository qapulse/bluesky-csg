package com.pearson.qa.bluesky.csg.collections;

import com.pearson.qa.bluesky.csg.TestBase;
import com.pearson.qa.bluesky.csg.collections.updatecollection.contexts.UpdateCollectionContext;
import com.pearson.qa.bluesky.csg.dataproviders.CollectionsDataProvider;
import com.pearson.qa.common.configuration.Configuration;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by brian on 3/23/14.
 */
public class UpdateCollectionTest extends TestBase {

    @Test
            (groups = {"collection.UpdateCollection"},
                    dependsOnGroups = {"authentication.login.success"},
                    dataProvider = "updateCollectionDP",
                    dataProviderClass = CollectionsDataProvider.class)
    public void updateCollection(String isbn, String status,  String statusModifier , int serverExpectedCodeResponse) {

        try {
            // prepare context
            UpdateCollectionContext context = injector.getInstance(UpdateCollectionContext.class);
            Configuration configuration = injector.getInstance(Configuration.class);
            context.setRequestHost(configuration.getString("com/pearson/qa/bluesky/csg/common/host", ""));
            context.setRequestHeaders(this.getRequestHeader());

            //context.getRequestPayload().setIsbn(isbn);
            //context.getRequestPayload().setStatus(status);// getRequestPayload().setStatus(status);
           // context.getRequestPayload().setStatusModifier(statusModifier);

            context.setExpectedHttpResponseCode(serverExpectedCodeResponse);

            // perform our test
            /*UpdateCollectionBuildExecutorDriver executorDriver = injector.getInstance(UpdateCollectionBuildExecutorDriver.class);
            executorDriver.execute(context);

           if (context.getReturnedHttpResponseCode() != 200) {
                Assert.assertNotNull(context.getErrorResponsePayload());
                Assert.assertNotNull(context.getErrorResponsePayload().getMessage());
            }
            else
                Assert.assertEquals("The Collection was updated",context.getResponsePayload().getResult());
*/

        } catch (Exception e) {
            Assert.fail(e.getMessage(), e);
        }
    }
}
