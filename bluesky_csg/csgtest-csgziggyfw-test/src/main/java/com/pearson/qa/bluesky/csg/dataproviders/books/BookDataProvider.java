package com.pearson.qa.bluesky.csg.dataproviders.books;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.codehaus.jettison.json.JSONObject;

/**
 * Created by dcorrales on 2/21/14.
 */
public class BookDataProvider {


    @DataProvider(name = "getAuthorBySchoolDataProvider")
    public static Object[][] getAuthorBySchoolDP() {
        String territory = "1";
        String school = "1";

        return new Object[][]{
                {"", "", 400},
                {"", school, 400},
                {"232323", "1", 200},
                {"2af4g5h6", "1", 200},
                {"23-43-54-12", "1", 200},
                {"-1", "1", 200},
                {"0", "1", 200},
                {"toTest", "1", 200},
                {"$$$$$$$", "1", 200},
                {"1", "dsfsdfs", 200},
                {"1", "232323232323232323323232365567654435", 200},
                {"1", "$$$$$$", 200},
                {"1", "ToTest", 200},

        };
    }

    @DataProvider(name = "CreateOrderHeaderDataProvider")
    public static Object[][] CreateOrderHeaderDP() {
        String prdAbrv = "ECC";
        String edInstitution = "Log(N)";
        String courseName = "Bluesky";
        String startOfTerm = "11/25/2012";
        String instructorName = "Forum Desai";
        String courseNumber = "PSYCH 101";
        String acctRefNum = "";
        String enteredBy = "";
        String custRefNum = "";


        return new Object[][]{
                {prdAbrv, edInstitution, courseName, startOfTerm, instructorName, courseNumber, acctRefNum, enteredBy, custRefNum, false}
        };
    }

    @DataProvider(name = "CreateOrderHeaderNegativeDataProvider")
    public static Object[][] CreateOrderHeaderNegativeDP() {
        String prdAbrv = "ECC";
        String edInstitution = "Log(N)";
        String courseName = "Bluesky";
        String startOfTerm = "11/25/2012";
        String instructorName = "Forum Desai";
        String courseNumber = "PSYCH 101";
        String acctRefNum = "";
        String enteredBy = "";
        String custRefNum = "";


        return new Object[][]{

                {"", edInstitution, courseName, startOfTerm, instructorName, courseNumber, acctRefNum, enteredBy, custRefNum, 400},
                {prdAbrv, "", courseName, startOfTerm, instructorName, courseNumber, acctRefNum, enteredBy, custRefNum, 400},
                {prdAbrv, edInstitution, "", startOfTerm, instructorName, courseNumber, acctRefNum, enteredBy, custRefNum, 400},
                {prdAbrv, edInstitution, courseName, "", instructorName, courseNumber, acctRefNum, enteredBy, custRefNum, 400},
                {prdAbrv, edInstitution, courseName, startOfTerm, "", courseNumber, acctRefNum, enteredBy, custRefNum, 200},
                {prdAbrv, edInstitution, courseName, startOfTerm, instructorName, "", acctRefNum, enteredBy, custRefNum, 200},
                {prdAbrv, edInstitution, courseName, startOfTerm, instructorName, courseNumber, "", enteredBy, custRefNum, 200},
                {prdAbrv, edInstitution, courseName, startOfTerm, instructorName, courseNumber, acctRefNum, "", custRefNum, 200},
                {prdAbrv, edInstitution, courseName, startOfTerm, instructorName, courseNumber, acctRefNum, enteredBy, "", 200}

        };
    }

    @DataProvider(name = "BookPriceProvider")
    public static Object[][] BookPriceDP() {

        String bookId = "0205033644";
        return new Object[][]{
                {bookId, "print", false, 200},
                {bookId, "ebook", false, 200},
                {"23232323232323232323232", "print", true, 404},
                {"2as4d4f5g6h7j8k8l9k7h6g", "print", true, 404},
                {"23232323232323232323232", "ebook", true, 404},
                {"2as4d4f5g6h7j8k8l9k7h6g", "ebook", true, 404},
                {"$$$$$", "ebook", true, 404},
                {"", "print", true, 400},
                {"----", "print", true, 404},
        };
    }

