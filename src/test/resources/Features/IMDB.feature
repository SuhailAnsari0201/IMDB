Feature: Research about movie plot and cast

Scenario: Launch IMDB Home page URL
    Given Browser is open
    When user launch IMDB url
    Then user is navigate IMDB home page

Scenario: Search a movie
    When user search "Harry Potter" movie in search field
  #  Then user click on search icon
  #  Then Verify user redirect to suggestion renders page

Scenario: Select a movie from suggestions render page
    When user select a movie from suggestion list
    Then Verify user redirect to "Harry Potter" movie details page

Scenario: Get details about movie plot and cast
    When user find movie plot section
    When user find movie cast section
   