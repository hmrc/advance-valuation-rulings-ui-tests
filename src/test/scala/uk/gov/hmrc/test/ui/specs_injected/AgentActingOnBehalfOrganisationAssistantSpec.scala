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

class AgentActingOnBehalfOrganisationAssistantSpec extends BaseSpec with BeforeAndAfterAll {

  // Keep a single browser session for all scenarios in this spec.
  override def beforeAll(): Unit =
    startBrowser()

  override def afterAll(): Unit =
    quitBrowser()

  override def beforeEach(): Unit = ()
  override def afterEach(): Unit = ()

  Feature("Agent Acting on Behalf of Organisation End to End Journey") {

    Scenario("Organisation Assistant End To End Journey - when Org assistant chosen") {
      Given("I am on the ARS Home Page with affinity group as a Organisation and Credential role as a Assistant")
      givenIAmOnTheARSHomePageWithAffinityGroupAsAStringAndCredentialRoleAsAString("Organisation", "Assistant")

      When("I click on Start new application in ARS Home")
        whenIClickOnStartNewApplicationInARSHome()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

      Then("I select role as a Agent acting on behalf of an organisation")
        whenISelectRoleAsAString("Agent acting on behalf of an organisation")

      And("I click continue on Information you need to complete an application page")
        andIClickContinueOnInformationYouNeedToCompleteAnApplicationPage()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

      And("I select Yes and continue in Are you planning to import goods page")
        andISelectBooleanValueAndContinueInAreYouPlanningToImportGoodsPage(true)

      And("I click on continue in How We Contact You page")
        andIClickOnContinueInHowWeContactYouPage()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

      And("I select Yes and continue in Check the name and address page for agent for org")
        andISelectBooleanValueAndContinueInCheckTheNameAndAddressPageForAgentForOrg(true)  // auto-chosen (score=0.66, StepDefinitionsSteps.scala)

      And("I enter Name: Automation Test, Email: Test@automation.com, Phone: 9876543211, Job title: Agent for Org details and continue in Provide your own contact details page")
        andIEnterNameStringEmailStringPhoneStringJobTitleStringDetailsAndContinueInProvideYourOwnContactDetailsPage("Automation Test", "Test@automation.com", "9876543211", "Agent for Org")

      And("I enter Eori: GB123412341234, CompanyName: Agent Company Name, StreetAndNumber: #1 Street and Number, City: City Upon River, Country: United Kingdom, PostalCode: PO11 1OD and continue on Your company's contact page")
        andIEnterEoriStringCompanyNameStringStreetAndNumberStringCityStringCountryStringPostalCodeStringAndContinueOnYourCompanySContactPage("GB123412341234", "Agent Company Name", "#1 Street and Number", "City Upon River", "United Kingdom", "PO11 1OD")

      And("I select Method 1 and continue in Select the method page")
        andISelectMethodIntAndContinueInSelectTheMethodPage(1)

      And("I select Yes and continue in Is There a Sale Involved")
        andISelectBooleanValueAndContinueInIsThereASaleInvolved(true)

      And("I select Yes and continue in Is the sale between related parties")
        andISelectBooleanValueAndContinueInIsTheSaleBetweenRelatedParties(true)

      And("I enter description and continue in Describe how the parties are related")
        andIEnterStringAndContinueInDescribeHowThePartiesAreRelated("description")

      And("I select Yes and continue in Are there any restrictions on the use or resale of the goods")
        andISelectBooleanValueAndContinueInAreThereAnyRestrictionsOnTheUseOrResaleOfTheGoods(true)  // auto-chosen (score=0.66, StepDefinitionsSteps.scala)

      And("I enter restrictions and continue in Describe any restrictions on the use or resale of goods")
        andIEnterStringAndContinueInDescribeAnyRestrictionsOnTheUseOrResaleOfGoods("restrictions")  // auto-chosen (score=0.66, StepDefinitionsSteps.scala)
        // --- Other possible matches ---
        // andINavigateToDescribeAnyRestrictionsOnTheUseOrResaleOfGoodsPageAndCompareTheText() [0.66] (StepDefinitionsSteps.scala) pattern: I navigate to Describe any restrictions on the use or resale of goods page and compare the text
        // andIEnterStringInDescribeAnyRestrictionsOnTheUseOrResaleOfGoods() [0.65] (StepDefinitionsSteps.scala) pattern: I enter {string} in Describe any restrictions on the use or resale of goods

      And("I select Yes and continue in Is the sale subject to any conditions or circumstances that could restrict you from valuing the goods")
        andISelectBooleanValueAndContinueInIsTheSaleSubjectToAnyConditionsOrCircumstancesThatCouldRestrictYouFromValuingTheGoods(true)  // auto-chosen (score=0.69, StepDefinitionsSteps.scala)
        // --- Other possible matches ---
        // andISelectBooleanValueAndContinueInIsTheSaleSubjectToAnyConditionsOrCircumstancesThatCouldRestrictYouFromValuingTheGoods() [0.67] (StepDefinitionsSteps.scala) pattern: I select {booleanValue} and continue in Is the sale subject to any conditions or circumstances that could restrict you from valuing the goods

      And("I enter various conditions as the conditions which cannot be calculated and press continue")
        andIEnterStringAsTheConditionsWhichCannotBeCalculatedAndPressContinue("various conditions")

      Then("I navigate to Description of the Goods")
        thenINavigateToDescriptionOfTheGoods()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

      And("I enter nice things as the description and press continue")
        andIEnterStringAsTheDescriptionAndPressContinue("nice things")

      And("I select Yes and continue in Tell us about the previous ruling page")
        andISelectBooleanValueAndContinueInTellUsAboutThePreviousRulingPage(true)

      And("I enter previous ruling information and continue")
        andIEnterStringAndContinue("previous ruling information")

      And("I select No on any other rulings that have used a similar method and continue")
        andISelectBooleanValueOnAnyOtherRulingsThatHaveUsedASimilarMethodAndContinue(false)  // auto-chosen (score=0.65, StepDefinitionsSteps.scala)

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

      And("I check my Company’s registered business name and Company’s registered business address are correct and are unable to be changed")
        andICheckMyStringAndStringAreCorrectAndAreUnableToBeChanged("Company’s registered business name", "Company’s registered business address")

      And("I check my answers and click on continue")
        andICheckMyAnswersAndClickOnContinue()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

      Then("I will be navigated to the Application Complete page")
        thenIWillBeNavigatedToTheApplicationCompletePage()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

    }

    Scenario("Organisation Assistant End To End Journey - when affinity group doesn't matter [AffinityGroup=Organisation, CredentialRole=User]") {
      Given("I am on the ARS Home Page with affinity group as a Organisation and Credential role as a User")
      givenIAmOnTheARSHomePageWithAffinityGroupAsAStringAndCredentialRoleAsAString("Organisation", "User")

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

      And("I select Yes and continue in Check the name and address page for agent for org")
        andISelectBooleanValueAndContinueInCheckTheNameAndAddressPageForAgentForOrg(true)  // auto-chosen (score=0.66, StepDefinitionsSteps.scala)

      And("I enter Name: Automation Test, Email: Test@automation.com, Phone: 9876543211, Job title: Agent for Org details and continue in Provide your own contact details page")
        andIEnterNameStringEmailStringPhoneStringJobTitleStringDetailsAndContinueInProvideYourOwnContactDetailsPage("Automation Test", "Test@automation.com", "9876543211", "Agent for Org")

      And("I enter Eori: GB123412341234, CompanyName: Agent Company Name, StreetAndNumber: #1 Street and Number, City: City Upon River, Country: United Kingdom, PostalCode: PO11 1OD and continue on Your company's contact page")
        andIEnterEoriStringCompanyNameStringStreetAndNumberStringCityStringCountryStringPostalCodeStringAndContinueOnYourCompanySContactPage("GB123412341234", "Agent Company Name", "#1 Street and Number", "City Upon River", "United Kingdom", "PO11 1OD")

      And("I select Method 1 and continue in Select the method page")
        andISelectMethodIntAndContinueInSelectTheMethodPage(1)

      And("I select Yes and continue in Is There a Sale Involved")
        andISelectBooleanValueAndContinueInIsThereASaleInvolved(true)

      And("I select Yes and continue in Is the sale between related parties")
        andISelectBooleanValueAndContinueInIsTheSaleBetweenRelatedParties(true)

      And("I enter description and continue in Describe how the parties are related")
        andIEnterStringAndContinueInDescribeHowThePartiesAreRelated("description")

      And("I select Yes and continue in Are there any restrictions on the use or resale of the goods")
        andISelectBooleanValueAndContinueInAreThereAnyRestrictionsOnTheUseOrResaleOfTheGoods(true)  // auto-chosen (score=0.66, StepDefinitionsSteps.scala)

      And("I enter restrictions and continue in Describe any restrictions on the use or resale of goods")
        andIEnterStringAndContinueInDescribeAnyRestrictionsOnTheUseOrResaleOfGoods("restrictions")  // auto-chosen (score=0.66, StepDefinitionsSteps.scala)
        // --- Other possible matches ---
        // andINavigateToDescribeAnyRestrictionsOnTheUseOrResaleOfGoodsPageAndCompareTheText() [0.66] (StepDefinitionsSteps.scala) pattern: I navigate to Describe any restrictions on the use or resale of goods page and compare the text
        // andIEnterStringInDescribeAnyRestrictionsOnTheUseOrResaleOfGoods() [0.65] (StepDefinitionsSteps.scala) pattern: I enter {string} in Describe any restrictions on the use or resale of goods

      And("I select Yes and continue in Is the sale subject to any conditions or circumstances that could restrict you from valuing the goods")
        andISelectBooleanValueAndContinueInIsTheSaleSubjectToAnyConditionsOrCircumstancesThatCouldRestrictYouFromValuingTheGoods(true)  // auto-chosen (score=0.69, StepDefinitionsSteps.scala)
        // --- Other possible matches ---
        // andISelectBooleanValueAndContinueInIsTheSaleSubjectToAnyConditionsOrCircumstancesThatCouldRestrictYouFromValuingTheGoods() [0.67] (StepDefinitionsSteps.scala) pattern: I select {booleanValue} and continue in Is the sale subject to any conditions or circumstances that could restrict you from valuing the goods

      And("I enter various conditions as the conditions which cannot be calculated and press continue")
        andIEnterStringAsTheConditionsWhichCannotBeCalculatedAndPressContinue("various conditions")

      Then("I navigate to Description of the Goods")
        thenINavigateToDescriptionOfTheGoods()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

      And("I enter nice things as the description and press continue")
        andIEnterStringAsTheDescriptionAndPressContinue("nice things")

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

      And("I check my Company’s registered business name and Company’s registered business address are correct and are unable to be changed")
        andICheckMyStringAndStringAreCorrectAndAreUnableToBeChanged("Company’s registered business name", "Company’s registered business address")

      And("I check my answers and click on continue")
        andICheckMyAnswersAndClickOnContinue()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

      Then("I will be navigated to the Application Complete page")
        thenIWillBeNavigatedToTheApplicationCompletePage()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

    }

    Scenario("Organisation Assistant End To End Journey - when affinity group doesn't matter [AffinityGroup=Individual, CredentialRole=User]") {
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

      And("I select Yes and continue in Check the name and address page for agent for org")
        andISelectBooleanValueAndContinueInCheckTheNameAndAddressPageForAgentForOrg(true)  // auto-chosen (score=0.66, StepDefinitionsSteps.scala)

      And("I enter Name: Automation Test, Email: Test@automation.com, Phone: 9876543211, Job title: Agent for Org details and continue in Provide your own contact details page")
        andIEnterNameStringEmailStringPhoneStringJobTitleStringDetailsAndContinueInProvideYourOwnContactDetailsPage("Automation Test", "Test@automation.com", "9876543211", "Agent for Org")

      And("I enter Eori: GB123412341234, CompanyName: Agent Company Name, StreetAndNumber: #1 Street and Number, City: City Upon River, Country: United Kingdom, PostalCode: PO11 1OD and continue on Your company's contact page")
        andIEnterEoriStringCompanyNameStringStreetAndNumberStringCityStringCountryStringPostalCodeStringAndContinueOnYourCompanySContactPage("GB123412341234", "Agent Company Name", "#1 Street and Number", "City Upon River", "United Kingdom", "PO11 1OD")

      And("I select Method 1 and continue in Select the method page")
        andISelectMethodIntAndContinueInSelectTheMethodPage(1)

      And("I select Yes and continue in Is There a Sale Involved")
        andISelectBooleanValueAndContinueInIsThereASaleInvolved(true)

      And("I select Yes and continue in Is the sale between related parties")
        andISelectBooleanValueAndContinueInIsTheSaleBetweenRelatedParties(true)

      And("I enter description and continue in Describe how the parties are related")
        andIEnterStringAndContinueInDescribeHowThePartiesAreRelated("description")

      And("I select Yes and continue in Are there any restrictions on the use or resale of the goods")
        andISelectBooleanValueAndContinueInAreThereAnyRestrictionsOnTheUseOrResaleOfTheGoods(true)  // auto-chosen (score=0.66, StepDefinitionsSteps.scala)

      And("I enter restrictions and continue in Describe any restrictions on the use or resale of goods")
        andIEnterStringAndContinueInDescribeAnyRestrictionsOnTheUseOrResaleOfGoods("restrictions")  // auto-chosen (score=0.66, StepDefinitionsSteps.scala)
        // --- Other possible matches ---
        // andINavigateToDescribeAnyRestrictionsOnTheUseOrResaleOfGoodsPageAndCompareTheText() [0.66] (StepDefinitionsSteps.scala) pattern: I navigate to Describe any restrictions on the use or resale of goods page and compare the text
        // andIEnterStringInDescribeAnyRestrictionsOnTheUseOrResaleOfGoods() [0.65] (StepDefinitionsSteps.scala) pattern: I enter {string} in Describe any restrictions on the use or resale of goods

      And("I select Yes and continue in Is the sale subject to any conditions or circumstances that could restrict you from valuing the goods")
        andISelectBooleanValueAndContinueInIsTheSaleSubjectToAnyConditionsOrCircumstancesThatCouldRestrictYouFromValuingTheGoods(true)  // auto-chosen (score=0.69, StepDefinitionsSteps.scala)
        // --- Other possible matches ---
        // andISelectBooleanValueAndContinueInIsTheSaleSubjectToAnyConditionsOrCircumstancesThatCouldRestrictYouFromValuingTheGoods() [0.67] (StepDefinitionsSteps.scala) pattern: I select {booleanValue} and continue in Is the sale subject to any conditions or circumstances that could restrict you from valuing the goods

      And("I enter various conditions as the conditions which cannot be calculated and press continue")
        andIEnterStringAsTheConditionsWhichCannotBeCalculatedAndPressContinue("various conditions")

      Then("I navigate to Description of the Goods")
        thenINavigateToDescriptionOfTheGoods()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

      And("I enter nice things as the description and press continue")
        andIEnterStringAsTheDescriptionAndPressContinue("nice things")

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

      And("I check my Company’s registered business name and Company’s registered business address are correct and are unable to be changed")
        andICheckMyStringAndStringAreCorrectAndAreUnableToBeChanged("Company’s registered business name", "Company’s registered business address")

      And("I check my answers and click on continue")
        andICheckMyAnswersAndClickOnContinue()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

      Then("I will be navigated to the Application Complete page")
        thenIWillBeNavigatedToTheApplicationCompletePage()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

    }

    Scenario("Organisation Assistant End To End Journey - when affinity group doesn't matter [AffinityGroup=Agent, CredentialRole=User]") {
      Given("I am on the ARS Home Page with affinity group as a Agent and Credential role as a User")
      givenIAmOnTheARSHomePageWithAffinityGroupAsAStringAndCredentialRoleAsAString("Agent", "User")

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

      And("I select Yes and continue in Check the name and address page for agent for org")
        andISelectBooleanValueAndContinueInCheckTheNameAndAddressPageForAgentForOrg(true)  // auto-chosen (score=0.66, StepDefinitionsSteps.scala)

      And("I enter Name: Automation Test, Email: Test@automation.com, Phone: 9876543211, Job title: Agent for Org details and continue in Provide your own contact details page")
        andIEnterNameStringEmailStringPhoneStringJobTitleStringDetailsAndContinueInProvideYourOwnContactDetailsPage("Automation Test", "Test@automation.com", "9876543211", "Agent for Org")

      And("I enter Eori: GB123412341234, CompanyName: Agent Company Name, StreetAndNumber: #1 Street and Number, City: City Upon River, Country: United Kingdom, PostalCode: PO11 1OD and continue on Your company's contact page")
        andIEnterEoriStringCompanyNameStringStreetAndNumberStringCityStringCountryStringPostalCodeStringAndContinueOnYourCompanySContactPage("GB123412341234", "Agent Company Name", "#1 Street and Number", "City Upon River", "United Kingdom", "PO11 1OD")

      And("I select Method 1 and continue in Select the method page")
        andISelectMethodIntAndContinueInSelectTheMethodPage(1)

      And("I select Yes and continue in Is There a Sale Involved")
        andISelectBooleanValueAndContinueInIsThereASaleInvolved(true)

      And("I select Yes and continue in Is the sale between related parties")
        andISelectBooleanValueAndContinueInIsTheSaleBetweenRelatedParties(true)

      And("I enter description and continue in Describe how the parties are related")
        andIEnterStringAndContinueInDescribeHowThePartiesAreRelated("description")

      And("I select Yes and continue in Are there any restrictions on the use or resale of the goods")
        andISelectBooleanValueAndContinueInAreThereAnyRestrictionsOnTheUseOrResaleOfTheGoods(true)  // auto-chosen (score=0.66, StepDefinitionsSteps.scala)

      And("I enter restrictions and continue in Describe any restrictions on the use or resale of goods")
        andIEnterStringAndContinueInDescribeAnyRestrictionsOnTheUseOrResaleOfGoods("restrictions")  // auto-chosen (score=0.66, StepDefinitionsSteps.scala)
        // --- Other possible matches ---
        // andINavigateToDescribeAnyRestrictionsOnTheUseOrResaleOfGoodsPageAndCompareTheText() [0.66] (StepDefinitionsSteps.scala) pattern: I navigate to Describe any restrictions on the use or resale of goods page and compare the text
        // andIEnterStringInDescribeAnyRestrictionsOnTheUseOrResaleOfGoods() [0.65] (StepDefinitionsSteps.scala) pattern: I enter {string} in Describe any restrictions on the use or resale of goods

      And("I select Yes and continue in Is the sale subject to any conditions or circumstances that could restrict you from valuing the goods")
        andISelectBooleanValueAndContinueInIsTheSaleSubjectToAnyConditionsOrCircumstancesThatCouldRestrictYouFromValuingTheGoods(true)  // auto-chosen (score=0.69, StepDefinitionsSteps.scala)
        // --- Other possible matches ---
        // andISelectBooleanValueAndContinueInIsTheSaleSubjectToAnyConditionsOrCircumstancesThatCouldRestrictYouFromValuingTheGoods() [0.67] (StepDefinitionsSteps.scala) pattern: I select {booleanValue} and continue in Is the sale subject to any conditions or circumstances that could restrict you from valuing the goods

      And("I enter various conditions as the conditions which cannot be calculated and press continue")
        andIEnterStringAsTheConditionsWhichCannotBeCalculatedAndPressContinue("various conditions")

      Then("I navigate to Description of the Goods")
        thenINavigateToDescriptionOfTheGoods()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

      And("I enter nice things as the description and press continue")
        andIEnterStringAsTheDescriptionAndPressContinue("nice things")

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

      And("I check my Company’s registered business name and Company’s registered business address are correct and are unable to be changed")
        andICheckMyStringAndStringAreCorrectAndAreUnableToBeChanged("Company’s registered business name", "Company’s registered business address")

      And("I check my answers and click on continue")
        andICheckMyAnswersAndClickOnContinue()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

      Then("I will be navigated to the Application Complete page")
        thenIWillBeNavigatedToTheApplicationCompletePage()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

    }

    Scenario("Organisation Assistant End To End Journey - when affinity group doesn't matter [AffinityGroup=Agent, CredentialRole=Assistant]") {
      Given("I am on the ARS Home Page with affinity group as a Agent and Credential role as a Assistant")
      givenIAmOnTheARSHomePageWithAffinityGroupAsAStringAndCredentialRoleAsAString("Agent", "Assistant")

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

      And("I select Yes and continue in Check the name and address page for agent for org")
        andISelectBooleanValueAndContinueInCheckTheNameAndAddressPageForAgentForOrg(true)  // auto-chosen (score=0.66, StepDefinitionsSteps.scala)

      And("I enter Name: Automation Test, Email: Test@automation.com, Phone: 9876543211, Job title: Agent for Org details and continue in Provide your own contact details page")
        andIEnterNameStringEmailStringPhoneStringJobTitleStringDetailsAndContinueInProvideYourOwnContactDetailsPage("Automation Test", "Test@automation.com", "9876543211", "Agent for Org")

      And("I enter Eori: GB123412341234, CompanyName: Agent Company Name, StreetAndNumber: #1 Street and Number, City: City Upon River, Country: United Kingdom, PostalCode: PO11 1OD and continue on Your company's contact page")
        andIEnterEoriStringCompanyNameStringStreetAndNumberStringCityStringCountryStringPostalCodeStringAndContinueOnYourCompanySContactPage("GB123412341234", "Agent Company Name", "#1 Street and Number", "City Upon River", "United Kingdom", "PO11 1OD")

      And("I select Method 1 and continue in Select the method page")
        andISelectMethodIntAndContinueInSelectTheMethodPage(1)

      And("I select Yes and continue in Is There a Sale Involved")
        andISelectBooleanValueAndContinueInIsThereASaleInvolved(true)

      And("I select Yes and continue in Is the sale between related parties")
        andISelectBooleanValueAndContinueInIsTheSaleBetweenRelatedParties(true)

      And("I enter description and continue in Describe how the parties are related")
        andIEnterStringAndContinueInDescribeHowThePartiesAreRelated("description")

      And("I select Yes and continue in Are there any restrictions on the use or resale of the goods")
        andISelectBooleanValueAndContinueInAreThereAnyRestrictionsOnTheUseOrResaleOfTheGoods(true)  // auto-chosen (score=0.66, StepDefinitionsSteps.scala)

      And("I enter restrictions and continue in Describe any restrictions on the use or resale of goods")
        andIEnterStringAndContinueInDescribeAnyRestrictionsOnTheUseOrResaleOfGoods("restrictions")  // auto-chosen (score=0.66, StepDefinitionsSteps.scala)
        // --- Other possible matches ---
        // andINavigateToDescribeAnyRestrictionsOnTheUseOrResaleOfGoodsPageAndCompareTheText() [0.66] (StepDefinitionsSteps.scala) pattern: I navigate to Describe any restrictions on the use or resale of goods page and compare the text
        // andIEnterStringInDescribeAnyRestrictionsOnTheUseOrResaleOfGoods() [0.65] (StepDefinitionsSteps.scala) pattern: I enter {string} in Describe any restrictions on the use or resale of goods

      And("I select Yes and continue in Is the sale subject to any conditions or circumstances that could restrict you from valuing the goods")
        andISelectBooleanValueAndContinueInIsTheSaleSubjectToAnyConditionsOrCircumstancesThatCouldRestrictYouFromValuingTheGoods(true)  // auto-chosen (score=0.69, StepDefinitionsSteps.scala)
        // --- Other possible matches ---
        // andISelectBooleanValueAndContinueInIsTheSaleSubjectToAnyConditionsOrCircumstancesThatCouldRestrictYouFromValuingTheGoods() [0.67] (StepDefinitionsSteps.scala) pattern: I select {booleanValue} and continue in Is the sale subject to any conditions or circumstances that could restrict you from valuing the goods

      And("I enter various conditions as the conditions which cannot be calculated and press continue")
        andIEnterStringAsTheConditionsWhichCannotBeCalculatedAndPressContinue("various conditions")

      Then("I navigate to Description of the Goods")
        thenINavigateToDescriptionOfTheGoods()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

      And("I enter nice things as the description and press continue")
        andIEnterStringAsTheDescriptionAndPressContinue("nice things")

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

      And("I check my Company’s registered business name and Company’s registered business address are correct and are unable to be changed")
        andICheckMyStringAndStringAreCorrectAndAreUnableToBeChanged("Company’s registered business name", "Company’s registered business address")

      And("I check my answers and click on continue")
        andICheckMyAnswersAndClickOnContinue()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

      Then("I will be navigated to the Application Complete page")
        thenIWillBeNavigatedToTheApplicationCompletePage()  // auto-chosen (score=1.00, StepDefinitionsSteps.scala)

    }
  }
}
