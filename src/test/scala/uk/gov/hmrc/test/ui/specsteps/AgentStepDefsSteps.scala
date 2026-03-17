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

import java.time.Duration

import org.openqa.selenium.support.ui.FluentWait
import org.openqa.selenium.{NoSuchElementException, StaleElementReferenceException, WebDriver}
import org.scalatest.matchers.should.Matchers.*
import org.scalatest.Assertions.fail

import uk.gov.hmrc.test.ui.pages.RequiredInformationPage.submitPage
import uk.gov.hmrc.test.ui.pages.*
import uk.gov.hmrc.test.ui.pages.base.BasePage.{baseUrl, titleSuffix}
import uk.gov.hmrc.test.ui.pages.base.ScenarioContext
import uk.gov.hmrc.test.ui.driver.BrowserDriver

object AgentStepDefsSteps extends BrowserDriver {

  // I select role as a {string}
  def whenISelectRoleAsAString(role: String): Unit = {
    AgentSelectRole.selectRole(role: String)
        ScenarioContext.setContext("Description Of Role", role)
        submitPage()
  }

  // I verify starter checklist page for {string} is displayed
  def andIVerifyStarterChecklistPageForStringIsDisplayed(role: String): Unit = {
    RequiredInformationPage.loadPage()
        assert(driver.getPageSource.contains(RequiredInformationPage.returnChecklistTextForRole(role)))
  }

  // I enter Name: {string}, Email: {string}, Phone: {string}, Job title: {string} details and continue in Provide your own contact details page
  def andIEnterNameStringEmailStringPhoneStringJobTitleStringDetailsAndContinueInProvideYourOwnContactDetailsPage(name: String, email: String, phone: String, jobTitle: String): Unit = {
    OrganisationContactDetailsPage.loadPage()
        OrganisationContactDetailsPage.enterContactDetails(
          name,
          email,
          phone,
          jobTitle
        )
        submitPage()
  }

  // I enter Eori: {string}, CompanyName: {string}, StreetAndNumber: {string}, City: {string}, Country: {string}, PostalCode: {string} and continue on Your company's contact page
  def andIEnterEoriStringCompanyNameStringStreetAndNumberStringCityStringCountryStringPostalCodeStringAndContinueOnYourCompanySContactPage(agentEori: String,
      agentCompanyName: String,
      agentStreetAndNumber: String,
      agentCity: String,
      agentCountry: String,
      agentPostalCode: String): Unit = {
    AgentCompanyDetailsPage.loadPage()
          AgentCompanyDetailsPage.enterFormDetails(
            agentEori,
            agentCompanyName,
            agentStreetAndNumber,
            agentCity,
            agentCountry,
            agentPostalCode
          )
          submitPage()
  }

  // I enter Eori: {string}, CompanyName: {string}, StreetAndNumber: {string}, City: {string}, Country: {string}, PostalCode: {string} on Your company's contact page
  def andIEnterEoriStringCompanyNameStringStreetAndNumberStringCityStringCountryStringPostalCodeStringOnYourCompanySContactPage(agentEori: String,
      agentCompanyName: String,
      agentStreetAndNumber: String,
      agentCity: String,
      agentCountry: String,
      agentPostalCode: String): Unit = {
    AgentCompanyDetailsPage.loadPage()
          AgentCompanyDetailsPage.enterFormDetails(
            agentEori,
            agentCompanyName,
            agentStreetAndNumber,
            agentCity,
            agentCountry,
            agentPostalCode
          )
          ScenarioContext.setContext("agent Eori", agentEori)
          ScenarioContext.setContext("agent company", agentCompanyName)
          ScenarioContext.setContext("agent company street", agentStreetAndNumber)
          ScenarioContext.setContext("agent company city", agentCity)
          ScenarioContext.setContext("agent country", agentCountry)
          ScenarioContext.setContext("agent company postcode", agentPostalCode)
  }

