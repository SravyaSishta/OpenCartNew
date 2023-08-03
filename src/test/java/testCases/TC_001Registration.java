package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.BaseClass;
import pageObjects.HomePage;
import pageObjects.RegistrationPage; 


public class TC_001Registration extends BaseClass {
@Test(groups={"Regression","Master"})
public void registration()
{
	logger.info("********TC_001Registration Testcase Started*********");
	try
	{
	HomePage hp= new HomePage(driver);
	logger.info("Clicked on MyAccount");
	hp.clickMyaccount();
	logger.info("Clicked on Register linkt");
	hp.clickRegister();
	
	RegistrationPage reg= new RegistrationPage(driver);
	logger.info("Providing Customer Details");
	reg.setFirstname(randomeString());
	reg.setLastname( randomeString());
	reg.setEmail( randomeString()+"@gmail.com");
	reg.setTelephone(randomeNumber());
	String pwd=randomeString();
	reg.setPassword(pwd);
	reg.setPwdConfirm(pwd);
	reg.setPrivacyPolicy();
	reg.clickContinue();
	logger.info("Clicked on Continue Button");
	 String cnfrmMsg=reg.getConfirmationMsg();
	if(cnfrmMsg.equals("Your Account Has Been Created!"))
	{
		logger.info("Test Passed");
		Assert.assertTrue(true);
	}
	else {
		logger.fatal("Test Failed");
		Assert.assertTrue(false);
	}

	}
	catch(Exception e)
	{
		Assert.fail();
	}
	logger.info("********TC_001Registration Testcase Finished*********");
}
}
