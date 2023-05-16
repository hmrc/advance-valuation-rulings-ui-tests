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

import uk.gov.hmrc.test.ui.pages.{AgentCompanyDetailsPage, AgentSelectRole, OrganisationContactDetailsPage}
import uk.gov.hmrc.test.ui.pages.RequiredInformationPage.submitPage

trait AgentStepDefs
    extends BaseStepDef
    with MethodTwoStepDefintions
    with MethodThreeStepDefintions
    with MethodFourStepDefintions
    with MethodSixStepDefintions {

  When("I select role as a {string}") {
    s: String ⇒
      s match {
        case "employee of the organisation"    => AgentSelectRole.selectRole(true)
        case "agent acting on an organisation" => AgentSelectRole.selectRole(false)
      }
      submitPage()
  }

  And(
    "I enter Name: {string}, Email: {string}, Phone: {string} details and continue in Provide your own contact details page"
  ) {
    (name: String, email: String, phone: String) =>
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
}
