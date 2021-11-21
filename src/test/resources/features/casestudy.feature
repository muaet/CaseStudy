Feature: casestudy tests
  Background:
    Given homepage is open
    And close the pop up

  Scenario: Task-1
    When  page title "Best Buy | Official Online Store | Shop Now & Save" verified
    Then Maximize window
    And Search for "Drone"
    Then Verify search results are listed for "Drone"

  Scenario: Task-2
    When go to Sign In page
    Then fill the login form
    And login with Enter button
    Then verify sucessful login

  Scenario: Task-3
    When go to Sign In page
    Then click sign in with google
    And switch to other window
    Then enter gmail
    Then click gmail next button
    And enter gmail password
    Then click gmail next button
    Then switch to main window
    Then verify sucessful login
    Then open new tab
    And switch to other window
    Then go to "https://www.bestbuy.com"
    Then verify sucessful login

