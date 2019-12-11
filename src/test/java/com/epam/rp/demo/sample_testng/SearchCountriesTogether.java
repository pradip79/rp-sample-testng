package com.epam.rp.demo.sample_testng;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.epam.rp.demo.sample_testng.common.BrowserFactory;
import com.epam.rp.demo.sample_testng.common.CommonTask;
import com.epam.rp.demo.sample_testng.pages.ArticlePage;
import com.epam.rp.demo.sample_testng.pages.MainPage;

public class SearchCountriesTogether extends BaseTest{
	MainPage mainPage;
	ArticlePage articlePage;	
	
	@Test (dataProvider="getCountries")
	public void searchSingleAsianCountry(String countryToSearch, String titleToValidate) {
		mainPage = new MainPage(driver);
		mainPage.searchContent(countryToSearch);
		
		articlePage = new ArticlePage(driver);
		Assert.assertEquals(articlePage.getArticleTitle(), titleToValidate, "Verify article title: ");
		
		articlePage.navigateToMainPage();
				
	}
	
		
	@DataProvider(name="getCountries")
	public Object[][] getCountries(){
		return new Object[][] {{"Indiia", "India"},{"Austria", "Austria"},{"USA", "USA"}};
	}

}
