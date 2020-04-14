package com.demoQA.driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestSuperClass {

	public WebDriver driver;
	public String url = "http://the-internet.herokuapp.com";

	
	
	@BeforeTest
	public void beforeTest() {
		driver = DriverManagerFactory.getManager(DriverType.CHROME).getDriver();

	}
	
	//aftertest
	
	@AfterTest

	public void afterTest()  {

	driver.quit();

	}


	
}
