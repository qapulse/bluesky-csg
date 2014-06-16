package com.pearson.qa.bluesky.csg.books;

import com.pearson.qa.bluesky.csg.TestBase;
import com.pearson.qa.bluesky.csg.books.authorsBySchool.contexts.AuthorsBySchoolContext;
import com.pearson.qa.bluesky.csg.books.authorsBySchool.executorDrivers.AuthorsBySchoolExecutorDriver;
import com.pearson.qa.bluesky.csg.dataproviders.StaticProvider;
import com.pearson.qa.bluesky.csg.dataproviders.books.BookDataProvider;
import com.pearson.qa.common.configuration.Configuration;
import org.codehaus.jettison.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dcorrales on 2/24/14.
 */
public class AuthorsBySchoolTests extends TestBase {

    /*@Test(groups = {"books.authorsBySchool"}
            ,dependsOnGroups = {"books.SchoolByTerritoryTest" }

    )
    */public void getAuthorBySchool() {

        for (int i = 0; i < schoolsByTerritoriesList.size(); i++) {

            try {
                // Get the territory and school for the list of schools and territories
                String territory = schoolsByTerritoriesList.get(i).get(0).toString();
                String school = schoolsByTerritoriesList.get(i).get(1).toString();


                // prepare context
                AuthorsBySchoolContext context = injector.getInstance(AuthorsBySchoolContext.class);
                Configuration configuration = injector.getInstance(Configuration.class);

                context.setRequestHost(configuration.getString("com/pearson/qa/bluesky/csg/common/host", "com/pearson/qa/bluesky/csg/common/host"));
                context.setRequestHeaders(this.getRequestHeader());

                context.setRequestPath("/csg/api/v2/books/authors?territoryId=" + territory + "&schoolId=" + school);

                context.setExpectedHttpResponseCode(200);

                // perform our test
                AuthorsBySchoolExecutorDriver executorDriver = injector.getInstance(AuthorsBySchoolExecutorDriver.class);
                executorDriver.execute(context);

                if (context.getReturnedHttpResponseCode() == 200) {
                    Assert.assertNull(context.getResponsePayload().getResult().contains("author"));

                }

            } catch (Exception e) {
                Assert.fail(e.getMessage(), e);

            }
        }
    }

    /*@Test(groups = {"books.authorsBySchool"}
            ,dependsOnGroups = {"books.SchoolByTerritoryTest" },
            dataProvider = "getAuthorBySchoolDP",
            dataProviderClass = BookDataProvider.class)
    */public void getAuthorBySchoolNegativeScenario(String territory, String school, int expectedServerResponse) {

            try {

                // prepare context
                AuthorsBySchoolContext context = injector.getInstance(AuthorsBySchoolContext.class);
                Configuration configuration = injector.getInstance(Configuration.class);

                context.setRequestHost(configuration.getString("com/pearson/qa/bluesky/csg/common/host", "com/pearson/qa/bluesky/csg/common/host"));
                context.setRequestHeaders(this.getRequestHeader());

                context.setRequestPath("/csg/api/v2/books/authors?territoryId=" + territory + "&schoolId=" + school);

                context.setExpectedHttpResponseCode(expectedServerResponse);

                // perform our test
                AuthorsBySchoolExecutorDriver executorDriver = injector.getInstance(AuthorsBySchoolExecutorDriver.class);
                executorDriver.execute(context);

                if (context.getReturnedHttpResponseCode() == 200) {
                  Assert.assertNull(context.getResponsePayload());

                }

            } catch (Exception e) {
                Assert.fail(e.getMessage(), e);

            }

    }
}
