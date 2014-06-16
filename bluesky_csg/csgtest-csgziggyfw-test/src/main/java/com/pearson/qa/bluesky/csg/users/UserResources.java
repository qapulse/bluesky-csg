package com.pearson.qa.bluesky.csg.users;

import com.pearson.qa.bluesky.csg.TestBase;
import com.pearson.qa.bluesky.csg.books.booksCCCOrders.contexts.BooksCCCOrdersContext;
import com.pearson.qa.bluesky.csg.books.booksCCCOrders.executordrivers.BooksCCCOrdersExecutorDriver;
import com.pearson.qa.bluesky.csg.dataproviders.books.BookDataProvider;
import com.pearson.qa.common.configuration.Configuration;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by didiercorrales on 2/26/14.
 */
public class UserResources extends TestBase{


    @Test(groups = {"books.booksforCCCOrders"},
            dependsOnGroups = {"authentication.login.success"}
            )
    public void bookForCCCTest() {

        try {
            // prepare context
            BooksCCCOrdersContext context = injector.getInstance(BooksCCCOrdersContext.class);
            Configuration configuration = injector.getInstance(Configuration.class);
            context.setRequestHost(configuration.getString("com/pearson/qa/bluesky/csg/common/host", ""));
            context.setRequestHeaders(this.getRequestHeader());
            context.setRequestPath("/csg/api/v2/books/CCCOrders");
            context.setExpectedHttpResponseCode(200);

            // perform our test
            BooksCCCOrdersExecutorDriver executorDriver = injector.getInstance(BooksCCCOrdersExecutorDriver.class);
            executorDriver.execute(context);

        } catch (Exception e) {
            Assert.fail(e.getMessage(), e);
        }
    }


    @Test(groups = {"books.booksforCCCOrders"},
            dependsOnGroups = {"authentication.login.success"},
            dataProvider = "booksforCCCOrdersDP",
            dataProviderClass = BookDataProvider.class)
    public void bookForCCCwithParameters(String  pageNumber ,String  pageSize, String sortBy,String sort, int expectedServerCode) {

        try {
            // prepare context
            BooksCCCOrdersContext context = injector.getInstance(BooksCCCOrdersContext.class);
            Configuration configuration = injector.getInstance(Configuration.class);
            context.setRequestHost(configuration.getString("com/pearson/qa/bluesky/csg/common/host", ""));
            context.setRequestHeaders(this.getRequestHeader());
            context.setRequestPath("/csg/api/v2/books/CCCOrders?sort-by="+sortBy+"&sort="+sort+"&pageNumber="+pageNumber+"&pageSize="+pageSize);
            context.setExpectedHttpResponseCode(expectedServerCode);

            // perform our test
            BooksCCCOrdersExecutorDriver executorDriver = injector.getInstance(BooksCCCOrdersExecutorDriver.class);
            executorDriver.execute(context);

        } catch (Exception e) {
            Assert.fail(e.getMessage(), e);
        }
    }
}
