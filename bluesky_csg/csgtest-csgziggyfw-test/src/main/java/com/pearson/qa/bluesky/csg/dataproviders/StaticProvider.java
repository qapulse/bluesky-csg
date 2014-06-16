package com.pearson.qa.bluesky.csg.dataproviders;

import org.apache.commons.lang3.StringUtils;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

/**
 * <p>
 * <b>StaticProvider</b>
 * </p>
 * <p>
 * <p/>
 * </p>
 *
 * @author Jake Campbell <jake.campbell@pearson.com>
 */
public class StaticProvider {

    @DataProvider(name = "LoginDP")
    public static Object[][] LoginDP(ITestContext iTestContext) {
        if (!StringUtils.isBlank(iTestContext.getSuite().getParameter("username")))
            return new Object[][]{{iTestContext.getSuite().getParameter("username"),
                    iTestContext.getSuite().getParameter("password"),
                    iTestContext.getSuite().getParameter("authSystem"),
                    false}};

        return new Object[][]{{"logntest1", "bed128365216c019988915ed3add75fb", "sms", true},
                {"logntest", "bed128365216c019988915ed3add75fb", "sms", false}
        };
    }

    @DataProvider(name = "LoginUrlDP")
    public static Object[][] LoginUrlDP() {


        return new Object[][]{
                {"logntest", "bed128365216c019988915ed3add75fb", "sms", "http://www.google.com", "http://www.google.co.cr", 200},
                {"logntest", "bed128365216c019988915ed3add75fb", "sms", "dfsdfsdf", "http://www.google.co.cr", 200},
                {"logntest", "bed128365216c019988915ed3add75fb", "sms", "-1", "http://www.google.co.cr", 200},
                {"logntest", "bed128365216c019988915ed3add75fb", "sms", "http://www.google.com", "ddsasadasd", 200},
                {"logntest", "bed128365216c019988915ed3add75fb", "sms", "http://www.google.com", "12121212121212", 200},
                {"logntest", "bed128365216c019988915ed3add75fb", "sms", "http://www.google.com", "-1", 200},
        };
    }

    @DataProvider(name = "LoginNegativeScenariosDP")
    public static Object[][] LoginNegativeScenariosDP() {

        return new Object[][]{
                {"logntest1", "bed128365216c019988915ed3add75fb", "sms", 403},
                {"logintest", "bed128365216c019988915ed3add75fb-1", "sms", 403},
                {"logintest", "", "sms", 400},
                {"", "bed128365216c019988915ed3add75fb-1", "sms", 400},
                {"login", "bed128365216c019988915ed3add75fb", "", 400}
        };
    }




    @DataProvider(name = "CreateCollectionDP")
    public static Object[][] CreateCollectionDP() {

        return new Object[][]{{"Collection Title Automation", false},
                {"", true},
                {" ", false},
                {"5234234", false},
                {"*$%^#@#$", false},
                {"dfdfdf54", false}};
    }

    @DataProvider(name = "genericUrlNegativeScenariosDP")
    public static Object[][] genericUrlNegativeScenariosDP() {

        return new Object[][]{
                {"XXXXXX", 400},
                {"", 404},
                {"1111111111", 404},
                {"$$$$$$$$", 404},
                {"-1", 404}
        };
    }

    @DataProvider(name = "getSessionTokenDP")
    public static Object[][] GetSessionTokenDP() {

        return new Object[][]{
                {"", false, 200},
                {"121212", true, 404},
                {"", true, 400}
        };
    }


    @DataProvider(name = "LoginAsDataProvider")
    public static Object[][] loginAsDP() {

        return new Object[][]{
                {"", false, 200},
                {"121212", true, 404},
                {"", true, 400},
                {"$$$$$3@#@#@#", true, 400}
        };
    }


}
