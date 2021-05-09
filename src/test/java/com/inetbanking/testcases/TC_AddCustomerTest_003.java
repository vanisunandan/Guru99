package com.inetbanking.testcases;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.AddCustomerPage;
import com.inetbanking.pageobjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass
{
	@Test
	public void AddNewCustomer() throws InterruptedException, IOException 
	{
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserName(username);
		logger.info("User name provided");
        lp.setPassword(password); 
        logger.info("password provided");
		lp.clickSubmit();
		Thread.sleep(3000);
		AddCustomerPage addcust = new AddCustomerPage(driver);
		logger.info("entered customer details..");
		addcust.clickAddNewCustomer();
		addcust.custName("Sunanda");
		
	//	addcust.custgender("female");
		
    	WebElement radio = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input"));
		if(radio.getAttribute("value")=="m")
		{
			driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[1]")).click();
		}
		else
		{
			driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[2]")).click();
		}
		
		//addcust.custdob("10","06","1991");
	   WebElement dob=	driver.findElement(By.xpath("//*[@id=\"dob\"]"));
	   dob.sendKeys("11");
	   dob.sendKeys("03");
	   dob.sendKeys(Keys.TAB);
	   dob.sendKeys("1992");
		
		
		Thread.sleep(3000);
		addcust.custaddress("Owk");
		addcust.custcity("Kurnool");
		addcust.custstate("AP");
		addcust.custpinno("518122");
		addcust.custtelephoneno("8341785349");
		
		String email= ramdomeString()+"@gmail.com";
		addcust.custemailid(email);
		
		addcust.custpassword("sunanda@1234");
		addcust.custsubmit();
		logger.info("validation starts...");
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
	 if(res==true)
	 {
		Assert.assertTrue(true); 
		logger.info("new customer added...");
	 }
	 else
	 {
		 logger.info("new customer failed..");
		 captureScreen(driver,"AddNewCustomer");
		 Assert.assertTrue(false);
	 }
	
	}
	
	
	
	
}
