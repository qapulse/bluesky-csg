package com.pearson.qa.bluesky.csg.authentication;

import com.pearson.qa.bluesky.csg.TestBase;
import com.pearson.qa.bluesky.csg.authentication.login.contexts.LoginContext;
import com.pearson.qa.bluesky.csg.authentication.login.executiondrivers.LoginExecutionDriver;
import com.pearson.qa.bluesky.csg.dataproviders.StaticProvider;
import com.pearson.qa.common.configuration.Configuration;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * <p>
 * <b>LoginTests</b>
 * </p>
 * <p>
 * <p/>
 * </p>
 * @author Jake Campbell <jake.campbell@pearson.com>
 */
public class LoginTests extends TestBase {



	@Test(  groups = {"authentication.login.success"},
            dataProvider = "LoginDP",
			dataProviderClass = StaticProvider.class)
	public void smsLoginTest(String username, String password, String authSystem, boolean isNegativeTest)
	{
		try
		{
			// prepare context
			LoginContext loginContext = injector.getInstance(LoginContext.class);
            Configuration configuration = injector.getInstance(Configuration.class);
            loginContext.setRequestHost(configuration.getString("com/pearson/qa/bluesky/csg/common/host",""));

            sessionTokenToTest = configuration.getString("com/pearson/qa/bluesky/csg/common/sessiontoken","com/pearson/qa/bluesky/csg/common/sessiontoken").replace("$sessiontoken","");
            authToken = configuration.getString("com/pearson/qa/bluesky/csg/common/apiKey","com/pearson/qa/bluesky/csg/common/apiKey")+","+
                        sessionTokenToTest;

            loginContext.setRequestHeaders(this.getRequestHeader());


			loginContext.getLoginPayload().setUserName(username);
			loginContext.getLoginPayload().setPassword(password);
			loginContext.getLoginPayload().setAuthSystem(authSystem);

			if (isNegativeTest)
				loginContext.setExpectedHttpResponseCode(403);
			else
				loginContext.setExpectedHttpResponseCode(200);

			// perform our test
			LoginExecutionDriver loginExecutionDriver = injector.getInstance(LoginExecutionDriver.class);
			loginExecutionDriver.execute(loginContext);

			if (loginContext.getReturnedHttpResponseCode() == 200)
			{

				userId = loginContext.getLoginResponsePayload().getUserId();
                sessionTokenToTest= loginContext.getLoginResponsePayload().getSessionToken();
			}
            else
            {

                System.out.println(loginContext.getErrorResponsePayload().getMessage());
            }


		} catch (Exception e)
		{
			Assert.fail(e.getMessage(), e);
		}
	}



    @Test(  groups = {"authentication.login.errors"},
            dataProvider = "LoginNegativeScenariosDP",
            dataProviderClass = StaticProvider.class)
    public void smsLoginTestNegativeScenarios(String username, String password, String authSystem, int serverResponseCode)
    {
        try
        {
            // prepare context
            LoginContext loginContext = injector.getInstance(LoginContext.class);
            Configuration configuration = injector.getInstance(Configuration.class);
            loginContext.setRequestHost(configuration.getString("com/pearson/qa/bluesky/csg/common/host",""));


            loginContext.setRequestHeaders(this.getRequestHeader());


            loginContext.getLoginPayload().setUserName(username);
            loginContext.getLoginPayload().setPassword(password);
            loginContext.getLoginPayload().setAuthSystem(authSystem);

                loginContext.setExpectedHttpResponseCode(serverResponseCode);



            // perform our test
            LoginExecutionDriver loginExecutionDriver = injector.getInstance(LoginExecutionDriver.class);
            loginExecutionDriver.execute(loginContext);

            if (loginContext.getReturnedHttpResponseCode() != 200)
               Assert.assertNotNull(loginContext.getErrorResponsePayload().getMessage());

        } catch (Exception e)
        {
            Assert.fail(e.getMessage(), e);
        }
    }

    @Test(  groups = {"authentication.login.urlTest"},
            dataProvider = "LoginUrlDP",
            dataProviderClass = StaticProvider.class)
    public void loginTestUrlTest(String username, String password, String authSystem,String okUrl, String errorUrl, int serverResponseCode)
    {
        try
        {
            // prepare context
            LoginContext loginContext = injector.getInstance(LoginContext.class);
            Configuration configuration = injector.getInstance(Configuration.class);
            loginContext.setRequestHost(configuration.getString("com/pearson/qa/bluesky/csg/common/host",""));


            loginContext.setRequestHeaders(this.getRequestHeader());


            loginContext.getLoginPayload().setUserName(username);
            loginContext.getLoginPayload().setPassword(password);
            loginContext.getLoginPayload().setAuthSystem(authSystem);
            loginContext.getLoginPayload().setOkUrl(okUrl);
            loginContext.getLoginPayload().setErrUrl(errorUrl);


            loginContext.setExpectedHttpResponseCode(serverResponseCode);

            // perform our test
            LoginExecutionDriver loginExecutionDriver = injector.getInstance(LoginExecutionDriver.class);
            loginExecutionDriver.execute(loginContext);

            if (loginContext.getReturnedHttpResponseCode() != 200)
                Assert.assertNotNull(loginContext.getErrorResponsePayload().getMessage());

        } catch (Exception e)
        {
            Assert.fail(e.getMessage(), e);
        }
    }

}
