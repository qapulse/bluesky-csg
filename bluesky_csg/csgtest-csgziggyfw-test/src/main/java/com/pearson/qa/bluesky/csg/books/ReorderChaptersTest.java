package com.pearson.qa.bluesky.csg.books;

import com.pearson.qa.bluesky.csg.TestBase;
import com.pearson.qa.bluesky.csg.books.chapterPrice.contexts.ChapterPriceContext;
import com.pearson.qa.bluesky.csg.books.chapterPrice.executordrivers.ChapterPriceExecutorDriver;
import com.pearson.qa.bluesky.csg.dataproviders.books.BookDataProvider;
import com.pearson.qa.common.configuration.Configuration;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by dcorrales on 2/24/14.
 */
public class ReorderChaptersTest extends TestBase{
    @Test(groups = {"books.chapterPrice"},
            dependsOnGroups = {"authentication.login.success"},
            dataProvider = "chapterPriceDP",
            dataProviderClass = BookDataProvider.class)
    public void chapterPrice(String chapterPrice, String type, boolean isNegativeTest, int expectedServerCode) {

        try {
            // prepare context
            ChapterPriceContext context = injector.getInstance(ChapterPriceContext.class);
            Configuration configuration = injector.getInstance(Configuration.class);
            context.setRequestHost(configuration.getString("com/pearson/qa/bluesky/csg/common/host", ""));
            context.setRequestHeaders(this.getRequestHeader());

            context.setRequestPath("/csg/api/v2/books/chapters/" + chapterPrice + "/price?type="+type);

            context.setExpectedHttpResponseCode(expectedServerCode);

            // perform our test
            ChapterPriceExecutorDriver executorDriver = injector.getInstance(ChapterPriceExecutorDriver.class);
            executorDriver.execute(context);

            if (isNegativeTest) {
                Assert.assertNotEquals(200, context.getReturnedHttpResponseCode());
                Assert.assertNotNull(context.getErrorResponsePayload());
                Assert.assertNotNull(context.getErrorResponsePayload().getMessage());
            }


        } catch (Exception e) {
            Assert.fail(e.getMessage(), e);
        }
    }
}
