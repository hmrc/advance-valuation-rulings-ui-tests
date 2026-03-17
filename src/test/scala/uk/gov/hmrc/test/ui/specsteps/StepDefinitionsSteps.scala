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

package uk.gov.hmrc.ui.specsteps

import org.scalatest.matchers.should.Matchers.*
import org.scalatest.Assertions.fail

import org.openqa.selenium.{By, WebDriver}
import org.openqa.selenium.support.ui.{ExpectedConditions, FluentWait}
import uk.gov.hmrc.test.ui.pages.RequiredInformationPage.{clickCancelApplicationLink, onPage, submitPage}
import uk.gov.hmrc.test.ui.pages.*
import uk.gov.hmrc.test.ui.pages.base.BasePage.{baseUrl, titleSuffix}
import uk.gov.hmrc.test.ui.pages.base.{BasePage, ScenarioContext}
import java.time.Duration
import uk.gov.hmrc.test.ui.driver.BrowserDriver

object StepDefinitionsSteps extends BrowserDriver {

  var draftId = ""
  def fluentWait: FluentWait[WebDriver] = new FluentWait[WebDriver](driver)
    .withTimeout(Duration.ofSeconds(15))
    .pollingEvery(Duration.ofMillis(500))
    .ignoring(classOf[Exception])

  // I am on the ARS Home Page with affinity group as a {string} and Credential role as a {string}
  def givenIAmOnTheARSHomePageWithAffinityGroupAsAStringAndCredentialRoleAsAString(affinityGroup: String, credentialRole: String): Unit = {
    BasePage.invokeURL(BasePage.URL_ARSHomePage, affinityGroup, credentialRole)
  }

  // I have accepted additional cookies
  def givenIHaveAcceptedAdditionalCookies(): Unit = {
    driver
          .findElement(By.cssSelector("body > div > div > div.cbanner-govuk-button-group > button:nth-child(1)"))
          .click()
  }

  // I am on the ARS Home Page and Login without enrolment
  def givenIAmOnTheARSHomePageAndLoginWithoutEnrolment(): Unit = {
    BasePage.invokeURL(BasePage.URL_ARSHomePage, "Individual", "User", hasEnrolment = false)
  }

  // user should see subscribe to advance rulings page to enrol
  def thenUserShouldSeeSubscribeToAdvanceRulingsPageToEnrol(): Unit = {
    driver.getTitle.contains(
          "Subscribe to advance rulings - Subscribe to advance rulings - GOV.UK"
        )
  }

  // I click on Start new application in ARS Home
  def whenIClickOnStartNewApplicationInARSHome(): Unit = {
    onPage(base.BasePage.arsHomePageText)
        submitPage()

        // Wait for URL to change and contain draft pattern
        val draftPattern = """(DRAFT\d+)""".r

        fluentWait.until((driver: WebDriver) => {
          val url = driver.getCurrentUrl
          draftPattern.findFirstIn(url).isDefined
        })

        val url = driver.getCurrentUrl
        draftPattern.findFirstIn(url) match {
          case Some(draft) =>
            draftId = draft
          case _ => throw new IllegalArgumentException("No Draft Id created within the new application")
        }
  }

  // I verify that a new draft application was created
  def andIVerifyThatANewDraftApplicationWasCreated(): Unit = {
    base.BasePage.getLastDraftCreated() shouldBe draftId
  }

  // I click continue on Information you need to complete an application page
  def andIClickContinueOnInformationYouNeedToCompleteAnApplicationPage(): Unit = {
    RequiredInformationPage.loadPage()
        submitPage()
  }

  // I select {booleanValue} and continue in Are you planning to import goods page
  def andISelectBooleanValueAndContinueInAreYouPlanningToImportGoodsPage(option: Boolean): Unit = {
    PlanningToImportGoods.loadPage()
        PlanningToImportGoods.select(option)
        submitPage()
  }

  // I click on continue in How We Contact You page
  def andIClickOnContinueInHowWeContactYouPage(): Unit = {
    HowWeContactYou.loadPage()
        submitPage()
  }

  // I select {booleanValue} and continue in Check the name and address page for agent for org
  def andISelectBooleanValueAndContinueInCheckTheNameAndAddressPageForAgentForOrg(option: Boolean): Unit = {
    AddressPageForAgentForOrg.loadPage().select(option).submitPage()
  }