    @DataProvider(name = "ChapterPriceProvider")
    public static Object[][] chapterPriceDP() {

        String chapterId = "126903250X";
        return new Object[][]{
                {chapterId, "print", false, 200},
                {chapterId, "ebook", false, 200},
                {"23232323232323232323232", "print", true, 404},
                {"23232323232323232323232", "ebook", true, 404},
                {"2as4d4f5g6h7j8k8l9k7h6g", "ebook", true, 404},
                {"2as4d4f5g6h7j8k8l9k7h6g", "print", true, 404},
                {"$$$$", "ebook", true, 404},
                {"", "print", true, 400},
        };
    }

    @DataProvider(name = "CreateOrderDetailsDataProvider")
    public static Object[][] createOrderDetailsDP() {

        String cccWorkInst = "123099610";
        String publicationYear = "2012";
        String numCopiesStdnts = "10";
        String numPages = "20";
        String fromPage = "1";
        String toPage = "20";
        String stdnum = "15538095";
        String title = "Bluesky Book";
        String publisherName = "Manuel";
        String author = "Forum";
        String dateOfIssue = "";
        String volume = "";
        String edition = "";
        String chapterArticle = "";
        String customerRefNum = "";


        return new Object[][]{
                {cccWorkInst, publicationYear, numCopiesStdnts, numPages, fromPage, toPage, stdnum, title, publisherName, author, dateOfIssue, volume, edition, chapterArticle, customerRefNum, false, 200}
        };
    }

    @DataProvider(name = "IsbnByNumberOrStatusDataProvider")
    public static Object[][] isbnByNumberOrStatusDP() {

        String status = "'New','Completed'";
        String ISBN = "";

        return new Object[][]{
                {"23232323232323232323232", "", 400},
                {"111111", "", 400},
                {"a3s4d5f5g6", "", 400},
                {"--------", "", 400},
                {"", "print", 400}
        };
    }

    @DataProvider(name = "BooksforCCCOrdersDataProvider")
    public static Object[][] booksforCCCOrdersDP() {

        String pageSize = "1";
        String pageNumber = "1";
        String sortBy = "bookName";
        String sort_asc = "asc";
        String sort_desc = "desc";

        return new Object[][]{
                {pageSize, pageNumber, sortBy, sort_asc, 200},
                {pageSize, pageNumber, "bookBuildContentId", sort_asc, 200},
                {pageSize, pageNumber, "isbn", sort_asc, 200},
                {pageSize, pageNumber, "authorName",sort_asc , 200},
                {pageSize, pageNumber, "hasOrderAssociated",sort_asc , 200},


                {pageSize, pageNumber, sortBy, sort_desc, 200},
                {pageSize, pageNumber, "bookBuildContentId", sort_desc, 200},
                {pageSize, pageNumber, "isbn", sort_desc, 200},
                {pageSize, pageNumber, "authorName",sort_desc , 200},
                {pageSize, pageNumber, "hasOrderAssociated",sort_desc , 200},

                {pageSize, pageNumber, "2323",sort_desc , 200},
                {pageSize, pageNumber, "12121",sort_asc , 200},

                {pageSize, pageNumber, "$$$$",sort_desc , 200},
                {pageSize, pageNumber, "$$$$",sort_asc , 200},


                {pageSize, "1000000", sortBy, sort_asc, 200},
                {pageSize, "dsdfsd", "bookBuildContentId", sort_asc, 200},
                {pageSize, "dsdfsd", "isbn", sort_asc, 200},
                {pageSize, "dsdfsd", "authorName",sort_asc , 200},
                {pageSize, "dsdfsd", "hasOrderAssociated",sort_asc , 200},
        };
    }

