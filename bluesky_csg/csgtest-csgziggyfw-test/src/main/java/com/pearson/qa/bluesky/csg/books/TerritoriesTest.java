package com.pearson.qa.bluesky.csg.books;

import com.pearson.qa.bluesky.csg.TestBase;
import com.pearson.qa.bluesky.csg.books.registeredBooks.contexts.RegisteredBooksContext;
import com.pearson.qa.bluesky.csg.books.registeredBooks.executordrivers.RegisteredBooksExecutorDriver;
import com.pearson.qa.bluesky.csg.books.territories.contexts.TerritoriesContext;
import com.pearson.qa.bluesky.csg.books.territories.executordrivers.TerritoriesExecutorDriver;
import com.pearson.qa.common.configuration.Configuration;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by dcorrales on 2/24/14.
 */
public class TerritoriesTest extends TestBase {

    @Test(groups = {"books.territories"},
            dependsOnGroups = {"authentication.login.success"})
    public void getTerritories() {
        try {

            // prepare context
            TerritoriesContext context = injector.getInstance(TerritoriesContext.class);
            Configuration configuration = injector.getInstance(Configuration.class);

            context.setRequestHost(configuration.getString("com/pearson/qa/bluesky/csg/common/host", "com/pearson/qa/bluesky/csg/common/host"));
            context.setRequestHeaders(this.getRequestHeader());

            context.setExpectedHttpResponseCode(200);

            // perform our test
            TerritoriesExecutorDriver executorDriver = injector.getInstance(TerritoriesExecutorDriver.class);
            executorDriver.execute(context);

            if (context.getReturnedHttpResponseCode() == 200) {

                JSONArray resultArray = new JSONArray(context.getResponsePayload().getResult().replace("\\", "").replace("[\"", "[").replace("\"]", "]").replace("}\",\"{", "},{"));
                for (int i = 0; i < resultArray.length(); i++) {
                    territoriesList.add(resultArray.getJSONObject(i).getString("id"));
                }
            }
        } catch (Exception e) {
            Assert.fail(e.getMessage(), e);

        }
    }
}
