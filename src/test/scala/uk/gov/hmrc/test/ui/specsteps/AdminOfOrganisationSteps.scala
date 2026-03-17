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

import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.{ExpectedConditions, FluentWait}
import uk.gov.hmrc.test.ui.driver.BrowserDriver
import uk.gov.hmrc.test.ui.pages.RequiredInformationPage
import uk.gov.hmrc.test.ui.pages.*
import uk.gov.hmrc.test.ui.pages.base.{BasePage, ScenarioContext}

import java.time.Duration

object
AdminOfOrganisationSteps extends BrowserDriver {

  private var draftId: String = ""

  private def fluentWait: FluentWait[WebDriver] = new FluentWait[WebDriver](driver)
    .withTimeout(Duration.ofSeconds(15))
    .pollingEvery(Duration.ofMillis(500))
    .ignoring(classOf[Exception])

  def givenIAmOnTheARSHomePageWithAffinityGroupAndCredentialRole(
    affinityGroup: String,
    credentialRole: String
  ): Unit =
    BasePage.invokeURL(BasePage.URL_ARSHomePage, affinityGroup, credentialRole)

  def whenIClickOnStartNewApplicationInARSHome(): Unit = {
    RequiredInformationPage.onPage(BasePage.arsHomePageText)
    RequiredInformationPage.submitPage()

    val draftPattern = """(DRAFT\d+)""".r

    fluentWait.until((driver: WebDriver) => {
      val url = driver.getCurrentUrl
      draftPattern.findFirstIn(url).isDefined
    })

    val url = driver.getCurrentUrl
    draftPattern.findFirstIn(url) match {
      case Some(draft) =>
        draftId = draft
        ScenarioContext.setContext("draftId", draftId)
      case _           => throw new IllegalArgumentException("No Draft Id created within the new application")
    }
  }

  def whenISelectRoleAsA(role: String): Unit = {
    AgentSelectRole.selectRole(role)
    ScenarioContext.setContext("Description Of Role", role)
    RequiredInformationPage.submitPage()
  }

  def andIClickContinueOnInformationYouNeedToCompleteAnApplicationPage(): Unit = {
    RequiredInformationPage.loadPage()
    RequiredInformationPage.submitPage()
  }

  def andISelectBooleanAndContinueInAreYouPlanningToImportGoodsPage(option: Boolean): Unit = {
    PlanningToImportGoods.loadPage()
    PlanningToImportGoods.select(option)
    RequiredInformationPage.submitPage()
  }

  def andIClickOnContinueInHowWeContactYouPage(): Unit = {
    HowWeContactYou.loadPage().submitPage()
  }

  def andISelectBooleanAndContinueInCheckTheNameAndAddressPageForEmployeeOfOrg(option: Boolean): Unit = {
    AddressPageForEmployeeOfOrg.loadPage().select(option).submitPage()
  }

  def andIEnterNameEmailPhoneJobTitleDetailsAndContinueInProvideYourContactDetailsPage(
    name: String,
    email: String,
    phone: String,
    jobTitle: String
  ): Unit = {
    ProvideYourContactDetails.loadPage()
    ProvideYourContactDetails.enterContactDetails(name, email, phone, jobTitle)
    RequiredInformationPage.submitPage()
  }

  def andISelectMethodAndContinueInSelectTheMethodPage(methodNumber: Int): Unit = {
    MethodDetailsPage.loadPage().submitPage()
    MethodSelectionPage.loadPage().selectOption(methodNumber).submitPage()
  }

  def andISelectBooleanAndContinueInIsThereASaleInvolved(option: Boolean): Unit = {
    IsThereASaleInvolved.loadPage().select(option).submitPage()
  }

  def andISelectBooleanAndContinueInIsTheSaleBetweenRelatedParties(option: Boolean): Unit = {
    IsTheSaleBetweenRelatedParties.loadPage().select(option).submitPage()
  }

  def andIEnterStringAndContinueInDescribeHowThePartiesAreRelated(text: String): Unit = {
    DescribeHowPartiesAreRelated.enterText(text)
    RequiredInformationPage.submitPage()
  }

  def andISelectBooleanAndContinueInAreThereAnyRestrictionsOnTheUseOrResaleOfTheGoods(option: Boolean): Unit = {
    AreThereAnyRestrictionsOnGoods.select(option).submitPage()
  }

  def andIEnterStringAndContinueInDescribeAnyRestrictionsOnTheUseOrResaleOfGoods(text: String): Unit = {
    DescribeAnyRestrictions.enterText(text)
    RequiredInformationPage.submitPage()
  }

  def andISelectBooleanAndContinueInIsTheSaleSubjectToAnyConditionsOrCircumstancesThatCouldRestrictYouFromValuingTheGoods(
    option: Boolean
  ): Unit = {
    IsSaleSubjectToConditions.select(option).submitPage()
  }

  def andIEnterStringAsTheConditionsWhichCannotBeCalculatedAndPressContinue(text: String): Unit = {
    DescribeAnyConditions.enterText(text).submitPage()
  }

  def thenINavigateToDescriptionOfTheGoods(): Unit = {
    DescriptionOfTheGoods.loadPage()
  }

  def andIEnterStringAsTheDescriptionAndPressContinue(goodsName: String): Unit = {
    DescriptionOfTheGoods.enterText(goodsName).submitPage()
  }

  def andISelectBooleanAndContinueInTellUsAboutThePreviousRulingPage(option: Boolean): Unit = {
    PreviousRulingsBasedOnSimilarMethods.loadPage().select(option).submitPage()
  }

  def andIEnterStringAndContinue(previousRulingInfo: String): Unit = {
    TellUsAboutThePreviousRuling.enterText(previousRulingInfo).submitPage()
  }

  def andISelectBooleanOnAnyOtherRulingsThatHaveUsedASimilarMethodAndContinue(option: Boolean): Unit = {
    OtherRulingsBasedOnSimilarMethod.loadPage().select(option).submitPage()
  }

  def andIEnterStringOnAboutTheRulingsForSimilarGoodsPageAndContinue(otherRulingInfo: String): Unit = {
    TellUsAboutOtherRulingsSimilarGoods.enterText(otherRulingInfo).submitPage()
  }

  def andISelectBooleanAndContinueInHaveYouFoundTheCommodityCode(option: Boolean): Unit = {
    HaveYouFoundTheCommodityCode.loadPage().select(option).submitPage()
  }

  def thenIWillBeNavigatedToHaveTheGoodsBeenSubjectToLegalChallenges(): Unit = {
    HaveTheGoodsBeenSubjectToLegalChallenges.loadPage()
  }

  def andISelectThatTheGoodsHaveNotBeenSubjectToLegalChallenges(): Unit = {
    HaveTheGoodsBeenSubjectToLegalChallenges.selectNo().submitPage()
  }

  def andISelectBooleanAndContinueInDoYouWantToAddAnyConfidentialInformationPage(option: Boolean): Unit = {
    DoYouWantToAddAnyConfidentialInformation.loadPage().select(option).submitPage()
  }

  def andISelectBooleanAndContinueInDoYouWantToUploadAnySupportingDocumentsPage(option: Boolean): Unit = {
    DoYouWantToUploadAnySupportingDocuments.loadPage().select(option).submitPage()
  }

  def thenIWillBeNavigatedToTheCheckYourAnswersPage(): Unit = {
    CheckYourAnswers.loadPage()
  }

  def andICheckMyAndAreCorrectAndAreUnableToBeChanged(name: String, business: String): Unit = {
    val text = CheckYourAnswers.noChangeButton
    assert(text.head.contains(name))
    assert(text.last.contains(business))
  }

  def andICheckMyAnswersAndClickOnContinue(): Unit = {
    CheckYourAnswers.submitPage()
  }

  def thenIWillBeNavigatedToTheApplicationCompletePage(): Unit = {
    webDriverWait().until(ExpectedConditions.titleContains(ApplicationComplete.pageTitle))
    ApplicationComplete.loadPage()
  }
}
