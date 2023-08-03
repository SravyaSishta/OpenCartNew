package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.BaseClass;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class TC_002LoginPage extends BaseClass {
@Test(groups={"Sanity","Master"})
public void login()
{
	logger.info("********Starting TC_002 LoginPage********");
	try 
	{
	HomePage hp= new HomePage(driver);
	hp.clickMyaccount();
	hp.clickLogin();
	
	LoginPage lp=new LoginPage(driver);       //LoginPage
	lp.setEmail("ps2@gmail.com");
	lp.setPassword("maniratnam");
	lp.clickLogin();
	Thread.sleep(3000);
	
	MyAccountPage ap=new MyAccountPage(driver);
	Assert.assertEquals(ap.IsMyAccountpageExists(),true);
	}
	catch(Exception e)
	{
		Assert.fail();
	}
	
	logger.info("********Ending TC_002 LoginPage********");
}
}
