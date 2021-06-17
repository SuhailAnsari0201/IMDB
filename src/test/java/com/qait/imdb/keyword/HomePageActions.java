package com.qait.imdb.keyword;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageActions {

	WebDriver driver;
	@FindBy(id = "suggestion-search")
	WebElement input_search;

	@FindBy(id = "suggestion-search-button")
	WebElement btn_search;
	
	WebDriverWait wait;

	public HomePageActions(WebDriver driver) {
		this.driver = driver;
	    wait = new WebDriverWait(driver, 20);
	}
	
	public void url(String url) {
		driver.get(url);
	}

	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public void searchMovie(String movieName){
		wait.until(ExpectedConditions.elementToBeClickable(input_search)).sendKeys(movieName);
		wait.until(ExpectedConditions.elementToBeClickable(btn_search)).click();
		//input_search.sendKeys(movieName);
		//btn_search.click();
	}
	
	

}
