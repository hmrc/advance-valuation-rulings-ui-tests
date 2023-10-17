Feature: Agent Acting on Behalf of Organisation End to End Journey

  @EndToEndJourney @AccessibilityTest @ZAP
  Scenario: Organisation Assistant End To End Journey - when Org assistant chosen
    Given I am on the ARS Home Page with affinity group as a "Organisation" and Credential role as a "Assistant"
    When I click on Start new application in ARS Home
    Then I select role as a "Agent acting on behalf of an organisation"
    And I click continue on Information you need to complete an application page
    And I select "Yes" and continue in Are you planning to import goods page
    And I click on continue in How We Contact You page
    And I select "Yes" and continue in Check the name and address page for agent for org
    And I enter Name: "Automation Test", Email: "Test@automation.com", Phone: "9876543211", Job title: "Agent for Org" details and continue in Provide your own contact details page
    And I enter Eori: "GB12341234123", CompanyName: "Agent Company Name", StreetAndNumber: "#1 Street and Number", City: "City Upon River", Country: "GB", PostalCode: "PO11 1OD" and continue on Your company's contact page
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

  @FunctionalTests
  Scenario: Organisation Assistant End To End Journey - when affinity group doesn't matter
    Given I am on the ARS Home Page with affinity group as a "Individual" and Credential role as a "User"
    When I click on Start new application in ARS Home
    And I select role as a "Agent acting on behalf of an organisation"
    And I click continue on Information you need to complete an application page
    And I select "Yes" and continue in Are you planning to import goods page
    And I click on continue in How We Contact You page
    And I select "Yes" and continue in Check the name and address page for agent for org
    And I enter Name: "Automation Test", Email: "Test@automation.com", Phone: "9876543211", Job title: "Agent for Org" details and continue in Provide your own contact details page
    And I enter Eori: "GB12341234123", CompanyName: "Agent Company Name", StreetAndNumber: "#1 Street and Number", City: "City Upon River", Country: "GB", PostalCode: "PO11 1OD" and continue on Your company's contact page
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