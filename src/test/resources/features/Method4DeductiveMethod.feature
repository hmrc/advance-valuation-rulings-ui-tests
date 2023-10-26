@FunctionalTests
Feature: Method 4 which is deductive method to value goods flows

  Scenario: Method 4 which is deductive method to value goods journey all pages for employee of org
    Given I am on the ARS Home Page with affinity group as a "Individual" and Credential role as a "User"
    When I click on Start new application in ARS Home
    And I select role as a "An employee of the organisation"
    And I click continue on Information you need to complete an application page
    And I select "Yes" and continue in Are you planning to import goods page
    And I click on continue in How We Contact You page
    And I select "Yes" and continue in Check the name and address page for employee of org
    And I enter Name- "Automation Test" Email- "Test6@automation.com",Phone- "9876543211", Job title- "Accountant" details and continue in Provide your contact details page
    And I select Method 4 and continue in Select the method page
    Then I will be navigated to explain why not methods one till three
    And I enter "not applicable" as my reason why I did not select methods one till three and continue
    Then I will be navigated to Explain why you have selected Method 4
    And I enter "string" as my reason for selecting method Method 4
    Then I navigate to Description of the Goods
    And I enter "Coffee" as the description and press continue
    And I select "Yes" and continue in Tell us about the previous ruling page
    And I enter "previous ruling information" and continue
    And I select "Yes" on any other rulings that have used a similar method and continue
    And I enter "other rulings for similar goods" on about the rulings for similar goods page and continue
    And I select "No" and continue in Have you found the commodity code
    Then I will be navigated to Have the goods been subject to legal challenges

  @EndToEndJourney @ZAP @AccessibilityTest
  Scenario Outline: Method 4 which is deductive method to value goods journey through all pages for agent for trader
    Given I am on the ARS Home Page with affinity group as a "Organisation" and Credential role as a "User"
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
    And I select Method 4 and continue in Select the method page
    Then I will be navigated to explain why not methods one till three
    And I enter "not applicable" as my reason why I did not select methods one till three and continue
    Then I will be navigated to Explain why you have selected Method 4
    And I enter "string" as my reason for selecting method Method 4
    Then I navigate to Description of the Goods
    And I enter "Coffee" as the description and press continue
    And I select "Yes" and continue in Tell us about the previous ruling page
    And I enter "previous ruling information" and continue
    And I select "Yes" on any other rulings that have used a similar method and continue
    And I enter "other rulings for similar goods" on about the rulings for similar goods page and continue
    And I select "No" and continue in Have you found the commodity code
    Then I will be navigated to Have the goods been subject to legal challenges
    And I select that the goods have not been subject to legal challenges
    And I select "No" and continue in Do you want to add any confidential information page
    And I select "No" and continue in Do you want to upload any supporting documents page
    Then I will be navigated to the Check Your Answers page
    And I check my answers and click on continue
    Then I will be navigated to the Application Complete page
    Examples:
      | EORINo           | EORIType  |
      | "GB112888888041" | "private" |
