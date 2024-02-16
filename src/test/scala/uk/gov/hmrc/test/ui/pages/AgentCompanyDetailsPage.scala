/*
 * Copyright 2024 HM Revenue & Customs
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

package uk.gov.hmrc.test.ui.pages

import uk.gov.hmrc.test.ui.pages.base.BasePage

import org.openqa.selenium.By

object AgentCompanyDetailsPage extends BasePage {
  val pageTitle = "Your organisation’s contact details"

  val agentEoriField            = By.id("agentEori")
  val agentCompanyNameField     = By.id("agentCompanyName")
  val agentStreetAndNumberField = By.id("agentStreetAndNumber")
  val agentCityField            = By.id("agentCity")
  val agentCountryField         = "country"
  val agentPostalCodeField      = By.id("agentPostalCode")
  val redirectUrl               = "/agent-company-details"

  def enterFormDetails(
    agentEori: String,
    agentCompanyName: String,
    agentStreetAndNumber: String,
    agentCity: String,
    agentCountry: String,
    agentPostalCode: String
  ): Unit = {
    agentEoriField.find.enterText(agentEori)
    agentCompanyNameField.find.enterText(agentCompanyName)
    agentStreetAndNumberField.find.enterText(agentStreetAndNumber)
    agentCityField.find.enterText(agentCity)
    selectFromAutocomplete(agentCountryField, agentCountry)
    agentPostalCodeField.find.enterText(agentPostalCode)
  }

  def getAgentEori(): String = agentEoriField.find.getAttribute("value")

  def getAgentCompanyName(): String = agentCompanyNameField.find.getAttribute("value")

  def getStreetAndNumber(): String = agentStreetAndNumberField.find.getAttribute("value")

  def getCity(): String = agentCityField.find.getAttribute("value")

  def getPostcode(): String = agentPostalCodeField.find.getAttribute("value")
}
