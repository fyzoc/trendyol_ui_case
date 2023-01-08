@all
Feature: TestPage
Background:
  Given user is on homePage
  Then user verifies that home page is visible successfully
  When user close advertisement alert
  @Test02
  Scenario: Login_Process
    Given user click on login button
    And user enters "email"
    And user enters "password"
    When user click on submit button
    Then user verifies that on the sign in page is visible successfully
  @Test01
  Scenario:Test_the_page
    And user get list of all boutique name in a list
    #And report url and response code in csv file
    And report duration when scrolled through the images


