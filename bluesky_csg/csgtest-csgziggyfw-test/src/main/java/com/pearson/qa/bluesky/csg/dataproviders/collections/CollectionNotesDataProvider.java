package com.pearson.qa.bluesky.csg.dataproviders.collections;

import org.testng.annotations.DataProvider;

/**
 * Created by didiercorrales on 3/29/14.
 */
public class CollectionNotesDataProvider {

    @DataProvider(name = "CreateCollectionNoteDataProvider")
    public static Object[][] CreateCollectionNoteDP() {

        return new Object[][]{
                {"Note body", "Resource Title", "collectionId", 200},
                {"", "Resource Title", "collectionId", 200},
                {"", "", "collectionId", 200},
                {"Note", "", "collectionId", 200},

                {"Note body", "Resource Title", "", 400},
                {"Note body", "Resource Title", "sdfsdfasfasdf", 400},
                {"Note body", "Resource Title", "121212121212", 400},
                {"Note body", "Resource Title", "@@@@@@@@@@@@@@", 400},

                {"221211212121212", "Resource Title", "", 400},
                {"@#@#@#@#@##2", "Resource Title", "", 400},

                {"Note body", "23232323", "", 400},
                {"Note body", "@#@#@#@#@#", "", 400},
                {"#$#$#$#$#$", "#$#$#$#$#$#%", "", 400}
        };
    }

    @DataProvider(name = "GetCollectionNoteDataProvider")
    public static Object[][] GetCollectionNoteDP() {

        return new Object[][]{
                {"collectionId", "noteId", 200},
                {"", "noteId", 400},
                {"-", "noteId", 200},
                {"sdsdsddsd", "noteId", 200},
                {"1212121212", "noteId", 200},
                {"@@$@$@$@$@$@4", "noteId", 200},
                {"collectionId", "32323223232", 200},
                {"collectionId", "adsdfsdfsdfsdfsdfsfsd", 200},
                {"collectionId", "@$$$@$@$@$@$", 200},
                {"@$@$@$@$@$@$@", "@$@$@$@$", 200},
        };
    }

    @DataProvider(name = "deleteCollectionNoteDataProvider")
    public static Object[][] deleteCollectionNoteDP() {

        return new Object[][]{
                {"collectionId", "noteId", 200},
                {"", "noteId", 400},
                {"-", "noteId", 404},
                {"sdsdsddsd", "noteId", 404},
                {"1212121212", "noteId", 404},
                {"@@$@$@$@$@$@4", "noteId", 404},
                {"collectionId", "32323223232", 404},
                {"collectionId", "adsdfsdfsdfsdfsdfsfsd", 404},
                {"collectionId", "@$$$@$@$@$@$", 404},
                {"@$@$@$@$@$@$@", "@$@$@$@$", 404},
        };
    }

    @DataProvider(name = "GetCollectionNotesDataProvider")
    public static Object[][] GetCollectionNotesDP() {

        String pageNumber = "1";
        String pageSize = "2";
        String sort_by_created = "created";
        String sort_by_creator = "creator";
        String sort_by_author = "author";
        String sort_asc = "asc";
        String sort_desc = "desc";

        return new Object[][]{
                {"collectionId",pageNumber, pageSize , sort_by_created, sort_asc, 200},
                {"collectionId",pageNumber, pageSize , sort_by_creator, sort_asc, 200},
                {"collectionId",pageNumber, pageSize , sort_by_author, sort_asc, 200},
                {"collectionId",pageNumber, pageSize , sort_by_created, sort_desc, 200},
                {"collectionId",pageNumber, pageSize , sort_by_creator, sort_desc, 200},
                {"collectionId",pageNumber, pageSize , sort_by_author, sort_desc, 200},
                {"collectionId","-1", pageSize , sort_by_author, sort_desc, 200},
                {"collectionId",pageNumber, "-1" , sort_by_author, sort_desc, 200},
                {"collectionId","-1", "-1" , sort_by_author, sort_desc, 200},
                {"collectionId",pageNumber, pageSize , sort_by_author, sort_desc, 200},
                {"collectionId",pageNumber, pageSize , sort_by_author, sort_desc, 200},
                {"collectionId",pageNumber, "-1" , sort_by_creator, sort_desc, 200},
                {"collectionId",pageNumber, pageSize , sort_by_created, sort_desc, 200},
                {"collectionId","-1", pageSize , sort_by_author, sort_desc, 200},
                {"collectionId",pageNumber, pageSize , sort_by_author, sort_desc, 200},
                {"collectionId",pageNumber, pageSize , "sfsdfsf", sort_asc, 200},
                {"collectionId","-1", pageSize , "22ew23232", sort_asc, 200},
                {"collectionId",pageNumber, "-1" , "$$$$$", sort_asc, 200},
                {"collectionId",pageNumber, pageSize , sort_by_created, "sdfdsfsdfs", 200},
                {"collectionId","-1", pageSize , sort_by_created, "@$$$$$", 200},
                {"collectionId",pageNumber, pageSize , sort_by_author, "23232323", 200},
                {"collectionId",pageNumber, "-1" , "", sort_asc, 200},
                {"collectionId",pageNumber, pageSize , sort_by_author, "", 200},
                {"collectionId","-1", pageSize , sort_by_created, sort_asc, 200},
                {"collectionId",pageNumber, pageSize , sort_by_author, sort_asc, 200},
                {"collectionId",pageNumber, "-1" , sort_by_author, sort_asc, 200},
                {"collectionId","-1", pageSize , sort_by_author, sort_asc, 200},
                {"collectionId",pageNumber, "-1" , sort_by_author, sort_asc, 200},
       };
    }


