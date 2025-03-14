/*
 * Copyright 2025 HM Revenue & Customs
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

package uk.gov.hmrc.test.ui.cucumber.stepdefs

import org.openqa.selenium.By
import org.openqa.selenium.support.ui.ExpectedConditions
import uk.gov.hmrc.test.ui.pages.RequiredInformationPage.{clickCancelApplicationLink, onPage, submitPage}
import uk.gov.hmrc.test.ui.pages._
import uk.gov.hmrc.test.ui.pages.base.BasePage.{baseUrl, titleSuffix}
import uk.gov.hmrc.test.ui.pages.base.{BasePage, ScenarioContext}

class StepDefinitions
    extends BaseStepDef
    with MethodTwoStepDefinitions
    with MethodThreeStepDefinitions
    with MethodFourStepDefinitions
    with MethodSixStepDefinitions
    with AgentStepDefs
    with ChangeImporterRoleSteps {

  var draftId = ""

  Given(
    "I am on the ARS Home Page with affinity group as a {string} and Credential role as a {string}"
  )((affinityGroup: String, credentialRole: String) =>
    BasePage.invokeURL(BasePage.URL_ARSHomePage, affinityGroup, credentialRole)
  )

  Given("I have accepted additional cookies") { () =>
    driver
      .findElement(By.cssSelector("body > div > div > div.cbanner-govuk-button-group > button:nth-child(1)"))
      .click()
  }

  Given("I am on the ARS Home Page and Login without enrolment") { () =>
    BasePage.invokeURL(BasePage.URL_ARSHomePage, "Individual", "User", hasEnrolment = false)
  }

  Then("user should see subscribe to advance rulings page to enrol") { () =>
    driver.getTitle.contains(
      "Subscribe to advance rulings - Subscribe to advance rulings - GOV.UK"
    )
  }

  When("I click on Start new application in ARS Home") { () =>
    onPage(base.BasePage.arsHomePageText)
    submitPage()
    val draftPattern = """(DRAFT\d+)""".r
    val url          = driver.getCurrentUrl
    draftPattern.findFirstIn(url) match {
      case Some(draft) =>
        draftId = draft
      case _           => throw new IllegalArgumentException("No Draft Id created within the new application")
    }
  }

  And("I verify that a new draft application was created") { () =>
    base.BasePage.getLastDraftCreated() shouldBe draftId
  }

  And("I click continue on Information you need to complete an application page") { () =>
    RequiredInformationPage.loadPage()
    submitPage()
  }

  And("I select {booleanValue} and continue in Are you planning to import goods page") { (option: Boolean) =>
    PlanningToImportGoods.loadPage()
    PlanningToImportGoods.select(option)
    submitPage()
  }

  And("I click on continue in How We Contact You page") { () =>
    HowWeContactYou.loadPage()
    submitPage()
  }

  And("I select {booleanValue} and continue in Check the name and address page for agent for org") {
    (option: Boolean) =>
      AddressPageForAgentForOrg.loadPage().select(option).submitPage()
  }

  And("I select {booleanValue} and continue in Check the name and address page for employee of org") {
    (option: Boolean) =>
      AddressPageForEmployeeOfOrg.loadPage().select(option).submitPage()
  }

  And("I select {booleanValue} and continue in Have you found the commodity code") { (option: Boolean) =>
    HaveYouFoundTheCommodityCode.loadPage().select(option).submitPage()
  }

  And("I enter {string} commodity code") { (commodityCode: String) =>
    WhatIsTheCommodityCode.enterCommodityCode(commodityCode)
    ScenarioContext.setContext("commodity code", commodityCode)
  }

  Then("I navigate to enter commodity code page and compare the text") { () =>
    val url = s"$baseUrl/advance-valuation-ruling/" + draftId + WhatIsTheCommodityCode.redirectUrl
    driver.get(url)
    assert(ScenarioContext.getContext("commodity code") == WhatIsTheCommodityCode.getCommodityCode)
  }

  And(
    "I select {booleanValue} and continue in Do you want to add any confidential information page"
  ) { (option: Boolean) =>
    DoYouWantToAddAnyConfidentialInformation
      .loadPage()
      .select(option)
      .submitPage()
  }

  And("I enter {string} in describe confidential information page") { (confidentialInformationText: String) =>
    DescriptionConfidentialInformation.loadPage().enterText(confidentialInformationText)
    ScenarioContext.setContext("confidential information", confidentialInformationText)
  }

  Then("I navigate to describe confidential information page and compare the text") { () =>
    val url = s"$baseUrl/advance-valuation-ruling/" + draftId + DescriptionConfidentialInformation.redirectUrl
    driver.get(url)
    assert(ScenarioContext.getContext("confidential information") == DescriptionConfidentialInformation.getText)
  }

  And(
    "I select {booleanValue} on You have uploaded supporting document"
  ) { (option: Boolean) =>
    if (ScenarioContext.getContext("Description Of Role") == BasePage.agentForTrader) {
      UploadedOneSupportingDocumentForAgentForTrader
        .loadPage()
        .select(option)
        .submitPage()
    } else {
      UploadedOneSupportingDocumentForEmployeeAndAgentOfOrg
        .loadPage()
        .select(option)
        .submitPage()
    }
  }

  And(
    "I select {booleanValue} on You have uploaded second supporting document"
  ) { (option: Boolean) =>
    if (ScenarioContext.getContext("Description Of Role") == BasePage.agentForTrader) {
      UploadedTwoSupportingDocumentsForAgentForTrader
        .loadPage()
        .select(option)
        .submitPage()
    } else {
      UploadedTwoSupportingDocumentsForEmployeeAndAgentOfOrg
        .loadPage()
        .select(option)
        .submitPage()
    }
  }

  And("I select {booleanValue} and continue in Do you want to upload any supporting documents page") {
    (option: Boolean) =>
      DoYouWantToUploadAnySupportingDocuments
        .loadPage()
        .select(option)
        .submitPage()
  }

  And("I upload the document {string} in Upload supporting documents page") { (filePath: String) =>
    val path = getClass.getResource(s"/testdata/$filePath").toURI.getPath
    UploadSupportingDocuments
      .loadPage()
      .uploadDocument(path)
    DoYouWantThisFileToBeMarkedAsConfidential.pollingClickAttempt()
  }

  And(
    "I enter Name- {string} Email- {string},Phone- {string}, Job title- {string} details and continue in Provide your contact details page"
  ) { (name: String, email: String, phone: String, jobTitle: String) =>
    ProvideYourContactDetails.loadPage()
    ProvideYourContactDetails.enterContactDetails(name, email, phone, jobTitle)
    submitPage()
  }

  And(
    "I enter Name- {string} Email- {string},Phone- {string}, Job title- {string} details"
  ) { (name: String, email: String, phone: String, jobTitle: String) =>
    ProvideYourContactDetails.loadPage()
    ProvideYourContactDetails.enterContactDetails(name, email, phone, jobTitle)
    ScenarioContext.setContext("name", name)
    ScenarioContext.setContext("email", email)
    ScenarioContext.setContext("phone", phone)
  }

  And("I click on Save and continue button")(() => submitPage())

  And("I navigate to provide your contact details page and compare the text") { () =>
    val url = s"$baseUrl/advance-valuation-ruling/" + draftId + ProvideYourContactDetails.redirectUrl
    driver.get(url)
    assert(ScenarioContext.getContext("name") == ProvideYourContactDetails.getName)
    assert(ScenarioContext.getContext("email") == ProvideYourContactDetails.getEmail)
    assert(ScenarioContext.getContext("phone") == ProvideYourContactDetails.getContact)
  }

  Then("I will be navigated to the Select a Method page")(() => MethodSelectionPage.loadPage())

  And("I select Method {int} and continue in Select the method page") { (methodNumber: Int) =>
    MethodDetailsPage.loadPage().submitPage()
    MethodSelectionPage.loadPage().selectOption(methodNumber).submitPage()
  }

  Then("I navigate to Description of the Goods")(() => DescriptionOfTheGoods.url)

  Then("I navigate to Description of the Goods page and compare the text") { () =>
    val url = s"$baseUrl/advance-valuation-ruling/" + draftId + DescriptionOfTheGoods.redirectUrl
    driver.get(url)
    assert(ScenarioContext.getContext("goodsName") == DescriptionOfTheGoods.getText)
  }

  And("I enter {string} as the description") { (goodsName: String) =>
    DescriptionOfTheGoods.enterText(goodsName)
    ScenarioContext.setContext("goods description", goodsName)
  }

  And("I enter {string} as the description and press continue") { (goodsName: String) =>
    DescriptionOfTheGoods
      .enterText(goodsName)
      .submitPage()
  }

  And("I select {booleanValue} and continue in Tell us about the previous ruling page") { (option: Boolean) =>
    PreviousRulingsBasedOnSimilarMethods.loadPage().select(option).submitPage()
  }

  And("I enter {string} and continue") { (previousRulingInfo: String) =>
    TellUsAboutThePreviousRuling.enterText(previousRulingInfo).submitPage()
  }

  And("I select {booleanValue} on any other rulings that have used a similar method and continue") {
    (option: Boolean) =>
      OtherRulingsBasedOnSimilarMethod.loadPage().select(option).submitPage()
  }

  And("I enter {string} on about the rulings for similar goods page and continue") { (otherRulingInfo: String) =>
    TellUsAboutOtherRulingsSimilarGoods.enterText(otherRulingInfo).submitPage()
  }

  And("I select {booleanValue} and continue in Have you found the commodity code page") { (option: Boolean) =>
    HaveYouFoundTheCommodityCode.loadPage().select(option)
  }

  And("I enter the commodity code {string} and continue in What is the commodity code page") {
    (commodityCode: String) =>
      WhatIsTheCommodityCode
        .loadPage()
        .enterCommodityCode(commodityCode)
      submitPage()
  }

  And(
    "I select {booleanValue} and continue in Do you want this file to be marked as confidential page"
  ) { (option: Boolean) =>
    DoYouWantThisFileToBeMarkedAsConfidential.loadPage().select(option).submitPage()
  }

  Then("I will be navigated to This service is designed for those") { () =>
    ThisServiceIsDesignedForThose.loadPage()
    ThisServiceIsDesignedForThose.linkNavigationValidation()
  }

  Then("I will be navigated to Your EORI number details must be correct to use this service")(() =>
    YourEORIMustBeUpToDate.loadPage()
  )

  Then("I will be navigated to Your EORI number details must be correct for {string} to use this service")(
    (role: String) =>
      if (role == "An employee of the organisation") {
        YourEORIMustBeUpToDate.loadPage()
      } else if (role == "Agent acting on behalf of an organisation") {
        OrgEORIMustBeUpToDate.loadPage()
      } else {
        throw new Exception("Invalid role selected")
      }
  )

  Then("I will be navigated to You must have a commodity code") { () =>
    YouMustHaveACommodityCode.loadPage()
    YouMustHaveACommodityCode.linkNavigationValidation()
  }

  Then("I will be navigated to Have the goods been subject to legal challenges") { () =>
    HaveTheGoodsBeenSubjectToLegalChallenges.loadPage()
  }

  And("I select that the goods been subject to legal challenges") { () =>
    HaveTheGoodsBeenSubjectToLegalChallenges
      .selectYes()
      .submitPage()
  }

  And("I select that the goods have not been subject to legal challenges") { () =>
    HaveTheGoodsBeenSubjectToLegalChallenges
      .selectNo()
      .submitPage()
  }

  And("I enter {string} in describe legal challenges page") { (legalChallenges: String) =>
    DescribeTheLegalChallenges.enterText(legalChallenges)
    ScenarioContext.setContext("legal challenges", legalChallenges)
  }

  Then("I navigate to enter legal challenges page and compare the text") { () =>
    val url = s"$baseUrl/advance-valuation-ruling/" + draftId + DescribeTheLegalChallenges.redirectUrl
    driver.get(url)
    assert(ScenarioContext.getContext("legal challenges") == DescribeTheLegalChallenges.getText)
  }

  Then("I will be navigated to You have uploaded supporting document") { () =>
    if (ScenarioContext.getContext("Description Of Role") == BasePage.agentForTrader) {
      assert(driver.getTitle == UploadedOneSupportingDocumentForAgentForTrader.pageTitle + titleSuffix)
    } else {
      assert(driver.getTitle == UploadedOneSupportingDocumentForEmployeeAndAgentOfOrg.pageTitle + titleSuffix)
    }
  }

  Then("I will be navigated to You have uploaded second supporting document") { () =>
    if (ScenarioContext.getContext("Description Of Role") == BasePage.agentForTrader) {
      assert(driver.getTitle == UploadedTwoSupportingDocumentsForAgentForTrader.pageTitle + titleSuffix)

    } else {
      assert(driver.getTitle == UploadedTwoSupportingDocumentsForEmployeeAndAgentOfOrg.pageTitle + titleSuffix)
    }
  }

  Then("I will be navigated to Why Computed Value page")(() => WhyComputedValue.loadPage())

  And("I enter a reason and continue in Why Computed Value page and continue") { () =>
    WhyComputedValue.enterText("Reasonable argument with evidence").submitPage()
  }

  And("I enter a {string} and continue in Why Computed Value page") { (reason: String) =>
    WhyComputedValue.enterText(reason)
    ScenarioContext.setContext("why not method 1-4", reason)
  }

  And("I navigate to explain why not methods one till four page and compare text") { () =>
    val url = s"$baseUrl/advance-valuation-ruling/" +
      ScenarioContext.getContext("draftId") +
      WhyComputedValue.redirectUrl
    driver.get(url)
    assert(ScenarioContext.getContext("why not method 1-4") == WhyComputedValue.getText)
  }

  Then("I will be navigated to Explain Reason Computed Value page") { () =>
    ExplainWhyComputedValue.loadPage()
  }

  And("I enter a reason and continue in Explain Reason Computed Value page") { () =>
    ExplainWhyComputedValue.enterText("Detailed explanation").submitPage()
  }

  And("I select {booleanValue} and continue in Is There a Sale Involved") { (option: Boolean) =>
    IsThereASaleInvolved.loadPage().select(option).submitPage()
  }

  And("I select {booleanValue} and continue in Is the sale between related parties") { (option: Boolean) =>
    IsTheSaleBetweenRelatedParties.loadPage().select(option).submitPage()
  }

  And("I enter {string} and continue in Describe how the parties are related") { (text: String) =>
    DescribeHowPartiesAreRelated.enterText(text)
    submitPage()
  }

  And("I enter {string} in Describe how the parties are related") { (text: String) =>
    DescribeHowPartiesAreRelated.enterText(text)
    ScenarioContext.setContext("describe how parties are related", text)
  }

  And("I navigate to Describe how the parties are related page and compare the text") { () =>
    val url = s"$baseUrl/advance-valuation-ruling/" + draftId + DescribeHowPartiesAreRelated.redirectUrl
    driver.get(url)
    assert(ScenarioContext.getContext("describe how parties are related") == DescribeHowPartiesAreRelated.getText)
  }

  And(
    "I select {booleanValue} and continue in Are there any restrictions on the use or resale of the goods"
  )((option: Boolean) => AreThereAnyRestrictionsOnGoods.select(option).submitPage())

  And("I enter {string} and continue in Describe any restrictions on the use or resale of goods") { (text: String) =>
    DescribeAnyRestrictions.enterText(text)
    submitPage()
  }

  And("I enter {string} in Describe any restrictions on the use or resale of goods") { (text: String) =>
    DescribeAnyRestrictions.enterText(text)
    ScenarioContext.setContext("describe restrictions", text)
  }

  And("I navigate to Describe any restrictions on the use or resale of goods page and compare the text") { () =>
    val url = s"$baseUrl/advance-valuation-ruling/" + draftId + DescribeAnyRestrictions.redirectUrl
    driver.get(url)
    assert(ScenarioContext.getContext("describe restrictions") == DescribeAnyRestrictions.getText)
  }

  And(
    "I enter {string} and continue in Describe the conditions or circumstances which cannot be calculated"
  )((text: String) => DescribeAnyConditions.enterText(text).submitPage())

  And("I enter {string} as the conditions which cannot be calculated and press continue") { (text: String) =>
    DescribeAnyConditions.enterText(text).submitPage()
  }

  And("I enter {string} as the conditions which cannot be calculated") { (text: String) =>
    DescribeAnyConditions.enterText(text)
    ScenarioContext.setContext("conditions which cannot be calculated", text)
  }

  And("I navigate to Is the sale subject to any conditions or circumstances page and compare the text") { () =>
    val url = s"$baseUrl/advance-valuation-ruling/" + draftId + DescribeAnyConditions.redirectUrl
    driver.get(url)
    assert(ScenarioContext.getContext("conditions which cannot be calculated") == DescribeAnyConditions.getText)
  }

  And(
    "I select {booleanValue} and continue in Is the sale subject to any conditions or circumstances that could restrict you from valuing the goods"
  )((option: Boolean) => IsSaleSubjectToConditions.select(option).submitPage())

  Then("I will be navigated to the Check Your Answers page")(() => CheckYourAnswers.loadPage())

  Then("I will be navigated to the Your Contact details page")(() => ProvideYourContactDetails.loadPage())

  And("I check my {string} and {string} are correct and are unable to be changed") { (name: String, business: String) =>
    val text = CheckYourAnswers.noChangeButton
    assert(text.head.contains(name))
    assert(text.last.contains(business))
  }

  And("I check my answers and click on continue") { () =>
    CheckYourAnswers.submitPage()
  }

  Then("I will be navigated to the Application Complete page") { () =>
    webDriverWait().until(ExpectedConditions.titleContains(ApplicationComplete.pageTitle))
    ApplicationComplete.loadPage()
  }

  Then("I should see submitted application once I click Go to application and ruling button") { () =>
    ApplicationComplete.clickGoToApplicationAndRulingButton()
    ApplicationNoViewPage.loadPage()
  }

  And("I delete the application in draft") { () =>
    ApplicationNoViewPage.clickDeleteApplicationButton()
  }

  And("I click on cancel application link") { () =>
    clickCancelApplicationLink()
    CancelApplicationPage.loadPage()
  }
  And("I select {booleanValue} and continue on cancellation page") { (option: Boolean) =>
    CancelApplicationPage.loadPage()
    CancelApplicationPage.select(option)
    CancelApplicationPage.clickConfirmCancellationButton()
  }

  And("I click on confirm button on cancellation page") { () =>
    CancelApplicationPage.clickConfirmCancellationButton()
    ApplicationNoViewPage.loadPage()
  }

  And("I click back button in the browser") { () =>
    driver.navigate().back()
  }

  Then("You cannot view this application page is displayed") { () =>
    CancelledApplicationPage.loadPage()
  }

  Then("I click on go to application and rulings page button") { () =>
    CancelledApplicationPage.clickGoToApplicationAndRulingButton()
    ApplicationNoViewPage.loadPage()
  }

  Then("I sign out")(() => BasePage.signOut())
}
