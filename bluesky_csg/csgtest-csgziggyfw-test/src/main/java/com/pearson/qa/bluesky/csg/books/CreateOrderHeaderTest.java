package com.pearson.qa.bluesky.csg.books;

import com.pearson.qa.bluesky.csg.TestBase;
import com.pearson.qa.bluesky.csg.books.createOrderHeader.contexts.CreateOrderHeaderContext;
import com.pearson.qa.bluesky.csg.books.createOrderHeader.executordrivers.CreateOrderHeaderExecutorDriver;
import com.pearson.qa.bluesky.csg.dataproviders.books.BookDataProvider;
import com.pearson.qa.common.configuration.Configuration;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dcorrales on 2/21/14.
 */
public class CreateOrderHeaderTest extends TestBase {



    @Test(groups = {"books.createOrderHeader"},
            dependsOnGroups = {"authentication.login.success"},
            dataProvider = "CreateOrderHeaderDP",
            dataProviderClass = BookDataProvider.class)
    public void createOrderHeader(
            String prdAbrv, String edInstitution,
            String courseName, String startOfTerm,
            String instructorName, String courseNumber,
            String acctRefNum, String enteredBy, String custRefNum, boolean isNegativeTest) {
        try {

            // prepare context
            CreateOrderHeaderContext context = injector.getInstance(CreateOrderHeaderContext.class);
            Configuration configuration = injector.getInstance(Configuration.class);

            context.setRequestHost(configuration.getString("com/pearson/qa/bluesky/csg/common/host", "com/pearson/qa/bluesky/csg/common/host"));
            context.setRequestHeaders(this.getRequestHeader());

            context.getRequestPayload().setPrdAbrv(prdAbrv);
            context.getRequestPayload().setEdInstitution(edInstitution);
            context.getRequestPayload().setCourseName(courseName);
            context.getRequestPayload().setStartOfTerm(startOfTerm);
            context.getRequestPayload().setInstructorName(instructorName);
            context.getRequestPayload().setCourseNumber(courseNumber);
            context.getRequestPayload().setAcctRefNum(acctRefNum);
            context.getRequestPayload().setEnteredBy(enteredBy);
            context.getRequestPayload().setCustRefNum(custRefNum);

            if (isNegativeTest)
                context.setExpectedHttpResponseCode(400);
            else
                context.setExpectedHttpResponseCode(200);

            // perform our test
            CreateOrderHeaderExecutorDriver executorDriver = injector.getInstance(CreateOrderHeaderExecutorDriver.class);
            executorDriver.execute(context);

            if (context.getExpectedHttpResponseCode() == 200)
                orderHeaderId = context.getResponsePayload().getHeaderId();


        } catch (Exception e) {
            Assert.fail(e.getMessage(), e);
        }
    }

    @Test(groups = {"books.createOrderHeader"},
            dependsOnGroups = {"authentication.login.success"},
            dataProvider = "CreateOrderHeaderNegativeDP",
            dataProviderClass = BookDataProvider.class)
    public void createOrderHeaderNegative(
            String prdAbrv, String edInstitution,
            String courseName, String startOfTerm,
            String instructorName, String courseNumber,
            String acctRefNum, String enteredBy, String custRefNum, int serverCodeExpected) {
        try {

            // prepare context
            CreateOrderHeaderContext context = injector.getInstance(CreateOrderHeaderContext.class);
            Configuration configuration = injector.getInstance(Configuration.class);

            context.setRequestHost(configuration.getString("com/pearson/qa/bluesky/csg/common/host", "com/pearson/qa/bluesky/csg/common/host"));
            context.setRequestHeaders(this.getRequestHeader());

            context.getRequestPayload().setPrdAbrv(prdAbrv);
            context.getRequestPayload().setEdInstitution(edInstitution);
            context.getRequestPayload().setCourseName(courseName);
            context.getRequestPayload().setStartOfTerm(startOfTerm);
            context.getRequestPayload().setInstructorName(instructorName);
            context.getRequestPayload().setCourseNumber(courseNumber);
            context.getRequestPayload().setAcctRefNum(acctRefNum);
            context.getRequestPayload().setEnteredBy(enteredBy);
            context.getRequestPayload().setCustRefNum(custRefNum);


                context.setExpectedHttpResponseCode(serverCodeExpected);

            // perform our test
            CreateOrderHeaderExecutorDriver executorDriver = injector.getInstance(CreateOrderHeaderExecutorDriver.class);
            executorDriver.execute(context);

            if (context.getExpectedHttpResponseCode() == 200)
                orderHeaderId = context.getResponsePayload().getHeaderId();


        } catch (Exception e) {
            Assert.fail(e.getMessage(), e);
        }
    }
}
