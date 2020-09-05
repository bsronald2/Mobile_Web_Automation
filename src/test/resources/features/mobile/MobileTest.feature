@mobile
Feature: Mobile Automation Testing example
  \\ Framework:
  After: Close the driver.
  Tags:
  \\@mobile: All mobile test cases should be tagged


  Scenario: LogIn Successfully to APP
    When I login successfully to App under test
    Then The HomePage should be displayed
