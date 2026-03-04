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

class Method3TransactionValueOfSimilarGoodsSpec extends BaseSpec {

  Feature("Method 3 flows which is based on Transaction value of similar goods") {

    Scenario("Employee of the org selects Method 3 which is based on Transaction value of similar goods") {
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

      And("I select Method 3 and continue in Select the method page")
        // ⚠️ No step-def match found for: I select Method 3 and continue in Select the method page

      Then("I will be navigated to Explain Why not select method one or two")
        thenIWillBeNavigatedToExplainWhyNotSelectMethodOneOrTwo()  // auto-chosen (score=1.00, MethodThreeStepDefinitionsSteps.scala)
        // --- Other possible matches ---
        // thenIWillBeNavigatedToExplainWhyNotMethodsOneTillThree() [0.67] (MethodFourStepDefinitionsSteps.scala) pattern: I will be navigated to explain why not methods one till three

      And("I enter a reason and continue in Explain why not method one or two page")
        andIEnterAReasonAndContinueInExplainWhyNotMethodOneOrTwoPage()  // auto-chosen (score=1.00, MethodThreeStepDefinitionsSteps.scala)
        // --- Other possible matches ---
        // andIEnterAStringInExplainWhyNotMethodOneOrTwoPage() [0.80] (MethodThreeStepDefinitionsSteps.scala) pattern: I enter a {string} in explain why not method one or two page
        // andIEnterAReasonAndContinueInExplainReasonComputedValuePage() [0.73] (StepDefinitionsSteps.scala) pattern: I enter a reason and continue in Explain Reason Computed Value page

      And("I select Yes and continue in Have You Used Method One In the Past 90 days")
        andISelectBooleanValueAndContinueInHaveYouUsedMethodOneInThePast90Days(true)  // auto-chosen (score=0.66, MethodThreeStepDefinitionsSteps.scala)

      Then("I will be navigated to Describe the Similar Goods page")
        thenIWillBeNavigatedToDescribeTheSimilarGoodsPage()  // auto-chosen (score=1.00, MethodThreeStepDefinitionsSteps.scala)
        // --- Other possible matches ---
        // thenINavigateToDescribeTheSimilarGoodsPageAndCompareText() [0.66] (MethodThreeStepDefinitionsSteps.scala) pattern: I navigate to Describe the Similar Goods page and compare text

      And("I enter a reason and continue in Describe the Similar Goods page")
        andIEnterAReasonAndContinueInDescribeTheSimilarGoodsPage()  // auto-chosen (score=1.00, MethodThreeStepDefinitionsSteps.scala)

    }

    Scenario("Employee of org selects Method 3: Have not used Method 1 to import similar goods in past") {
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

      And("I select Method 3 and continue in Select the method page")
        // ⚠️ No step-def match found for: I select Method 3 and continue in Select the method page

      Then("I will be navigated to Explain Why not select method one or two")
        thenIWillBeNavigatedToExplainWhyNotSelectMethodOneOrTwo()  // auto-chosen (score=1.00, MethodThreeStepDefinitionsSteps.scala)
        // --- Other possible matches ---
        // thenIWillBeNavigatedToExplainWhyNotMethodsOneTillThree() [0.67] (MethodFourStepDefinitionsSteps.scala) pattern: I will be navigated to explain why not methods one till three

      And("I enter a reason and continue in Explain why not method one or two page")
        andIEnterAReasonAndContinueInExplainWhyNotMethodOneOrTwoPage()  // auto-chosen (score=1.00, MethodThreeStepDefinitionsSteps.scala)
        // --- Other possible matches ---
        // andIEnterAStringInExplainWhyNotMethodOneOrTwoPage() [0.80] (MethodThreeStepDefinitionsSteps.scala) pattern: I enter a {string} in explain why not method one or two page
        // andIEnterAReasonAndContinueInExplainReasonComputedValuePage() [0.73] (StepDefinitionsSteps.scala) pattern: I enter a reason and continue in Explain Reason Computed Value page

      And("I select No and continue in Have You Used Method One In the Past 90 days")
        andISelectBooleanValueAndContinueInHaveYouUsedMethodOneInThePast90Days(false)  // auto-chosen (score=0.66, MethodThreeStepDefinitionsSteps.scala)

      Then("I will be navigated to the Select a Method page")
        thenIWillBeNavigatedToTheSelectAMethodPage()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

    }

    Scenario("Agent on behalf of trader selects Method 3 which is based on Transaction value of similar goods [EORINo=GB113888888041, EORIType=public]") {
      Given("I am on the ARS Home Page with affinity group as a Individual and Credential role as a User")
        // ⚠️ No step-def match found for: I am on the ARS Home Page with affinity group as a Individual and Credential role as a User

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

      And("I select Method 3 and continue in Select the method page")
        // ⚠️ No step-def match found for: I select Method 3 and continue in Select the method page

      Then("I will be navigated to Explain Why not select method one or two")
        thenIWillBeNavigatedToExplainWhyNotSelectMethodOneOrTwo()  // auto-chosen (score=1.00, MethodThreeStepDefinitionsSteps.scala)
        // --- Other possible matches ---
        // thenIWillBeNavigatedToExplainWhyNotMethodsOneTillThree() [0.67] (MethodFourStepDefinitionsSteps.scala) pattern: I will be navigated to explain why not methods one till three

      And("I enter a reason and continue in Explain why not method one or two page")
        andIEnterAReasonAndContinueInExplainWhyNotMethodOneOrTwoPage()  // auto-chosen (score=1.00, MethodThreeStepDefinitionsSteps.scala)
        // --- Other possible matches ---
        // andIEnterAStringInExplainWhyNotMethodOneOrTwoPage() [0.80] (MethodThreeStepDefinitionsSteps.scala) pattern: I enter a {string} in explain why not method one or two page
        // andIEnterAReasonAndContinueInExplainReasonComputedValuePage() [0.73] (StepDefinitionsSteps.scala) pattern: I enter a reason and continue in Explain Reason Computed Value page

      And("I select Yes and continue in Have You Used Method One In the Past 90 days")
        andISelectBooleanValueAndContinueInHaveYouUsedMethodOneInThePast90Days(true)  // auto-chosen (score=0.66, MethodThreeStepDefinitionsSteps.scala)

      Then("I will be navigated to Describe the Similar Goods page")
        thenIWillBeNavigatedToDescribeTheSimilarGoodsPage()  // auto-chosen (score=1.00, MethodThreeStepDefinitionsSteps.scala)
        // --- Other possible matches ---
        // thenINavigateToDescribeTheSimilarGoodsPageAndCompareText() [0.66] (MethodThreeStepDefinitionsSteps.scala) pattern: I navigate to Describe the Similar Goods page and compare text

      And("I enter a reason and continue in Describe the Similar Goods page")
        andIEnterAReasonAndContinueInDescribeTheSimilarGoodsPage()  // auto-chosen (score=1.00, MethodThreeStepDefinitionsSteps.scala)

    }

    Scenario("Agent on behalf of trader selects Method 3 which is based on Transaction value of similar goods [EORINo=GB112888888041, EORIType=private]") {
      Given("I am on the ARS Home Page with affinity group as a Individual and Credential role as a User")
        // ⚠️ No step-def match found for: I am on the ARS Home Page with affinity group as a Individual and Credential role as a User

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

      And("I enter EORI number GB112888888041 on Provide traders EORI number page")
        // ⚠️ No step-def match found for: I enter EORI number GB112888888041 on Provide traders EORI number page

      And("I click on Save and continue button")
        andIClickOnSaveAndContinueButton()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

      And("I select Yes for private EORI on Check the name and address page")
        // ⚠️ No step-def match found for: I select Yes for private EORI on Check the name and address page

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

      And("I select Method 3 and continue in Select the method page")
        // ⚠️ No step-def match found for: I select Method 3 and continue in Select the method page

      Then("I will be navigated to Explain Why not select method one or two")
        thenIWillBeNavigatedToExplainWhyNotSelectMethodOneOrTwo()  // auto-chosen (score=1.00, MethodThreeStepDefinitionsSteps.scala)
        // --- Other possible matches ---
        // thenIWillBeNavigatedToExplainWhyNotMethodsOneTillThree() [0.67] (MethodFourStepDefinitionsSteps.scala) pattern: I will be navigated to explain why not methods one till three

      And("I enter a reason and continue in Explain why not method one or two page")
        andIEnterAReasonAndContinueInExplainWhyNotMethodOneOrTwoPage()  // auto-chosen (score=1.00, MethodThreeStepDefinitionsSteps.scala)
        // --- Other possible matches ---
        // andIEnterAStringInExplainWhyNotMethodOneOrTwoPage() [0.80] (MethodThreeStepDefinitionsSteps.scala) pattern: I enter a {string} in explain why not method one or two page
        // andIEnterAReasonAndContinueInExplainReasonComputedValuePage() [0.73] (StepDefinitionsSteps.scala) pattern: I enter a reason and continue in Explain Reason Computed Value page

      And("I select Yes and continue in Have You Used Method One In the Past 90 days")
        andISelectBooleanValueAndContinueInHaveYouUsedMethodOneInThePast90Days(true)  // auto-chosen (score=0.66, MethodThreeStepDefinitionsSteps.scala)

      Then("I will be navigated to Describe the Similar Goods page")
        thenIWillBeNavigatedToDescribeTheSimilarGoodsPage()  // auto-chosen (score=1.00, MethodThreeStepDefinitionsSteps.scala)
        // --- Other possible matches ---
        // thenINavigateToDescribeTheSimilarGoodsPageAndCompareText() [0.66] (MethodThreeStepDefinitionsSteps.scala) pattern: I navigate to Describe the Similar Goods page and compare text

      And("I enter a reason and continue in Describe the Similar Goods page")
        andIEnterAReasonAndContinueInDescribeTheSimilarGoodsPage()  // auto-chosen (score=1.00, MethodThreeStepDefinitionsSteps.scala)

    }
  }
}
