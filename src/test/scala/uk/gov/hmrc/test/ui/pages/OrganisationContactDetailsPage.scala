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

package uk.gov.hmrc.test.ui.pages

import uk.gov.hmrc.test.ui.pages.base.BasePage

import org.openqa.selenium.By

object OrganisationContactDetailsPage extends BasePage {
  val pageTitle    = "Your own contact details"
  val nameField    = By.id("name")
  val emailField   = By.id("email")
  val contactField = By.id("phone")

  def enterContactDetails(
    name: String,
    email: String,
    contact: String
  ): Unit = {
    nameField.find.enterText(name)
    emailField.find.enterText(email)
    contactField.find.enterText(contact)
  }
}