@all
Feature:User Login
  Background:
    Given user navigates to the application
    When user clicks on signup or login link
    Then signup or login page should be displayed
@smoke
  Scenario Outline:Scenario outline demo
    And user enters username as "<userName>" and password as "<password>"
    And user clicks on login button
    Then application should navigate to logged in user home page
    And user clicks on logout link
    @positiveLoginScenario
    Examples:
      | userName                       | password       |
      | testmiuser@gmail.com           | Testmiuser@01  |
#    @negativeLoginScenario
#    Examples:
#      | userName       | password |
#      | test@gmail.com | test@01  |
