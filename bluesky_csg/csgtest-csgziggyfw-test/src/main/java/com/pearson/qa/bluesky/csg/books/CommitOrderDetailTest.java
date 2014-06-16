package com.pearson.qa.bluesky.csg.books;

import com.pearson.qa.bluesky.csg.TestBase;
import com.pearson.qa.bluesky.csg.books.commitOrderDetail.contexts.CommitOrderDetailContext;
import com.pearson.qa.bluesky.csg.books.commitOrderDetail.executordrivers.CommitOrderDetailExecutorDriver;
import com.pearson.qa.common.configuration.Configuration;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by didiercorrales on 2/26/14.
 */
public class CommitOrderDetailTest extends TestBase {

    @Test(groups = {"books.CommitOrderDetailTest"},
            dependsOnGroups = {"books.createOrderDetails"})
    public void commitOrderDetail() {
        try {

            // prepare context
            CommitOrderDetailContext context = injector.getInstance(CommitOrderDetailContext.class);
            Configuration configuration = injector.getInstance(Configuration.class);

            context.setRequestPath("/csg/api/v2/books/orders/details/"+orderDetailId);
            context.setRequestHost(configuration.getString("com/pearson/qa/bluesky/csg/common/host", "com/pearson/qa/bluesky/csg/common/host"));
            context.setRequestHeaders(this.getRequestHeader());

            context.setExpectedHttpResponseCode(200);

            // perform our test
            CommitOrderDetailExecutorDriver executorDriver = injector.getInstance(CommitOrderDetailExecutorDriver.class);
            executorDriver.execute(context);


        } catch (Exception e) {
            Assert.fail(e.getMessage(), e);

        }
    }
}
