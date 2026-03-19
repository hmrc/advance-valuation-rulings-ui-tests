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
import uk.gov.hmrc.ui.specsteps.ChangeImporterRoleStepsSteps._

import org.scalatest.BeforeAndAfterAll

class ChangeRoleImporterSpec extends BaseSpec with BeforeAndAfterAll {

  // Keep a single browser session for all scenarios in this spec.
  override def beforeAll(): Unit =
    startBrowser()

  override def afterAll(): Unit =
    quitBrowser()

  override def beforeEach(): Unit = ()
  override def afterEach(): Unit = ()

  Feature("A user attempts to change their importer role") {

    Scenario("User clicks change link but does not change the role", AllTests) {
      navigateToCheckYourAnswers()
      Then("I click on the change link on the check your answers page")
        andIClickOnTheChangeLinkOnTheCheckYourAnswersPage()

      Then("The page title is: Your role as an importer")
        andThePageTitleIsX("Your role as an importer")

      And("The An employee of the organisation radio has been previously selected")
        andTheAnEmployeeOfTheOrganisationRadioHasBeenPreviouslySelected()

      And("I click the continue button")
        andIClickTheContinueButton()

      Then("The page title is: Check your answers before sending your application")
        andThePageTitleIsX("Check your answers before sending your application")

    }

    Scenario("User clicks change link and changes the role but does not wish to actually change the role.", AllTests) {
      navigateToCheckYourAnswers()
      Then("I click on the change link on the check your answers page")
        andIClickOnTheChangeLinkOnTheCheckYourAnswersPage()

      Then("The page title is: Your role as an importer")
        andThePageTitleIsX("Your role as an importer")

      And("The An employee of the organisation radio has been previously selected")
        andTheAnEmployeeOfTheOrganisationRadioHasBeenPreviouslySelected()

      And("The user clicks on the Agent acting on behalf of an organisation radio")
        andTheUserClicksOnTheAgentActingOnBehalfOfAnOrganisationRadio()

      And("I click the continue button")
        andIClickTheContinueButton()

      Then("The page title is: Change your role as importer")
        andThePageTitleIsX("Change your role as importer")

      And("I click the no radio button")
        andIClickTheXRadioButton("no")

      And("I click the continue button")
        andIClickTheContinueButton()

      Then("The page title is: Your role as an importer")
        andThePageTitleIsX("Your role as an importer")

      And("The An employee of the organisation radio has been previously selected")
        andTheAnEmployeeOfTheOrganisationRadioHasBeenPreviouslySelected()

      And("I click the continue button")
        andIClickTheContinueButton()

      Then("The page title is: Check your answers before sending your application")
        andThePageTitleIsX("Check your answers before sending your application")

    }

    Scenario("User clicks change link and changes the role and successfully changes their role to 'Agent acting on behalf of an organisation'", AllTests) {
      navigateToCheckYourAnswers()
      Then("I click on the change link on the check your answers page")
        andIClickOnTheChangeLinkOnTheCheckYourAnswersPage()

      Then("The page title is: Your role as an importer")
        andThePageTitleIsX("Your role as an importer")

      And("The An employee of the organisation radio has been previously selected")
        andTheAnEmployeeOfTheOrganisationRadioHasBeenPreviouslySelected()

      And("The user clicks on the Agent acting on behalf of an organisation radio")
        andTheUserClicksOnTheAgentActingOnBehalfOfAnOrganisationRadio()

      And("I click the continue button")
        andIClickTheContinueButton()

      Then("The page title is: Change your role as importer")
        andThePageTitleIsX("Change your role as importer")

      And("I click the yes radio button")
        andIClickTheXRadioButton("yes")

      And("I click the continue button")
        andIClickTheContinueButton()

      Then("The page title is: Before you start your application")
        andThePageTitleIsX("Before you start your application")

    }

    Scenario("User returns to an application via the start application previous application page and changes the Role", AllTests) {
      navigateToCheckYourAnswers()
      And("I click on the service header")
        andIClickOnTheServiceHeader()

      Then("The page title is: Your applications")
        andThePageTitleIsX("Your applications")

      And("I click on the Continue application link")
        andIClickOnTheContinueApplicationLink()

      Then("The page title is: Your role as an importer")
        andThePageTitleIsX("Your role as an importer")

      And("The An employee of the organisation radio has been previously selected")
        andTheAnEmployeeOfTheOrganisationRadioHasBeenPreviouslySelected()

      And("I click the continue button")
        andIClickTheContinueButton()

      Then("The page title is: Before you start your application")
        andThePageTitleIsX("Before you start your application")

      Then("I click on the Back link")
        andIClickOnTheBackLink()

      Then("The page title is: Your role as an importer")
        andThePageTitleIsX("Your role as an importer")

      And("The An employee of the organisation radio has been previously selected")
        andTheAnEmployeeOfTheOrganisationRadioHasBeenPreviouslySelected()

      And("The user clicks on the Agent acting on behalf of an organisation radio")
        andTheUserClicksOnTheAgentActingOnBehalfOfAnOrganisationRadio()

      And("I click the continue button")
        andIClickTheContinueButton()

      Then("The page title is: Change your role as importer")
        andThePageTitleIsX("Change your role as importer")

      And("I click the no radio button")
        andIClickTheXRadioButton("no")

      And("I click the continue button")
        andIClickTheContinueButton()

      Then("The page title is: Your role as an importer")
        andThePageTitleIsX("Your role as an importer")

      And("The An employee of the organisation radio has been previously selected")
        andTheAnEmployeeOfTheOrganisationRadioHasBeenPreviouslySelected()

      And("The user clicks on the Agent acting on behalf of an organisation radio")
        andTheUserClicksOnTheAgentActingOnBehalfOfAnOrganisationRadio()

      And("I click the continue button")
        andIClickTheContinueButton()

      Then("The page title is: Change your role as importer")
        andThePageTitleIsX("Change your role as importer")

      And("I click the yes radio button")
        andIClickTheXRadioButton("yes")

      And("I click the continue button")
        andIClickTheContinueButton()

      Then("The page title is: Before you start your application")
        andThePageTitleIsX("Before you start your application")

    }
  }

