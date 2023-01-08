@grid_feature
Feature: grid_feature
  @grid_chrome
  Scenario: TC01_running_on_chrome
    Given user is on homePage Url with Chrome
    Then user verifies that home page is visible successfully
    When user close advertisement alert
    Given user click on login button
    And user enters "email"
    And user enters "password"
    When user click on submit button
    Then user verifies that on the sign in page is visible successfully
  @grid_firefox
  Scenario: TC02_running_on_firefox
    Given user is on homePage Url with Firefox
    Then user verifies that home page is visible successfully
    When user close advertisement alert
    Given user click on login button
    And user enters "email"
    And user enters "password"
    When user click on submit button
    Then user verifies that on the sign in page is visible successfully