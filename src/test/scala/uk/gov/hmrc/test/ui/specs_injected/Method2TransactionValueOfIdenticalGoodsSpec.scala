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

class Method2TransactionValueOfIdenticalGoodsSpec extends BaseSpec {

  Feature("Flows for Method 2 which is based on Transaction value of identical goods") {

    Scenario("Method 2 which is based on Transaction value of identical goods where all pages answered 'yes'") {
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

      And("I select Method 2 and continue in Select the method page")
        // ⚠️ No step-def match found for: I select Method 2 and continue in Select the method page

      Then("I will be navigated to Outline Why Not Method One page")
        thenIWillBeNavigatedToOutlineWhyNotMethodOnePage()  // auto-chosen (score=1.00, MethodTwoStepDefinitionsSteps.scala)

      And("I enter not applicable as my reason why I did not select method 1")
        // ⚠️ No step-def match found for: I enter not applicable as my reason why I did not select method 1

      Then("I will be navigated to In the Past Have you used Method 1 to import any goods")
        thenIWillBeNavigatedToInThePastHaveYouUsedMethod1ToImportAnyGoods()  // auto-chosen (score=1.00, MethodTwoStepDefinitionsSteps.scala)

      And("I select that I have used Method 1 to import goods and press continue")
        andISelectThatIHaveUsedMethod1ToImportGoodsAndPressContinue()  // auto-chosen (score=1.00, MethodTwoStepDefinitionsSteps.scala)
        // --- Other possible matches ---
        // andISelectThatIHaveNotUsedMethod1ToImportGoodsAndPressContinue() [0.65] (MethodTwoStepDefinitionsSteps.scala) pattern: I select that I have not used Method 1 to import goods and press continue

      Then("I will be navigated to Describe the Identical Goods")
        thenIWillBeNavigatedToDescribeTheIdenticalGoods()  // auto-chosen (score=1.00, MethodTwoStepDefinitionsSteps.scala)

      And("I enter many details as the description of the identical goods and press continue")
        // ⚠️ No step-def match found for: I enter many details as the description of the identical goods and press continue

      Then("I navigate to Description of the Goods")
        thenINavigateToDescriptionOfTheGoods()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

    }

    Scenario("Method 2 which is based on Transaction value of identical goods: Have not used Method 1 to import identical goods in past") {
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

      And("I select Method 2 and continue in Select the method page")
        // ⚠️ No step-def match found for: I select Method 2 and continue in Select the method page

      Then("I will be navigated to Outline Why Not Method One page")
        thenIWillBeNavigatedToOutlineWhyNotMethodOnePage()  // auto-chosen (score=1.00, MethodTwoStepDefinitionsSteps.scala)

      And("I enter not applicable as my reason why I did not select method 1")
        // ⚠️ No step-def match found for: I enter not applicable as my reason why I did not select method 1

      Then("I will be navigated to In the Past Have you used Method 1 to import any goods")
        thenIWillBeNavigatedToInThePastHaveYouUsedMethod1ToImportAnyGoods()  // auto-chosen (score=1.00, MethodTwoStepDefinitionsSteps.scala)

      And("I select that I have not used Method 1 to import goods and press continue")
        andISelectThatIHaveNotUsedMethod1ToImportGoodsAndPressContinue()  // auto-chosen (score=1.00, MethodTwoStepDefinitionsSteps.scala)
        // --- Other possible matches ---
        // andISelectThatIHaveUsedMethod1ToImportGoodsAndPressContinue() [0.70] (MethodTwoStepDefinitionsSteps.scala) pattern: I select that I have used Method 1 to import goods and press continue

      Then("I will be navigated to the Select a Method page")
        thenIWillBeNavigatedToTheSelectAMethodPage()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

    }

    Scenario("Method 2: Have not used Method 1 to import identical goods in past [EORINo=GB113888888041, EORIType=public]") {
      Given("I am on the ARS Home Page with affinity group as a Individual and Credential role as a User")
        // ⚠️ No step-def match found for: I am on the ARS Home Page with affinity group as a Individual and Credential role as a User

      And("I click on Start new application in ARS Home")
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

      And("I select Method 2 and continue in Select the method page")
        // ⚠️ No step-def match found for: I select Method 2 and continue in Select the method page

      Then("I will be navigated to Outline Why Not Method One page")
        thenIWillBeNavigatedToOutlineWhyNotMethodOnePage()  // auto-chosen (score=1.00, MethodTwoStepDefinitionsSteps.scala)

      And("I enter not applicable as my reason why I did not select method 1")
        // ⚠️ No step-def match found for: I enter not applicable as my reason why I did not select method 1

      Then("I will be navigated to In the Past Have you used Method 1 to import any goods")
        thenIWillBeNavigatedToInThePastHaveYouUsedMethod1ToImportAnyGoods()  // auto-chosen (score=1.00, MethodTwoStepDefinitionsSteps.scala)

      And("I select that I have not used Method 1 to import goods and press continue")
        andISelectThatIHaveNotUsedMethod1ToImportGoodsAndPressContinue()  // auto-chosen (score=1.00, MethodTwoStepDefinitionsSteps.scala)
        // --- Other possible matches ---
        // andISelectThatIHaveUsedMethod1ToImportGoodsAndPressContinue() [0.70] (MethodTwoStepDefinitionsSteps.scala) pattern: I select that I have used Method 1 to import goods and press continue

      Then("I will be navigated to the Select a Method page")
        thenIWillBeNavigatedToTheSelectAMethodPage()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

    }

    Scenario("Method 2: Have not used Method 1 to import identical goods in past [EORINo=GB112888888041, EORIType=private]") {
      Given("I am on the ARS Home Page with affinity group as a Individual and Credential role as a User")
        // ⚠️ No step-def match found for: I am on the ARS Home Page with affinity group as a Individual and Credential role as a User

      And("I click on Start new application in ARS Home")
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

      And("I select Method 2 and continue in Select the method page")
        // ⚠️ No step-def match found for: I select Method 2 and continue in Select the method page

      Then("I will be navigated to Outline Why Not Method One page")
        thenIWillBeNavigatedToOutlineWhyNotMethodOnePage()  // auto-chosen (score=1.00, MethodTwoStepDefinitionsSteps.scala)

      And("I enter not applicable as my reason why I did not select method 1")
        // ⚠️ No step-def match found for: I enter not applicable as my reason why I did not select method 1

      Then("I will be navigated to In the Past Have you used Method 1 to import any goods")
        thenIWillBeNavigatedToInThePastHaveYouUsedMethod1ToImportAnyGoods()  // auto-chosen (score=1.00, MethodTwoStepDefinitionsSteps.scala)

      And("I select that I have not used Method 1 to import goods and press continue")
        andISelectThatIHaveNotUsedMethod1ToImportGoodsAndPressContinue()  // auto-chosen (score=1.00, MethodTwoStepDefinitionsSteps.scala)
        // --- Other possible matches ---
        // andISelectThatIHaveUsedMethod1ToImportGoodsAndPressContinue() [0.70] (MethodTwoStepDefinitionsSteps.scala) pattern: I select that I have used Method 1 to import goods and press continue

      Then("I will be navigated to the Select a Method page")
        thenIWillBeNavigatedToTheSelectAMethodPage()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

    }
  }
}
