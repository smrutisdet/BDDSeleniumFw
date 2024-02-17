Feature:User Login
  Scenario:Verify user Login with valid credentials
    Given user navigates to the application
    When user clicks on signup or login link
    Then signup or login page should be displayed
    And user enters username as "QAAutomationClasses@gmail.com" and password as "QAAutomationClasses"
    And user clicks on login button
    Then application should navigate to logged in user home page
    And user clicks on logout link
    And user closes the browser