  // I select {booleanValue} and continue in Check the name and address page for employee of org
  def andISelectBooleanValueAndContinueInCheckTheNameAndAddressPageForEmployeeOfOrg(option: Boolean): Unit = {
    AddressPageForEmployeeOfOrg.loadPage().select(option).submitPage()
  }

  // I select {booleanValue} and continue in Have you found the commodity code
  def andISelectBooleanValueAndContinueInHaveYouFoundTheCommodityCode(option: Boolean): Unit = {
    HaveYouFoundTheCommodityCode.loadPage().select(option).submitPage()
  }

  // I enter {string} commodity code
  def andIEnterStringCommodityCode(commodityCode: String): Unit = {
    WhatIsTheCommodityCode.enterCommodityCode(commodityCode)
        ScenarioContext.setContext("commodity code", commodityCode)
  }

  // I navigate to enter commodity code page and compare the text
  def thenINavigateToEnterCommodityCodePageAndCompareTheText(): Unit = {
    val url = s"$baseUrl/advance-valuation-ruling/" + draftId + WhatIsTheCommodityCode.redirectUrl
        driver.get(url)
        assert(ScenarioContext.getContext("commodity code") == WhatIsTheCommodityCode.getCommodityCode)
  }

  // I select {booleanValue} and continue in Do you want to add any confidential information page
  def andISelectBooleanValueAndContinueInDoYouWantToAddAnyConfidentialInformationPage(option: Boolean): Unit = {
    DoYouWantToAddAnyConfidentialInformation
          .loadPage()
          .select(option)
          .submitPage()
  }

  // I enter {string} in describe confidential information page
  def andIEnterStringInDescribeConfidentialInformationPage(confidentialInformationText: String): Unit = {
    DescriptionConfidentialInformation.loadPage().enterText(confidentialInformationText)
        ScenarioContext.setContext("confidential information", confidentialInformationText)
  }

  // I navigate to describe confidential information page and compare the text
  def thenINavigateToDescribeConfidentialInformationPageAndCompareTheText(): Unit = {
    val url = s"$baseUrl/advance-valuation-ruling/" + draftId + DescriptionConfidentialInformation.redirectUrl
        driver.get(url)
        assert(ScenarioContext.getContext("confidential information") == DescriptionConfidentialInformation.getText)
  }

