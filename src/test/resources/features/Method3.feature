# Disabled for now as it is not working
@Method3
@EndToEndJourney
Feature: Method 3 flows

  @AccessibilityTest
  @ZAP
  Scenario: Method 3 flow
    Given I am on the ARS Home Page with affinity group as a Individual and Credential role as a User
    When I click on Start new application in ARS Home
    And I click continue on Information you need to complete an application page
    And I select "Yes" and continue in Are you planning to import goods page
    And I click on continue in How We Contact You page
    And I select "Yes" and continue in Check the name and address page
    And I enter Name- "Automation Test" Email- "Test@automation.com",Phone- "9876543211" details and continue in Provide your contact details page
    And I select Method 3 and continue in Select the method page
    Then I will be navigated to Explain Why Transaction of Similar Goods page
    And I enter a reason and continue in Explain Why Transaction of Similar Goods page
    And I select "Yes" and continue in Have You Used Method One In the Past 90 days
    Then I will be navigated to Describe the Similar Goods page
    And I enter a reason and continue in Describe the Similar Goods page

  Scenario: Method 3: Have not used Method 1 to import similar goods in past
    Given I am on the ARS Home Page with affinity group as a Individual and Credential role as a User
    When I click on Start new application in ARS Home
    And I click continue on Information you need to complete an application page
    And I select "Yes" and continue in Are you planning to import goods page
    And I click on continue in How We Contact You page
    And I select "Yes" and continue in Check the name and address page
    And I enter Name- "Automation Test" Email- "Test@automation.com",Phone- "9876543211" details and continue in Provide your contact details page
    And I select Method 3 and continue in Select the method page
    Then I will be navigated to Explain Why Transaction of Similar Goods page
    And I enter a reason and continue in Explain Why Transaction of Similar Goods page
    And I select "No" and continue in Have You Used Method One In the Past 90 days
    Then I will be navigated to the Select a Method page
