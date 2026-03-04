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
import org.scalatest.matchers.should.Matchers
import org.scalatest.featurespec.AnyFeatureSpec

class Method6FallbackMethodSpec extends BaseSpec {

  Feature("Journeys for Method 6 which is Fallback method") {

    Scenario("Journey for Method 6 all pages for employee of org") {
      Given("I am on the ARS Home Page with affinity group as a Individual and Credential role as a User")
        // ⚠️ No step-def match found for: I am on the ARS Home Page with affinity group as a Individual and Credential role as a User

      When("I click on Start new application in ARS Home")
        whenIClickOnStartNewApplicationInARSHome()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

      And("I select role as a An employee of the organisation")
        // ⚠️ No step-def match found for: I select role as a An employee of the organisation

      And("I click continue on Information you need to complete an application page")
        andIClickContinueOnInformationYouNeedToCompleteAnApplicationPage()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

      And("I select Yes and continue in Are you planning to import goods page")
        // ⚠️ No step-def match found for: I select Yes and continue in Are you planning to import goods page

      And("I click on continue in How We Contact You page")
        andIClickOnContinueInHowWeContactYouPage()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

      And("I select Yes and continue in Check the name and address page for employee of org")
        andISelectBooleanValueAndContinueInCheckTheNameAndAddressPageForEmployeeOfOrg(true)  // auto-chosen (score=0.66, StepDefinitionsSteps.scala)

      And("I enter Name- Automation Test Email- Test6@automation.com,Phone- 9876543211, Job title- Accountant details and continue in Provide your contact details page")
        // ⚠️ No step-def match found for: I enter Name- Automation Test Email- Test6@automation.com,Phone- 9876543211, Job title- Accountant details and continue in Provide your contact details page

      And("I select Method 6 and continue in Select the method page")
        // ⚠️ No step-def match found for: I select Method 6 and continue in Select the method page

      Then("I will be navigated to explain why have you not selected Methods 1-5 to value your goods")
        thenIWillBeNavigatedToExplainWhyHaveYouNotSelectedMethods15ToValueYourGoods()  // auto-chosen (score=0.85, MethodSixStepDefinitionsSteps.scala)
        // --- Other possible matches ---
        // thenIWillBeNavigatedToExplainWhyYouHaveSelectedMethod4() [0.79] (MethodFourStepDefinitionsSteps.scala) pattern: I will be navigated to Explain why you have selected Method 4
        // thenIWillBeNavigatedToExplainWhyNotSelectMethodOneOrTwo() [0.69] (MethodThreeStepDefinitionsSteps.scala) pattern: I will be navigated to Explain Why not select method one or two
        // thenIWillBeNavigatedToExplainWhyNotMethodsOneTillThree() [0.67] (MethodFourStepDefinitionsSteps.scala) pattern: I will be navigated to explain why not methods one till three

      And("I enter various reasons as my reason why I did not select methods 1 through 5 and continue")
        andIEnterStringAsMyReasonWhyIDidNotSelectMethods1Through5AndContinue("")  // auto-chosen (score=0.66, MethodSixStepDefinitionsSteps.scala)
        // --- Other possible matches ---
        // andIEnterStringAsMyReasonWhyIDidNotSelectMethods1Through5() [0.65] (MethodSixStepDefinitionsSteps.scala) pattern: I enter {string} as my reason why I did not select methods 1 through 5

      Then("I will be navigated to which method do you wish to adapt")
        thenIWillBeNavigatedToWhichMethodDoYouWishToAdapt()  // auto-chosen (score=1.00, MethodSixStepDefinitionsSteps.scala)

      And("I select Method 6 as the method I wish to adapt")
        // ⚠️ No step-def match found for: I select Method 6 as the method I wish to adapt

      Then("I will be navigated to how have you used method six to value goods")
        thenIWillBeNavigatedToHowHaveYouUsedMethodSixToValueGoods()  // auto-chosen (score=1.00, MethodSixStepDefinitionsSteps.scala)

      And("I enter using calculator as my explanation of how I have used method six to value goods and continue")
        andIEnterStringAsMyExplanationOfHowIHaveUsedMethodSixToValueGoodsAndContinue("")  // auto-chosen (score=0.86, MethodSixStepDefinitionsSteps.scala)
        // --- Other possible matches ---
        // andIEnterStringAsMyExplanationOfHowIHaveUsedMethodSixToValueGoods() [0.86] (MethodSixStepDefinitionsSteps.scala) pattern: I enter {string} as my explanation of how I have used method six to value goods
        // thenIWillBeNavigatedToHowHaveYouUsedMethodSixToValueGoods() [0.65] (MethodSixStepDefinitionsSteps.scala) pattern: I will be navigated to how have you used method six to value goods

      Then("I navigate to Description of the Goods")
        thenINavigateToDescriptionOfTheGoods()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

    }

    Scenario("Agent on behalf of trader selects Method 6 all pages") {
      Given("I am on the ARS Home Page with affinity group as a Agent and Credential role as a Assistant")
        // ⚠️ No step-def match found for: I am on the ARS Home Page with affinity group as a Agent and Credential role as a Assistant

      When("I click on Start new application in ARS Home")
        whenIClickOnStartNewApplicationInARSHome()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

      And("I select role as a Agent acting on behalf of a trader")
        // ⚠️ No step-def match found for: I select role as a Agent acting on behalf of a trader

      And("I click continue on Information you need to complete an application page")
        andIClickContinueOnInformationYouNeedToCompleteAnApplicationPage()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

      And("I select Yes and continue in Are you planning to import goods page")
        // ⚠️ No step-def match found for: I select Yes and continue in Are you planning to import goods page

      And("I click on continue in How We Contact You page")
        andIClickOnContinueInHowWeContactYouPage()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

      And("I enter EORI number GB113888888041 on Provide traders EORI number page")
        // ⚠️ No step-def match found for: I enter EORI number GB113888888041 on Provide traders EORI number page

      And("I click on Save and continue button")
        andIClickOnSaveAndContinueButton()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

      And("I select Yes for public EORI on Check the name and address page")
        // ⚠️ No step-def match found for: I select Yes for public EORI on Check the name and address page

      And("I click on Save and continue button")
        andIClickOnSaveAndContinueButton()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

      And("I upload the document test1.pdf and continue in Upload letter of authority page")
        // ⚠️ No step-def match found for: I upload the document test1.pdf and continue in Upload letter of authority page

      And("I click on continue on Uploaded letter of authority page")
        andIClickOnContinueOnUploadedLetterOfAuthorityPage()  // auto-chosen (score=1.00, AgentStepDefsSteps.scala)

      And("I enter Name- Automation Test Email- Test@automation.com,Phone- 9876543211, Company name - company test, Job title - agent for trader details")
        // ⚠️ No step-def match found for: I enter Name- Automation Test Email- Test@automation.com,Phone- 9876543211, Company name - company test, Job title - agent for trader details

      And("I click on Save and continue button")
        andIClickOnSaveAndContinueButton()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

      And("I select Method 6 and continue in Select the method page")
        // ⚠️ No step-def match found for: I select Method 6 and continue in Select the method page

      Then("I will be navigated to explain why have you not selected Methods 1-5 to value your goods")
        thenIWillBeNavigatedToExplainWhyHaveYouNotSelectedMethods15ToValueYourGoods()  // auto-chosen (score=0.85, MethodSixStepDefinitionsSteps.scala)
        // --- Other possible matches ---
        // thenIWillBeNavigatedToExplainWhyYouHaveSelectedMethod4() [0.79] (MethodFourStepDefinitionsSteps.scala) pattern: I will be navigated to Explain why you have selected Method 4
        // thenIWillBeNavigatedToExplainWhyNotSelectMethodOneOrTwo() [0.69] (MethodThreeStepDefinitionsSteps.scala) pattern: I will be navigated to Explain Why not select method one or two
        // thenIWillBeNavigatedToExplainWhyNotMethodsOneTillThree() [0.67] (MethodFourStepDefinitionsSteps.scala) pattern: I will be navigated to explain why not methods one till three

      And("I enter various reasons as my reason why I did not select methods 1 through 5 and continue")
        andIEnterStringAsMyReasonWhyIDidNotSelectMethods1Through5AndContinue("")  // auto-chosen (score=0.66, MethodSixStepDefinitionsSteps.scala)
        // --- Other possible matches ---
        // andIEnterStringAsMyReasonWhyIDidNotSelectMethods1Through5() [0.65] (MethodSixStepDefinitionsSteps.scala) pattern: I enter {string} as my reason why I did not select methods 1 through 5

      Then("I will be navigated to which method do you wish to adapt")
        thenIWillBeNavigatedToWhichMethodDoYouWishToAdapt()  // auto-chosen (score=1.00, MethodSixStepDefinitionsSteps.scala)

      And("I select Method 6 as the method I wish to adapt")
        // ⚠️ No step-def match found for: I select Method 6 as the method I wish to adapt

      Then("I will be navigated to how have you used method six to value goods")
        thenIWillBeNavigatedToHowHaveYouUsedMethodSixToValueGoods()  // auto-chosen (score=1.00, MethodSixStepDefinitionsSteps.scala)

      And("I enter using calculator as my explanation of how I have used method six to value goods and continue")
        andIEnterStringAsMyExplanationOfHowIHaveUsedMethodSixToValueGoodsAndContinue("")  // auto-chosen (score=0.86, MethodSixStepDefinitionsSteps.scala)
        // --- Other possible matches ---
        // andIEnterStringAsMyExplanationOfHowIHaveUsedMethodSixToValueGoods() [0.86] (MethodSixStepDefinitionsSteps.scala) pattern: I enter {string} as my explanation of how I have used method six to value goods
        // thenIWillBeNavigatedToHowHaveYouUsedMethodSixToValueGoods() [0.65] (MethodSixStepDefinitionsSteps.scala) pattern: I will be navigated to how have you used method six to value goods

      Then("I navigate to Description of the Goods")
        thenINavigateToDescriptionOfTheGoods()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

      And("I enter nice things as the description and press continue")
        // ⚠️ No step-def match found for: I enter nice things as the description and press continue

      And("I select Yes and continue in Tell us about the previous ruling page")
        // ⚠️ No step-def match found for: I select Yes and continue in Tell us about the previous ruling page

      And("I enter previous ruling information and continue")
        // ⚠️ No step-def match found for: I enter previous ruling information and continue

      And("I select Yes on any other rulings that have used a similar method and continue")
        andISelectBooleanValueOnAnyOtherRulingsThatHaveUsedASimilarMethodAndContinue(true)  // auto-chosen (score=0.65, StepDefinitionsSteps.scala)

      And("I enter other rulings for similar goods on about the rulings for similar goods page and continue")
        // ⚠️ No step-def match found for: I enter other rulings for similar goods on about the rulings for similar goods page and continue

      And("I select No and continue in Have you found the commodity code")
        // ⚠️ No step-def match found for: I select No and continue in Have you found the commodity code

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

      And("I check my Trader’s registered business name and Trader’s registered business address are correct and are unable to be changed")
        // ⚠️ No step-def match found for: I check my Trader’s registered business name and Trader’s registered business address are correct and are unable to be changed

      And("I check my answers and click on continue")
        andICheckMyAnswersAndClickOnContinue()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

      Then("I will be navigated to the Application Complete page")
        thenIWillBeNavigatedToTheApplicationCompletePage()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

    }
  }
}