    @DataProvider(name = "CollectionCoverDataProvider")
    public static Object[][] CollectionCoverDP() {

        return new Object[][]{
                {"Note body", "Resource Title", "collectionId", 200},
                {"", "Resource Title", "collectionId", 200},
                {"", "", "collectionId", 200},
                {"Note", "", "collectionId", 200},

                {"Note body", "Resource Title", "", 400},
                {"Note body", "Resource Title", "sdfsdfasfasdf", 400},
                {"Note body", "Resource Title", "121212121212", 400},
                {"Note body", "Resource Title", "@@@@@@@@@@@@@@", 400},

                {"221211212121212", "Resource Title", "", 400},
                {"@#@#@#@#@##2", "Resource Title", "", 400},

                {"Note body", "23232323", "", 400},
                {"Note body", "@#@#@#@#@#", "", 400},
                {"#$#$#$#$#$", "#$#$#$#$#$#%", "", 400}
        };
    }

    @DataProvider(name = "updateResourceByResourceInstanceDataProvider")
    public static Object[][] updateResourceByResourceInstanceDP() {

        String resourceInstanceId = "AddTheCorrectResourceId";
        String  description = "Update - Slide: Kinetic Energy Description";
        String status = "Pending";

        return new Object[][]{
                {resourceInstanceId, description, status, 200},
                {"", description, status, 404},
                {"sdfsdfsdfsd", description, status, 404},
                {"@$@$@$@$@$@$", description, status, 404},
                {"121122121", description, status, 404},
                {"-1", description, status, 404},
                {resourceInstanceId, "-1", status, 400},
                {resourceInstanceId, "@#%$^%^&^**(%)%^$%%$T%$%^^$%^$%^%$", status, 400},
                {resourceInstanceId, description, "sdfasdfasdf", 400},
                {resourceInstanceId, description, "1212121", 400},
                {resourceInstanceId, description, "-1", 400},
                {resourceInstanceId, description, "", 400},


        };
    }

    @DataProvider(name = "collectionChaptersDataProvider")
    public static Object[][] collectionChaptersDP() {

        return new Object[][]{
                {"collectionId",  200},
                {"",  404},
                {"4 34 43 23",  404},
                {"9rty65iu45",  404},
                {"sdfsdfsdfsd",  404},
                {"@$@$@$@$@$@$",  404},
                {"121122121",   404},
                {"-1",  404},
        };
    }

    @DataProvider(name = "deletecollectionChaptersDataProvider")
    public static Object[][] deletecollectionChaptersDP() {

        return new Object[][]{
                {"collectionId", "chapterId", 200},
                {"", "", 404},
                {"sdfsdfsdfsd","sdfasdf" , 404},
                {"@$@$@$@$@$@$", "@$@$@$@$", 404},
                {"121122121", "454545454545" , 404},
                {"-1", "-1", 404},
                {"sdfsdfsdfsd","chapterId" , 404},
                {"collectionId","sdfasdf" , 404},
                {"@$@$@$@$@$@$$","chapterId" , 404},
                {"collectionId","@$@$@$@$@$" , 404},
                {"-1","chapterId" , 404},
                {"collectionId","-1" , 404},
                {"11313131313","chapterId" , 404},
                {"collectionId","13131313131314567577" , 404},
        };
    }
}
