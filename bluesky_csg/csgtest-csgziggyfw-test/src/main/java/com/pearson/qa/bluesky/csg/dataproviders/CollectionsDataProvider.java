package com.pearson.qa.bluesky.csg.dataproviders;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

/**
 * Created by brian on 2/28/14.
 */
public class CollectionsDataProvider {

    @DataProvider(name = "ResourcesByCollectionDataProvider")
    public static Object[][] ResourcesByCollectionDP() {

        return new Object[][]{
                {"00000000-4474-1da3-8144-769db9a60008", "My test", false, 404},
                {"asdfasdfa", "hola", true, 404},
                {"00000000-4474-1da3-810008", "!!!!",true, 404},
                {"fgfgfgfg", "asdfasdf", false, 404},
                {"00000000-4474-1da3-8144-769db9a60008", "#%#$%",false, 404},
                {"ppp", " ",false, 404},
        };
    }

    @DataProvider(name = "DeleteCollectionDataProviderNegativeScenarios")
    public static Object[][]  deleteCollectionDPNegativeScenarios() {

        return new Object[][]{
                {"00000000-4474-1da3-8144-769db9a60008",  404},
                {"asdfasdfa",  404},
                {"00000000-4474-1da3-810008",   404},
                {"ppp",  404},
                {"",  400},
                {"-1",  404},
                {"$$$$",  404},

        };
    }

    @DataProvider(name = "GetCollectionDataProvider")
    public static Object[][] GetCollectionDP() {

        return new Object[][]{
                {"ppp", "My test", false, 404},
                {"asdfas", "hola", true, 404},
                {"0000000", "!!!!",true, 404},
                {"a3s4f5g6", "!!!!",true, 404},
                {"--------", "&%$^$%",true, 404},
                {"643453", "&%$^$%",true, 404},
                {"00000000-44db-1421-8144-dc82590b0040", " ",true, 404},
        };
    }


    @DataProvider(name = "CollectionByStatusDataProvider")
    public static Object[][] CollectionByStatusDP() {

        return new Object[][]{
                {"InProgress", 0, false, 404},
                {"InProgress", 0, true, 404},
                {"InProgress", 0, true, 404},
                {"InProgress", 0, false, 404},
                {"InProgress", 0, true, 404},
        };
    }

    @DataProvider(name = "UpdateCollectionDataProvider")
     public static Object[][] updateCollectionDP() {

        String isbn = "1091000174";
        String status = "Checked out";
        String statusModifier = "JUnit Tester";
        return new Object[][]{
                {isbn, status, statusModifier, 200},
                {"^$#%#$", status, statusModifier, 200},
                {isbn, status, "", 400},
                {isbn, "", statusModifier, 400},
                {" ", status, statusModifier, 400},
                // ISBN test
                {"", status, statusModifier, 400},
        };
    }

    @DataProvider(name = "PlayCollectionDataProvider")
    public static Object[][] PlayCollectionDP() {

        return new Object[][]{
                {"ppp", "My test", false, 404},
                {"asdfas", "hola", true, 404},
                {"0000000", "!!!!",true, 404},
                {"a3s4f5g6", "!!!!",true, 404},
                {"--------", "&%$^$%",true, 404},
                {"643453", "&%$^$%",true, 404},
                {"00000000-44db-1421-8144-dc82590b0040", " ",true, 404},
        };
    }


}
