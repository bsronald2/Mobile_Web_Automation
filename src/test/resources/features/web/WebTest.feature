@ui
Feature: User Interface Automation Testing example
  \\ Framework:
    Before: Once the framework is initialized the webDriver open and maximize the browser.
    After: Close the driver.
  \\Features:
    Preconditions: All scenarios start on Babbel Orange HomePage.
  Tags:
    \\@HomePage: Redirect the web driver to Babbel Orange HomePage.
    \\@ui: test suit

  @HomePage
  Scenario Outline: Navigate to Questions Page once selected language to learn
    Given I am in homepage
    When I select the language to start learning "<language>"
    Then I verify that QuestionPage is displayed "Why are you learning <language>?"
    Examples:
      | language    |
      | German      |
      | Portuguese  |