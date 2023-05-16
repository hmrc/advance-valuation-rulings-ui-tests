@EndToEndJourney
Feature: End To End Journey

  Scenario: User does not intend to import goods
    Given I am on the ARS Home Page with affinity group as a Individual and Credential role as a User
    When I click on Start new application in ARS Home
    And I check all the checkboxes and click continue in Information you need to complete an application page
    And I select "No" and continue in Are you planning to import goods page
    Then I will be navigated to This service is designed for those

  Scenario: User's EORI number details are incorrect
    Given I am on the ARS Home Page with affinity group as a Individual and Credential role as a User
    When I click on Start new application in ARS Home
    And I check all the checkboxes and click continue in Information you need to complete an application page
    And I select "Yes" and continue in Are you planning to import goods page
    And I click on continue in How We Contact You page
    And I select "No" and continue in Check the name and address page
    Then I will be navigated to Your EORI number details must be correct to use this service

  Scenario: User does not have an enrolment to access service
    Given I am on the ARS Home Page and Login without enrolment
    Then user should see subscribe to advance rulings page to enrol
    Then I sign out
