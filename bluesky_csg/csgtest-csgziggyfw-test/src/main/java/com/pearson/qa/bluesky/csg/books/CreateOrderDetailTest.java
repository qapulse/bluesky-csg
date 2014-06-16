package com.pearson.qa.bluesky.csg.books;

import com.pearson.qa.bluesky.csg.TestBase;
import com.pearson.qa.bluesky.csg.books.createOrderDetail.contexts.CreateOrderDetailContext;
import com.pearson.qa.bluesky.csg.books.createOrderDetail.executordrivers.CreateOrderDetailExecutorDriver;
import com.pearson.qa.bluesky.csg.dataproviders.books.BookDataProvider;
import com.pearson.qa.common.configuration.Configuration;
import com.pearson.qa.common.ziggyfw.exceptions.ValidationException;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by didiercorrales on 2/26/14.
 */
public class CreateOrderDetailTest extends TestBase {

    @Test(groups = {"books.createOrderDetails"},
            dependsOnGroups = {"books.createOrderHeader"},
            dataProvider = "createOrderDetailsDP",
            dataProviderClass = BookDataProvider.class)
    public void createOrderDetails(
            String cccWorkInst,
            String publicationYear,
            String numCopiesStdnts,
            String numPages,
            String fromPage,
            String toPage,
            String stdnum,
            String title,
            String publisherName,
            String author,
            String dateOfIssue,
            String volume,
            String edition,
            String chapterArticle,
            String customerRefNum,
            boolean isNegativeTest,
            int serverCodeExpected) throws ValidationException {
        try {

            // prepare context
            CreateOrderDetailContext context = injector.getInstance(CreateOrderDetailContext.class);
            Configuration configuration = injector.getInstance(Configuration.class);

            context.setRequestHost(configuration.getString("com/pearson/qa/bluesky/csg/common/host", "com/pearson/qa/bluesky/csg/common/host"));
            context.setRequestHeaders(this.getRequestHeader());
            context.setRequestPath("/csg/api/v2/books/orders/" + orderHeaderId + "/details");

            context.getRequestPayload().setOrderHeaderId(orderHeaderId);
            context.getRequestPayload().setCccWorkInst(cccWorkInst);
            context.getRequestPayload().setPublicationYear(publicationYear);
            context.getRequestPayload().setNumCopiesStdnts(numCopiesStdnts);
            context.getRequestPayload().setNumPages(numPages);
            context.getRequestPayload().setFromPage(fromPage);
            context.getRequestPayload().setToPage(toPage);
            context.getRequestPayload().setStdnum(stdnum);
            context.getRequestPayload().setTitle(title);
            context.getRequestPayload().setPublisherName(publisherName);
            context.getRequestPayload().setAuthor(author);
            context.getRequestPayload().setDateOfIssue(dateOfIssue);
            context.getRequestPayload().setVolume(volume);
            context.getRequestPayload().setEdition(edition);
            context.getRequestPayload().setChapterArticle(chapterArticle);
            context.getRequestPayload().setCustomerRefNum(customerRefNum);


            if (isNegativeTest)
                context.setExpectedHttpResponseCode(serverCodeExpected);
            else
                context.setExpectedHttpResponseCode(200);

            // perform our test
            CreateOrderDetailExecutorDriver executorDriver = injector.getInstance(CreateOrderDetailExecutorDriver.class);
            executorDriver.execute(context);

            if (context.getExpectedHttpResponseCode() == 200)
                orderDetailId = context.getResponsePayload().getTempOrderDetailId();

        } catch (Exception e) {
            Assert.fail(e.getMessage(), e);
            Assert.fail(e.getStackTrace().toString());
        }
    }

    // TODO  Create the negatives Scenarios
}

