package com.pearson.qa.bluesky.csg.books;

import com.pearson.qa.bluesky.csg.TestBase;
import com.pearson.qa.bluesky.csg.books.orderDetailStatus.contexts.OrderDetailStatusContext;
import com.pearson.qa.bluesky.csg.books.orderDetailStatus.executordrivers.OrderDetailStatusExecutorDriver;
import com.pearson.qa.bluesky.csg.dataproviders.StaticProvider;
import com.pearson.qa.common.configuration.Configuration;
import org.testng.Assert;
import org.testng.annotations.Test;


/**
 * Created by didiercorrales on 2/26/14.
 */
public class OrderDetailStatusTest extends TestBase{

    @Test(groups = {"books.orderDetailStatus"},

            dependsOnGroups = {"books.createOrderDetails"})
    public void orderDetailStatus() {
        try {

            // prepare context
            OrderDetailStatusContext context = injector.getInstance(OrderDetailStatusContext.class);
            Configuration configuration = injector.getInstance(Configuration.class);

            context.setRequestPath("/csg/api/v2/books/orders/details/"+orderDetailId+"/status");
            context.setRequestHost(configuration.getString("com/pearson/qa/bluesky/csg/common/host", "com/pearson/qa/bluesky/csg/common/host"));
            context.setRequestHeaders(this.getRequestHeader());

            context.setExpectedHttpResponseCode(200);

            // perform our test
            OrderDetailStatusExecutorDriver executorDriver = injector.getInstance(OrderDetailStatusExecutorDriver.class);
            executorDriver.execute(context);


        } catch (Exception e) {
            Assert.fail(e.getMessage(), e);

        }
    }

    /*@Test(groups = {"books.orderDetailStatusNegativesScenarios"},
           dataProvider = "genericUrlNegativeScenariosDP",
            dataProviderClass = StaticProvider.class
    )*/
    public void orderDetailStatusNegativesScenarios(String orderDetailId, int expectedServerCode) {
        try {

            // prepare context
            OrderDetailStatusContext context = injector.getInstance(OrderDetailStatusContext.class);
            Configuration configuration = injector.getInstance(Configuration.class);

            context.setRequestPath("/csg/api/v2/books/orders/details/"+orderDetailId+"/status");
            context.setRequestHost(configuration.getString("com/pearson/qa/bluesky/csg/common/host", "com/pearson/qa/bluesky/csg/common/host"));
            context.setRequestHeaders(this.getRequestHeader());

            context.setExpectedHttpResponseCode(expectedServerCode);

            // perform our test
            OrderDetailStatusExecutorDriver executorDriver = injector.getInstance(OrderDetailStatusExecutorDriver.class);
            executorDriver.execute(context);


        } catch (Exception e) {
            Assert.fail(e.getMessage(), e);

        }
    }
}
