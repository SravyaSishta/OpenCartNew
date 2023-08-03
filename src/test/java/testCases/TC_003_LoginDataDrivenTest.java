package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.BaseClass;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataProviders;

public class TC_003_LoginDataDrivenTest extends BaseClass {
@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void LoginTest_DDT(String email, String pwd,String exp) throws InterruptedException
	{
	logger.info("test case TC_003 LoginDataDrivenTest is started.....");
	try
	{
		
	HomePage hp= new HomePage(driver);
	hp.clickMyaccount();
	hp.clickLogin();
	
	LoginPage lp=new LoginPage(driver);       //LoginPage
	lp.setEmail(email);
	lp.setPassword(pwd);
	lp.clickLogin();
	Thread.sleep(3000);
	
	MyAccountPage ap=new MyAccountPage(driver);
	boolean targetpage= ap.IsMyAccountpageExists();
	if(exp.equals("Valid")) 
	{
		if(targetpage==true)
		{
			ap.clickLogout();
			Assert.assertTrue(true);
		}
		else
			Assert.assertTrue(false);
	}
	if(exp.equals("Invalid")) 
	{
		if(targetpage==true)
		{
			ap.clickLogout();
			Assert.assertTrue(false);
		}
		else
			Assert.assertTrue(true);
	}
	}
	catch(Exception e)
	{
		Assert.fail();
	}
	logger.info(" Finished TC_003_LoginDataDrivenTest");
	
	}
}
