package com.pearson.qa.bluesky.csg.dataproviders.users;

import org.testng.annotations.DataProvider;

/**
 * Created by didiercorrales on 3/30/14.
 */
public class UsersDataProvider {


    @DataProvider(name = "userListDataProvider")
    public static Object[][] userListDP() {

        String nativeurl = "taxonomy.pdf";
        String category = "Slide";
        String title = "taxonomy";
        String license = "{\"name\":\"Other\"}";
        String recordSource = "useradded";
        String folder = "f000/0010/0120/";
        String sharing = "Public";
        String description = "Custom Description 111";
        String thumbnail = "slides/thumbnail1.jpg";

        String json = "{" +
                "    \"nativeurl\": \"taxonomy.pdf\"," +
                "    \"category\": \"Slide\"," +
                "    \"title\": \"taxonomy\"," +
                "    \"license\": {" +
                "      \"name\": \"Other\"" +
                "    }," +
                "    \"recordSource\": \"useradded\"," +
                "    \"folder\": \"f000/0010/0120/\"," +
                "    \"sharing\" : \"Public\"," +
                "    \"description\" :  \"Custom Description 111\"," +
                "    \"thumbnail\": \"slides/thumbnail1.jpg\"" +
                "  }";

        return new Object[][]{
                {"userId",json, 400},
                {"userId","{}", 400},
                {"userId","", 400},
                {"", json, 400},
                {"65-76-87-43", json, 400},
                {"xxdffehmyy", json, 400},
                {"aDfGsDeAtR", json, 400},
                {"121212",json, 400},
                {"a2s3d4f5",json, 400},
                {"-------",json, 400},
                {"",json, 400},
                {"@$@$@$@$@$@", json, 400},
        };
    }


    @DataProvider(name = "userResourcesDataProvider")
    public static Object[][] userResourcesDP() {


        return new Object[][]{
                {"userId", 200},
                {"", 400},
                {"xxdffehmyy", 200},
                {"a2s4d5f6", 200},
                {"121212", 200},
                {"     ", 200},
                {"------", 200},
                {"@$@$@$@$@$@$@$", 200},
        };
    }

    @DataProvider(name = "userCollectionByStatusDataProvider")
    public static Object[][] userCollectionByStatusDP() {

        String nativeurl = "taxonomy.pdf";
        String category = "Slide";
        String title = "taxonomy";
        String license = "{\"name\":\"Other\"}";
        String recordSource = "useradded";
        String folder = "f000/0010/0120/";
        String sharing = "Public";
        String description = "Custom Description 111";
        String thumbnail = "slides/thumbnail1.jpg";

        String json = "{" +
                "    \"nativeurl\": \"taxonomy.pdf\"," +
                "    \"category\": \"Slide\"," +
                "    \"title\": \"taxonomy\"," +
                "    \"license\": {" +
                "      \"name\": \"Other\"" +
                "    }," +
                "    \"recordSource\": \"useradded\"," +
                "    \"folder\": \"f000/0010/0120/\"," +
                "    \"sharing\" : \"Public\"," +
                "    \"description\" :  \"Custom Description 111\"," +
                "    \"thumbnail\": \"slides/thumbnail1.jpg\"" +
                "  }";

        return new Object[][]{
                {"userId",json, 400},
                {"userId","{}", 400},
                {"userId","", 400},
                {"", json, 400},
                {"65-76-87-43", json, 400},
                {"xxdffehmyy", json, 400},
                {"aDfGsDeAtR", json, 400},
                {"121212",json, 400},
                {"a2s3d4f5",json, 400},
                {"-------",json, 400},
                {"",json, 400},
                {"@$@$@$@$@$@", json, 400},
        };
    }

    @DataProvider(name = "deleteResourcesDataProvider")
    public static Object[][] deleteUserResourcesDP() {


        return new Object[][]{
                {"resourceId","", 400},
                {"", "",400},
                {"xxdffehmyy","", 400},
                {"121212","", 400},
                {"43-76-89-45", "", 400},
                {"1212121212", "", 400},
                {"a3s4f5g6h7", "", 400},
                {"00000", "", 400},
                {"--------", "", 400},
                {"@$@$@$@$@$@$@$", "", 400},
        };
    }

    @DataProvider(name = "createUserResourcesDataProvider")
    public static Object[][] createUserResourcesDP() {

        String nativeurl = "taxonomy.pdf";
        String category = "Slide";
        String title = "taxonomy";
        String license = "{\"name\":\"Other\"}";
        String recordSource = "useradded";
        String folder = "f000/0010/0120/";
        String sharing = "Public";
        String description = "Custom Description 111";
        String thumbnail = "slides/thumbnail1.jpg";

        String json = "{" +
                "    \"nativeurl\": \"taxonomy.pdf\"," +
                "    \"category\": \"Slide\"," +
                "    \"title\": \"taxonomy\"," +
                "    \"license\": {" +
                "      \"name\": \"Other\"" +
                "    }," +
                "    \"recordSource\": \"useradded\"," +
                "    \"folder\": \"f000/0010/0120/\"," +
                "    \"sharing\" : \"Public\"," +
                "    \"description\" :  \"Custom Description 111\"," +
                "    \"thumbnail\": \"slides/thumbnail1.jpg\"" +
                "  }";

        return new Object[][]{
                {"userId",json, 400},
                {"userId","{}", 400},
                {"userId","", 400},
                {"", json, 400},
                {"65-76-87-43", json, 400},
                {"xxdffehmyy", json, 400},
                {"aDfGsDeAtR", json, 400},
                {"121212",json, 400},
                {"a2s3d4f5",json, 400},
                {"-------",json, 400},
                {"",json, 400},
                {"@$@$@$@$@$@", json, 400},
        };
    }

    @DataProvider(name = "userFavoritesDataProvider")
    public static Object[][] userFavoritesDP() {


        return new Object[][]{
                {"resourceId","", 400},
                {"", "",400},
                {"xxdffehmyy","", 400},
                {"121212","", 400},
                {"43-76-89-45", "", 400},
                {"1212121212", "", 400},
                {"a3s4f5g6h7", "", 400},
                {"00000", "", 400},
                {"--------", "", 400},
                {"@$@$@$@$@$@$@$", "", 400},
        };
    }
}
