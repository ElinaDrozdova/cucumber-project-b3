Feature: Wikipedia Search feature

  Background:
  Given User is on Wikipedia home page

  @Wiki
  Scenario: Wikipedia Header Verification
    When User types "Steve Jobs" in the wiki search box
    And User clicks wiki search button
    Then User sees "Steve Jobs - Wikipedia" is in the wiki title

  @Wiki
  Scenario: Wikipedia Header Verification
    When User types "Steve Jobs" in the wiki search box
    And User clicks wiki search button
    Then User sees "Steve Jobs" is in the main header

  @Wiki
  Scenario: Wikipedia Image Header Verification
    When User types "Steve Jobs" in the wiki search box
    And User clicks wiki search button
    Then User sees "Steve Jobs" is in the image header


