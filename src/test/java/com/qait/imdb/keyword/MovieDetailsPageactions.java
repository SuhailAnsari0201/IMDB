package com.qait.imdb.keyword;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MovieDetailsPageactions {

	WebDriver driver;
	@FindBy(xpath = "//div[@data-testid='storyline-header']")
	WebElement header_storyline;

	@FindBy(xpath = "//div[@class='ipc-html-content ipc-html-content--base']/div")
	WebElement storyline;
	
	@FindBy(xpath = "//div[@data-testid='title-cast']")
	WebElement herder_cast;
	
	@FindBy(xpath = "//a[@data-testid='title-cast-item__actor']")
	List<WebElement> cast_actorNames;
	
	@FindBy(xpath = "//div[@class='title-cast-item__characters-list']")
	List<WebElement> cast_actorCharacters;
	
	

	public MovieDetailsPageactions(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public void clickOnMovieStoryline() {
		header_storyline.click();
	}
	public String getMovieStoryline() {
		return storyline.getText();
	}
	
	public void clickOnMovieCast() {
		herder_cast.click();
	}
	public String getMovieCastDetails() {
		int size = cast_actorNames.size();
		String actorName[] = new String[size];
		String charactorName[] = new String[size];
		String result[] = new String[size];
		int i=0;
		int j=0;
		if (cast_actorNames.size() > 0) {
			for (WebElement webElement : cast_actorNames) {
				actorName[i] = webElement.getText();
				i++;
			}
		}
		if (cast_actorCharacters.size() > 0) {
			for (WebElement webElement : cast_actorCharacters) {
				charactorName[j] = webElement.getText();
				result[j] = actorName[j] + "-" + charactorName[j] ;
				j++;
			}
		}
		
		return result.toString();
	}

}
