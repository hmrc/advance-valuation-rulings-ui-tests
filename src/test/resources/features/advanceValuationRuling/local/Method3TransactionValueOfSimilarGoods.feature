@local @FunctionalTests
Feature: Method 3 flows which is based on Transaction value of similar goods

  Scenario: Employee of the org selects Method 3 which is based on Transaction value of similar goods
    Given I am on the ARS Home Page with affinity group as a "Individual" and Credential role as a "User"
    When I click on Start new application in ARS Home
    And I select role as a "An employee of the organisation"
    And I click continue on Information you need to complete an application page
    And I select "Yes" and continue in Are you planning to import goods page
    And I click on continue in How We Contact You page
    And I select "Yes" and continue in Check the name and address page for employee of org
    And I enter Name- "Automation Test" Email- "Test6@automation.com",Phone- "9876543211", Job title- "Accountant" details and continue in Provide your contact details page
    And I select Method 3 and continue in Select the method page
    Then I will be navigated to Explain Why not select method one or two
    And I enter a reason and continue in Explain why not method one or two page
    And I select "Yes" and continue in Have You Used Method One In the Past 90 days
    Then I will be navigated to Describe the Similar Goods page
    And I enter a reason and continue in Describe the Similar Goods page

  Scenario: Employee of org selects Method 3: Have not used Method 1 to import similar goods in past
    Given I am on the ARS Home Page with affinity group as a "Individual" and Credential role as a "User"
    When I click on Start new application in ARS Home
    And I select role as a "An employee of the organisation"
    And I click continue on Information you need to complete an application page
    And I select "Yes" and continue in Are you planning to import goods page
    And I click on continue in How We Contact You page
    And I select "Yes" and continue in Check the name and address page for employee of org
    And I enter Name- "Automation Test" Email- "Test6@automation.com",Phone- "9876543211", Job title- "Accountant" details and continue in Provide your contact details page
    And I select Method 3 and continue in Select the method page
    Then I will be navigated to Explain Why not select method one or two
    And I enter a reason and continue in Explain why not method one or two page
    And I select "No" and continue in Have You Used Method One In the Past 90 days
    Then I will be navigated to the Select a Method page

  @AccessibilityTest @ZAP
  Scenario Outline: Agent on behalf of trader selects Method 3 which is based on Transaction value of similar goods
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
    And I select Method 3 and continue in Select the method page
    Then I will be navigated to Explain Why not select method one or two
    And I enter a reason and continue in Explain why not method one or two page
    And I select "Yes" and continue in Have You Used Method One In the Past 90 days
    Then I will be navigated to Describe the Similar Goods page
    And I enter a reason and continue in Describe the Similar Goods page
    Examples:
      | EORINo           | EORIType  |
      | "GB113888888041" | "public"  |
      | "GB112888888041" | "private" |
