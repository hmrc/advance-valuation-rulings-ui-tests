@AllTests
Feature: Employee of Organisation End To End Journey

  Scenario: Organisation User End To End Journey without upload
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
    And I select "Yes" and continue in Is the sale between related parties
    And I enter "description" and continue in Describe how the parties are related
    And I select "Yes" and continue in Are there any restrictions on the use or resale of the goods
    And I enter "restrictions" and continue in Describe any restrictions on the use or resale of goods
    And I select "Yes" and continue in Is the sale subject to any conditions or circumstances that could restrict you from valuing the goods
    And I enter "various conditions" as the conditions which cannot be calculated and press continue
    Then I navigate to Description of the Goods
    And I enter "nice things" as the description and press continue
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


  Scenario Outline: Organisation User End To End Journey without upload
    Given I am on the ARS Home Page with affinity group as a <AffinityGroup> and Credential role as a <CredentialRole>
    When I click on Start new application in ARS Home
    And I select role as a "An employee of the organisation"
    And I click continue on Information you need to complete an application page
    And I select "Yes" and continue in Are you planning to import goods page
    And I click on continue in How We Contact You page
    And I select "Yes" and continue in Check the name and address page for employee of org
    And I enter Name- "Automation Test" Email- "Test6@automation.com",Phone- "9876543211", Job title- "Accountant" details and continue in Provide your contact details page
    And I select Method 1 and continue in Select the method page
    And I select "Yes" and continue in Is There a Sale Involved
    And I select "Yes" and continue in Is the sale between related parties
    And I enter "description" and continue in Describe how the parties are related
    And I select "Yes" and continue in Are there any restrictions on the use or resale of the goods
    And I enter "restrictions" and continue in Describe any restrictions on the use or resale of goods
    And I select "Yes" and continue in Is the sale subject to any conditions or circumstances that could restrict you from valuing the goods
    And I enter "various conditions" as the conditions which cannot be calculated and press continue
    Then I navigate to Description of the Goods
    And I enter "nice things" as the description and press continue
    And I select "No" and continue in Tell us about the previous ruling page
    And I select "No" on any other rulings that have used a similar method and continue
    And I select "No" and continue in Have you found the commodity code
    Then I will be navigated to Have the goods been subject to legal challenges
    And I select that the goods have not been subject to legal challenges
    And I select "No" and continue in Do you want to add any confidential information page
    And I select "No" and continue in Do you want to upload any supporting documents page
    Then I will be navigated to the Check Your Answers page
    And I check my answers and click on continue
    Then I will be navigated to the Application Complete page
    Examples:
      | AffinityGroup  | CredentialRole |
      | "Organisation" | "Assistant"    |
      | "Agent"        | "User"         |
      | "Agent"        | "Assistant"    |