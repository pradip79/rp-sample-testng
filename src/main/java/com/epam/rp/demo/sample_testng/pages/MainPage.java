package com.epam.rp.demo.sample_testng.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends BasePage{	
	
	public MainPage(WebDriver driver) {
		super(driver);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	
	public void searchContent(String searchString) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchInput")));
		WebElement searchInput = driver.findElement(By.id("searchInput"));		
		WebElement searchButton = driver.findElement(By.id("searchButton"));
		
		searchInput.sendKeys(searchString);
		logger.info("Entered "+searchString+" in search input");
		searchButton.click();
		
		}
	
	
}