    @DataProvider(name = "ReorderChapterProvider")
    public static Object[][] reorderChapterDP() {

        String chapterId = "126903250X";
        return new Object[][]{
                {chapterId, "print", false, 200},
                {chapterId, "ebook", false, 200},
                {"23232323232323232323232", "print", true, 404},
                {"23232323232323232323232", "ebook", true, 404},
                {"2as4d4f5g6h7j8k8l9k7h6g", "ebook", true, 404},
                {"2as4d4f5g6h7j8k8l9k7h6g", "print", true, 404},
                {"$$$$", "ebook", true, 404},
                {"", "print", true, 400},
        };
    }


    @DataProvider(name = "BookBuilDataProvider")
    public static Object[][] bookBuildDP() {
        String TitleDetailsJSON;
        String TitleDetails = "";
        String collectionId = "collectionIdToBeTested";

        TitleDetails = "{\"Title-Details\":{\"Title\":{\"Adopter\":{\"firstName\":\"Public\",\"lastName\":\"User\"},\"Primary-Last-Name\":\"User\"," +
                "\"Course-Title\":\"Another test\",\"Contracted-Title\":\"New Book\",\"Course-No\":\"PSYH-001\",\"Comment\":\"\"," +
                "\"Saleable-Qty\":\"33\",\"Edition\":\"1\",\"Group-Id\":\"75\",\"Discipline\":\"Psychology\",\"School\":\"norcal - stanford\"," +
                "\"Department\":\"Custom\",\"Street\":\"sdfs\",\"City\":\"sdfg\",\"State\":\"MG\",\"Zip\":\"453333\",\"Country\":\"US\"," +
                "\"Other-Address\":\"Preet Vihar\",\"Home-Phone\":\"\",\"Office-Phone\":\"2132121\",\"Main-Phone\":\"2132121\",\"Fax\":\"\"," +
                "\"E-Mail\":\"public@n.com\",\"Apt-Suite\":\"-\",\"Full-Name\":\"Public User\",\"SchoolDesk\":\"test\",\"DepartmentDesk\":\"Custom\"," +
                "\"Address1Desk\":\"\",\"Address2Desk\":\"\",\"CityDesk\":\"\",\"StateDesk\":\"\",\"ZipDesk\":\"\",\"CountryDesk\":\"\"," +
                "\"PhoneDesk\":\"\",\"OtherAddDesk\":\"\",\"No-PG-Proofs\":\"1\",\"Class-Start\":\"2012-06-14\",\"Store-Date\":\"2012-06-14\"," +
                "\"Net-Price\":\"15.00\",\"Page-Count\":\"35\",\"Cover-Image-Location\":\"http://pcpmr.highcrestmedia.com/services.php type=cover&amp;amp;uid=MRCR\"," +
                "\"Create-Date\":\"2011-01-31\",\"Address1\":\"\",\"Address2\":\"\",\"Project-Type\":\"eBook\",\"No-Of-Pages-TP\":\"21\"," +
                "\"Media-Type\":\"PCL PDF\",\"Family-ISBN\":\"\",\"Bundled-With-ISBNS\":{\"Component\":[{\"Comp-ISBN\":\"1071000004\"," +
                "\"Comp-Desc\":\"Bundled Component Test for 1071000004\"},{\"Comp-ISBN\":\"1071000012\",\"Comp-Desc\":\"Bundled Component Test for 1071000012\"}," +
                "{\"Comp-ISBN\":\"1071000020\",\"Comp-Desc\":\"Bundled Component Test for 1071000020\"}]}," +
                "\"Derivative-Component-ISBNS\":{\"Derivative\":[{\"Derivative-ISBN\":\"\",\"No-Of-Pages-Used\":\"\"},{\"Derivative-ISBN\":\"\"," +
                "\"No-Of-Pages-Used\":\"\"},{\"Derivative-ISBN\":\"\",\"No-Of-Pages-Used\":\"\"}]},\"Custom-Content\":{\"Content\":[{\"Type\":\"Instructor\"," +
                "\"BlueSky-Id\":\"12345\",\"Description\":\"This is a book\"},{\"Type\":\"OER\",\"BlueSky-Id\":\"67890\"," +
                "\"Description\":\"This is an open ebook resource\"},{\"Type\":\"OWR\",\"BlueSky-Id\":\"09876\"," +
                "\"Description\":\"This is an open web resource\"}]}},\"schoolTerritoryAssociationId\":\"1\",\"External-OID\":\"" + collectionId + "\"}}";


        return new Object[][]{
                {TitleDetails, 200}
        };
    }

