package com.demoQA.tests;
import org.openqa.selenium.WebDriver;
import com.demoQA.driver.*;
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
	
	@AfterTest

	public void afterTest() {

	driver.quit();

	}


	
}
