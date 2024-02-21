@AllTests
Feature: Flows for Method 2 which is based on Transaction value of identical goods

  Scenario: Method 2 which is based on Transaction value of identical goods where all pages answered 'yes'
    Given I am on the ARS Home Page with affinity group as a "Individual" and Credential role as a "User"
    When I click on Start new application in ARS Home
    And I select role as a "An employee of the organisation"
    And I click continue on Information you need to complete an application page
    And I select "Yes" and continue in Are you planning to import goods page
    And I click on continue in How We Contact You page
    And I select "Yes" and continue in Check the name and address page for employee of org
    And I enter Name- "Automation Test" Email- "Test6@automation.com",Phone- "9876543211", Job title- "Accountant" details and continue in Provide your contact details page
    And I select Method 2 and continue in Select the method page
    Then I will be navigated to Outline Why Not Method One page
    And I enter "not applicable" as my reason why I did not select method 1
    Then I will be navigated to In the Past Have you used Method 1 to import any goods
    And I select that I have used Method 1 to import goods and press continue
    Then I will be navigated to Describe the Identical Goods
    And I enter "many details" as the description of the identical goods and press continue
    Then I navigate to Description of the Goods

  Scenario: Method 2 which is based on Transaction value of identical goods: Have not used Method 1 to import identical goods in past
    Given I am on the ARS Home Page with affinity group as a "Individual" and Credential role as a "User"
    When I click on Start new application in ARS Home
    And I select role as a "An employee of the organisation"
    And I click continue on Information you need to complete an application page
    And I select "Yes" and continue in Are you planning to import goods page
    And I click on continue in How We Contact You page
    And I select "Yes" and continue in Check the name and address page for employee of org
    And I enter Name- "Automation Test" Email- "Test6@automation.com",Phone- "9876543211", Job title- "Accountant" details and continue in Provide your contact details page
    And I select Method 2 and continue in Select the method page
    Then I will be navigated to Outline Why Not Method One page
    And I enter "not applicable" as my reason why I did not select method 1
    Then I will be navigated to In the Past Have you used Method 1 to import any goods
    And I select that I have not used Method 1 to import goods and press continue
    Then I will be navigated to the Select a Method page


  Scenario Outline: Method 2: Have not used Method 1 to import identical goods in past
    Given I am on the ARS Home Page with affinity group as a "Individual" and Credential role as a "User"
    And I click on Start new application in ARS Home
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
    And I select Method 2 and continue in Select the method page
    Then I will be navigated to Outline Why Not Method One page
    And I enter "not applicable" as my reason why I did not select method 1
    Then I will be navigated to In the Past Have you used Method 1 to import any goods
    And I select that I have not used Method 1 to import goods and press continue
    Then I will be navigated to the Select a Method page
    Examples:
      | EORINo           | EORIType  |
      | "GB113888888041" | "public"  |
      | "GB112888888041" | "private" |