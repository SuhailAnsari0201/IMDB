package com.qait.stepDefination;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qait.imdb.keyword.HomePageActions;
import com.qait.imdb.keyword.MovieDetailsPageactions;
import com.qait.imdb.keyword.SuggestionRendersPageActions;
import com.qait.util.BrowserFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class IMDBStep {
	public static WebDriver driver;
	public static HomePageActions homePage;
	public static SuggestionRendersPageActions suggestionPage;
	public static MovieDetailsPageactions movieDetailsPage;
	
	
	
	@Given("Browser is open")
	public void browser_is_open() {
		// Open the URL on a particular browser
		driver = BrowserFactory.startBrowser("chrome");
		// Create HomePage class object
		homePage = PageFactory.initElements(driver, HomePageActions.class);
		suggestionPage =PageFactory.initElements(driver, SuggestionRendersPageActions.class);
		movieDetailsPage =PageFactory.initElements(driver, MovieDetailsPageactions.class);
	}
	@When("user launch IMDB url")
	public void user_enter_home_url_on_browser() {
		homePage.url("https://www.imdb.com/");
	}
	@Then("user is navigate IMDB home page")
	public void user_is_navigate_home_page() {
		String title = homePage.getTitle();
		Assert.assertTrue(title.contains("IMDb: Ratings, Reviews, and Where to Watch the Best Movies & TV Shows"));
	}
	

	
	@When("user search {string} movie in search field")
	public void user_enter_in_search_field(String movieName) {
		System.out.println("MOVIE:::"+movieName);
		homePage.searchMovie(movieName);
		Assert.assertTrue(suggestionPage.getTitle().contains("Find"));
	}

	@When("user select a movie from suggestion list")
	public void user_select_a_movie_from_suggestion_list() {
		suggestionPage.clickFirstSearchResult();
	}
	@Then("Verify user redirect to {string} movie details page")
	public void verify_user_redirect_to_movie_details_page(String movieName) {
		Assert.assertTrue(movieDetailsPage.getTitle().toLowerCase().contains(movieName.toLowerCase()));
	}
	
	

	@When("user find movie plot section")
	public void user_find_movie_plot_section() {
		movieDetailsPage.clickOnMovieStoryline();
	}
	@When("user find movie plot section")
	public void user_find_movie_cast_section() {
		movieDetailsPage.clickOnMovieCast();
	}

}
