
Feature: Login Functionality

  Background:

    Given navigate to NetCologne

  @Smoke
  Scenario Outline: Login
    When navigate to Loginseite
    Then the user is logged "<KundenNummer>" and "<Password>"
    Then Login should be not successfully
    And navigate to Homepage

    Examples:

      | KundenNummer | Password |
      | 123456       | erste    |
      | 345678       | zweite   |
      | 123456       | dritte   |

