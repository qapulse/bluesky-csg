package com.pearson.qa.bluesky.csg.taxonomies;

import com.pearson.qa.bluesky.csg.TestBase;
import com.pearson.qa.bluesky.csg.taxonomies.getTaxonomies.contexts.TaxonimiesContext;
import com.pearson.qa.bluesky.csg.taxonomies.getTaxonomies.executordrivers.TaxonimiesExecutorDriver;
import com.pearson.qa.common.configuration.Configuration;
import org.codehaus.jettison.json.JSONArray;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by didiercorrales on 3/29/14.
 */
public class taxonomies extends TestBase {

    @Test(groups = {"taxonomies.getTaxonomies"},
            dependsOnGroups = {"authentication.login.success"})
    public void taxonomiesTest() {
        try {

            // Todo @Brian autentication using automationtest throws an error because does not have permissions
            //{"status":"error","errorCode":"403","message":"User Doesn't have permission to perform this operation"}"
            // prepare context
            TaxonimiesContext context = injector.getInstance(TaxonimiesContext.class);
            Configuration configuration = injector.getInstance(Configuration.class);
            context.setRequestHost(configuration.getString("com/pearson/qa/bluesky/csg/common/host", "com/pearson/qa/bluesky/csg/common/host"));

            context.setRequestHeaders(this.getRequestHeader());

            context.setRequestPath("/csg/api/v2/content/collections/taxonomies");

            context.setExpectedHttpResponseCode(200);

            // perform our test
            TaxonimiesExecutorDriver createCollectionExecutorDriver = injector.getInstance(TaxonimiesExecutorDriver.class);
            createCollectionExecutorDriver.execute(context);


            if (context.getReturnedHttpResponseCode() == 200) {
                JSONArray jsonArrayDisciplines = new JSONArray(context.getResponsePayload().getDisciplines());
                taxonomyCourseId = jsonArrayDisciplines.getJSONObject(0).getJSONArray("subDisciplines").getJSONObject(0).getJSONArray("courses").getJSONObject(0).get("id").toString();
            }

        } catch (Exception e) {
            Assert.fail(e.getMessage(), e);
        }
    }
}


