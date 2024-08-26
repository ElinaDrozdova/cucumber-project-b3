Feature: Passing multiple parameters to the same step


  @nsh
  Scenario: Searching multiple items
    Given user is on Google search page
    Then user searches the following item
    |items|
    |loop academy|
    |java        |
    |cucumber    |
# Ctrl + Alt + L - выровнять