    @DataProvider(name = "BookBuilDataProvider-NegativeScenarios")
    public static Object[][] bookBuildNegativeDP() {
        String TitleDetailsJSON;
        String TitleDetails = "";
        String collectionId = "";

        TitleDetails = "{\"Title-Details\":{\"Title\":{\"Adopter\":{\"firstName\":\"Public\",\"lastName\":\"User\"},\"Primary-Last-Name\":\"User\"," +
                "\"Course-Title\":\"Another test\",\"Contracted-Title\":\"New Book\",\"Course-No\":\"PSYH-001\",\"Comment\":\"\"," +
                "\"Saleable-Qty\":\"33\",\"Edition\":\"1\",\"Group-Id\":\"75\",\"Discipline\":\"Psychology\",\"School\":\"norcal - stanford\"," +
                "\"Department\":\"Custom\",\"Street\":\"sdfs\",\"City\":\"sdfg\",\"State\":\"MG\",\"Zip\":\"453333\",\"Country\":\"US\"," +
                "\"Other-Address\":\"Preet Vihar\",\"Home-Phone\":\"\",\"Office-Phone\":\"2132121\",\"Main-Phone\":\"2132121\",\"Fax\":\"\"," +
                "\"E-Mail\":\"public@n.com\",\"Apt-Suite\":\"-\",\"Full-Name\":\"Public User\",\"SchoolDesk\":\"test\",\"DepartmentDesk\":\"Custom\"," +
                "\"Address1Desk\":\"\",\"Address2Desk\":\"\",\"CityDesk\":\"\",\"StateDesk\":\"\",\"ZipDesk\":\"\",\"CountryDesk\":\"\"," +
                "\"PhoneDesk\":\"\",\"OtherAddDesk\":\"\",\"No-PG-Proofs\":\"1\",\"Class-Start\":\"2012-06-14\",\"Store-Date\":\"2012-06-14\"," +
                "\"Net-Price\":\"15.00\",\"Page-Count\":\"35\",\"Cover-Image-Location\":\"http://pcpmr.highcrestmedia.com/services.php type=cover&amp;amp;uid=MRCR\"," +
                "\"Create-Date\":\"2011-01-31\",\"Address1\":\"\",\"Address2\":\"\",\"Project-Type\":\"eBook\",\"No-Of-Pages-TP\":\"21\"," +
                "\"Media-Type\":\"PCL PDF\",\"Family-ISBN\":\"\",\"Bundled-With-ISBNS\":{\"Component\":[{\"Comp-ISBN\":\"1071000004\"," +
                "\"Comp-Desc\":\"Bundled Component Test for 1071000004\"},{\"Comp-ISBN\":\"1071000012\",\"Comp-Desc\":\"Bundled Component Test for 1071000012\"}," +
                "{\"Comp-ISBN\":\"1071000020\",\"Comp-Desc\":\"Bundled Component Test for 1071000020\"}]}," +
                "\"Derivative-Component-ISBNS\":{\"Derivative\":[{\"Derivative-ISBN\":\"\",\"No-Of-Pages-Used\":\"\"},{\"Derivative-ISBN\":\"\"," +
                "\"No-Of-Pages-Used\":\"\"},{\"Derivative-ISBN\":\"\",\"No-Of-Pages-Used\":\"\"}]},\"Custom-Content\":{\"Content\":[{\"Type\":\"Instructor\"," +
                "\"BlueSky-Id\":\"12345\",\"Description\":\"This is a book\"},{\"Type\":\"OER\",\"BlueSky-Id\":\"67890\"," +
                "\"Description\":\"This is an open ebook resource\"},{\"Type\":\"OWR\",\"BlueSky-Id\":\"09876\"," +
                "\"Description\":\"This is an open web resource\"}]}},\"schoolTerritoryAssociationId\":\"1\",\"External-OID\":\"" + "collectionIdToBeTested" + "\"}}";


        return new Object[][]{
                {collectionId,TitleDetails, 400},
                {"2323232323",TitleDetails, 404},
                {"   ",TitleDetails, 404},
                {"",TitleDetails, 404},
                {"234234lkjlkj",TitleDetails, 404},
                {"2323232323","sdfsdfsdf", 404},
                {"asdfsdf","456456456", 404},
                {"  ","   ", 404},
                {"ertere","87sd876df", 404},
                {"------","------", 404},
                {"4345-ert-345","634--345--345-345", 404},
                {"2323232323","&^%^%$^", 404},
                {"XXXXX",TitleDetails, 404},
                {"@#@#@#@#@#@3",TitleDetails, 404},
                {"--",TitleDetails, 404},
        };
    }

