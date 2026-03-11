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

class Method6FallbackMethodSpec extends BaseSpec with BeforeAndAfterAll {

  override def beforeAll(): Unit =
    startBrowser()

  override def afterAll(): Unit =
    quitBrowser()

  override def beforeEach(): Unit = ()
  override def afterEach(): Unit = ()

  Feature("Journeys for Method 6 which is Fallback method") {

    Scenario("Journey for Method 6 all pages for employee of org") {
      Given("I am on the ARS Home Page with affinity group as a Individual and Credential role as a User")
        givenIAmOnTheARSHomePageWithAffinityGroupAsAStringAndCredentialRoleAsAString("Individual", "User")

      When("I click on Start new application in ARS Home")
        whenIClickOnStartNewApplicationInARSHome()

      And("I select role as a An employee of the organisation")
        whenISelectRoleAsAString("An employee of the organisation")

      And("I click continue on Information you need to complete an application page")
        andIClickContinueOnInformationYouNeedToCompleteAnApplicationPage()

      And("I select Yes and continue in Are you planning to import goods page")
        andISelectBooleanValueAndContinueInAreYouPlanningToImportGoodsPage(true)

      And("I click on continue in How We Contact You page")
        andIClickOnContinueInHowWeContactYouPage()

      And("I select Yes and continue in Check the name and address page for employee of org")
        andISelectBooleanValueAndContinueInCheckTheNameAndAddressPageForEmployeeOfOrg(true)

      And("I enter Name- Automation Test Email- Test6@automation.com,Phone- 9876543211, Job title- Accountant details and continue in Provide your contact details page")
        andIEnterNameStringEmailStringPhoneStringJobTitleStringDetailsAndContinueInProvideYourContactDetailsPage("Automation Test", "Test6@automation.com", "9876543211", "Accountant")

      And("I select Method 6 and continue in Select the method page")
        andISelectMethodIntAndContinueInSelectTheMethodPage(6)

      Then("I will be navigated to explain why have you not selected Methods 1-5 to value your goods")
        thenIWillBeNavigatedToExplainWhyHaveYouNotSelectedMethods15ToValueYourGoods()

      And("I enter various reasons as my reason why I did not select methods 1 through 5 and continue")
        andIEnterStringAsMyReasonWhyIDidNotSelectMethods1Through5AndContinue("various reasons")

      Then("I will be navigated to which method do you wish to adapt")
        thenIWillBeNavigatedToWhichMethodDoYouWishToAdapt()

      And("I select Method 6 as the method I wish to adapt")
        andISelectMethodIntAsTheMethodIWishToAdapt(6)

      Then("I will be navigated to how have you used method six to value goods")
        thenIWillBeNavigatedToHowHaveYouUsedMethodSixToValueGoods()

      And("I enter using calculator as my explanation of how I have used method six to value goods and continue")
        andIEnterStringAsMyExplanationOfHowIHaveUsedMethodSixToValueGoodsAndContinue("using calculator")

      Then("I navigate to Description of the Goods")
        thenINavigateToDescriptionOfTheGoods()
    }

    Scenario("Agent on behalf of trader selects Method 6 all pages") {
      Given("I am on the ARS Home Page with affinity group as a Individual and Credential role as a User")
        givenIAmOnTheARSHomePageWithAffinityGroupAsAStringAndCredentialRoleAsAString("Individual", "User")

      When("I click on Start new application in ARS Home")
        whenIClickOnStartNewApplicationInARSHome()

      And("I select role as a Agent acting on behalf of a trader")
        whenISelectRoleAsAString("Agent acting on behalf of a trader")

      And("I click continue on Information you need to complete an application page")
        andIClickContinueOnInformationYouNeedToCompleteAnApplicationPage()

      And("I select Yes and continue in Are you planning to import goods page")
        andISelectBooleanValueAndContinueInAreYouPlanningToImportGoodsPage(true)

      And("I click on continue in How We Contact You page")
        andIClickOnContinueInHowWeContactYouPage()

      And("I enter EORI number GB113888888041 on Provide traders EORI number page")
        andIEnterEORINumberStringOnProvideTradersEORINumberPage("GB113888888041")

      And("I click on Save and continue button")
        andIClickOnSaveAndContinueButton()

      And("I select Yes for public EORI on Check the name and address page")
        andISelectBooleanValueForStringEORIOnCheckTheNameAndAddressPage(true, "public")

      And("I click on Save and continue button")
        andIClickOnSaveAndContinueButton()

      And("I upload the document test1.pdf and continue in Upload letter of authority page")
        andIUploadTheDocumentStringAndContinueInUploadLetterOfAuthorityPage("test1.pdf")

      And("I click on continue on Uploaded letter of authority page")
        andIClickOnContinueOnUploadedLetterOfAuthorityPage()

      And("I enter Name- Automation Test Email- Test@automation.com,Phone- 9876543211, Company name - company test, Job title - agent for trader details")
        andIEnterNameStringEmailStringPhoneStringCompanyNameStringJobTitleStringDetails("Automation Test", "Test@automation.com", "9876543211", "company test", "agent for trader")

      And("I click on Save and continue button")
        andIClickOnSaveAndContinueButton()

      And("I select Method 6 and continue in Select the method page")
        andISelectMethodIntAndContinueInSelectTheMethodPage(6)

      Then("I will be navigated to explain why have you not selected Methods 1-5 to value your goods")
        thenIWillBeNavigatedToExplainWhyHaveYouNotSelectedMethods15ToValueYourGoods()

      And("I enter various reasons as my reason why I did not select methods 1 through 5 and continue")
        andIEnterStringAsMyReasonWhyIDidNotSelectMethods1Through5AndContinue("various reasons")

      Then("I will be navigated to which method do you wish to adapt")
        thenIWillBeNavigatedToWhichMethodDoYouWishToAdapt()

      And("I select Method 6 as the method I wish to adapt")
        andISelectMethodIntAsTheMethodIWishToAdapt(6)

      Then("I will be navigated to how have you used method six to value goods")
        thenIWillBeNavigatedToHowHaveYouUsedMethodSixToValueGoods()

      And("I enter using calculator as my explanation of how I have used method six to value goods and continue")
        andIEnterStringAsMyExplanationOfHowIHaveUsedMethodSixToValueGoodsAndContinue("using calculator")

      Then("I navigate to Description of the Goods")
        thenINavigateToDescriptionOfTheGoods()

      And("I enter nice things as the description and press continue")
        andIEnterStringAsTheDescriptionAndPressContinue("nice things")

      And("I select Yes and continue in Tell us about the previous ruling page")
        andISelectBooleanValueAndContinueInTellUsAboutThePreviousRulingPage(true)

      And("I enter previous ruling information and continue")
        andIEnterStringAndContinue("previous ruling information")

      And("I select Yes on any other rulings that have used a similar method and continue")
        andISelectBooleanValueOnAnyOtherRulingsThatHaveUsedASimilarMethodAndContinue(true)

      And("I enter other rulings for similar goods on about the rulings for similar goods page and continue")
        andIEnterStringOnAboutTheRulingsForSimilarGoodsPageAndContinue("other rulings for similar goods")

      And("I select No and continue in Have you found the commodity code")
        andISelectBooleanValueAndContinueInHaveYouFoundTheCommodityCode(false)

      Then("I will be navigated to Have the goods been subject to legal challenges")
        thenIWillBeNavigatedToHaveTheGoodsBeenSubjectToLegalChallenges()

      And("I select that the goods have not been subject to legal challenges")
        andISelectThatTheGoodsHaveNotBeenSubjectToLegalChallenges()

      And("I select No and continue in Do you want to add any confidential information page")
        andISelectBooleanValueAndContinueInDoYouWantToAddAnyConfidentialInformationPage(false)

      And("I select No and continue in Do you want to upload any supporting documents page")
        andISelectBooleanValueAndContinueInDoYouWantToUploadAnySupportingDocumentsPage(false)

      Then("I will be navigated to the Check Your Answers page")
        thenIWillBeNavigatedToTheCheckYourAnswersPage()

      And("I check my Trader’s registered business name and Trader’s registered business address are correct and are unable to be changed")
        andICheckMyStringAndStringAreCorrectAndAreUnableToBeChanged("Trader’s registered business name", "Trader’s registered business address")

      And("I check my answers and click on continue")
        andICheckMyAnswersAndClickOnContinue()

      Then("I will be navigated to the Application Complete page")
        thenIWillBeNavigatedToTheApplicationCompletePage()
    }
  }
}
