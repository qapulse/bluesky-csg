package com.pearson.qa.bluesky.csg;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.pearson.qa.bluesky.csg.authentication.login.contexts.LoginContext;
import com.pearson.qa.bluesky.csg.authentication.login.executiondrivers.LoginExecutionDriver;
import com.pearson.qa.bluesky.csg.authentication.login.modules.LoginModule;
import com.pearson.qa.bluesky.csg.books.approveISBNs.contexts.ApproveIsbnContext;
import com.pearson.qa.bluesky.csg.books.approveISBNs.executordrivers.ApproveIsbnExecutorDriver;
import com.pearson.qa.bluesky.csg.books.approveISBNs.modules.ApproveIsbnModule;
import com.pearson.qa.bluesky.csg.books.authorsBySchool.contexts.AuthorsBySchoolContext;
import com.pearson.qa.bluesky.csg.books.authorsBySchool.executorDrivers.AuthorsBySchoolExecutorDriver;
import com.pearson.qa.bluesky.csg.books.authorsBySchool.modules.AuthorsBySchoolModule;
import com.pearson.qa.bluesky.csg.books.bookBuild.contexts.BookBuildContext;
import com.pearson.qa.bluesky.csg.books.bookBuild.executordrivers.BookBuildExecutorDriver;
import com.pearson.qa.bluesky.csg.books.bookBuild.modules.BookBuildModule;
import com.pearson.qa.bluesky.csg.books.bookPrice.contexts.BookPriceContext;
import com.pearson.qa.bluesky.csg.books.bookPrice.executordrivers.BookPriceExecutorDriver;
import com.pearson.qa.bluesky.csg.books.bookPrice.modules.BookPriceModule;
import com.pearson.qa.bluesky.csg.books.booksCCCOrders.contexts.BooksCCCOrdersContext;
import com.pearson.qa.bluesky.csg.books.booksCCCOrders.executordrivers.BooksCCCOrdersExecutorDriver;
import com.pearson.qa.bluesky.csg.books.booksCCCOrders.modules.BooksCCCOrdersModule;
import com.pearson.qa.bluesky.csg.books.chapterPrice.contexts.ChapterPriceContext;
import com.pearson.qa.bluesky.csg.books.chapterPrice.executordrivers.ChapterPriceExecutorDriver;
import com.pearson.qa.bluesky.csg.books.chapterPrice.modules.ChapterPriceModule;
import com.pearson.qa.bluesky.csg.books.commitOrderDetail.contexts.CommitOrderDetailContext;
import com.pearson.qa.bluesky.csg.books.commitOrderDetail.executordrivers.CommitOrderDetailExecutorDriver;
import com.pearson.qa.bluesky.csg.books.commitOrderDetail.modules.CommitOrderDetailModule;
import com.pearson.qa.bluesky.csg.books.createOrderDetail.contexts.CreateOrderDetailContext;
import com.pearson.qa.bluesky.csg.books.createOrderDetail.executordrivers.CreateOrderDetailExecutorDriver;
import com.pearson.qa.bluesky.csg.books.createOrderDetail.modules.CreateOrderDetailModule;
import com.pearson.qa.bluesky.csg.books.createOrderHeader.contexts.CreateOrderHeaderContext;
import com.pearson.qa.bluesky.csg.books.createOrderHeader.executordrivers.CreateOrderHeaderExecutorDriver;
import com.pearson.qa.bluesky.csg.books.createOrderHeader.modules.CreateOrderHeaderModules;
import com.pearson.qa.bluesky.csg.books.isbnByNumberOrStatus.contexts.IsbnByNumberOrStatusContext;
import com.pearson.qa.bluesky.csg.books.isbnByNumberOrStatus.executordrivers.IsbnByNumberOrStatusExecutorDriver;
import com.pearson.qa.bluesky.csg.books.isbnByNumberOrStatus.modules.IsbnByNumberOrStatusModule;
import com.pearson.qa.bluesky.csg.books.oplUrl.contexts.OplUrlContext;
import com.pearson.qa.bluesky.csg.books.oplUrl.executordrivers.OplUrlExecutorDriver;
import com.pearson.qa.bluesky.csg.books.oplUrl.modules.OplUrlModule;
import com.pearson.qa.bluesky.csg.books.orderDetailStatus.contexts.OrderDetailStatusContext;
import com.pearson.qa.bluesky.csg.books.orderDetailStatus.executordrivers.OrderDetailStatusExecutorDriver;
import com.pearson.qa.bluesky.csg.books.orderDetailStatus.modules.OrderDetailStatusModule;
import com.pearson.qa.bluesky.csg.books.owrContentFee.contexts.OwrContentFeeContext;
import com.pearson.qa.bluesky.csg.books.owrContentFee.executordrivers.OwrContentFeeExecutorDriver;
import com.pearson.qa.bluesky.csg.books.owrContentFee.modules.OwrContentFeeModule;
import com.pearson.qa.bluesky.csg.books.processCccOrder.contexts.ProcessCccOrderContext;
import com.pearson.qa.bluesky.csg.books.processCccOrder.executordrivers.ProcessCccOrderExecutorDriver;
import com.pearson.qa.bluesky.csg.books.processCccOrder.modules.ProcessCccOrderModule;
import com.pearson.qa.bluesky.csg.books.registeredBooks.contexts.RegisteredBooksContext;
import com.pearson.qa.bluesky.csg.books.registeredBooks.executordrivers.RegisteredBooksExecutorDriver;
import com.pearson.qa.bluesky.csg.books.registeredBooks.modules.RegisteredBooksModule;
import com.pearson.qa.bluesky.csg.books.resourceMediaContentPrice.contexts.ResourceMediaContentPriceContext;
import com.pearson.qa.bluesky.csg.books.resourceMediaContentPrice.executordrivers.ResourceMediaContentPriceExecutorDriver;
import com.pearson.qa.bluesky.csg.books.resourceMediaContentPrice.modules.ResourceMediaContentPriceModule;
import com.pearson.qa.bluesky.csg.books.schoolTerritoryAssociation.contexts.SchoolTerritoryAssociationContext;
import com.pearson.qa.bluesky.csg.books.schoolTerritoryAssociation.executordrivers.SchoolTerritoryAssociationExecutorDriver;
import com.pearson.qa.bluesky.csg.books.schoolTerritoryAssociation.modules.SchoolTerritoryAssociationModule;
import com.pearson.qa.bluesky.csg.books.schoolsByTerritory.contexts.SchoolContext;
import com.pearson.qa.bluesky.csg.books.schoolsByTerritory.executorDrivers.SchoolExecutorDriver;
import com.pearson.qa.bluesky.csg.books.schoolsByTerritory.modules.SchoolModule;
import com.pearson.qa.bluesky.csg.books.territories.contexts.TerritoriesContext;
import com.pearson.qa.bluesky.csg.books.territories.executordrivers.TerritoriesExecutorDriver;
import com.pearson.qa.bluesky.csg.books.territories.modules.TerritoriesModule;
import com.pearson.qa.bluesky.csg.books.updateBookBuild.contexts.UpdateBookBuildContext;
import com.pearson.qa.bluesky.csg.books.updateBookBuild.executordrivers.UpdateBookBuildExecutorDriver;
import com.pearson.qa.bluesky.csg.books.updateBookBuild.modules.UpdateBookBuildModule;
import com.pearson.qa.bluesky.csg.books.updateIsbnStatus.contexts.UpdateIsbnStatusContext;
import com.pearson.qa.bluesky.csg.books.updateIsbnStatus.executordrivers.UpdateIsbnStatusExecutorDriver;
import com.pearson.qa.bluesky.csg.books.updateIsbnStatus.modules.UpdateIsbnStatusModule;
import com.pearson.qa.bluesky.csg.collections.collectionChapters.contexts.CollectionChapterContext;
import com.pearson.qa.bluesky.csg.collections.collectionChapters.executordrivers.CollectionChapterExecutorDriver;
import com.pearson.qa.bluesky.csg.collections.collectionChapters.modules.CollectionChapterModule;
import com.pearson.qa.bluesky.csg.collections.collectionbystatus.contexts.CollectionByStatusContexts;
import com.pearson.qa.bluesky.csg.collections.collectionbystatus.executordrivers.CollectionByStatusExecutorDriver;
import com.pearson.qa.bluesky.csg.collections.collectionbystatus.modules.CollectionByStatusModule;
import com.pearson.qa.bluesky.csg.collections.createCollectionNotes.contexts.CreateCollectionNotesContext;
import com.pearson.qa.bluesky.csg.collections.createCollectionNotes.executordrivers.CreateCollectionNotesExecutorDriver;
import com.pearson.qa.bluesky.csg.collections.createCollectionNotes.modules.CreateCollectionNotesModule;
import com.pearson.qa.bluesky.csg.collections.createcollection.contexts.CreateCollectionContexts;
import com.pearson.qa.bluesky.csg.collections.createcollection.executordrivers.CreateCollectionExecutorDriver;
import com.pearson.qa.bluesky.csg.collections.createcollection.modules.CreateCollectionModule;
import com.pearson.qa.bluesky.csg.collections.deleteCollectionChapter.contexts.DeleteCollectionChapterContext;
import com.pearson.qa.bluesky.csg.collections.deleteCollectionChapter.executordrivers.DeleteCollectionChapterExecutorDriver;
import com.pearson.qa.bluesky.csg.collections.deleteCollectionChapter.modules.DeleteCollectionChapterModule;
import com.pearson.qa.bluesky.csg.collections.deleteCollectionNote.contexts.DeleteCollectionNoteContext;
import com.pearson.qa.bluesky.csg.collections.deleteCollectionNote.executordrivers.DeleteCollectionNoteExecutorDriver;
import com.pearson.qa.bluesky.csg.collections.deleteCollectionNote.modules.DeleteCollectionNoteModule;
import com.pearson.qa.bluesky.csg.collections.deletecollection.contexts.DeleteCollectionContext;
import com.pearson.qa.bluesky.csg.collections.deletecollection.executordrivers.DeleteCollectionExecutorDriver;
import com.pearson.qa.bluesky.csg.collections.deletecollection.modules.DeleteCollectionModule;
import com.pearson.qa.bluesky.csg.collections.getCollectionNote.contexts.GetCollectionNoteContext;
import com.pearson.qa.bluesky.csg.collections.getCollectionNote.executordrivers.GetCollectionNoteExecutorDriver;
import com.pearson.qa.bluesky.csg.collections.getCollectionNote.modules.GetCollectionNoteModule;
import com.pearson.qa.bluesky.csg.collections.getCollectionNotes.contexts.GetCollectionNotesContext;
import com.pearson.qa.bluesky.csg.collections.getCollectionNotes.executordrivers.GetCollectionNotesExecutorDriver;
import com.pearson.qa.bluesky.csg.collections.getCollectionNotes.modules.GetCollectionNotesModule;
import com.pearson.qa.bluesky.csg.collections.getcollection.contexts.GetCollectionContext;
import com.pearson.qa.bluesky.csg.collections.getcollection.executordrivers.GetCollectionExecutorDriver;
import com.pearson.qa.bluesky.csg.collections.getcollection.modules.GetCollectionModule;
import com.pearson.qa.bluesky.csg.collections.resourcescollection.contexts.ResourcesByCollection;
import com.pearson.qa.bluesky.csg.collections.resourcescollection.executordrivers.ResourcesByCollectionDriver;
import com.pearson.qa.bluesky.csg.collections.resourcescollection.modules.ResourcesByCollectionModule;
import com.pearson.qa.bluesky.csg.collections.updateResourceByResourceInstance.contexts.UpdateResourceByResourceInstanceContext;
import com.pearson.qa.bluesky.csg.collections.updateResourceByResourceInstance.executordrivers.UpdateResourceByResourceInstanceExecutorDriver;
import com.pearson.qa.bluesky.csg.collections.updateResourceByResourceInstance.modules.UpdateResourceByResourceInstanceModule;
import com.pearson.qa.bluesky.csg.collections.updatecollection.contexts.UpdateCollectionContext;
import com.pearson.qa.bluesky.csg.collections.updatecollection.executordrivers.UpdateCollectionBuildExecutorDriver;
import com.pearson.qa.bluesky.csg.collections.updatecollection.modules.UpdateCollectionBuildModule;
import com.pearson.qa.bluesky.csg.taxonomies.collectionsByTaxonomyCourse.contexts.CollectionsByTaxonomyCourseContext;
import com.pearson.qa.bluesky.csg.taxonomies.collectionsByTaxonomyCourse.executordrivers.CollectionsByTaxonomyCourseExecutorDriver;
import com.pearson.qa.bluesky.csg.taxonomies.collectionsByTaxonomyCourse.modules.CollectionsByTaxonomyCourseModule;
import com.pearson.qa.bluesky.csg.taxonomies.getCollectionByISBN.contexts.GetCollectionByISBNContext;
import com.pearson.qa.bluesky.csg.taxonomies.getCollectionByISBN.executordrivers.GetCollectionByISBNExecutorDriver;
import com.pearson.qa.bluesky.csg.taxonomies.getCollectionByISBN.modules.GetCollectionByISBNModule;
import com.pearson.qa.bluesky.csg.taxonomies.getTaxonomies.contexts.TaxonimiesContext;
import com.pearson.qa.bluesky.csg.taxonomies.getTaxonomies.executordrivers.TaxonimiesExecutorDriver;
import com.pearson.qa.bluesky.csg.taxonomies.getTaxonomies.modules.TaxonomiesModule;
import com.pearson.qa.bluesky.csg.user.createUserResource.contexts.CreateUserResourceContext;
import com.pearson.qa.bluesky.csg.user.createUserResource.executordrivers.CreateUserResourceExecutorDriver;
import com.pearson.qa.bluesky.csg.user.createUserResource.modules.CreateUserResourceModule;
import com.pearson.qa.bluesky.csg.user.deleteResource.contexts.DeleteResourceContext;
import com.pearson.qa.bluesky.csg.user.deleteResource.executordrivers.DeleteResourceExecutorDriver;
import com.pearson.qa.bluesky.csg.user.deleteResource.modules.DeleteResourceModule;
import com.pearson.qa.bluesky.csg.user.userResources.contexts.UserResourcesContext;
import com.pearson.qa.bluesky.csg.user.userResources.executordrivers.UserResourcesExecutorDriver;
import com.pearson.qa.bluesky.csg.user.userResources.modules.UserResourcesModule;
import com.pearson.qa.common.configuration.modules.XmlConfigurationModule;
import com.pearson.qa.common.ziggyfw.http.modules.HttpModule;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * User: dcorrales
 * Date: 2/6/14
 * Time: 4:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class Tests {


    Injector injector;

    @BeforeClass
    public void setUpInjector() {
        injector = Guice.createInjector(
                new XmlConfigurationModule(),
                new HttpModule(),
                new LoginModule(),
                new CreateCollectionModule(),
                new CreateOrderHeaderModules(),
                new BookPriceModule(),
                new ChapterPriceModule(),
                new RegisteredBooksModule(),
                new TerritoriesModule(),
                new SchoolModule(),
                new AuthorsBySchoolModule(),
                new SchoolTerritoryAssociationModule(),
                new CreateOrderDetailModule(),
                new CommitOrderDetailModule(),
                new OrderDetailStatusModule(),
                new IsbnByNumberOrStatusModule(),
                new BooksCCCOrdersModule(),
                new BookBuildModule(),
                new ResourcesByCollectionModule(),
                new CollectionByStatusModule(),
                new GetCollectionModule(),
                new UpdateCollectionBuildModule(),
                new ApproveIsbnModule(),
                new DeleteCollectionModule(),
                new ResourceMediaContentPriceModule(),
                new OplUrlModule(),
                new OwrContentFeeModule(),
                new UpdateIsbnStatusModule(),
                new ProcessCccOrderModule(),
                new UpdateBookBuildModule(),
                new TaxonomiesModule(),
                new CollectionsByTaxonomyCourseModule(),
                new CreateCollectionNotesModule(),
                new GetCollectionNoteModule(),
                new GetCollectionNotesModule(),

                new CollectionChapterModule(),
                new DeleteCollectionChapterModule(),
                new GetCollectionByISBNModule(),
                new UpdateResourceByResourceInstanceModule(),
                new UserResourcesModule(),
                new CreateUserResourceModule(),
                new DeleteResourceModule(),
                new DeleteCollectionNoteModule()

        );
    }

    @Test
    public void createLoginContextTest() {
        injector.getInstance(LoginContext.class);
    }

    @Test
    public void createLoginExecutionDriverTest() {
        injector.getInstance(LoginExecutionDriver.class);
    }

    @Test
    public void createCreateCollectionContextTest() {
        injector.getInstance(CreateCollectionContexts.class);
    }

    @Test
    public void createCreateCollectionExecutionDriverTest() {
        injector.getInstance(CreateCollectionExecutorDriver.class);
    }

    @Test
    public void createCreateOrderHeaderContextTest() {
        injector.getInstance(CreateOrderHeaderContext.class);
    }

    @Test
    public void createCreateOrderHeaderExecutorDriverTest() {
        injector.getInstance(CreateOrderHeaderExecutorDriver.class);
    }

    @Test
    public void bookPriceContextTest() {
        injector.getInstance(BookPriceContext.class);
    }

    @Test
    public void bookPriceExecutorDriverTest() {
        injector.getInstance(BookPriceExecutorDriver.class);
    }

    @Test
    public void chapterPriceContextTest() {
        injector.getInstance(ChapterPriceContext.class);
    }

    @Test
    public void chapterPriceExecutorDriverTest() {
        injector.getInstance(ChapterPriceExecutorDriver.class);
    }

    @Test
    public void registeredBooksContextTest() {
        injector.getInstance(RegisteredBooksContext.class);
    }

    @Test
    public void registeredBooksExecutorDriverTest() {
        injector.getInstance(RegisteredBooksExecutorDriver.class);
    }

    @Test
    public void territoriesContextTest() {
        injector.getInstance(TerritoriesContext.class);
    }

    @Test
    public void territoriesExecutorDriverTest() {
        injector.getInstance(TerritoriesExecutorDriver.class);
    }

    @Test
    public void schoolContextTest() {
        injector.getInstance(SchoolContext.class);
    }

    @Test
    public void schoolExecutorDriverTest() {
        injector.getInstance(SchoolExecutorDriver.class);
    }

    @Test
    public void authorBySchoolContextTest() {
        injector.getInstance(AuthorsBySchoolContext.class);
    }

    @Test
    public void authorBySchoolExecutorDriverTest() {
        injector.getInstance(AuthorsBySchoolExecutorDriver.class);
    }

    @Test
    public void schoolTerritoryAssociationContextTest() {
        injector.getInstance(SchoolTerritoryAssociationContext.class);
    }

    @Test
    public void schoolTerritoryAssociationExecutorDriverTest() {
        injector.getInstance(SchoolTerritoryAssociationExecutorDriver.class);
    }

    @Test
    public void createOrderDetailContextTest() {
        injector.getInstance(CreateOrderDetailContext.class);
    }

    @Test
    public void createOrderDetailExecutorDriverTest() {
        injector.getInstance(CreateOrderDetailExecutorDriver.class);
    }

    @Test
    public void commitOrderDetailContextTest() {
        injector.getInstance(CommitOrderDetailContext.class);
    }

    @Test
    public void commitOrderDetailExecutorDriverTest() {
        injector.getInstance(CommitOrderDetailExecutorDriver.class);
    }

    @Test
    public void orderDetailStatusContextTest() {
        injector.getInstance(OrderDetailStatusContext.class);
    }

    @Test
    public void orderDetailStatusExecutorDriverTest() {
        injector.getInstance(OrderDetailStatusExecutorDriver.class);
    }

    @Test
    public void isbnByNumberOrStatusContextTest() {
        injector.getInstance(IsbnByNumberOrStatusContext.class);
    }

    @Test
    public void isbnByNumberOrStatusExecutorDriverTest() {
        injector.getInstance(IsbnByNumberOrStatusExecutorDriver.class);
    }

    @Test
    public void booksCCCOrdersContextTest() {
        injector.getInstance(BooksCCCOrdersContext.class);
    }

    @Test
    public void booksCCCOrdersExecutorDriverTest() {
        injector.getInstance(BooksCCCOrdersExecutorDriver.class);
    }

    @Test
    public void bookBuildContextTest() {
        injector.getInstance(BookBuildContext.class);
    }

    @Test
    public void bookBuildExecutorDriverTest() {
        injector.getInstance(BookBuildExecutorDriver.class);
    }

    @Test
    public void resourcesByCollectionTest() {
        injector.getInstance(ResourcesByCollection.class);
    }

    @Test
    public void resourcesByCollectionDriverTest() {
        injector.getInstance(ResourcesByCollectionDriver.class);
    }

    @Test
    public void updateCollectionTest() {
        injector.getInstance(UpdateCollectionContext.class);
    }

    @Test
    public void updateCollectionDriverTest() {
        injector.getInstance(UpdateCollectionBuildExecutorDriver.class);
    }

    @Test
    public void collectionByStatusTest() {
        injector.getInstance(CollectionByStatusContexts.class);
    }

    @Test
    public void collectionByStatusDriverTest() {
        injector.getInstance(CollectionByStatusExecutorDriver.class);
    }

    @Test
    public void getCollectionTest() {
        injector.getInstance(GetCollectionContext.class);
    }

    @Test
    public void getCollectionDriverTest() {
        injector.getInstance(GetCollectionExecutorDriver.class);
    }

    @Test
    public void approvedISBNDriverTest() {
        injector.getInstance(ApproveIsbnExecutorDriver.class);
    }


    @Test
    public void approvedISBNContextTest() {
        injector.getInstance(ApproveIsbnContext.class);
    }

    @Test
    public void deleteCollectionDriverTest() {
        injector.getInstance(DeleteCollectionExecutorDriver.class);
    }

    @Test
    public void deleteCollectionContextTest() {
        injector.getInstance(DeleteCollectionContext.class);
    }


    @Test
    public void resourceMediaContentPriceExecutorDriverTest() {
        injector.getInstance(ResourceMediaContentPriceExecutorDriver.class);
    }

    @Test
    public void resourceMediaContentPriceContextTest() {
        injector.getInstance(ResourceMediaContentPriceContext.class);
    }

    @Test
    public void oplURLExecutorDriverTest() {
        injector.getInstance(OplUrlExecutorDriver.class);
    }

    @Test
    public void oplURLContextTest() {
        injector.getInstance(OplUrlContext.class);
    }


    @Test
    public void owrContentFeeDriverTest() {
        injector.getInstance(OwrContentFeeExecutorDriver.class);
    }

    @Test
    public void owrContentFeeContextTest() {
        injector.getInstance(OwrContentFeeContext.class);
    }

    @Test
    public void updateISBNStatusDriverTest() {
        injector.getInstance(UpdateIsbnStatusExecutorDriver.class);
    }

    @Test
    public void updateISBNStatusContextTest() {
        injector.getInstance(UpdateIsbnStatusContext.class);
    }

    @Test
    public void processCccOrderExecutorDriverTest() {
        injector.getInstance(ProcessCccOrderExecutorDriver.class);
    }

    @Test
    public void processCccOrderContextTest() {
        injector.getInstance(ProcessCccOrderContext.class);
    }

    @Test
    public void updateBookBuildExecutorDriverTest() {
        injector.getInstance(UpdateBookBuildExecutorDriver.class);
    }

    @Test
    public void updateBookBuildContextTest() {
        injector.getInstance(UpdateBookBuildContext.class);
    }

    @Test
    public void taxonomiesExecutorDriverTest() {
        injector.getInstance(TaxonimiesExecutorDriver.class);
    }

    @Test
    public void taxonomiesContextTest() {
        injector.getInstance(TaxonimiesContext.class);
    }

    @Test
    public void collectionByTaxonomyExecutorDriverTest() {
        injector.getInstance(CollectionsByTaxonomyCourseExecutorDriver.class);
    }

    @Test
    public void collectionByTaxonomyContextTest() {
        injector.getInstance(CollectionsByTaxonomyCourseContext.class);
    }

    @Test
    public void createCollectionNotesExecutorDriverTest() {
        injector.getInstance(CreateCollectionNotesExecutorDriver.class);
    }

    @Test
    public void createCollectionNotesContextTest() {
        injector.getInstance(CreateCollectionNotesContext.class);
    }

    @Test
    public void getCollectionNotesExecutorDriverTest() {
        injector.getInstance(GetCollectionNotesExecutorDriver.class);
    }

    @Test
    public void getCollectionNotesContextTest() {
        injector.getInstance(GetCollectionNotesContext.class);
    }

    @Test
    public void getCollectionNoteExecutorDriverTest() {
        injector.getInstance(GetCollectionNoteExecutorDriver.class);
    }

    @Test
    public void getCollectionNoteContextTest() {
        injector.getInstance(GetCollectionNoteContext.class);
    }

    @Test
    public void collectionChapterExecutorDriverTest() {
        injector.getInstance(CollectionChapterExecutorDriver.class);
    }

    @Test
    public void collectionChapterContextTest() {
        injector.getInstance(CollectionChapterContext.class);
    }

    @Test
    public void deleteCollectionChapterExecutorDriverTest() {
        injector.getInstance(DeleteCollectionChapterExecutorDriver.class);
    }

    @Test
    public void deleteCollectionChapterContextTest() {
        injector.getInstance(DeleteCollectionChapterContext.class);
    }

    @Test
    public void getCollectionByISBNExecutorDriverTest() {
        injector.getInstance(GetCollectionByISBNExecutorDriver.class);
    }

    @Test
    public void getCollectionByISBNContextTest() {
        injector.getInstance(GetCollectionByISBNContext.class);
    }

    @Test
    public void updateResourceByResourceInstanceExecutorDriverTest() {
        injector.getInstance(UpdateResourceByResourceInstanceExecutorDriver.class);
    }

    @Test
    public void UpdateResourceByResourceInstanceContextTest() {
        injector.getInstance(UpdateResourceByResourceInstanceContext.class);
    }

    @Test
    public void userResourcesExecutorDriverTest() {
        injector.getInstance(UserResourcesExecutorDriver.class);
    }

    @Test
    public void userResourcesContextTest() {
        injector.getInstance(UserResourcesContext.class);
    }

    @Test
    public void createUserResourceExecutorDriverTest() {
        injector.getInstance(CreateUserResourceExecutorDriver.class);
    }

    @Test
    public void createUserResourceContextTest() {
        injector.getInstance(CreateUserResourceContext.class);
    }

    @Test
    public void deleteResourceExecutorDriverTest() {
        injector.getInstance(DeleteResourceExecutorDriver.class);
    }

    @Test
    public void deleteResourceContextTest() {
        injector.getInstance(DeleteResourceContext.class);
    }

    @Test
    public void deleteCollectionNoteExecutorDriverTest() {
        injector.getInstance(DeleteCollectionNoteExecutorDriver.class);
    }

    @Test
    public void deleteCollectionNoteContextTest() {
        injector.getInstance(DeleteCollectionNoteContext.class);
    }

}