    @DataProvider(name = "ApprovedISBNDataProvider")
    public static Object[][] approvedISBNDP() {

        return new Object[][]{
                {"\"approvedISBNsXML\":   \"<ApprovedISBNs>    <ISBN>1091000174</ISBN>   </ApprovedISBNs>\"", 200}

        };
    }

    @DataProvider(name = "ApprovedISBNNegativeDataProvider")
    public static Object[][] approveISBNNegativeScenariosDP() {

        return new Object[][]{
                {"\"approvedISBNsXML\":   \"<ApprovedISBNs>    <ISBN>"+"asdfsadfs"+"</ISBN>   </ApprovedISBNs>\"", 200},
                {"\"approvedISBNsXML\":   \"<ApprovedISBNs>    <ISBN>"+"12121212"+"</ISBN>   </ApprovedISBNs>\"", 200},
                {"\"approvedISBNsXML\":   \"<ApprovedISBNs>    <ISBN>"+"-1"+"</ISBN>   </ApprovedISBNs>\"", 200} ,
                {"\"approvedISBNsXML\":   \"<ApprovedISBNs>    <ISBN>"+""+"</ISBN>   </ApprovedISBNs>\"", 200}

        };
    }

    @DataProvider(name = "BookRegisteredDetailsDataProvider")
    public static Object[][] BookRegisteredDetailsDP() {

        String productId = "XXX";
        return new Object[][]{
                {productId, 200},
                {"4343sfsdfsdf", 200},
                {"XCVBB", 200},
                {"-1", 200}
        };
    }


    @DataProvider(name = "GenereateSalesReportDataProvider")
    public static Object[][] generateSalesReportDP() {

        String territoryId = "2";
        String schooldId = "2";
        String author = "Public,User";
        return new Object[][]{
                {territoryId, schooldId, author, 400},
                {"", schooldId, author, 400},
                {territoryId, "", author, 400},
                {territoryId, schooldId, "", 400},
                {"-1", schooldId, author, 400},
                {"asfsdsfd", schooldId, author, 400},
                {territoryId, "dsfdsdfsf", author, 400},
                {territoryId, schooldId, "", 400},
                {territoryId, schooldId, "12121212", 400},
                {"0", schooldId, author, 400},
                {territoryId, "0", author, 400},
                {territoryId, schooldId, "0", 400},
                {territoryId, schooldId, author, 400},
                {"$$$$", schooldId, author, 400},
                {territoryId, schooldId, "0", 400},
                {territoryId, schooldId, author, 400},
                {territoryId, "$$$$", author, 400},
                {territoryId, schooldId, "$$$$", 400}


        };
    }


    @DataProvider(name = "ResourceMediaContentPriceDataProvider")
    public static Object[][] resourceMediaContentPriceDP() {

        String isbn = "1269041347";
        String type = "ebook";

        return new Object[][]{
                {isbn, type, 404},
                {"7655434", type, 404},
                {isbn, "print", 404},
                {"-1", type, 404},
                {"sfds", type, 404},
                {"a3b5c7e8", type, 404},
                {"---", type, 404},
                {"+++", type, 404}
        };
    }


