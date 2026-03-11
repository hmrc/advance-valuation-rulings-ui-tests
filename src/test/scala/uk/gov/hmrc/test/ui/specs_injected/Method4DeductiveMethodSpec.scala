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

class Method4DeductiveMethodSpec extends BaseSpec with BeforeAndAfterAll {

  // Keep a single browser session for all scenarios in this spec.
  override def beforeAll(): Unit =
    startBrowser()

  override def afterAll(): Unit =
    quitBrowser()

  override def beforeEach(): Unit = ()
  override def afterEach(): Unit = ()

  Feature("Method 4 which is deductive method to value goods flows") {

    Scenario("Method 4 which is deductive method to value goods journey all pages for employee of org") {
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

      And("I select Yes and continue in Check the name and address page for employee of org")
        andISelectBooleanValueAndContinueInCheckTheNameAndAddressPageForEmployeeOfOrg(true)  // auto-chosen (score=0.66, StepDefinitionsSteps.scala)

      And("I enter Name- Automation Test Email- Test6@automation.com,Phone- 9876543211, Job title- Accountant details and continue in Provide your contact details page")
        andIEnterNameStringEmailStringPhoneStringJobTitleStringDetailsAndContinueInProvideYourContactDetailsPage("Automation Test", "Test6@automation.com", "9876543211", "Accountant")

      And("I select Method 4 and continue in Select the method page")
        andISelectMethodIntAndContinueInSelectTheMethodPage(4)

      Then("I will be navigated to explain why not methods one till three")
        thenIWillBeNavigatedToExplainWhyNotMethodsOneTillThree()  // auto-chosen (score=1.00, MethodFourStepDefinitionsSteps.scala)
        // --- Other possible matches ---
        // thenIWillBeNavigatedToExplainWhyNotSelectMethodOneOrTwo() [0.69] (MethodThreeStepDefinitionsSteps.scala) pattern: I will be navigated to Explain Why not select method one or two

      And("I enter not applicable as my reason why I did not select methods one till three and continue")
        andIEnterStringAsMyReasonWhyIDidNotSelectMethodsOneTillThreeAndContinue("not applicable")

      Then("I will be navigated to Explain why you have selected Method 4")
        thenIWillBeNavigatedToExplainWhyYouHaveSelectedMethod4()  // auto-chosen (score=1.00, MethodFourStepDefinitionsSteps.scala)

      And("I enter string as my reason for selecting method Method 4")
        andIEnterStringAsMyReasonForSelectingMethodMethod4("reason for selecting method 4")

      Then("I navigate to Description of the Goods")
        thenINavigateToDescriptionOfTheGoods()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

      And("I enter Coffee as the description and press continue")
        andIEnterStringAsTheDescriptionAndPressContinue("Coffee")

      And("I select Yes and continue in Tell us about the previous ruling page")
        andISelectBooleanValueAndContinueInTellUsAboutThePreviousRulingPage(true)

      And("I enter previous ruling information and continue")
        andIEnterStringAndContinue("previous ruling information")

      And("I select Yes on any other rulings that have used a similar method and continue")
        andISelectBooleanValueOnAnyOtherRulingsThatHaveUsedASimilarMethodAndContinue(true)  // auto-chosen (score=0.65, StepDefinitionsSteps.scala)

      And("I enter other rulings for similar goods on about the rulings for similar goods page and continue")
        andIEnterStringOnAboutTheRulingsForSimilarGoodsPageAndContinue("other rulings for similar goods")

      And("I select No and continue in Have you found the commodity code")
        andISelectBooleanValueAndContinueInHaveYouFoundTheCommodityCode(false)

      Then("I will be navigated to Have the goods been subject to legal challenges")
        thenIWillBeNavigatedToHaveTheGoodsBeenSubjectToLegalChallenges()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

    }

    Scenario("Method 4 which is deductive method to value goods journey through all pages for agent for trader [EORINo=GB112888888041, EORIType=private]") {
      Given("I am on the ARS Home Page with affinity group as a Organisation and Credential role as a User")
        givenIAmOnTheARSHomePageWithAffinityGroupAsAStringAndCredentialRoleAsAString("Organisation", "User")

      When("I click on Start new application in ARS Home")
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

      And("I select Yes for private EORI on Check the name and address page")
        andISelectBooleanValueForStringEORIOnCheckTheNameAndAddressPage(true, "private")

      And("I click on Save and continue button")
        andIClickOnSaveAndContinueButton()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

      And("I upload the document test1.pdf and continue in Upload letter of authority page")
        andIUploadTheDocumentStringAndContinueInUploadLetterOfAuthorityPage("test1.pdf")

      And("I click on continue on Uploaded letter of authority page")
        andIClickOnContinueOnUploadedLetterOfAuthorityPage()  // auto-chosen (score=1.00, AgentStepDefsSteps.scala)

      And("I enter Name- Automation Test Email- Test@automation.com,Phone- 9876543211, Company name - company test, Job title - agent for trader details")
        andIEnterNameStringEmailStringPhoneStringCompanyNameStringJobTitleStringDetails("Automation Test", "Test@automation.com", "9876543211", "company test", "agent for trader")

      And("I click on Save and continue button")
        andIClickOnSaveAndContinueButton()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

      And("I select Method 4 and continue in Select the method page")
        andISelectMethodIntAndContinueInSelectTheMethodPage(4)

      Then("I will be navigated to explain why not methods one till three")
        thenIWillBeNavigatedToExplainWhyNotMethodsOneTillThree()  // auto-chosen (score=1.00, MethodFourStepDefinitionsSteps.scala)
        // --- Other possible matches ---
        // thenIWillBeNavigatedToExplainWhyNotSelectMethodOneOrTwo() [0.69] (MethodThreeStepDefinitionsSteps.scala) pattern: I will be navigated to Explain Why not select method one or two

      And("I enter not applicable as my reason why I did not select methods one till three and continue")
        andIEnterStringAsMyReasonWhyIDidNotSelectMethodsOneTillThreeAndContinue("not applicable")

      Then("I will be navigated to Explain why you have selected Method 4")
        thenIWillBeNavigatedToExplainWhyYouHaveSelectedMethod4()  // auto-chosen (score=1.00, MethodFourStepDefinitionsSteps.scala)

      And("I enter string as my reason for selecting method Method 4")
        andIEnterStringAsMyReasonForSelectingMethodMethod4("reason for selecting method 4")

      Then("I navigate to Description of the Goods")
        thenINavigateToDescriptionOfTheGoods()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

      And("I enter Coffee as the description and press continue")
        andIEnterStringAsTheDescriptionAndPressContinue("Coffee")

      And("I select Yes and continue in Tell us about the previous ruling page")
        andISelectBooleanValueAndContinueInTellUsAboutThePreviousRulingPage(true)

      And("I enter previous ruling information and continue")
        andIEnterStringAndContinue("previous ruling information")

      And("I select Yes on any other rulings that have used a similar method and continue")
        andISelectBooleanValueOnAnyOtherRulingsThatHaveUsedASimilarMethodAndContinue(true)  // auto-chosen (score=0.65, StepDefinitionsSteps.scala)

      And("I enter other rulings for similar goods on about the rulings for similar goods page and continue")
        andIEnterStringOnAboutTheRulingsForSimilarGoodsPageAndContinue("other rulings for similar goods")

      And("I select No and continue in Have you found the commodity code")
        andISelectBooleanValueAndContinueInHaveYouFoundTheCommodityCode(false)

      Then("I will be navigated to Have the goods been subject to legal challenges")
        thenIWillBeNavigatedToHaveTheGoodsBeenSubjectToLegalChallenges()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

      And("I select that the goods have not been subject to legal challenges")
        andISelectThatTheGoodsHaveNotBeenSubjectToLegalChallenges()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)
        // --- Other possible matches ---
        // andISelectThatTheGoodsBeenSubjectToLegalChallenges() [0.70] (StepDefinitionsSteps.scala) pattern: I select that the goods been subject to legal challenges

      And("I select No and continue in Do you want to add any confidential information page")
        andISelectBooleanValueAndContinueInDoYouWantToAddAnyConfidentialInformationPage(false)  // auto-chosen (score=0.65, StepDefinitionsSteps.scala)

      And("I select No and continue in Do you want to upload any supporting documents page")
        andISelectBooleanValueAndContinueInDoYouWantToUploadAnySupportingDocumentsPage(false)  // auto-chosen (score=0.65, StepDefinitionsSteps.scala)

      Then("I will be navigated to the Check Your Answers page")
        thenIWillBeNavigatedToTheCheckYourAnswersPage()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

      And("I check my answers and click on continue")
        andICheckMyAnswersAndClickOnContinue()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

      Then("I will be navigated to the Application Complete page")
        thenIWillBeNavigatedToTheApplicationCompletePage()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

    }
  }
}
