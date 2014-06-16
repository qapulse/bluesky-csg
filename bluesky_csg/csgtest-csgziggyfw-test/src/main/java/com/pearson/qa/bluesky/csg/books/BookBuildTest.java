package com.pearson.qa.bluesky.csg.books;

import com.pearson.qa.bluesky.csg.TestBase;
import com.pearson.qa.bluesky.csg.books.bookBuild.contexts.BookBuildContext;
import com.pearson.qa.bluesky.csg.books.bookBuild.executordrivers.BookBuildExecutorDriver;
import com.pearson.qa.bluesky.csg.dataproviders.books.BookDataProvider;
import com.pearson.qa.common.configuration.Configuration;



import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by dcorrales on 2/27/14.
 */
public class BookBuildTest extends TestBase {



    @Test(groups = {"books.bookBuild"},
            dependsOnGroups = {"collection.createcollection"},
            dataProvider = "bookBuildDP",
            dataProviderClass = BookDataProvider.class)
    public void bookBuild(String titleDetails, int expectedServerCode) {

        try {

            // prepare context
            BookBuildContext context = injector.getInstance(BookBuildContext.class);
            Configuration configuration = injector.getInstance(Configuration.class);
            context.setRequestHost(configuration.getString("com/pearson/qa/bluesky/csg/common/host", ""));
            context.setRequestHeaders(this.getRequestHeader());


            context.getRequestPayload().setTitleDetails(titleDetails.replace("collectionIdToBeTested", collectionIdGlobal));
            context.setExpectedHttpResponseCode(expectedServerCode);

            // perform our test
            BookBuildExecutorDriver executorDriver = injector.getInstance(BookBuildExecutorDriver.class);
            executorDriver.execute(context);


        } catch (Exception e) {
            Assert.fail(e.getMessage(), e);
        }
    }

    @Test(groups = {"books.bookBuild"},
           dependsOnGroups = {"collection.createcollection"},
           dataProvider = "bookBuildNegativeDP",
           dataProviderClass = BookDataProvider.class)
   public void bookBuildNegativeScenarios(String collectionId, String titleDetails, int expectedServerCode) {

        try {

            // prepare context
            BookBuildContext context = injector.getInstance(BookBuildContext.class);
            Configuration configuration = injector.getInstance(Configuration.class);
            context.setRequestHost(configuration.getString("com/pearson/qa/bluesky/csg/common/host", ""));
            context.setRequestHeaders(this.getRequestHeader());


            context.getRequestPayload().setTitleDetails(titleDetails.replace("collectionIdToBeTested", collectionId));
            context.setExpectedHttpResponseCode(expectedServerCode);

            // perform our test
            BookBuildExecutorDriver executorDriver = injector.getInstance(BookBuildExecutorDriver.class);
            executorDriver.execute(context);


        } catch (Exception e) {
            Assert.fail(e.getMessage(), e);
        }
    }


    @Test(groups = {"books.bookBuild"},
            dependsOnGroups = {"collection.createcollection"}
            )
    public void bookBuildNegativeScenariosWithoutParameters() {

        try {

            // prepare context
            BookBuildContext context = injector.getInstance(BookBuildContext.class);
            Configuration configuration = injector.getInstance(Configuration.class);
            context.setRequestHost(configuration.getString("com/pearson/qa/bluesky/csg/common/host", ""));
            context.setRequestHeaders(this.getRequestHeader());

            context.setExpectedHttpResponseCode(422);

            // perform our test
            BookBuildExecutorDriver executorDriver = injector.getInstance(BookBuildExecutorDriver.class);
            executorDriver.execute(context);


        } catch (Exception e) {
            Assert.fail(e.getMessage(), e);
        }
    }

}
