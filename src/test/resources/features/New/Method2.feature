@EndToEndJourneyNew
@Method2New
Feature: Method 2 flows 1

  @AccessibilityTestNew
  Scenario: Method 2 all pages answered 'yes'
    Given I am on the ARS Home Page with affinity group as a "Individual" and Credential role as a "User"
    When I click on Start new application in ARS Home
    And I select role as a "An employee of the organisation"
    And I click continue on Information you need to complete an application page
    And I select "Yes" and continue in Are you planning to import goods page
    And I click on continue in How We Contact You page
    And I select "Yes" and continue in Check the name and address page
    And I enter Name- "Automation Test" Email- "Test@automation.com",Phone- "9876543211" details and continue in Provide your contact details page
    And I select Method 2 and continue in Select the method page
    Then I will be navigated to Outline Why Not Method One page
    And I enter "not applicable" as my reason why I did not select method 1
    Then I will be navigated to In the Past Have you used Method 1 to import any goods
    And I select that I have used Method 1 to import goods and press continue
    Then I will be navigated to Describe the Identical Goods
    And I enter "many details" as the description of the identical goods and press continue
    Then I navigate to Description of the Goods

  Scenario: Method 2: Have not used Method 1 to import identical goods in past
    Given I am on the ARS Home Page with affinity group as a "Individual" and Credential role as a "User"
    When I click on Start new application in ARS Home
    And I select role as a "An employee of the organisation"
    And I click continue on Information you need to complete an application page
    And I select "Yes" and continue in Are you planning to import goods page
    And I click on continue in How We Contact You page
    And I select "Yes" and continue in Check the name and address page
    And I enter Name- "Automation Test" Email- "Test@automation.com",Phone- "9876543211" details and continue in Provide your contact details page
    And I select Method 2 and continue in Select the method page
    Then I will be navigated to Outline Why Not Method One page
    And I enter "not applicable" as my reason why I did not select method 1
    Then I will be navigated to In the Past Have you used Method 1 to import any goods
    And I select that I have not used Method 1 to import goods and press continue
    Then I will be navigated to the Select a Method page
