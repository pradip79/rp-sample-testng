package com.epam.rp.demo.sample_testng.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ArticlePage extends BasePage{	
	
	public ArticlePage(WebDriver driver) {
		super(driver);
	}
	
	public String getArticleTitle() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstHeading")));
		WebElement articleHeader = driver.findElement(By.id("firstHeading"));		
				
		return articleHeader.getText();		
	}
	
	public void navigateToMainPage() {
		WebElement mainPageIcon = driver.findElement(By.xpath("//a[@title='Visit the main page']"));
		mainPageIcon.click();
	}
	
		
}
