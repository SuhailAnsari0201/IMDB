package com.qait.imdb.keyword;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MovieDetailsPageactions {

	WebDriver driver;
	@FindBy(xpath = "//*[text()='Storyline']")
	WebElement header_storyline;
	
	@FindBy(xpath = "//*[text()='Cast']")
	WebElement herder_cast;
	
	@FindBy(xpath = "//a[text()='See full cast']")
	WebElement cast_listLink;
	
	@FindBy(xpath = "//a[text()='Plot Summary']")
	WebElement plot_summaryLink;
	
	

	public MovieDetailsPageactions(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public void clickOnMovieStoryline() {
		header_storyline.click();
	}
//	public void clickOnMoviePlotSummaryLink() {
//		String clickLink = Keys.chord(Keys.CONTROL,Keys.ENTER);
//		plot_summaryLink.sendKeys(clickLink);
//	}
	
	
	public void clickOnMovieCast() {
		herder_cast.click();
	}
//	public void clickOnFullCastLink() {
//		String clickLink = Keys.chord(Keys.CONTROL,Keys.ENTER);
//		cast_listLink.sendKeys(clickLink);
//	}

	
	

}
