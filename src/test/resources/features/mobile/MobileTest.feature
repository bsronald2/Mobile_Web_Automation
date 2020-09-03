@mobile
Feature: Mobile Automation Testing example
  \\ Framework:
  Before: Once the framework is initialized the webDriver open and maximize the browser.
  After: Close the driver.
  \\Features:
  Preconditions: All scenarios start on Babbel Orange Home.
  Tags:
  \\@HomePage: Redirect the web driver to Babbel Orange HomePage.
  \\@ui: test suit


  Scenario: LogIn Successfully to APP
    When I login successfully to App under test
    Then The HomePage should be displayed
