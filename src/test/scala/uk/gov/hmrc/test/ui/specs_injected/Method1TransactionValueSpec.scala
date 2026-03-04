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

class Method1TransactionValueSpec extends BaseSpec {

  Feature("End To End Journey for Method 1 which is based on Transaction value of goods") {

    Scenario("Method 1 based on Transaction value short flow") {
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

      And("I select Method 1 and continue in Select the method page")
        // ⚠️ No step-def match found for: I select Method 1 and continue in Select the method page

      And("I select Yes and continue in Is There a Sale Involved")
        // ⚠️ No step-def match found for: I select Yes and continue in Is There a Sale Involved

      And("I select No and continue in Is the sale between related parties")
        // ⚠️ No step-def match found for: I select No and continue in Is the sale between related parties

      And("I select No and continue in Are there any restrictions on the use or resale of the goods")
        andISelectBooleanValueAndContinueInAreThereAnyRestrictionsOnTheUseOrResaleOfTheGoods(false)  // auto-chosen (score=0.66, StepDefinitionsSteps.scala)

      And("I select No and continue in Is the sale subject to any conditions or circumstances that could restrict you from valuing the goods")
        andINavigateToIsTheSaleSubjectToAnyConditionsOrCircumstancesPageAndCompareTheText()  // auto-chosen (score=0.69, StepDefinitionsSteps.scala)
        // --- Other possible matches ---
        // andISelectBooleanValueAndContinueInIsTheSaleSubjectToAnyConditionsOrCircumstancesThatCouldRestrictYouFromValuingTheGoods() [0.67] (StepDefinitionsSteps.scala) pattern: I select {booleanValue} and continue in Is the sale subject to any conditions or circumstances that could restrict you from valuing the goods

      Then("I navigate to Description of the Goods")
        thenINavigateToDescriptionOfTheGoods()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

    }

    Scenario("Method 1 based on Transaction value and no sale involved") {
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

      And("I select Method 1 and continue in Select the method page")
        // ⚠️ No step-def match found for: I select Method 1 and continue in Select the method page

      And("I select No and continue in Is There a Sale Involved")
        // ⚠️ No step-def match found for: I select No and continue in Is There a Sale Involved

      Then("I will be navigated to the Select a Method page")
        thenIWillBeNavigatedToTheSelectAMethodPage()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

    }

    Scenario("Employee of Org selects Method 1 based on Transaction value with full flow with multiple upload") {
      Given("I am on the ARS Home Page with affinity group as a Organisation and Credential role as a User")
        // ⚠️ No step-def match found for: I am on the ARS Home Page with affinity group as a Organisation and Credential role as a User

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

      And("I select Method 1 and continue in Select the method page")
        // ⚠️ No step-def match found for: I select Method 1 and continue in Select the method page

      And("I select Yes and continue in Is There a Sale Involved")
        // ⚠️ No step-def match found for: I select Yes and continue in Is There a Sale Involved

      And("I select Yes and continue in Is the sale between related parties")
        // ⚠️ No step-def match found for: I select Yes and continue in Is the sale between related parties

      And("I enter description and continue in Describe how the parties are related")
        // ⚠️ No step-def match found for: I enter description and continue in Describe how the parties are related

      And("I select Yes and continue in Are there any restrictions on the use or resale of the goods")
        andISelectBooleanValueAndContinueInAreThereAnyRestrictionsOnTheUseOrResaleOfTheGoods(true)  // auto-chosen (score=0.66, StepDefinitionsSteps.scala)

      And("I enter restrictions and continue in Describe any restrictions on the use or resale of goods")
        andIEnterStringAndContinueInDescribeAnyRestrictionsOnTheUseOrResaleOfGoods("")  // auto-chosen (score=0.66, StepDefinitionsSteps.scala)
        // --- Other possible matches ---
        // andINavigateToDescribeAnyRestrictionsOnTheUseOrResaleOfGoodsPageAndCompareTheText() [0.66] (StepDefinitionsSteps.scala) pattern: I navigate to Describe any restrictions on the use or resale of goods page and compare the text
        // andIEnterStringInDescribeAnyRestrictionsOnTheUseOrResaleOfGoods() [0.65] (StepDefinitionsSteps.scala) pattern: I enter {string} in Describe any restrictions on the use or resale of goods

      And("I select Yes and continue in Is the sale subject to any conditions or circumstances that could restrict you from valuing the goods")
        andINavigateToIsTheSaleSubjectToAnyConditionsOrCircumstancesPageAndCompareTheText()  // auto-chosen (score=0.69, StepDefinitionsSteps.scala)
        // --- Other possible matches ---
        // andISelectBooleanValueAndContinueInIsTheSaleSubjectToAnyConditionsOrCircumstancesThatCouldRestrictYouFromValuingTheGoods() [0.67] (StepDefinitionsSteps.scala) pattern: I select {booleanValue} and continue in Is the sale subject to any conditions or circumstances that could restrict you from valuing the goods

      And("I enter various conditions as the conditions which cannot be calculated and press continue")
        // ⚠️ No step-def match found for: I enter various conditions as the conditions which cannot be calculated and press continue

      Then("I navigate to Description of the Goods")
        thenINavigateToDescriptionOfTheGoods()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

      And("I enter nice things as the description and press continue")
        // ⚠️ No step-def match found for: I enter nice things as the description and press continue

      And("I select Yes and continue in Tell us about the previous ruling page")
        // ⚠️ No step-def match found for: I select Yes and continue in Tell us about the previous ruling page

      And("I enter previous ruling information and continue")
        // ⚠️ No step-def match found for: I enter previous ruling information and continue

      And("I select No on any other rulings that have used a similar method and continue")
        andISelectBooleanValueOnAnyOtherRulingsThatHaveUsedASimilarMethodAndContinue(false)  // auto-chosen (score=0.65, StepDefinitionsSteps.scala)

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

      And("I select Yes and continue in Do you want to upload any supporting documents page")
        andISelectBooleanValueAndContinueInDoYouWantToUploadAnySupportingDocumentsPage(true)  // auto-chosen (score=0.65, StepDefinitionsSteps.scala)

      And("I upload the document test1.pdf in Upload supporting documents page")
        // ⚠️ No step-def match found for: I upload the document test1.pdf in Upload supporting documents page

      And("I select Yes and continue in Do you want this file to be marked as confidential page")
        andISelectBooleanValueAndContinueInDoYouWantThisFileToBeMarkedAsConfidentialPage(true)  // auto-chosen (score=0.66, StepDefinitionsSteps.scala)

      Then("I will be navigated to You have uploaded supporting document")
        thenIWillBeNavigatedToYouHaveUploadedSupportingDocument()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

      Then("I select Yes on You have uploaded supporting document")
        // ⚠️ No step-def match found for: I select Yes on You have uploaded supporting document

      And("I upload the document test2.jpg in Upload supporting documents page")
        // ⚠️ No step-def match found for: I upload the document test2.jpg in Upload supporting documents page

      And("I select Yes and continue in Do you want this file to be marked as confidential page")
        andISelectBooleanValueAndContinueInDoYouWantThisFileToBeMarkedAsConfidentialPage(true)  // auto-chosen (score=0.66, StepDefinitionsSteps.scala)

      Then("I will be navigated to You have uploaded second supporting document")
        thenIWillBeNavigatedToYouHaveUploadedSecondSupportingDocument()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)
        // --- Other possible matches ---
        // thenIWillBeNavigatedToYouHaveUploadedSupportingDocument() [0.70] (StepDefinitionsSteps.scala) pattern: I will be navigated to You have uploaded supporting document

      Then("I select No on You have uploaded second supporting document")
        // ⚠️ No step-def match found for: I select No on You have uploaded second supporting document

      Then("I will be navigated to the Check Your Answers page")
        thenIWillBeNavigatedToTheCheckYourAnswersPage()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

      And("I check my Organisation’s registered business name and Organisation’s registered business address are correct and are unable to be changed")
        // ⚠️ No step-def match found for: I check my Organisation’s registered business name and Organisation’s registered business address are correct and are unable to be changed

      And("I check my answers and click on continue")
        andICheckMyAnswersAndClickOnContinue()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

      Then("I will be navigated to the Application Complete page")
        thenIWillBeNavigatedToTheApplicationCompletePage()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

    }
  }
}
