package com.pearson.qa.bluesky.csg;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.pearson.qa.bluesky.csg.authentication.getSession.modules.GetSessionModule;
import com.pearson.qa.bluesky.csg.authentication.login.modules.LoginModule;
import com.pearson.qa.bluesky.csg.authentication.loginAs.modules.LoginAsModule;
import com.pearson.qa.bluesky.csg.authentication.logout.modules.LogoutModule;
import com.pearson.qa.bluesky.csg.authentication.profile.modules.ProfileModule;
import com.pearson.qa.bluesky.csg.books.approveISBNs.modules.ApproveIsbnModule;
import com.pearson.qa.bluesky.csg.books.authorsBySchool.modules.AuthorsBySchoolModule;
import com.pearson.qa.bluesky.csg.books.bookBuild.modules.BookBuildModule;
import com.pearson.qa.bluesky.csg.books.bookPrice.modules.BookPriceModule;
import com.pearson.qa.bluesky.csg.books.bookRegisteredDetails.modules.BookRegisteredDetailsModule;
import com.pearson.qa.bluesky.csg.books.booksCCCOrders.modules.BooksCCCOrdersModule;
import com.pearson.qa.bluesky.csg.books.chapterPrice.modules.ChapterPriceModule;
import com.pearson.qa.bluesky.csg.books.commitOrderDetail.modules.CommitOrderDetailModule;
import com.pearson.qa.bluesky.csg.books.createOrderDetail.modules.CreateOrderDetailModule;
import com.pearson.qa.bluesky.csg.books.createOrderHeader.modules.CreateOrderHeaderModules;
import com.pearson.qa.bluesky.csg.books.generateSalesRepReport.modules.GenerateSalesRepReportModule;
import com.pearson.qa.bluesky.csg.books.isbnByNumberOrStatus.modules.IsbnByNumberOrStatusModule;
import com.pearson.qa.bluesky.csg.books.oplUrl.modules.OplUrlModule;
import com.pearson.qa.bluesky.csg.books.orderDetailStatus.modules.OrderDetailStatusModule;
import com.pearson.qa.bluesky.csg.books.owrContentFee.modules.OwrContentFeeModule;
import com.pearson.qa.bluesky.csg.books.processCccOrder.modules.ProcessCccOrderModule;
import com.pearson.qa.bluesky.csg.books.registeredBooks.modules.RegisteredBooksModule;
import com.pearson.qa.bluesky.csg.books.resourceMediaContentPrice.modules.ResourceMediaContentPriceModule;
import com.pearson.qa.bluesky.csg.books.schoolTerritoryAssociation.modules.SchoolTerritoryAssociationModule;
import com.pearson.qa.bluesky.csg.books.schoolsByTerritory.modules.SchoolModule;
import com.pearson.qa.bluesky.csg.books.territories.modules.TerritoriesModule;
import com.pearson.qa.bluesky.csg.books.updateBookBuild.modules.UpdateBookBuildModule;
import com.pearson.qa.bluesky.csg.books.updateIsbnStatus.modules.UpdateIsbnStatusModule;
import com.pearson.qa.bluesky.csg.collections.collectionbystatus.modules.CollectionByStatusModule;
import com.pearson.qa.bluesky.csg.collections.createCollectionNotes.modules.CreateCollectionNotesModule;
import com.pearson.qa.bluesky.csg.collections.createcollection.modules.CreateCollectionModule;
import com.pearson.qa.bluesky.csg.collections.deleteCollectionNote.modules.DeleteCollectionNoteModule;
import com.pearson.qa.bluesky.csg.collections.deletecollection.modules.DeleteCollectionModule;
import com.pearson.qa.bluesky.csg.collections.getCollectionNote.modules.GetCollectionNoteModule;
import com.pearson.qa.bluesky.csg.collections.getCollectionNotes.modules.GetCollectionNotesModule;
import com.pearson.qa.bluesky.csg.collections.getcollection.modules.GetCollectionModule;
import com.pearson.qa.bluesky.csg.collections.resourcescollection.modules.ResourcesByCollectionModule;
import com.pearson.qa.bluesky.csg.collections.updateResourceByResourceInstance.modules.UpdateResourceByResourceInstanceModule;
import com.pearson.qa.bluesky.csg.collections.updatecollection.modules.UpdateCollectionBuildModule;
import com.pearson.qa.bluesky.csg.taxonomies.collectionsByTaxonomyCourse.modules.CollectionsByTaxonomyCourseModule;
import com.pearson.qa.bluesky.csg.taxonomies.getCollectionByISBN.modules.GetCollectionByISBNModule;
import com.pearson.qa.bluesky.csg.taxonomies.getTaxonomies.modules.TaxonomiesModule;
import com.pearson.qa.bluesky.csg.user.createUserResource.modules.CreateUserResourceModule;
import com.pearson.qa.bluesky.csg.user.deleteResource.modules.DeleteResourceModule;
import com.pearson.qa.bluesky.csg.user.userResources.modules.UserResourcesModule;
import com.pearson.qa.common.configuration.Configuration;
import com.pearson.qa.common.configuration.modules.XmlConfigurationModule;
import com.pearson.qa.common.ziggyfw.http.modules.HttpModule;
import com.pearson.qa.common.ziggyfw.http.modules.TrustingHttpModule;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
import org.codehaus.jettison.json.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.ArrayList;
import java.util.List;