  // Mirrors ChangeRoleImporter.feature Background: completes journey up to CYA page.
  private def navigateToCheckYourAnswers(): Unit = {
    givenIAmOnTheARSHomePageWithAffinityGroupAsAStringAndCredentialRoleAsAString("Individual", "User")
    whenIClickOnStartNewApplicationInARSHome()
    whenISelectRoleAsAString("An employee of the organisation")
    andIClickContinueOnInformationYouNeedToCompleteAnApplicationPage()
    andISelectBooleanValueAndContinueInAreYouPlanningToImportGoodsPage(true)
    andIClickOnContinueInHowWeContactYouPage()
    andISelectBooleanValueAndContinueInCheckTheNameAndAddressPageForEmployeeOfOrg(true)
    andIEnterNameStringEmailStringPhoneStringJobTitleStringDetailsAndContinueInProvideYourContactDetailsPage(
      "Automation Test",
      "Test6@automation.com",
      "9876543211",
      "Accountant"
    )
    andISelectMethodIntAndContinueInSelectTheMethodPage(1)
    andISelectBooleanValueAndContinueInIsThereASaleInvolved(true)
    andISelectBooleanValueAndContinueInIsTheSaleBetweenRelatedParties(true)
    andIEnterStringAndContinueInDescribeHowThePartiesAreRelated("description")
    andISelectBooleanValueAndContinueInAreThereAnyRestrictionsOnTheUseOrResaleOfTheGoods(true)
    andIEnterStringAndContinueInDescribeAnyRestrictionsOnTheUseOrResaleOfGoods("restrictions")
    andISelectBooleanValueAndContinueInIsTheSaleSubjectToAnyConditionsOrCircumstancesThatCouldRestrictYouFromValuingTheGoods(true)
    andIEnterStringAsTheConditionsWhichCannotBeCalculatedAndPressContinue("various conditions")
    thenINavigateToDescriptionOfTheGoods()
    andIEnterStringAsTheDescriptionAndPressContinue("nice things")
    andISelectBooleanValueAndContinueInTellUsAboutThePreviousRulingPage(true)
    andIEnterStringAndContinue("previous ruling information")
    andISelectBooleanValueOnAnyOtherRulingsThatHaveUsedASimilarMethodAndContinue(true)
    andIEnterStringOnAboutTheRulingsForSimilarGoodsPageAndContinue("other rulings for similar goods")
    andISelectBooleanValueAndContinueInHaveYouFoundTheCommodityCode(false)
    thenIWillBeNavigatedToHaveTheGoodsBeenSubjectToLegalChallenges()
    andISelectThatTheGoodsHaveNotBeenSubjectToLegalChallenges()
    andISelectBooleanValueAndContinueInDoYouWantToAddAnyConfidentialInformationPage(false)
    andISelectBooleanValueAndContinueInDoYouWantToUploadAnySupportingDocumentsPage(false)
    thenIWillBeNavigatedToTheCheckYourAnswersPage()
  }
}
