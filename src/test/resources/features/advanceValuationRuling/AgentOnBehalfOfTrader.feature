@FunctionalTests
Feature: Agent acting on behalf of a trader changes

  Scenario Outline: Agent on behalf of trader starter checklist for three roles
    Given I am on the ARS Home Page with affinity group as a "Individual" and Credential role as a "User"
    And I click on Start new application in ARS Home
    When I select role as a <role>
    Then I verify starter checklist page for <role> is displayed
    Examples:
      | role                                        |
      | "An employee of the organisation"           |
      | "Agent acting on behalf of an organisation" |
      | "Agent acting on behalf of a trader"        |


  Scenario Outline: Agent for trader when public or private EORI is entered
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
    Examples:
      | EORINo           | EORIType  |
      | "GB113888888041" | "public"  |
      | "GB112888888041" | "private" |

  @AccessibilityTest @ZAP
  Scenario Outline: Agent for trader journey for public or private EORI is entered with upload supporting documents
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
    And I enter Name- "Automation Test" Email- "Test@automation.com",Phone- "9876543211", Company name - "company test" details
    And I click on Continue button
    And I select Method 1 and continue in Select the method page
    And I select "Yes" and continue in Is There a Sale Involved
    And I select "Yes" and continue in Is the sale between related parties
    And I enter "description" and continue in Describe how the parties are related
    And I select "Yes" and continue in Are there any restrictions on the use or resale of the goods
    And I enter "restrictions" and continue in Describe any restrictions on the use or resale of goods
    And I select "Yes" and continue in Is the sale subject to any conditions or circumstances that could restrict you from valuing the goods
    And I enter "various conditions" as the conditions which cannot be calculated and press continue
    And I navigate to Description of the Goods
    And I enter "nice things" as the description and press continue
    And I select "No" and continue in Have you found the commodity code
    And I will be navigated to Have the goods been subject to legal challenges
    And I select that the goods have not been subject to legal challenges
    And I select "No" and continue in Do you want to add any confidential information page
    And I select "Yes" and continue in Do you want to upload any supporting documents page
    And I upload the document "test1.pdf" in Upload supporting documents page
    And I select "Yes" and continue in Do you want this file to be marked as confidential page
    And I will be navigated to You have uploaded supporting document
    And I select "Yes" on You have uploaded supporting document
    And I upload the document "test2.jpg" in Upload supporting documents page
    And I select "Yes" and continue in Do you want this file to be marked as confidential page
    And I will be navigated to You have uploaded second supporting document
    And I select "No" on You have uploaded second supporting document
    And I will be navigated to the Check Your Answers page
    And I check my answers and click on continue
    Then I will be navigated to the Application Complete page
    Examples:
      | EORINo           | EORIType  |
      | "GB113888888041" | "public"  |
      | "GB112888888041" | "private" |