import com.pearson.qa.bluesky.csg.GlobalBase;

/**
 * <p>
 * <b>TestBase</b>
 * </p>
 * <p>
 * <p/>
 * </p>
 */
public class TestBase extends com.pearson.qa.bluesky.csg.GlobalBase {
    Configuration configuration;

    public TestBase(){
        injector = Guice.createInjector(new XmlConfigurationModule());
        configuration = injector.getInstance(Configuration.class);
    }




	@BeforeSuite(alwaysRun = true)
	public void setUpInjector()
	{
        List<AbstractModule> modules = new ArrayList<>();
        modules.add(new XmlConfigurationModule());

        // Authentication Modules
        modules.add(new LoginModule());
        modules.add(new GetSessionModule());
        modules.add(new ProfileModule());
        modules.add(new LoginAsModule());
        modules.add(new LogoutModule());

        // Collection Modules
        modules.add(new CreateCollectionModule());
        modules.add(new ResourcesByCollectionModule());
        modules.add(new DeleteCollectionModule());
        modules.add(new GetCollectionModule());
        modules.add(new CollectionByStatusModule());
        modules.add(new UpdateCollectionBuildModule());
        modules.add(new CreateCollectionNotesModule());
        modules.add(new GetCollectionNoteModule());
        modules.add(new GetCollectionNotesModule());
        modules.add(new DeleteCollectionNoteModule());


        // Book Modules
        modules.add(new BookPriceModule());
        modules.add(new ChapterPriceModule());
        modules.add(new CreateOrderHeaderModules());
        modules.add(new RegisteredBooksModule());
        modules.add(new TerritoriesModule());
        modules.add(new SchoolModule());
        modules.add(new AuthorsBySchoolModule());
        modules.add(new SchoolTerritoryAssociationModule());
        modules.add(new CreateOrderDetailModule());
        modules.add(new CommitOrderDetailModule());
        modules.add(new OrderDetailStatusModule());
        modules.add(new IsbnByNumberOrStatusModule());
        modules.add(new BooksCCCOrdersModule());
        modules.add(new BookBuildModule());
        modules.add(new BookRegisteredDetailsModule());
        modules.add(new GenerateSalesRepReportModule());
        modules.add(new ResourceMediaContentPriceModule());
        modules.add(new OplUrlModule());
        modules.add(new ApproveIsbnModule());
        modules.add(new OwrContentFeeModule());
        modules.add(new UpdateIsbnStatusModule());
        modules.add(new ProcessCccOrderModule());
        modules.add(new UpdateBookBuildModule());
        modules.add(new UpdateResourceByResourceInstanceModule());

        // Taxonomies
        modules.add(new TaxonomiesModule());
        modules.add(new CollectionsByTaxonomyCourseModule());
        modules.add(new GetCollectionByISBNModule());


        //Users
        modules.add(new UserResourcesModule());
        modules.add(new CreateUserResourceModule());
        modules.add(new DeleteResourceModule());







        // Configure the http client to be used in the request
        boolean useTrustingHttpClient = configuration.getBoolean("com/pearson/qa/bluesky/csg/common", "useTrustingHttpClient", false);
        modules.add((useTrustingHttpClient) ? new TrustingHttpModule() : new HttpModule());

        // Inject the modules
		injector = Guice.createInjector(modules);
	}

    /*
     * Return the header information to be used in the Api request
     */
   public List<Header> getRequestHeader(){
     String   sessionToken = configuration.getString("com/pearson/qa/bluesky/csg/common/sessiontoken","com/pearson/qa/bluesky/csg/common/sessiontoken").replace("$sessiontoken",sessionTokenToTest);
       authToken = configuration.getString("com/pearson/qa/bluesky/csg/common/apiKey","com/pearson/qa/bluesky/csg/common/apiKey")+","+
                   sessionToken;


       List<Header> requestHeader = new ArrayList<>();
        Header header = new BasicHeader("Authorization", authToken);
        requestHeader.add(header);
        return requestHeader;
    }
}
