Feature: casestudy tests
  Background:
    Given homepage is open
    And close the pop up

  Scenario: Task-1
    When  page title "Best Buy | Official Online Store | Shop Now & Save" verified
    Then Maximize window
    And Search for "Drone"
    Then Verify search results are listed for "Drone"


