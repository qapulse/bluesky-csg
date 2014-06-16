package com.pearson.qa.bluesky.csg.dataproviders.taxonomies;

import org.testng.annotations.DataProvider;

/**
 * Created by didiercorrales on 3/29/14.
 */
public class TaxonomyDataProvider {

    @DataProvider(name = "collectionsByTaxonomiesCourseDataProvier")
    public static Object[][] collectionsByTaxonomiesCourseDP() {

        // TODO BRIAN Add the correct course id here
        String courseId = "ADD-HERE-THE-CORRECT-course-ID";
        return new Object[][]{
                {"00000000-4474-1da3-8144-769db9a60008", "false", 404},
                {"00000000-4474-1da3-8144-769db9a60008", "true", 404},
                {"", "false", 404},
                {"2323232323", "true", 404},
                {courseId, "2323232323", 404},
                {courseId, "00000000", 404},
                {courseId, "--------", 404},
                {courseId, "43-65-87-09", 404},
                {courseId, "a3s4f5g6h7", 404},
                {courseId, "asdfasdfsadfsdfsdf", 404},
                {courseId, "sdf-sad-fad-fas-df", 404},
                {courseId, "-1", 404},
                {courseId, "", 404},
                {"", "", 404},
        };
    }

    @DataProvider(name = "getCollectionByISBNDataProvider")
    public static Object[][] getCollectionByISBNDP() {

        // TODO BRIAN Add the correct isbn here
        String isbn = "1091000174";
        return new Object[][]{

                {isbn, 500},
                {"@$@$@$@$@", 500},
                {"sdfasdgfwafasdfd", 500},
                {"-2", 500},
                {"232323", 500},
                {"", 500},
        };
    }


}
