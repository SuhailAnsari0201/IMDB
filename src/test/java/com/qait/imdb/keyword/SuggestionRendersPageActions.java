package com.qait.imdb.keyword;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SuggestionRendersPageActions {

	WebDriver driver;
	@FindBy(xpath = "//*[@id='main']/div/div[2]/table/tbody/tr[1]")
	WebElement first_result;
	
	public SuggestionRendersPageActions(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public void clickFirstSearchResult() {
		first_result.click();
	}

}
