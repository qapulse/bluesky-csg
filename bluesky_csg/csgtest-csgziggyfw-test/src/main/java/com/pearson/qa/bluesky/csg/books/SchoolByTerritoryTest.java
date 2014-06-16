package com.pearson.qa.bluesky.csg.books;

import com.pearson.qa.bluesky.csg.TestBase;
import com.pearson.qa.bluesky.csg.books.registeredBooks.contexts.RegisteredBooksContext;
import com.pearson.qa.bluesky.csg.books.registeredBooks.executordrivers.RegisteredBooksExecutorDriver;
import com.pearson.qa.bluesky.csg.books.schoolsByTerritory.contexts.SchoolContext;
import com.pearson.qa.bluesky.csg.books.schoolsByTerritory.executorDrivers.SchoolExecutorDriver;
import com.pearson.qa.bluesky.csg.dataproviders.books.BookDataProvider;
import com.pearson.qa.common.configuration.Configuration;
import org.apache.commons.lang3.StringUtils;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

/**
 * Created by dcorrales on 2/24/14.
 */
public class SchoolByTerritoryTest extends TestBase {

    @Test(groups = {"books.SchoolByTerritoryTest"}
            , dependsOnGroups = {"books.territories"}
    )
    public void getSchoolByTerritories() {
        try {

            if (territoriesList.size() != 0 || territoriesList == null) {


                for (int i = 0; i < territoriesList.size(); i++) {

                    String territory = territoriesList.get(i);

                    // prepare context
                    SchoolContext context = injector.getInstance(SchoolContext.class);
                    Configuration configuration = injector.getInstance(Configuration.class);

                    context.setRequestHost(configuration.getString("com/pearson/qa/bluesky/csg/common/host", "com/pearson/qa/bluesky/csg/common/host"));
                    context.setRequestHeaders(this.getRequestHeader());


                    context.setRequestPath("/csg/api/v2/books/schools?territoryId=" + territory);

                    context.setExpectedHttpResponseCode(200);

                    // perform our test
                    SchoolExecutorDriver executorDriver = injector.getInstance(SchoolExecutorDriver.class);
                    executorDriver.execute(context);

                    if (context.getReturnedHttpResponseCode() == 200) {

                        //If the response was success get the information about the school by territory
                        JSONArray schoolJSON = new JSONArray(context.getResponsePayload().getResult().replace("\\", "").replace("[\"", "[").replace("\"]", "]").replace("}\",\"{", "},{"));

                        for (int schoolIndex = 0; schoolIndex < schoolJSON.length(); schoolIndex++) {
                            JSONObject school = schoolJSON.getJSONObject(schoolIndex);

                            ArrayList<String> schoolList = new ArrayList();

                            schoolList.add(territory);
                            schoolList.add(school.getString("id"));

                            // Store the information about the school by territory
                            schoolsByTerritoriesList.add(schoolList);
                        }
                    } else {
                        if (context.getErrorResponsePayload().getMessage() != null) {
                            Assert.assertTrue(!StringUtils.isBlank(context.getErrorResponsePayload().getMessage().toString()));
                            Assert.assertTrue(!StringUtils.isBlank(context.getErrorResponsePayload().getMessage().toString()));
                        } else
                            Assert.fail("The error message is not returned correctly");

                    }
                }
            } else {
                Assert.fail("Territory List wasn't returned correctly");
            }


        } catch (Exception e) {
            Assert.fail(e.getMessage(), e);

        }
    }

    @Test(groups = {"books.SchoolByTerritoryTest"}
            , dependsOnGroups = {"books.territories"},
            dataProvider = "SchoolsByTerritoriesNegativeDP",
            dataProviderClass = BookDataProvider.class
    )
    public void getSchoolByTerritoriesNegativeScenarios(String territory, int serverCodeExpected) {
        try {

                    // prepare context
                    SchoolContext context = injector.getInstance(SchoolContext.class);
                    Configuration configuration = injector.getInstance(Configuration.class);

                    context.setRequestHost(configuration.getString("com/pearson/qa/bluesky/csg/common/host", "com/pearson/qa/bluesky/csg/common/host"));
                    context.setRequestHeaders(this.getRequestHeader());


                    context.setRequestPath("/csg/api/v2/books/schools?territoryId=" + territory);

                    context.setExpectedHttpResponseCode(serverCodeExpected);

                    // perform our test
                    SchoolExecutorDriver executorDriver = injector.getInstance(SchoolExecutorDriver.class);
                    executorDriver.execute(context);

                    if (context.getReturnedHttpResponseCode() == 200) {
                       Assert.assertTrue(context.getResponsePayload().getResult().toString().equals("[]"));


                    } else {
                        if (context.getErrorResponsePayload().getMessage() != null) {
                            Assert.assertTrue(!StringUtils.isBlank(context.getErrorResponsePayload().getMessage().toString()));
                            Assert.assertTrue(!StringUtils.isBlank(context.getErrorResponsePayload().getMessage().toString()));
                        } else
                            Assert.fail("The error message is not returned correctly");

                    }
        } catch (Exception e) {
            Assert.fail(e.getMessage(), e);

        }
    }

}
