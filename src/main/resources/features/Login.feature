Feature: Login User HRM

  Scenario: User successful login into web HRM
    Given User open browser and url
    When User enter valid username
    And User enter valid password
    And User click button login
    Then User go to page Dashboard

 Scenario: User invalid login into web HRM
    When User click on logout link
    And User enter invalid username
    And User enter invalid password
    And User click button login
    Then User can view message invalid credential

  Scenario: User login password is don't entered into web HRM
    When User enter valid username
    And User click button login
    Then User can view messages required
