@SaveAsDraftAgentsCred
@RegressionAgentsCred
@EndToEndJourneyAgentsCred
Feature: Save as draft functionality for all text pages in the application journeys

  Scenario: Save as draft functionality check as Individual User End To End Journey for Method 1
    Given I am on the ARS Home Page with affinity group as a "Individual" and Credential role as a "User"
    And I click on Start new application in ARS Home
    And I select role as a "An employee of the organisation"
    And I click continue on Information you need to complete an application page
    And I select "Yes" and continue in Are you planning to import goods page
    And I click on continue in How We Contact You page
    And I select "Yes" and continue in Check the name and address page
    When I enter Name- "Automation Test" Email- "TestSaveAsDraft@automation.com",Phone- "9876543211" details
    And I click on Save as draft button
    And I am on Save as draft page and I click on your applications and rulings link
    Then I navigate to provide your contact details page and compare the text
    And I click on Continue button
    And I select Method 1 and continue in Select the method page
    And I select "Yes" and continue in Is There a Sale Involved
    And I select "Yes" and continue in Is the sale between related parties
    When I enter "description" in Describe how the parties are related
    And I click on Save as draft button
    And I am on Save as draft page and I click on your applications and rulings link
    Then I navigate to Describe how the parties are related page and compare the text
    And I click on Continue button
    And I select "Yes" and continue in Are there any restrictions on the use or resale of the goods
    When I enter "restrictions" in Describe any restrictions on the use or resale of goods
    And I click on Save as draft button
    And I am on Save as draft page and I click on your applications and rulings link
    Then I navigate to Describe any restrictions on the use or resale of goods page and compare the text
    And I click on Continue button
    And I select "Yes" and continue in Is the sale subject to any conditions or circumstances that could restrict you from valuing the goods
    When I enter "various conditions" as the conditions which cannot be calculated
    And I click on Save as draft button
    And I am on Save as draft page and I click on your applications and rulings link
    Then I navigate to Is the sale subject to any conditions or circumstances page and compare the text
    And I click on Continue button
    And I navigate to Description of the Goods
    When I enter "spices" as the description
    And I click on Save as draft button
    And I am on Save as draft page and I click on your applications and rulings link
    Then I navigate to Description of the Goods page and compare the text
    And I click on Continue button
    And I select "Yes" and continue in Have you found the commodity code
    When I enter "1234" commodity code
    And I click on Save as draft button
    And I am on Save as draft page and I click on your applications and rulings link
    Then I navigate to enter commodity code page and compare the text
    And I click on Continue button
    And I will be navigated to Have the goods been subject to legal challenges
    And I select that the goods been subject to legal challenges
    When I enter "legal challenges" in describe legal challenges page
    And I click on Save as draft button
    And I am on Save as draft page and I click on your applications and rulings link
    Then I navigate to enter legal challenges page and compare the text
    And I click on Continue button
    And I select "Yes" and continue in Do you want to add any confidential information page
    When I enter "confidential information" in describe confidential information page
    And I click on Save as draft button
    And I am on Save as draft page and I click on your applications and rulings link
    Then I navigate to describe confidential information page and compare the text
    And I click on Continue button
    And I select "No" and continue in Do you want to upload any supporting documents page
    And I will be navigated to the Check Your Answers page
    And I check my answers and click on continue
    And I will be navigated to the Application Complete page

  Scenario: Save as draft functionality check as Individual User End To End Journey for Method 2
    Given I am on the ARS Home Page with affinity group as a "Individual" and Credential role as a "User"
    And I click on Start new application in ARS Home
    And I select role as a "An employee of the organisation"
    And I click continue on Information you need to complete an application page
    And I select "Yes" and continue in Are you planning to import goods page
    And I click on continue in How We Contact You page
    And I select "Yes" and continue in Check the name and address page
    And I enter Name- "Automation Test" Email- "Test@automation.com",Phone- "9876543211" details and continue in Provide your contact details page
    And I select Method 2 and continue in Select the method page
    And I will be navigated to Outline Why Not Method One page
    And I enter "not applicable" as my reason why I did not select method 1
    And I will be navigated to In the Past Have you used Method 1 to import any goods
    And I select that I have used Method 1 to import goods and press continue
    And I will be navigated to Describe the Identical Goods
    When I enter "many details" as the description of the identical goods
    And I click on Save as draft button
    And I am on Save as draft page and I click on your applications and rulings link
    Then I navigate to describe the identical goods page and compare the text
    And I should see submitted application once I click Go to application and ruling button
    And I delete the application in draft

  Scenario: Save as draft functionality check as Individual User End To End Journey for Method 3
    Given I am on the ARS Home Page with affinity group as a "Individual" and Credential role as a "User"
    And I click on Start new application in ARS Home
    And I select role as a "An employee of the organisation"
    And I click continue on Information you need to complete an application page
    And I select "Yes" and continue in Are you planning to import goods page
    And I click on continue in How We Contact You page
    And I select "Yes" and continue in Check the name and address page
    And I enter Name- "Automation Test" Email- "Test@automation.com",Phone- "9876543211" details and continue in Provide your contact details page
    And I select Method 3 and continue in Select the method page
    When I enter a "method 1 and 2 not applicable" in explain why not method one or two page
    And I click on Save as draft button
    And I am on Save as draft page and I click on your applications and rulings link
    Then I navigate to explain why not select method one or two page and compare text
    And I click on Continue button
    And I select "Yes" and continue in Have You Used Method One In the Past 90 days
    And I will be navigated to Describe the Similar Goods page
    When I enter a "reason" in Describe the Similar Goods page
    And I click on Save as draft button
    And I am on Save as draft page and I click on your applications and rulings link
    Then I navigate to Describe the Similar Goods page and compare text
    And I should see submitted application once I click Go to application and ruling button
    And I delete the application in draft

  Scenario: Save as draft functionality check as Individual User End To End Journey for Method 4
    Given I am on the ARS Home Page with affinity group as a "Individual" and Credential role as a "User"
    And I click on Start new application in ARS Home
    And I select role as a "An employee of the organisation"
    And I click continue on Information you need to complete an application page
    And I select "Yes" and continue in Are you planning to import goods page
    And I click on continue in How We Contact You page
    And I select "Yes" and continue in Check the name and address page
    And I enter Name- "Automation Test" Email- "Test@automation.com",Phone- "9876543211" details and continue in Provide your contact details page
    And I select Method 4 and continue in Select the method page
    And I will be navigated to explain why not methods one till three
    When I enter "not applicable" as my reason why I did not select methods one till three
    And I click on Save as draft button
    And I am on Save as draft page and I click on your applications and rulings link
    Then I navigate to explain why not methods one till three page and compare text
    And I should see submitted application once I click Go to application and ruling button
    And I delete the application in draft

  Scenario: Save as draft functionality check as Individual User End To End Journey for Method 5
    Given I am on the ARS Home Page with affinity group as a "Individual" and Credential role as a "User"
    And I click on Start new application in ARS Home
    And I select role as a "An employee of the organisation"
    And I click continue on Information you need to complete an application page
    And I select "Yes" and continue in Are you planning to import goods page
    And I click on continue in How We Contact You page
    And I select "Yes" and continue in Check the name and address page
    And I enter Name- "Automation Test payal" Email- "Test1@automation.com",Phone- "9876543210" details and continue in Provide your contact details page
    And I select Method 5 and continue in Select the method page
    And I will be navigated to Why Computed Value page
    When I enter a "reason" and continue in Why Computed Value page
    And I click on Save as draft button
    And I am on Save as draft page and I click on your applications and rulings link
    Then I navigate to explain why not methods one till four page and compare text
    And I should see submitted application once I click Go to application and ruling button
    And I delete the application in draft

  Scenario: Save as draft functionality check as Individual User End To End Journey for Method 6
    Given I am on the ARS Home Page with affinity group as a "Individual" and Credential role as a "User"
    And I click on Start new application in ARS Home
    And I select role as a "An employee of the organisation"
    And I click continue on Information you need to complete an application page
    And I select "Yes" and continue in Are you planning to import goods page
    And I click on continue in How We Contact You page
    And I select "Yes" and continue in Check the name and address page
    And I enter Name- "Automation Test" Email- "Test@automation.com",Phone- "9876543211" details and continue in Provide your contact details page
    And I select Method 6 and continue in Select the method page
    And I will be navigated to explain why have you not selected Methods 1-5 to value your goods
    When I enter "various reasons" as my reason why I did not select methods 1 through 5
    And I click on Save as draft button
    And I am on Save as draft page and I click on your applications and rulings link
    Then I navigate to explain why not methods one through five page and compare text
    And I click on Continue button
    And I will be navigated to which method do you wish to adapt
    And I select Method 6 as the method I wish to adapt
    And I will be navigated to how have you used method six to value goods
    When I enter "using calculator" as my explanation of how I have used method six to value goods
    And I click on Save as draft button
    And I am on Save as draft page and I click on your applications and rulings link
    Then I navigate to explain how method 6 page and compare text
    And I should see submitted application once I click Go to application and ruling button
    And I delete the application in draft

#   @WIPFAIl
#  Scenario: Save as draft functionality check as Organisation Assistant
#    Given I am on the ARS Home Page with affinity group as a "Organisation" and Credential role as a "Assistant"
#    And I click on Start new application in ARS Home
#    And I select role as a "Agent acting on behalf of an organisation"
#    And I click continue on Information you need to complete an application page
#    And I select "Yes" and continue in Are you planning to import goods page
#    And I click on continue in How We Contact You page
#    And I select "Yes" and continue in Check the name and address page
#    And I enter Name: "Automation Test", Email: "Test@automation.com", Phone: "9876543211" details and continue in Provide your own contact details page
#    When I enter Eori: "GB12341234123", CompanyName: "Agent Company Name", StreetAndNumber: "#1 Street and Number", City: "City Upon River", Country: "GB", PostalCode: "POS CODE" on Your company's contact page
#    And I click on Save as draft button
#    And I am on Save as draft page and I click on your applications and rulings link
#    Then I navigate to agent company's contact details page and compare the text
#    And I should see submitted application once I click Go to application and ruling button
#    And I delete the application in draft