  // I navigate to agent company's contact details page and compare the text
  def andINavigateToAgentCompanySContactDetailsPageAndCompareTheText(): Unit = {
    val url = s"$baseUrl/advance-valuation-ruling/" +
          ScenarioContext.getContext("draftId") +
          AgentCompanyDetailsPage.redirectUrl
        driver.get(url)
        assert(ScenarioContext.getContext("agent Eori") == AgentCompanyDetailsPage.getAgentEori)
        assert(ScenarioContext.getContext("agent company") == AgentCompanyDetailsPage.getAgentCompanyName)
        assert(ScenarioContext.getContext("agent company street") == AgentCompanyDetailsPage.getStreetAndNumber)
        assert(ScenarioContext.getContext("agent company city") == AgentCompanyDetailsPage.getCity)
        assert(ScenarioContext.getContext("agent company postcode") == AgentCompanyDetailsPage.getPostcode)
  }

  // I enter EORI number {string} on Provide traders EORI number page
  def andIEnterEORINumberStringOnProvideTradersEORINumberPage(eoriNo: String): Unit = {
    ProvideTraderEori.loadPage()
        ProvideTraderEori.enterEoriNumber(eoriNo)
  }

  // I verify error message for invalid EORI is displayed
  def andIVerifyErrorMessageForInvalidEORIIsDisplayed(): Unit = {
    AddressPageForInvalidEori.loadPage()
  }

  // I upload the document {string} and continue in Upload letter of authority page
  def andIUploadTheDocumentStringAndContinueInUploadLetterOfAuthorityPage(filename: String): Unit = {
    val path = getClass.getResource(s"/testdata/$filename").toURI.getPath

    UploadLetterOfAuthorityPage
      .loadPage()
      .uploadDocument(path)

    val uploadPageTitle    = UploadLetterOfAuthorityPage.pageTitle + titleSuffix
    val uploadedPageTitle  = UploadedLetterOfAuthorityPage.pageTitle + titleSuffix
    val uploadingPageTitle = UploadingInProgressPage.pageTitle + titleSuffix

    new FluentWait[WebDriver](driver)
      .withTimeout(Duration.ofSeconds(60))
      .pollingEvery(Duration.ofMillis(500))
      .ignoring(classOf[NoSuchElementException])
      .ignoring(classOf[StaleElementReferenceException])
      .until((d: WebDriver) => {
        d.getTitle.trim match {
          case `uploadPageTitle`    =>
            submitPage()
            false
          case `uploadedPageTitle`  => true
          case `uploadingPageTitle` =>
            UploadingInProgressPage.clickCheckProgressButton()
            false
          case _                    => false
        }
      })
  }

  // I click on continue on Uploaded letter of authority page
  def andIClickOnContinueOnUploadedLetterOfAuthorityPage(): Unit = {
    UploadedLetterOfAuthorityPage.loadPage()
        submitPage()
  }

  // I enter Name- {string} Email- {string},Phone- {string}, Company name - {string}, Job title - {string} details
  def andIEnterNameStringEmailStringPhoneStringCompanyNameStringJobTitleStringDetails(name: String, email: String, phone: String, companyName: String, jobTitle: String): Unit = {
    AgentForTraderContactDetailsPage.loadPage()
        AgentForTraderContactDetailsPage.enterContactDetails(name, email, phone, companyName, jobTitle)
  }

  // I will be navigated to {string} kickout screen
  def thenIWillBeNavigatedToStringKickoutScreen(eoriType: String): Unit = {
    if (eoriType == "public") {
          TradersEoriMustBeUpToDate.loadPage()
        } else if (eoriType == "private") {
          TradersIncorrectPrivateEori.loadPage()
        } else {
          throw new Exception("Invalid EORI type passed")
        }
  }

  // I select {booleanValue} for {string} EORI on Check the name and address page
  def andISelectBooleanValueForStringEORIOnCheckTheNameAndAddressPage(option: Boolean, eoriType: String): Unit = {
    if (eoriType == "public") {
            AddressPageForAgentForTrader.loadPage().select(option)
          } else if (eoriType == "private") {
            AddressPageForPrivateEori.loadPage().select(option)
          } else {
            throw new Exception("Invalid EORI type passed")
          }
  }

}
