Feature: Login

  @smoke @login
  Scenario: Valid Login
    And I see OrangeHrm logo
    When I enter valid username and password
    And I click login button
    Then I see the dashboard

  @regression @login
  Scenario: Invalid Login
    And I see OrangeHrm logo
    When I enter invalid username and password
    And I click login button
    Then I see error message

  @error
  Scenario: Error message validation
    When I enter invalid username an password I see errorMessage
      | UserName | Password   | ErrorMessage        |
      | Admin    | Admin123   | Invalid Credentials |
      | Admin1   | Syntax1234 | Invalid Credentials |
      | Adminrty | ertyioo    | Invalid Credentials |

      