  // I select {booleanValue} on You have uploaded supporting document
  def andISelectBooleanValueOnYouHaveUploadedSupportingDocument(option: Boolean): Unit = {
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

  // I select {booleanValue} on You have uploaded second supporting document
  def andISelectBooleanValueOnYouHaveUploadedSecondSupportingDocument(option: Boolean): Unit = {
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

  // I select {booleanValue} and continue in Do you want to upload any supporting documents page
  def andISelectBooleanValueAndContinueInDoYouWantToUploadAnySupportingDocumentsPage(option: Boolean): Unit = {
    DoYouWantToUploadAnySupportingDocuments
            .loadPage()
            .select(option)
            .submitPage()
  }

  // I upload the document {string} in Upload supporting documents page
  def andIUploadTheDocumentStringInUploadSupportingDocumentsPage(filePath: String): Unit = {
    val path = getClass.getResource(s"/testdata/$filePath").toURI.getPath
        UploadSupportingDocuments
          .loadPage()
          .uploadDocument(path)
        DoYouWantThisFileToBeMarkedAsConfidential.pollingClickAttempt()
  }

  // I enter Name- {string} Email- {string},Phone- {string}, Job title- {string} details and continue in Provide your contact details page
  def andIEnterNameStringEmailStringPhoneStringJobTitleStringDetailsAndContinueInProvideYourContactDetailsPage(name: String, email: String, phone: String, jobTitle: String): Unit = {
    ProvideYourContactDetails.loadPage()
        ProvideYourContactDetails.enterContactDetails(name, email, phone, jobTitle)
        submitPage()
  }

  // I enter Name- {string} Email- {string},Phone- {string}, Job title- {string} details
  def andIEnterNameStringEmailStringPhoneStringJobTitleStringDetails(name: String, email: String, phone: String, jobTitle: String): Unit = {
    ProvideYourContactDetails.loadPage()
        ProvideYourContactDetails.enterContactDetails(name, email, phone, jobTitle)
        ScenarioContext.setContext("name", name)
        ScenarioContext.setContext("email", email)
        ScenarioContext.setContext("phone", phone)
  }

  // I click on Save and continue button
  def andIClickOnSaveAndContinueButton(): Unit = {
    submitPage()
  }

  // I navigate to provide your contact details page and compare the text
  def andINavigateToProvideYourContactDetailsPageAndCompareTheText(): Unit = {
    val url = s"$baseUrl/advance-valuation-ruling/" + draftId + ProvideYourContactDetails.redirectUrl
        driver.get(url)
        assert(ScenarioContext.getContext("name") == ProvideYourContactDetails.getName)
        assert(ScenarioContext.getContext("email") == ProvideYourContactDetails.getEmail)
        assert(ScenarioContext.getContext("phone") == ProvideYourContactDetails.getContact)
  }

  // I will be navigated to the Select a Method page
  def thenIWillBeNavigatedToTheSelectAMethodPage(): Unit = {
    MethodSelectionPage.loadPage()
  }

  // I select Method {int} and continue in Select the method page
  def andISelectMethodIntAndContinueInSelectTheMethodPage(methodNumber: Int): Unit = {
    MethodDetailsPage.loadPage().submitPage()
        MethodSelectionPage.loadPage().selectOption(methodNumber).submitPage()
  }

  // I navigate to Description of the Goods
  def thenINavigateToDescriptionOfTheGoods(): Unit = {
    DescriptionOfTheGoods.url
  }

  // I navigate to Description of the Goods page and compare the text
  def thenINavigateToDescriptionOfTheGoodsPageAndCompareTheText(): Unit = {
    val url = s"$baseUrl/advance-valuation-ruling/" + draftId + DescriptionOfTheGoods.redirectUrl
        driver.get(url)
        assert(ScenarioContext.getContext("goodsName") == DescriptionOfTheGoods.getText)
  }

  // I enter {string} as the description
  def andIEnterStringAsTheDescription(goodsName: String): Unit = {
    DescriptionOfTheGoods.enterText(goodsName)
        ScenarioContext.setContext("goods description", goodsName)
  }

  // I enter {string} as the description and press continue
  def andIEnterStringAsTheDescriptionAndPressContinue(goodsName: String): Unit = {
    DescriptionOfTheGoods
          .enterText(goodsName)
          .submitPage()
  }

  // I select {booleanValue} and continue in Tell us about the previous ruling page
  def andISelectBooleanValueAndContinueInTellUsAboutThePreviousRulingPage(option: Boolean): Unit = {
    PreviousRulingsBasedOnSimilarMethods.loadPage().select(option).submitPage()
  }

  // I enter {string} and continue
  def andIEnterStringAndContinue(previousRulingInfo: String): Unit = {
    TellUsAboutThePreviousRuling.enterText(previousRulingInfo).submitPage()
  }

  // I select {booleanValue} on any other rulings that have used a similar method and continue
  def andISelectBooleanValueOnAnyOtherRulingsThatHaveUsedASimilarMethodAndContinue(option: Boolean): Unit = {
    OtherRulingsBasedOnSimilarMethod.loadPage().select(option).submitPage()
  }

  // I enter {string} on about the rulings for similar goods page and continue
  def andIEnterStringOnAboutTheRulingsForSimilarGoodsPageAndContinue(otherRulingInfo: String): Unit = {
    TellUsAboutOtherRulingsSimilarGoods.enterText(otherRulingInfo).submitPage()
  }

  // I select {booleanValue} and continue in Have you found the commodity code page
  def andISelectBooleanValueAndContinueInHaveYouFoundTheCommodityCodePage(option: Boolean): Unit = {
    HaveYouFoundTheCommodityCode.loadPage().select(option)
  }

  // I enter the commodity code {string} and continue in What is the commodity code page
  def andIEnterTheCommodityCodeStringAndContinueInWhatIsTheCommodityCodePage(commodityCode: String): Unit = {
    WhatIsTheCommodityCode
            .loadPage()
            .enterCommodityCode(commodityCode)
          submitPage()
  }

  // I select {booleanValue} and continue in Do you want this file to be marked as confidential page
  def andISelectBooleanValueAndContinueInDoYouWantThisFileToBeMarkedAsConfidentialPage(option: Boolean): Unit = {
    DoYouWantThisFileToBeMarkedAsConfidential.loadPage().select(option).submitPage()
  }

  // I will be navigated to This service is designed for those
  def thenIWillBeNavigatedToThisServiceIsDesignedForThose(): Unit = {
    ThisServiceIsDesignedForThose.loadPage()
        ThisServiceIsDesignedForThose.linkNavigationValidation()
  }

  // I will be navigated to Your EORI number details must be correct to use this service
  def thenIWillBeNavigatedToYourEORINumberDetailsMustBeCorrectToUseThisService(): Unit = {
    YourEORIMustBeUpToDate.loadPage()
  }

  // I will be navigated to Your EORI number details must be correct for {string} to use this service
  def thenIWillBeNavigatedToYourEORINumberDetailsMustBeCorrectForStringToUseThisService(role: String): Unit = {
    if (role == "An employee of the organisation") {
            YourEORIMustBeUpToDate.loadPage()
          } else if (role == "Agent acting on behalf of an organisation") {
            OrgEORIMustBeUpToDate.loadPage()
          } else {
            throw new Exception("Invalid role selected")
          }
  }

  // I will be navigated to You must have a commodity code
  def thenIWillBeNavigatedToYouMustHaveACommodityCode(): Unit = {
    YouMustHaveACommodityCode.loadPage()
        YouMustHaveACommodityCode.linkNavigationValidation()
  }

  // I will be navigated to Have the goods been subject to legal challenges
  def thenIWillBeNavigatedToHaveTheGoodsBeenSubjectToLegalChallenges(): Unit = {
    HaveTheGoodsBeenSubjectToLegalChallenges.loadPage()
  }

  // I select that the goods been subject to legal challenges
  def andISelectThatTheGoodsBeenSubjectToLegalChallenges(): Unit = {
    HaveTheGoodsBeenSubjectToLegalChallenges
          .selectYes()
          .submitPage()
  }

  // I select that the goods have not been subject to legal challenges
  def andISelectThatTheGoodsHaveNotBeenSubjectToLegalChallenges(): Unit = {
    HaveTheGoodsBeenSubjectToLegalChallenges
          .selectNo()
          .submitPage()
  }

  // I enter {string} in describe legal challenges page
  def andIEnterStringInDescribeLegalChallengesPage(legalChallenges: String): Unit = {
    DescribeTheLegalChallenges.enterText(legalChallenges)
        ScenarioContext.setContext("legal challenges", legalChallenges)
  }

  // I navigate to enter legal challenges page and compare the text
  def thenINavigateToEnterLegalChallengesPageAndCompareTheText(): Unit = {
    val url = s"$baseUrl/advance-valuation-ruling/" + draftId + DescribeTheLegalChallenges.redirectUrl
        driver.get(url)
        assert(ScenarioContext.getContext("legal challenges") == DescribeTheLegalChallenges.getText)
  }

  // I will be navigated to You have uploaded supporting document
  def thenIWillBeNavigatedToYouHaveUploadedSupportingDocument(): Unit = {
    val expectedTitle = if (ScenarioContext.getContext("Description Of Role") == BasePage.agentForTrader) {
          UploadedOneSupportingDocumentForAgentForTrader.pageTitle + titleSuffix
        } else {
          UploadedOneSupportingDocumentForEmployeeAndAgentOfOrg.pageTitle + titleSuffix
        }

        fluentWait.until((driver: WebDriver) => {
          driver.getTitle == expectedTitle
        })

        assert(driver.getTitle == expectedTitle)
  }

  // I will be navigated to You have uploaded second supporting document
  def thenIWillBeNavigatedToYouHaveUploadedSecondSupportingDocument(): Unit = {
    val expectedTitle = if (ScenarioContext.getContext("Description Of Role") == BasePage.agentForTrader) {
          UploadedTwoSupportingDocumentsForAgentForTrader.pageTitle + titleSuffix
        } else {
          UploadedTwoSupportingDocumentsForEmployeeAndAgentOfOrg.pageTitle + titleSuffix
        }

        fluentWait.until((driver: WebDriver) => {
          driver.getTitle == expectedTitle
        })

        assert(driver.getTitle == expectedTitle)
  }

  // I will be navigated to Why Computed Value page
  def thenIWillBeNavigatedToWhyComputedValuePage(): Unit = {
    WhyComputedValue.loadPage()
  }

  // I enter a reason and continue in Why Computed Value page and continue
  def andIEnterAReasonAndContinueInWhyComputedValuePageAndContinue(): Unit = {
    WhyComputedValue.enterText("Reasonable argument with evidence").submitPage()
  }

  // I enter a {string} and continue in Why Computed Value page
  def andIEnterAStringAndContinueInWhyComputedValuePage(reason: String): Unit = {
    WhyComputedValue.enterText(reason)
        ScenarioContext.setContext("why not method 1-4", reason)
  }

  // I navigate to explain why not methods one till four page and compare text
  def andINavigateToExplainWhyNotMethodsOneTillFourPageAndCompareText(): Unit = {
    val url = s"$baseUrl/advance-valuation-ruling/" +
          ScenarioContext.getContext("draftId") +
          WhyComputedValue.redirectUrl
        driver.get(url)
        assert(ScenarioContext.getContext("why not method 1-4") == WhyComputedValue.getText)
  }

  // I will be navigated to Explain Reason Computed Value page
  def thenIWillBeNavigatedToExplainReasonComputedValuePage(): Unit = {
    ExplainWhyComputedValue.loadPage()
  }

  // I enter a reason and continue in Explain Reason Computed Value page
  def andIEnterAReasonAndContinueInExplainReasonComputedValuePage(): Unit = {
    ExplainWhyComputedValue.enterText("Detailed explanation").submitPage()
  }

  // I select {booleanValue} and continue in Is There a Sale Involved
  def andISelectBooleanValueAndContinueInIsThereASaleInvolved(option: Boolean): Unit = {
    IsThereASaleInvolved.loadPage().select(option).submitPage()
  }

  // I select {booleanValue} and continue in Is the sale between related parties
  def andISelectBooleanValueAndContinueInIsTheSaleBetweenRelatedParties(option: Boolean): Unit = {
    IsTheSaleBetweenRelatedParties.loadPage().select(option).submitPage()
  }

  // I enter {string} and continue in Describe how the parties are related
  def andIEnterStringAndContinueInDescribeHowThePartiesAreRelated(text: String): Unit = {
    DescribeHowPartiesAreRelated.enterText(text)
        submitPage()
  }

  // I enter {string} in Describe how the parties are related
  def andIEnterStringInDescribeHowThePartiesAreRelated(text: String): Unit = {
    DescribeHowPartiesAreRelated.enterText(text)
        ScenarioContext.setContext("describe how parties are related", text)
  }

  // I navigate to Describe how the parties are related page and compare the text
  def andINavigateToDescribeHowThePartiesAreRelatedPageAndCompareTheText(): Unit = {
    val url = s"$baseUrl/advance-valuation-ruling/" + draftId + DescribeHowPartiesAreRelated.redirectUrl
        driver.get(url)
        assert(ScenarioContext.getContext("describe how parties are related") == DescribeHowPartiesAreRelated.getText)
  }

  // I select {booleanValue} and continue in Are there any restrictions on the use or resale of the goods
  def andISelectBooleanValueAndContinueInAreThereAnyRestrictionsOnTheUseOrResaleOfTheGoods(option: Boolean): Unit = {
    AreThereAnyRestrictionsOnGoods.select(option).submitPage()
  }

  // I enter {string} and continue in Describe any restrictions on the use or resale of goods
  def andIEnterStringAndContinueInDescribeAnyRestrictionsOnTheUseOrResaleOfGoods(text: String): Unit = {
    DescribeAnyRestrictions.enterText(text)
        submitPage()
  }

  // I enter {string} in Describe any restrictions on the use or resale of goods
  def andIEnterStringInDescribeAnyRestrictionsOnTheUseOrResaleOfGoods(text: String): Unit = {
    DescribeAnyRestrictions.enterText(text)
        ScenarioContext.setContext("describe restrictions", text)
  }

  // I navigate to Describe any restrictions on the use or resale of goods page and compare the text
  def andINavigateToDescribeAnyRestrictionsOnTheUseOrResaleOfGoodsPageAndCompareTheText(): Unit = {
    val url = s"$baseUrl/advance-valuation-ruling/" + draftId + DescribeAnyRestrictions.redirectUrl
        driver.get(url)
        assert(ScenarioContext.getContext("describe restrictions") == DescribeAnyRestrictions.getText)
  }

  // I enter {string} and continue in Describe the conditions or circumstances which cannot be calculated
  def andIEnterStringAndContinueInDescribeTheConditionsOrCircumstancesWhichCannotBeCalculated(text: String): Unit = {
    DescribeAnyConditions.enterText(text).submitPage()
  }

  // I enter {string} as the conditions which cannot be calculated and press continue
  def andIEnterStringAsTheConditionsWhichCannotBeCalculatedAndPressContinue(text: String): Unit = {
    DescribeAnyConditions.enterText(text).submitPage()
  }

  // I enter {string} as the conditions which cannot be calculated
  def andIEnterStringAsTheConditionsWhichCannotBeCalculated(text: String): Unit = {
    DescribeAnyConditions.enterText(text)
        ScenarioContext.setContext("conditions which cannot be calculated", text)
  }

  // I navigate to Is the sale subject to any conditions or circumstances page and compare the text
  def andINavigateToIsTheSaleSubjectToAnyConditionsOrCircumstancesPageAndCompareTheText(): Unit = {
    val url = s"$baseUrl/advance-valuation-ruling/" + draftId + DescribeAnyConditions.redirectUrl
        driver.get(url)
        assert(ScenarioContext.getContext("conditions which cannot be calculated") == DescribeAnyConditions.getText)
  }

  // I select {booleanValue} and continue in Is the sale subject to any conditions or circumstances that could restrict you from valuing the goods
  def andISelectBooleanValueAndContinueInIsTheSaleSubjectToAnyConditionsOrCircumstancesThatCouldRestrictYouFromValuingTheGoods(option: Boolean): Unit = {
    IsSaleSubjectToConditions.select(option).submitPage()
  }

  // I will be navigated to the Check Your Answers page
  def thenIWillBeNavigatedToTheCheckYourAnswersPage(): Unit = {
    CheckYourAnswers.loadPage()
  }

  // I will be navigated to the Your Contact details page
  def thenIWillBeNavigatedToTheYourContactDetailsPage(): Unit = {
    ProvideYourContactDetails.loadPage()
  }

  // I check my {string} and {string} are correct and are unable to be changed
  def andICheckMyStringAndStringAreCorrectAndAreUnableToBeChanged(name: String, business: String): Unit = {
    val text = CheckYourAnswers.noChangeButton
        assert(text.head.contains(name))
        assert(text.last.contains(business))
  }

  // I check my answers and click on continue
  def andICheckMyAnswersAndClickOnContinue(): Unit = {
    CheckYourAnswers.submitPage()
  }

  // I will be navigated to the Application Complete page
  def thenIWillBeNavigatedToTheApplicationCompletePage(): Unit = {
    webDriverWait().until(ExpectedConditions.titleContains(ApplicationComplete.pageTitle))
        ApplicationComplete.loadPage()
  }

  // I should see submitted application once I click Go to application and ruling button
  def thenIShouldSeeSubmittedApplicationOnceIClickGoToApplicationAndRulingButton(): Unit = {
    ApplicationComplete.clickGoToApplicationAndRulingButton()
        ApplicationNoViewPage.loadPage()
  }

  // I delete the application in draft
  def andIDeleteTheApplicationInDraft(): Unit = {
    ApplicationNoViewPage.clickDeleteApplicationButton()
  }

  // I click on cancel application link
  def andIClickOnCancelApplicationLink(): Unit = {
    clickCancelApplicationLink()
        CancelApplicationPage.loadPage()
  }

  // I select {booleanValue} and continue on cancellation page
  def andISelectBooleanValueAndContinueOnCancellationPage(option: Boolean): Unit = {
    CancelApplicationPage.loadPage()
        CancelApplicationPage.select(option)
        CancelApplicationPage.clickConfirmCancellationButton()
  }

  // I click on confirm button on cancellation page
  def andIClickOnConfirmButtonOnCancellationPage(): Unit = {
    CancelApplicationPage.clickConfirmCancellationButton()
        ApplicationNoViewPage.loadPage()
  }

  // I click back button in the browser
  def andIClickBackButtonInTheBrowser(): Unit = {
    driver.navigate().back()
  }

  // You cannot view this application page is displayed
  def thenYouCannotViewThisApplicationPageIsDisplayed(): Unit = {
    CancelledApplicationPage.loadPage()
  }

  // I click on go to application and rulings page button
  def thenIClickOnGoToApplicationAndRulingsPageButton(): Unit = {
    CancelledApplicationPage.clickGoToApplicationAndRulingButton()
        ApplicationNoViewPage.loadPage()
  }

  // I sign out
  def thenISignOut(): Unit = {
    BasePage.signOut()
  }

}
