/*
 * Copyright 2026 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.ui.specs

import uk.gov.hmrc.ui.tags.AllTests
import uk.gov.hmrc.ui.specsteps.StepDefinitionsSteps._
import uk.gov.hmrc.ui.specsteps.AgentStepDefsSteps._
import uk.gov.hmrc.ui.specsteps.MethodTwoStepDefinitionsSteps._
import uk.gov.hmrc.ui.specsteps.MethodThreeStepDefinitionsSteps._
import uk.gov.hmrc.ui.specsteps.MethodFourStepDefinitionsSteps._
import uk.gov.hmrc.ui.specsteps.MethodSixStepDefinitionsSteps._
import uk.gov.hmrc.ui.specsteps.ChangeImporterRoleStepsSteps._

import uk.gov.hmrc.ui.specs.BaseSpec
import org.scalatest.BeforeAndAfterAll
import org.scalatest.matchers.should.Matchers
import org.scalatest.featurespec.AnyFeatureSpec

class KickoutJourneysSpec extends BaseSpec with BeforeAndAfterAll {

  // Keep a single browser session for all scenarios in this spec.
  override def beforeAll(): Unit =
    startBrowser()

  override def afterAll(): Unit =
    quitBrowser()

  override def beforeEach(): Unit = ()
  override def afterEach(): Unit = ()

  Feature("Kickout Journeys") {

    Scenario("User  EORI number details are incorrect for employee of the org and agent of the org [role=An employee of the organisation]", AllTests) {
      Given("I am on the ARS Home Page with affinity group as a Individual and Credential role as a User")
        givenIAmOnTheARSHomePageWithAffinityGroupAsAStringAndCredentialRoleAsAString("Individual", "User")

      When("I click on Start new application in ARS Home")
        whenIClickOnStartNewApplicationInARSHome()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

      And("I select role as a An employee of the organisation")
        whenISelectRoleAsAString("An employee of the organisation")

      And("I click continue on Information you need to complete an application page")
        andIClickContinueOnInformationYouNeedToCompleteAnApplicationPage()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

      And("I select Yes and continue in Are you planning to import goods page")
        andISelectBooleanValueAndContinueInAreYouPlanningToImportGoodsPage(true)

      And("I click on continue in How We Contact You page")
        andIClickOnContinueInHowWeContactYouPage()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

      And("I select No and continue in Check the name and address page for employee of org")
        andISelectBooleanValueAndContinueInCheckTheNameAndAddressPageForEmployeeOfOrg(false)  // auto-chosen (score=0.66, StepDefinitionsSteps.scala)

      Then("I will be navigated to Your EORI number details must be correct for An employee of the organisation to use this service")
        thenIWillBeNavigatedToYourEORINumberDetailsMustBeCorrectForStringToUseThisService("An employee of the organisation")

    }

    Scenario("User  EORI number details are incorrect for employee of the org and agent of the org [role=Agent acting on behalf of an organisation]", AllTests) {
      Given("I am on the ARS Home Page with affinity group as a Individual and Credential role as a User")
        givenIAmOnTheARSHomePageWithAffinityGroupAsAStringAndCredentialRoleAsAString("Individual", "User")

      When("I click on Start new application in ARS Home")
        whenIClickOnStartNewApplicationInARSHome()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

      And("I select role as a Agent acting on behalf of an organisation")
        whenISelectRoleAsAString("Agent acting on behalf of an organisation")

      And("I click continue on Information you need to complete an application page")
        andIClickContinueOnInformationYouNeedToCompleteAnApplicationPage()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

      And("I select Yes and continue in Are you planning to import goods page")
        andISelectBooleanValueAndContinueInAreYouPlanningToImportGoodsPage(true)

      And("I click on continue in How We Contact You page")
        andIClickOnContinueInHowWeContactYouPage()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

      And("I select No and continue in Check the name and address page for agent for org")
        andISelectBooleanValueAndContinueInCheckTheNameAndAddressPageForAgentForOrg(false)  // auto-chosen (score=0.66, StepDefinitionsSteps.scala)

      Then("I will be navigated to Your EORI number details must be correct for Agent acting on behalf of an organisation to use this service")
        thenIWillBeNavigatedToYourEORINumberDetailsMustBeCorrectForStringToUseThisService("Agent acting on behalf of an organisation")

    }

    Scenario("User does not have an enrolment to access service", AllTests) {
      Given("I am on the ARS Home Page and Login without enrolment")
        givenIAmOnTheARSHomePageAndLoginWithoutEnrolment()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

      Then("user should see subscribe to advance rulings page to enrol")
        thenUserShouldSeeSubscribeToAdvanceRulingsPageToEnrol()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

      Then("I sign out")
        thenISignOut()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

    }

    Scenario("User clicks on cancel application link with yes value", AllTests) {
      Given("I am on the ARS Home Page with affinity group as a Individual and Credential role as a User")
        givenIAmOnTheARSHomePageWithAffinityGroupAsAStringAndCredentialRoleAsAString("Individual", "User")

      And("I click on Start new application in ARS Home")
        whenIClickOnStartNewApplicationInARSHome()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

      And("I select role as a An employee of the organisation")
        whenISelectRoleAsAString("An employee of the organisation")

      And("I click continue on Information you need to complete an application page")
        andIClickContinueOnInformationYouNeedToCompleteAnApplicationPage()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

      And("I select Yes and continue in Are you planning to import goods page")
        andISelectBooleanValueAndContinueInAreYouPlanningToImportGoodsPage(true)

      And("I click on continue in How We Contact You page")
        andIClickOnContinueInHowWeContactYouPage()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

      And("I select Yes and continue in Check the name and address page for employee of org")
        andISelectBooleanValueAndContinueInCheckTheNameAndAddressPageForEmployeeOfOrg(true)  // auto-chosen (score=0.66, StepDefinitionsSteps.scala)

      And("I enter Name- Automation Test Email- TestSaveAsDraft@automation.com,Phone- 9876543211, Job title- employee of org details")
        andIEnterNameStringEmailStringPhoneStringJobTitleStringDetails("Automation Test", "TestSaveAsDraft@automation.com", "9876543211", "employee of org")

      When("I click on cancel application link")
        andIClickOnCancelApplicationLink()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

      And("I select Yes and continue on cancellation page")
        andISelectBooleanValueAndContinueOnCancellationPage(true)

      And("I click back button in the browser")
        andIClickBackButtonInTheBrowser()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

      Then("You cannot view this application page is displayed")
        thenYouCannotViewThisApplicationPageIsDisplayed()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

      And("I click on go to application and rulings page button")
        thenIClickOnGoToApplicationAndRulingsPageButton()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

    }

    Scenario("User clicks on cancel application link with no value", AllTests) {
      Given("I am on the ARS Home Page with affinity group as a Individual and Credential role as a User")
        givenIAmOnTheARSHomePageWithAffinityGroupAsAStringAndCredentialRoleAsAString("Individual", "User")

      And("I click on Start new application in ARS Home")
        whenIClickOnStartNewApplicationInARSHome()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

      And("I select role as a An employee of the organisation")
        whenISelectRoleAsAString("An employee of the organisation")

      And("I click continue on Information you need to complete an application page")
        andIClickContinueOnInformationYouNeedToCompleteAnApplicationPage()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

      And("I select Yes and continue in Are you planning to import goods page")
        andISelectBooleanValueAndContinueInAreYouPlanningToImportGoodsPage(true)

      And("I click on continue in How We Contact You page")
        andIClickOnContinueInHowWeContactYouPage()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

      And("I select Yes and continue in Check the name and address page for employee of org")
        andISelectBooleanValueAndContinueInCheckTheNameAndAddressPageForEmployeeOfOrg(true)  // auto-chosen (score=0.66, StepDefinitionsSteps.scala)

      And("I enter Name- Automation Test Email- TestSaveAsDraft@automation.com,Phone- 9876543211, Job title- employee of org details")
        andIEnterNameStringEmailStringPhoneStringJobTitleStringDetails("Automation Test", "TestSaveAsDraft@automation.com", "9876543211", "employee of org")

      When("I click on cancel application link")
        andIClickOnCancelApplicationLink()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

      And("I select No and continue on cancellation page")
        andISelectBooleanValueAndContinueOnCancellationPage(false)

      Then("I will be navigated to the Your Contact details page")
        thenIWillBeNavigatedToTheYourContactDetailsPage()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

    }

    Scenario("Agent on behalf of trader when invalid EORI is entered", AllTests) {
      Given("I am on the ARS Home Page with affinity group as a Individual and Credential role as a User")
        givenIAmOnTheARSHomePageWithAffinityGroupAsAStringAndCredentialRoleAsAString("Individual", "User")

      And("I click on Start new application in ARS Home")
        whenIClickOnStartNewApplicationInARSHome()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

      And("I select role as a Agent acting on behalf of a trader")
        whenISelectRoleAsAString("Agent acting on behalf of a trader")

      And("I click continue on Information you need to complete an application page")
        andIClickContinueOnInformationYouNeedToCompleteAnApplicationPage()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

      And("I select Yes and continue in Are you planning to import goods page")
        andISelectBooleanValueAndContinueInAreYouPlanningToImportGoodsPage(true)

      And("I click on continue in How We Contact You page")
        andIClickOnContinueInHowWeContactYouPage()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

      When("I enter EORI number GB321888888041 on Provide traders EORI number page")
        andIEnterEORINumberStringOnProvideTradersEORINumberPage("GB321888888041")

      And("I click on Save and continue button")
        andIClickOnSaveAndContinueButton()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

      Then("I verify error message for invalid EORI is displayed")
        andIVerifyErrorMessageForInvalidEORIIsDisplayed()  // auto-chosen (score=1.00, AgentStepDefsSteps.scala)

    }

    Scenario("Agent on behalf of trader enters valid EORI and selects No on check name and address page [EORINo=GB113888888041, EORIType=public]", AllTests) {
      Given("I am on the ARS Home Page with affinity group as a Individual and Credential role as a User")
        givenIAmOnTheARSHomePageWithAffinityGroupAsAStringAndCredentialRoleAsAString("Individual", "User")

      And("I click on Start new application in ARS Home")
        whenIClickOnStartNewApplicationInARSHome()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

      And("I select role as a Agent acting on behalf of a trader")
        whenISelectRoleAsAString("Agent acting on behalf of a trader")

      And("I click continue on Information you need to complete an application page")
        andIClickContinueOnInformationYouNeedToCompleteAnApplicationPage()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

      And("I select Yes and continue in Are you planning to import goods page")
        andISelectBooleanValueAndContinueInAreYouPlanningToImportGoodsPage(true)

      And("I click on continue in How We Contact You page")
        andIClickOnContinueInHowWeContactYouPage()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

      And("I enter EORI number GB113888888041 on Provide traders EORI number page")
        andIEnterEORINumberStringOnProvideTradersEORINumberPage("GB113888888041")

      And("I click on Save and continue button")
        andIClickOnSaveAndContinueButton()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

      When("I select No for public EORI on Check the name and address page")
        andISelectBooleanValueForStringEORIOnCheckTheNameAndAddressPage(false, "public")

      And("I click on Save and continue button")
        andIClickOnSaveAndContinueButton()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

      Then("I will be navigated to public kickout screen")
        thenIWillBeNavigatedToStringKickoutScreen("public")

    }

    Scenario("Agent on behalf of trader enters valid EORI and selects No on check name and address page [EORINo=GB112888888041, EORIType=private]", AllTests) {
      Given("I am on the ARS Home Page with affinity group as a Individual and Credential role as a User")
        givenIAmOnTheARSHomePageWithAffinityGroupAsAStringAndCredentialRoleAsAString("Individual", "User")

      And("I click on Start new application in ARS Home")
        whenIClickOnStartNewApplicationInARSHome()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

      And("I select role as a Agent acting on behalf of a trader")
        whenISelectRoleAsAString("Agent acting on behalf of a trader")

      And("I click continue on Information you need to complete an application page")
        andIClickContinueOnInformationYouNeedToCompleteAnApplicationPage()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

      And("I select Yes and continue in Are you planning to import goods page")
        andISelectBooleanValueAndContinueInAreYouPlanningToImportGoodsPage(true)

      And("I click on continue in How We Contact You page")
        andIClickOnContinueInHowWeContactYouPage()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

      And("I enter EORI number GB112888888041 on Provide traders EORI number page")
        andIEnterEORINumberStringOnProvideTradersEORINumberPage("GB112888888041")

      And("I click on Save and continue button")
        andIClickOnSaveAndContinueButton()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

      When("I select No for private EORI on Check the name and address page")
        andISelectBooleanValueForStringEORIOnCheckTheNameAndAddressPage(false, "private")

      And("I click on Save and continue button")
        andIClickOnSaveAndContinueButton()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

      Then("I will be navigated to private kickout screen")
        thenIWillBeNavigatedToStringKickoutScreen("private")

    }

    Scenario("User creates a Draft application when leaving journey without cancelling", AllTests) {
      Given("I am on the ARS Home Page with affinity group as a Individual and Credential role as a User")
        givenIAmOnTheARSHomePageWithAffinityGroupAsAStringAndCredentialRoleAsAString("Individual", "User")

      And("I click on Start new application in ARS Home")
        whenIClickOnStartNewApplicationInARSHome()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

      And("I select role as a An employee of the organisation")
        whenISelectRoleAsAString("An employee of the organisation")

      And("I click continue on Information you need to complete an application page")
        andIClickContinueOnInformationYouNeedToCompleteAnApplicationPage()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

      And("I select Yes and continue in Are you planning to import goods page")
        andISelectBooleanValueAndContinueInAreYouPlanningToImportGoodsPage(true)

      And("I click on continue in How We Contact You page")
        andIClickOnContinueInHowWeContactYouPage()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

      And("I select Yes and continue in Check the name and address page for employee of org")
        andISelectBooleanValueAndContinueInCheckTheNameAndAddressPageForEmployeeOfOrg(true)  // auto-chosen (score=0.66, StepDefinitionsSteps.scala)

      And("I enter Name- Automation Test Email- TestSaveAsDraft@automation.com,Phone- 9876543211, Job title- employee of org details")
        andIEnterNameStringEmailStringPhoneStringJobTitleStringDetails("Automation Test", "TestSaveAsDraft@automation.com", "9876543211", "employee of org")

      And("I click on Save and continue button")
        andIClickOnSaveAndContinueButton()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

      And("I click on go to application and rulings page button")
        thenIClickOnGoToApplicationAndRulingsPageButton()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

      And("I verify that a new draft application was created")
        andIVerifyThatANewDraftApplicationWasCreated()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

    }
  }
}