    @DataProvider(name = "ResourceMediaContentPriceNegativeScenariosDataProvider")
    public static Object[][] resourceMediaContentPriceNegativeScenariosDP() {

        String isbn = "1269041347";
        String type = "";


        return new Object[][]{
                {isbn, type, 404},
        };
    }

    @DataProvider(name = "oplUrlDataProvider")
    public static Object[][] oplUrlDP() {

        String isbn = "1091000174";

        return new Object[][]{
                {"adsfasdf", 404},
                {"-1", 404},
                {"-+sdfsadfadsfasdfs_________-------adfadsfadfasdfasdfasdfasdfasdsd++++++sadasdasdasdsa", 404},
                {"", 400},
                {"a2s3d4f5", 404},
                {"###", 404},
                {"---", 404}

        };
    }


    @DataProvider(name = "approveISBNDataProvider")
    public static Object[][] approveISBNDP() {

        String isbn = "1091000174";

        return new Object[][]{
                {isbn, 200},
                {"adsfasdf", 404},
                {"a3a4d5g6", 404},
                {"89-87-654-43", 404},
                {"-1", 404},
                {"-+sdfsadfadsfasdfs_________-------adfadsfadfasdfasdfasdfasdfasdsd++++++sadasdasdasdsa", 404},
                {"", 400},
                {"-", 404}
        };
    }


    @DataProvider(name = "owrContentFeeDataProvider")
    public static Object[][] owrContentFeeDP() {
        String resourceId = "0362-4331";
        String publicationYear = "2000";
        String numCopies = "1";
        String numPages = "1";
        String typeEBoook = "ebook";
        String typePrint = "print";

        return new Object[][]{
                {resourceId, publicationYear, numCopies, numPages, typeEBoook, 200},
                {resourceId, publicationYear, numCopies, numPages, typePrint, 200},
                {"", publicationYear, numCopies, numPages, typePrint, 400},
                {"-1", publicationYear, numCopies, numPages, typePrint, 200},
                {resourceId, publicationYear, numCopies, numPages, "", 400},
                {resourceId, "1950", numCopies, numPages, typePrint, 200},
                {resourceId, "1920", numCopies, numPages, typePrint, 200},
                {resourceId, "2010", numCopies, numPages, typePrint, 200},
                {resourceId, publicationYear, "-1", numPages, typeEBoook, 200},
                {resourceId, "2000", "0", numPages, typePrint, 200},
                {resourceId, "2000", "202020202020", numPages, typePrint, 200},
                {resourceId, "2000", "", numPages, typePrint, 200},
                {resourceId, "2000", " ", numPages, typePrint, 200},
                {resourceId, "2000", "asdfg", numPages, typePrint, 200},
                {resourceId, "2000", "432asdf", numPages, typePrint, 200},
                {resourceId, "2000", "&^^%$#", numPages, typePrint, 200},
                {resourceId, "2000", numCopies, "1", typePrint, 200},
                {resourceId, "2000", numCopies, numPages, typeEBoook, 200},
                {resourceId, "2000", numCopies, "1", typeEBoook, 200},
                {resourceId, "2000", numCopies, numPages, typeEBoook, 200},
                {"0362-4331", publicationYear, numCopies, "1", typePrint, 200},
                {"0362-4331", publicationYear, numCopies, numPages, typePrint, 200},
                {"0362-4331", publicationYear, numCopies, "1", typePrint, 200},
                {"0362-4331", publicationYear, numCopies, numPages, typePrint, 200},
                {"0362-4331", publicationYear, numCopies, "1", typePrint, 200},
        };
    }


