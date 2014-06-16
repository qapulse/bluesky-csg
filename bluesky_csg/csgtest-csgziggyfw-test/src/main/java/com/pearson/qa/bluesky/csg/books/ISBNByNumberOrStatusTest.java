package com.pearson.qa.bluesky.csg.books;

import com.pearson.qa.bluesky.csg.TestBase;
import com.pearson.qa.bluesky.csg.books.isbnByNumberOrStatus.contexts.IsbnByNumberOrStatusContext;
import com.pearson.qa.bluesky.csg.books.isbnByNumberOrStatus.executordrivers.IsbnByNumberOrStatusExecutorDriver;
import com.pearson.qa.bluesky.csg.dataproviders.StaticProvider;
import com.pearson.qa.bluesky.csg.dataproviders.books.BookDataProvider;
import com.pearson.qa.common.configuration.Configuration;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by didiercorrales on 2/26/14.
 */
public class ISBNByNumberOrStatusTest extends TestBase {

    @Test(groups = {"books.isbnByNumberOrStatus"},
            dependsOnGroups = {"authentication.login.success"},
            dataProvider = "isbnByNumberOrStatusDP",
            dataProviderClass = BookDataProvider.class)

    public void isbnByNumberOrStatus(String status, String isbns, int expectedServerCode) {
        try {

            // prepare context
            IsbnByNumberOrStatusContext context = injector.getInstance(IsbnByNumberOrStatusContext.class);
            Configuration configuration = injector.getInstance(Configuration.class);

            context.setRequestPath("/csg/api/v2/books/isbns?status=" + status);
            context.setRequestHost(configuration.getString("com/pearson/qa/bluesky/csg/common/host", "com/pearson/qa/bluesky/csg/common/host"));
            context.setRequestHeaders(this.getRequestHeader());

            context.setExpectedHttpResponseCode(expectedServerCode);

            // perform our test
            IsbnByNumberOrStatusExecutorDriver executorDriver = injector.getInstance(IsbnByNumberOrStatusExecutorDriver.class);
            executorDriver.execute(context);


        } catch (Exception e) {
            Assert.fail(e.getMessage(), e);

        }
    }

    @Test(groups = {"books.isbnByNumberOrStatus"},
            dependsOnGroups = {"authentication.login.success"}
    )
    public void isbnByNumberOrStatusNoStatus () {
        try {

            // prepare context
            IsbnByNumberOrStatusContext context = injector.getInstance(IsbnByNumberOrStatusContext.class);
            Configuration configuration = injector.getInstance(Configuration.class);

            context.setRequestPath("/csg/api/v2/books/isbns");
            context.setRequestHost(configuration.getString("com/pearson/qa/bluesky/csg/common/host", "com/pearson/qa/bluesky/csg/common/host"));
            context.setRequestHeaders(this.getRequestHeader());

            context.setExpectedHttpResponseCode(400);

            // perform our test
            IsbnByNumberOrStatusExecutorDriver executorDriver = injector.getInstance(IsbnByNumberOrStatusExecutorDriver.class);
            executorDriver.execute(context);


        } catch (Exception e) {
            Assert.fail(e.getMessage(), e);

        }
    }

    @Test(groups = {"books.isbnByNumberOrStatus"},
            dependsOnGroups = {"authentication.login.success"}
    )
    public void isbnByNumberOrStatus_byISBN () {
        try {

            // prepare context
            IsbnByNumberOrStatusContext context = injector.getInstance(IsbnByNumberOrStatusContext.class);
            Configuration configuration = injector.getInstance(Configuration.class);

            context.setRequestPath("/csg/api/v2/books/isbns?isbns=1269041347");
            context.setRequestHost(configuration.getString("com/pearson/qa/bluesky/csg/common/host", "com/pearson/qa/bluesky/csg/common/host"));
            context.setRequestHeaders(this.getRequestHeader());

            context.setExpectedHttpResponseCode(400);

            // perform our test
            IsbnByNumberOrStatusExecutorDriver executorDriver = injector.getInstance(IsbnByNumberOrStatusExecutorDriver.class);
            executorDriver.execute(context);


        } catch (Exception e) {
            Assert.fail(e.getMessage(), e);

        }
    }

}

