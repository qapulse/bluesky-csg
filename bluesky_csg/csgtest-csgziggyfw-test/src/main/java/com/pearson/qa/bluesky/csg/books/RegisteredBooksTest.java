package com.pearson.qa.bluesky.csg.books;

import com.pearson.qa.bluesky.csg.TestBase;
import com.pearson.qa.bluesky.csg.books.registeredBooks.contexts.RegisteredBooksContext;
import com.pearson.qa.bluesky.csg.books.registeredBooks.executordrivers.RegisteredBooksExecutorDriver;
import com.pearson.qa.common.configuration.Configuration;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by dcorrales on 2/24/14.
 */
public class RegisteredBooksTest extends TestBase{

    /*@Test(groups = {"books.registeredBooks"},
            dependsOnGroups = {"authentication.login.success"})
    */public void registeredBooks() {
        try {

            // prepare context
            RegisteredBooksContext context = injector.getInstance(RegisteredBooksContext.class);
            Configuration configuration = injector.getInstance(Configuration.class);

            context.setRequestHost(configuration.getString("com/pearson/qa/bluesky/csg/common/host", "com/pearson/qa/bluesky/csg/common/host"));
            context.setRequestHeaders(this.getRequestHeader());

            context.setExpectedHttpResponseCode(422);

            // perform our test
            RegisteredBooksExecutorDriver executorDriver = injector.getInstance(RegisteredBooksExecutorDriver.class);
            executorDriver.execute(context);


        } catch (Exception e) {
            Assert.fail(e.getMessage(), e);

        }
    }
}