    @DataProvider(name = "UpdateISBNStatustDataProvider")
    public static Object[][] updateISBNStatustDP() {

        String isbn = "1091000174";
        String status = "Checked out";
        String statusModifier = "JUnit Tester";
        return new Object[][]{
                {"", status, "", 400},
                {isbn, status, "", 400},
                {isbn, "", statusModifier, 400},

                // ISBN test
                {"", status, statusModifier, 400},
                {"", "",statusModifier, 400},
                {"", status, "", 400},
                {"", "", "", 400},
                {isbn, "", "", 400},
                {isbn, status,"", 400},

                // Status
                {"", status, "", 400},
                {isbn, status, "", 400},
                {isbn, "", statusModifier, 400},
                {"", status, "", 400},
                {"", "", "", 400},

                //statusModifier
                {"", "",statusModifier, 400},
                {"", status, "", 400},
                {"", "", "", 400},
                {isbn, "", "", 400},

        };
    }

    @DataProvider(name = "ProcessCCCOrderTestDataProvider")
    public static Object[][] processCCCOrderTestDP() {
        String bookBuildContentId = "402881843a1e8233013a1e8493a60002";
        String issns = "[\"9781604269581\",\"SN77020506\"]";
        String productType = "ECC";
        String userInformation = "Junit Test";

        return new Object[][]{
                {bookBuildContentId, issns, productType, userInformation, 404},
                {"5      5", issns, productType, userInformation, 404},
                {"-1", issns, productType, userInformation, 404},
                {"323232232323", issns, productType, userInformation, 404},
                {"a3a4s5d6g7h8", issns, productType, userInformation, 404},
                {"*&^%%$#@", issns, productType, userInformation, 404},
                {"----------", issns, productType, userInformation, 404},
                {"lkoooklelele", issns, productType, userInformation, 404},

                {bookBuildContentId, "", productType, userInformation, 400},
                {bookBuildContentId, "[]", productType, userInformation, 404},
                {bookBuildContentId, "[\"sdfsdfdsfsdfsdf\",\"SN77020506\"]", productType, userInformation, 404},
                {bookBuildContentId, "[\"sdfsdfdsfsdfsdf\"]", productType, userInformation, 404},
                {bookBuildContentId, issns, "-1", userInformation, 404},
                {bookBuildContentId, issns, "sdfsdfqwewewqeqw", userInformation, 404},
                {bookBuildContentId, issns, "$$$$$$$", userInformation, 404},
                {bookBuildContentId, issns, "", userInformation, 400},
                {bookBuildContentId, issns, productType, "", 400},
                {bookBuildContentId, issns, productType, "$$$$", 404},
                {bookBuildContentId, issns, productType, "2323232323232323232323232x223cc2c23c2c2323c23c2323c232c32", 404},

        };
    }


    @DataProvider(name = "UpdateBookBuildDataProvider")
    public static Object[][] updateBookBuildDP() {

        String isbn = "1091000174";
        String bookBuildId = "";
        String moduleId = "14311";
        String productId = "1234567890";
        return new Object[][]{
                {isbn, bookBuildId, moduleId, productId, 200}

        };
    }


    @DataProvider(name = "UpdateBookBuildDataProviderForNegativeScenarios")
    public static Object[][] updateBookBuildNegativeScenariosDP() {

        String isbn = "1091000174";
        String bookBuildId = "";
        String moduleId = "14311";
        String productId = "1234567890";

        return new Object[][]{

                {isbn, "", "-1", productId, 200},
                {isbn, "", "0", productId, 200},
                {isbn, bookBuildId, moduleId, "0", 200},
                {isbn, bookBuildId, moduleId, "-1", 200},

                {isbn, "", "sdfsadfasdfs", productId, 200},
                {isbn, "", "$$$$$$$$$$$$", productId, 200},
                {isbn, bookBuildId, moduleId, "1818181818181818181818181811818188118188181818118", 200},
                {isbn, "", "1818181818181818181818181811818188118188181818118", productId, 200},
                {isbn, "", "-----@@@@@", productId, 200},

        };
    }


    @DataProvider(name = "SchoolsByTerritoriesNegativeDataProvider")
    public static Object[][] SchoolsByTerritoriesNegativeDP() {

        return new Object[][]{
                {"", 400},
                {"sdfsdfsdsdf", 200},
                {"$$$$", 200},
                {"---", 200},
                {"2323232323", 200},
                {"-1", 200},
                {"0", 200},
        };}

}