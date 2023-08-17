#@EndToEndJourneyAgentsCred
Feature: End To End Journey

  @WIPFail
  Scenario Outline: User  EORI number details are incorrect for employee of the org and agent of the org
    Given I am on the ARS Home Page with affinity group as a "Individual" and Credential role as a "User"
    When I click on Start new application in ARS Home
    And I select role as a <role>
    And I click continue on Information you need to complete an application page
    And I select "Yes" and continue in Are you planning to import goods page
    And I click on continue in How We Contact You page
    And I select "No" and continue in Check the name and address page
    Then I will be navigated to Your EORI number details must be correct for <role> to use this service
    Examples:
      | role                                        |
      | "An employee of the organisation"           |
      | "Agent acting on behalf of an organisation" |

  @EndToEndJourneyAgentsCred
  Scenario: User does not have an enrolment to access service
    Given I am on the ARS Home Page and Login without enrolment
    Then user should see subscribe to advance rulings page to enrol
    Then I sign out

  @EndToEndJourneyAgentsCred
  Scenario: User clicks on cancel application link
    Given I am on the ARS Home Page with affinity group as a "Individual" and Credential role as a "User"
    And I click on Start new application in ARS Home
    And I select role as a "An employee of the organisation"
    And I click continue on Information you need to complete an application page
    And I select "Yes" and continue in Are you planning to import goods page
    And I click on continue in How We Contact You page
    And I select "Yes" and continue in Check the name and address page
    And I enter Name- "Automation Test" Email- "TestSaveAsDraft@automation.com",Phone- "9876543211" details
    When I click on cancel application link
    And I click on confirm button on cancellation page
    And I click back button in the browser
    Then You cannot view this application page is displayed
    And I click on go to application and rulings page button on application cancelled page

  @EndToEndJourneyAgentsCred
  Scenario: Agent on behalf of trader when invalid EORI is entered
    Given I am on the ARS Home Page with affinity group as a "Individual" and Credential role as a "User"
    And I click on Start new application in ARS Home
    And I select role as a "Agent acting on behalf of a trader"
    And I click continue on Information you need to complete an application page
    And I select "Yes" and continue in Are you planning to import goods page
    And I click on continue in How We Contact You page
    When I enter EORI number "GB321888888041" on Provide traders EORI number page
    And I click on Continue button
    Then I verify error message for invalid EORI is displayed

  @WIPFail
  Scenario Outline: Agent on behalf of trader enters valid EORI and selects No on check name and address page
    Given I am on the ARS Home Page with affinity group as a "Individual" and Credential role as a "User"
    And I click on Start new application in ARS Home
    And I select role as a "Agent acting on behalf of a trader"
    And I click continue on Information you need to complete an application page
    And I select "Yes" and continue in Are you planning to import goods page
    And I click on continue in How We Contact You page
    And I enter EORI number <EORINo> on Provide traders EORI number page
    And I click on Continue button
    When I select "No" for <EORIType> EORI on Check the name and address page
    And I click on Continue button
    Then I will be navigated to <EORIType> kickout screen
    Examples:
      | EORINo           | EORIType  |
      | "GB113888888041" | "public"  |
      | "GB112888888041" | "private" |




