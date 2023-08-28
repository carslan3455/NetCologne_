
Feature: Login Functionality

  Background:

    Given navigate to NetCologne

  @Login
  Scenario Outline: Login
    When navigate to Loginseite
    Then the user is logged "<KundenNummer>" and "<Password>"
    Then Login should be not successfully
    And navigate to Homepage

    Examples:

      | KundenNummer | Password |
      | 123456       | erste    |
      | 234567       | zweite   |
      | 345678       | dritte   |

