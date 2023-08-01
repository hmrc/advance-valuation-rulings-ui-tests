@Method4
@EndToEndJourney
Feature: Method 4 flows

  @AccessibilityTest
  Scenario: Method 4 all pages
    Given I am on the ARS Home Page with affinity group as a "Individual" and Credential role as a "User"
    When I click on Start new application in ARS Home
    And I click continue on Information you need to complete an application page
    And I select "Yes" and continue in Are you planning to import goods page
    And I click on continue in How We Contact You page
    And I select "Yes" and continue in Check the name and address page
    And I enter Name- "Automation Test" Email- "Test@automation.com",Phone- "9876543211" details and continue in Provide your contact details page
    And I select Method 4 and continue in Select the method page
    Then I will be navigated to explain why not methods one till three
    And I enter "not applicable" as my reason why I did not select methods one till three and continue
    Then I will be navigated to Explain why you have selected Method 4
    And I enter "string" as my reason for selecting method Method 4
    Then I navigate to Description of the Goods
    And I enter "Coffee" as the description and press continue
    And I select "No" and continue in Have you found the commodity code
    Then I will be navigated to Have the goods been subject to legal challenges
