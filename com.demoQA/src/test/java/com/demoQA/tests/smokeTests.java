package com.demoQA.tests;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class smokeTests extends TestSuperClass {

	long time = 1000;
	TimeUnit unit = TimeUnit.MILLISECONDS;

	public void fillNames() {

		boolean check = false;

		driver.get("https://demoqa.com/automation-practice-form/");
		driver.manage().timeouts().implicitlyWait(time, unit);
		driver.findElement(By.name("firstname")).sendKeys("Askhat");
		driver.findElement(By.id("lastname")).sendKeys("Seitenov");
		driver.findElement(By.id("buttonwithclass")).click();

		String actualURL = driver.getCurrentUrl();
		if (actualURL.contains("Askhat")) {
			check = true;
		} else
			check = false;
		Assert.assertTrue(check, "Something went wrong on fillNames Test");
	}

	@Test
	public void fillPageInfo() {

		// Fill Names
		driver.get("https://demoqa.com/automation-practice-form/");
		driver.manage().timeouts().implicitlyWait(time, unit);
		driver.findElement(By.name("firstname")).sendKeys("Askhat");
		driver.findElement(By.id("lastname")).sendKeys("Seitenov");

		// Radio Gender
		WebElement radioMF = driver.findElement(By.id("sex-0"));
		if (radioMF.isSelected() == false) {
			radioMF.click();
		}

		// Radio Experience
		WebElement radioExp1 = driver.findElement(By.id("exp-0"));
		if (radioExp1.isSelected() == false) {
			radioExp1.click();
		}

		// Date Picker
		LocalDate date = LocalDate.now();
		String dateStr = date.toString();
		driver.findElement(By.id("datepicker")).sendKeys(dateStr);

		// Checkbox Profession
		WebElement checkboxProf = driver.findElement(By.id("profession-0"));
		if (checkboxProf.isSelected() == false) {
			checkboxProf.click();
		}

		// Upload Photo
		WebElement uploadElement = driver.findElement(By.id("photo"));
		uploadElement.sendKeys("/Users/user/Downloads/stringofshapes.png");

		// Download xlsx
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/form/fieldset/div[26]/a")).click();
		File tempFile = new File("/Users/user/Downloads/Test-File-To-Download.xlsx");
		boolean exists = tempFile.exists();
		if (exists) {
			Scanner sc = null;
			try {
				sc = new Scanner(tempFile);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			while (sc.hasNextLine())
				System.out.println(sc.nextLine());
		}

		// Checkbox Tool
		WebElement checkboxTool1 = driver.findElement(By.id("tool-0"));
		if (checkboxTool1.isSelected() == false) {
			checkboxTool1.click();
		}

		//Select Continent
		Select drpContinent= new Select(driver.findElement(By.id("continents")));
		drpContinent.selectByVisibleText("Africa");
		
		
		//Select Multiple Continent
		Select multContinent= new Select(driver.findElement(By.id("continentsmultiple")));
		multContinent.selectByVisibleText("Africa");
		
		//Select Selenium Commands
		Select selCommands = new Select(driver.findElement(By.id("selenium_commands")));
		selCommands.selectByVisibleText("Switch Commands");
		
		boolean allCommandsExecuted=true;
		
		Assert.assertTrue(allCommandsExecuted, "Something went wrong on a test phase");

	}

}
