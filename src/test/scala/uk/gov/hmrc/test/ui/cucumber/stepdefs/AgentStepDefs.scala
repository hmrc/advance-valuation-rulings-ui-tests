/*
 * Copyright 2023 HM Revenue & Customs
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

import uk.gov.hmrc.test.ui.pages.{AddressPage, AddressPageForInvalidEori, AddressPageForPrivateEori, AgentCompanyDetailsPage, AgentForTraderContactDetailsPage, AgentSelectRole, OrganisationContactDetailsPage, ProvideTraderEori, RequiredInformationPage, TradersEoriMustBeUpToDate, TradersIncorrectPrivateEori, UploadLetterOfAuthorityPage, UploadedLetterOfAuthorityPage, UploadingInProgressPage}
import uk.gov.hmrc.test.ui.pages.RequiredInformationPage.submitPage
import uk.gov.hmrc.test.ui.pages.base.BasePage.baseUrl
import uk.gov.hmrc.test.ui.pages.base.ScenarioContext

trait AgentStepDefs
    extends BaseStepDef
    with MethodTwoStepDefintions
    with MethodThreeStepDefintions
    with MethodFourStepDefintions
    with MethodSixStepDefintions {

  When("I select role as a {string}") { role: String =>
    AgentSelectRole.selectRole(role: String)
    ScenarioContext.setContext("Description Of Role", role)
    submitPage()
  }

  And("I verify starter checklist page for {string} is displayed") { role: String =>
    RequiredInformationPage.loadPage()
    assert(driver.getPageSource.contains(RequiredInformationPage.returnChecklistTextForRole(role)))
  }

  And(
    "I enter Name: {string}, Email: {string}, Phone: {string} details and continue in Provide your own contact details page"
  ) { (name: String, email: String, phone: String) =>
    OrganisationContactDetailsPage.loadPage()
    OrganisationContactDetailsPage.enterContactDetails(
      name,
      email,
      phone
    )
    submitPage()
  }

  And(
    "I enter Eori: {string}, CompanyName: {string}, StreetAndNumber: {string}, City: {string}, Country: {string}, PostalCode: {string} and continue on Your company's contact page"
  ) {
    (
      agentEori: String,
      agentCompanyName: String,
      agentStreetAndNumber: String,
      agentCity: String,
      agentCountry: String,
      agentPostalCode: String
    ) =>
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

  And(
    "I enter Eori: {string}, CompanyName: {string}, StreetAndNumber: {string}, City: {string}, Country: {string}, PostalCode: {string} on Your company's contact page"
  ) {
    (
      agentEori: String,
      agentCompanyName: String,
      agentStreetAndNumber: String,
      agentCity: String,
      agentCountry: String,
      agentPostalCode: String
    ) =>
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

  And("I navigate to agent company's contact details page and compare the text") { () =>
    val url = s"$baseUrl/advance-valuation-ruling/" +
      ScenarioContext.getContext("draftId") +
      AgentCompanyDetailsPage.redirectUrl
    driver.get(url)
    assert(ScenarioContext.getContext("agent Eori") == AgentCompanyDetailsPage.getAgentEori())
    assert(ScenarioContext.getContext("agent company") == AgentCompanyDetailsPage.getAgentCompanyName())
    assert(ScenarioContext.getContext("agent company street") == AgentCompanyDetailsPage.getStreetAndNumber())
    assert(ScenarioContext.getContext("agent company city") == AgentCompanyDetailsPage.getCity())
    assert(ScenarioContext.getContext("agent company postcode") == AgentCompanyDetailsPage.getPostcode())
  }

  And("I enter EORI number {string} on Provide traders EORI number page") { (eoriNo: String) =>
    ProvideTraderEori.loadPage()
    ProvideTraderEori.enterEoriNumber(eoriNo)
  }

  And("I verify error message for invalid EORI is displayed") { () =>
    AddressPageForInvalidEori.loadPage()
  }

  And("I upload the document {string} and continue in Upload letter of authority page") { (filename: String) =>
    val path = getClass.getResource(s"/testdata/$filename").getPath
    UploadLetterOfAuthorityPage.loadPage().uploadDocument(path)
    UploadingInProgressPage
      .clickCheckProgressButton()
  }

  And("I click on continue on Uploaded letter of authority page") { () =>
    UploadedLetterOfAuthorityPage.loadPage()
    submitPage()
  }

  And(
    "I enter Name- {string} Email- {string},Phone- {string}, Company name - {string} details"
  ) { (name: String, email: String, phone: String, companyName: String) =>
    AgentForTraderContactDetailsPage.loadPage()
    AgentForTraderContactDetailsPage.enterContactDetails(name, email, phone, companyName)
  }

  Then("I will be navigated to {string} kickout screen")((eoriType: String) =>
    if (eoriType == "public") {
      TradersEoriMustBeUpToDate.loadPage()
    } else if (eoriType == "private") {
      TradersIncorrectPrivateEori.loadPage()
    } else throw new Exception("Invalid EORI type passed")
  )

  And("I select {booleanValue} for {string} EORI on Check the name and address page") {
    (option: Boolean, eoriType: String) =>
      if (eoriType == "public") {
        AddressPage.loadPage().select(option)
      } else if (eoriType == "private") {
        AddressPageForPrivateEori.loadPage().select(option)
      } else throw new Exception("Invalid EORI type passed")
  }
}
