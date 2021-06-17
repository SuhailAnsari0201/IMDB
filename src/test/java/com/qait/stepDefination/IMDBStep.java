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
	public WebDriver driver;
	public HomePageActions homePage;
	public SuggestionRendersPageActions suggestionPage;
	public MovieDetailsPageactions movieDetailsPage;
	
	
	
	@Given("Browser is open")
	public void browser_is_open() {
		// Open the URL on a particular browser
		driver = BrowserFactory.startBrowser("chrome");
		// Create HomePage class object
		homePage = PageFactory.initElements(driver, HomePageActions.class);
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
	

	
	@When("user enter {string} in search field")
	public void user_enter_in_search_field(String movieName) {
		System.out.println("MOVIE:::"+movieName);
		homePage.searchMovie(movieName);
		suggestionPage =PageFactory.initElements(driver, SuggestionRendersPageActions.class);
		Assert.assertTrue(suggestionPage.getTitle().contains("Find"));
	}

	@When("user select a movie from suggestion list")
	public void user_select_a_movie_from_suggestion_list() {
		suggestionPage.clickFirstSearchResult();
	}

	@Then("Verify user redirect to movie {string} details page")
	public void verify_user_redirect_to_movie_details_page(String movieName) {
		Assert.assertTrue(movieDetailsPage.getTitle().contains(movieName));
	}
	
	

	@When("user find movie plot section")
	public void user_find_movie_plot_section() {
		movieDetailsPage =PageFactory.initElements(driver, MovieDetailsPageactions.class);
		movieDetailsPage.clickOnMovieStoryline();
	}

	@Then("user get details about movie plot")
	public void user_get_details_about_movie_plot() {
		System.out.println("Movie Plot :: "+movieDetailsPage.getMovieStoryline());
	}

	@When("user find movie cast section")
	public void user_find_movie_cast_section() {
		movieDetailsPage.clickOnMovieCast();
	}

	@Then("user get details about movie cast")
	public void user_get_details_about_movie_cast() {
		System.out.println("Movie Plot :: "+movieDetailsPage.getMovieCastDetails());

	}
}
