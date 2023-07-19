@Method5
@EndToEndJourney
Feature: Method 5 flows

  Scenario: Method 5 flow
    Given I am on the ARS Home Page with affinity group as a Individual and Credential role as a User
    When I click on Start new application in ARS Home
    And I click continue on Information you need to complete an application page
    And I select "Yes" and continue in Are you planning to import goods page
    And I click on continue in How We Contact You page
    And I select "Yes" and continue in Check the name and address page
    And I enter Name- "Automation Test" Email- "Test@automation.com",Phone- "9876543211" details and continue in Provide your contact details page
    And I select Method 5 and continue in Select the method page
    Then I will be navigated to Why Computed Value page
    And I enter a reason and continue in Why Computed Value page and continue
    Then I will be navigated to Explain Reason Computed Value page
    And I enter a reason and continue in Explain Reason Computed Value page