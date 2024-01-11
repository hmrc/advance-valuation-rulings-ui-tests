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

package uk.gov.hmrc.test.ui.pages.base

import org.openqa.selenium.By

trait YesNoPage extends BasePage {
  import uk.gov.hmrc.test.ui.pages._

  private val radioOptionYes = "(//input[@type='radio'])[1]"
  private val radioOptionNo  = "(//input[@type='radio'])[2]"

  private val yesRadio = By.xpath(radioOptionYes)
  private val noRadio  = By.xpath(radioOptionNo)

  def selectYes(): YesNoPage = {
    yesRadio.find.click()
    this
  }
  def selectNo(): YesNoPage  = {
    noRadio.find.click()
    this
  }

  def select(value: Boolean): YesNoPage =
    if (value) selectYes() else selectNo()
}
