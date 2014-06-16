package com.pearson.qa.bluesky.csg.books;

import com.pearson.qa.bluesky.csg.TestBase;
import com.pearson.qa.bluesky.csg.books.schoolTerritoryAssociation.contexts.SchoolTerritoryAssociationContext;
import com.pearson.qa.bluesky.csg.books.schoolTerritoryAssociation.executordrivers.SchoolTerritoryAssociationExecutorDriver;
import com.pearson.qa.common.configuration.Configuration;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by dcorrales on 2/25/14.
 */
public class SchoolTerritoryAssociationTest extends TestBase {

    @Test(groups = {"books.schoolTerritoryAssociation"},
            dependsOnGroups = {"authentication.login.success"})
    public void getSchoolTerritoryAssociation() {
        try {

            // prepare context
            SchoolTerritoryAssociationContext context = injector.getInstance(SchoolTerritoryAssociationContext.class);
            Configuration configuration = injector.getInstance(Configuration.class);

            context.setRequestHost(configuration.getString("com/pearson/qa/bluesky/csg/common/host", "com/pearson/qa/bluesky/csg/common/host"));
            context.setRequestHeaders(this.getRequestHeader());

            context.setExpectedHttpResponseCode(200);

            // perform our test
            SchoolTerritoryAssociationExecutorDriver executorDriver = injector.getInstance(SchoolTerritoryAssociationExecutorDriver.class);
            executorDriver.execute(context);

            if (context.getReturnedHttpResponseCode() == 200) {
                Assert.assertTrue(context.getResponsePayload().getResult().contains("id"));
            }

        } catch (Exception e) {
            Assert.fail(e.getMessage(), e);

        }
    }
}
