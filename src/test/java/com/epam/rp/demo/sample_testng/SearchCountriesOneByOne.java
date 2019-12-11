package com.epam.rp.demo.sample_testng;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.epam.rp.demo.sample_testng.common.BrowserFactory;
import com.epam.rp.demo.sample_testng.common.CommonTask;
import com.epam.rp.demo.sample_testng.pages.ArticlePage;
import com.epam.rp.demo.sample_testng.pages.MainPage;

public class SearchCountriesOneByOne extends BaseTest{	
	
	MainPage mainPage;
	ArticlePage articlePage;
	static final Logger logger = LogManager.getLogger(SearchCountriesOneByOne.class);
	
		
	@Test	
	public void searchSingleAsianCountry() {
		mainPage = new MainPage(driver);
		mainPage.searchContent("India");
		
		articlePage = new ArticlePage(driver);
		Assert.assertEquals(articlePage.getArticleTitle(), "India", "Verify article title");
		
		articlePage.navigateToMainPage();
	}
	
	@Test
	public void searchSingleEuoropeanCountry() {
		mainPage = new MainPage(driver);
		mainPage.searchContent("Austria");
		
		articlePage = new ArticlePage(driver);
		Assert.assertEquals(articlePage.getArticleTitle(), "Austia", "Verify article title: ");
		
		articlePage.navigateToMainPage();
	}
		
  
}
