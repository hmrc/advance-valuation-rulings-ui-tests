@local @FunctionalTests
Feature: Method 5 which is computed value to value goods flows

  Scenario: Method 5 which is computed value to value goods flow for employee of org
    Given I am on the ARS Home Page with affinity group as a "Individual" and Credential role as a "User"
    When I click on Start new application in ARS Home
    And I select role as a "An employee of the organisation"
    And I click continue on Information you need to complete an application page
    And I select "Yes" and continue in Are you planning to import goods page
    And I click on continue in How We Contact You page
    And I select "Yes" and continue in Check the name and address page for employee of org
    And I enter Name- "Automation Test" Email- "Test6@automation.com",Phone- "9876543211", Job title- "Accountant" details and continue in Provide your contact details page
    And I select Method 5 and continue in Select the method page
    Then I will be navigated to Why Computed Value page
    And I enter a reason and continue in Why Computed Value page and continue
    Then I will be navigated to Explain Reason Computed Value page
    And I enter a reason and continue in Explain Reason Computed Value page

  @AccessibilityTest @ZAP
  Scenario Outline: Method 5 computed value to value goods flow for agent on behalf of trader
    Given I am on the ARS Home Page with affinity group as a "Individual" and Credential role as a "User"
    When I click on Start new application in ARS Home
    And I select role as a "Agent acting on behalf of a trader"
    And I click continue on Information you need to complete an application page
    And I select "Yes" and continue in Are you planning to import goods page
    And I click on continue in How We Contact You page
    And I enter EORI number <EORINo> on Provide traders EORI number page
    And I click on Continue button
    And I select "Yes" for <EORIType> EORI on Check the name and address page
    And I click on Continue button
    And I upload the document "test1.pdf" and continue in Upload letter of authority page
    And I click on continue on Uploaded letter of authority page
    And I enter Name- "Automation Test" Email- "Test@automation.com",Phone- "9876543211", Company name - "company test", Job title - "agent for trader" details
    And I click on Continue button
    And I select Method 5 and continue in Select the method page
    Then I will be navigated to Why Computed Value page
    And I enter a reason and continue in Why Computed Value page and continue
    Then I will be navigated to Explain Reason Computed Value page
    And I enter a reason and continue in Explain Reason Computed Value page
    Examples:
      | EORINo           | EORIType  |
      | "GB113888888041" | "public"  |
      | "GB112888888041" | "private" |