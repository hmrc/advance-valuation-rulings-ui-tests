@FunctionalTests
Feature: End To End Journey for Method 1 which is based on Transaction value of goods

  Scenario: Method 1 based on Transaction value short flow
    Given I am on the ARS Home Page with affinity group as a "Individual" and Credential role as a "User"
    When I click on Start new application in ARS Home
    And I select role as a "An employee of the organisation"
    And I click continue on Information you need to complete an application page
    And I select "Yes" and continue in Are you planning to import goods page
    And I click on continue in How We Contact You page
    And I select "Yes" and continue in Check the name and address page for employee of org
    And I enter Name- "Automation Test" Email- "Test6@automation.com",Phone- "9876543211", Job title- "Accountant" details and continue in Provide your contact details page
    And I select Method 1 and continue in Select the method page
    And I select "Yes" and continue in Is There a Sale Involved
    And I select "No" and continue in Is the sale between related parties
    And I select "No" and continue in Are there any restrictions on the use or resale of the goods
    And I select "No" and continue in Is the sale subject to any conditions or circumstances that could restrict you from valuing the goods
    Then I navigate to Description of the Goods

  Scenario: Method 1 based on Transaction value and no sale involved
    Given I am on the ARS Home Page with affinity group as a "Individual" and Credential role as a "User"
    When I click on Start new application in ARS Home
    And I select role as a "An employee of the organisation"
    And I click continue on Information you need to complete an application page
    And I select "Yes" and continue in Are you planning to import goods page
    And I click on continue in How We Contact You page
    And I select "Yes" and continue in Check the name and address page for employee of org
    And I enter Name- "Automation Test" Email- "Test6@automation.com",Phone- "9876543211", Job title- "Accountant" details and continue in Provide your contact details page
    And I select Method 1 and continue in Select the method page
    And I select "No" and continue in Is There a Sale Involved
    Then I will be navigated to the Select a Method page
