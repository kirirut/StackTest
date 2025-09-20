Feature: Changing data on Stack Overflow profile
  Scenario Outline: Check if display name change works correctly
    Given I'm on Stack Overflow web page
    And I click login button
    And I login using my "<email>" and "<password>"
    And I open my profile
    And I click edit profile
    When I change my display name to "<display_name>"
    And I save changes



    Examples:
      | email     | password           | display_name  |
      | ${EMAIL}  |   ${PASSWORD}      | kirirut2      |