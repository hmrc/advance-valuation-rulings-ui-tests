@EndToEndJourneyAgentsCred
@AccessibilityTestAgentsCred
Feature: Agent acting on behalf of a trader changes

  Scenario Outline: Organisation User End To End Journey without upload
    Given I am on the ARS Home Page with affinity group as a "Individual" and Credential role as a "User"
    And I click on Start new application in ARS Home
    When I select role as a <role>
    Then I verify starter checklist page for <role> is displayed
    Examples:
      | role                                        |
      | "An employee of the organisation"           |
      | "Agent acting on behalf of an organisation" |
      | "Agent acting on behalf of a trader"        |

  Scenario Outline: Agent on behalf of trader when public EORI is entered
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
    Examples:
      | EORINo            | EORIType  |
      | "GB113888888041" | "public"  |
      | "GB112888888041" | "private" |

