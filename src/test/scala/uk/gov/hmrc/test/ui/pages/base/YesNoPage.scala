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

package uk.gov.hmrc.test.ui.pages.base

import org.openqa.selenium.{By, StaleElementReferenceException}
import org.openqa.selenium.support.ui.ExpectedConditions

trait YesNoPage extends BasePage {
  import uk.gov.hmrc.test.ui.pages._

  private val radioOptionYes = "(//input[@type='radio'])[1]"
  private val radioOptionNo  = "(//input[@type='radio'])[2]"

  private val yesRadio = By.xpath(radioOptionYes)
  private val noRadio  = By.xpath(radioOptionNo)

  def selectYes(): YesNoPage = {
    var attempts = 0
    while (attempts < 3) {
      try {
        val element = fluentWait.until(ExpectedConditions.presenceOfElementLocated(yesRadio))
        element.click()
        return this
      } catch {
        case _: StaleElementReferenceException =>
          attempts += 1
          if (attempts >= 3) throw new RuntimeException("Failed to click Yes radio after 3 attempts")
      }
    }
    this
  }

  def selectNo(): YesNoPage = {
    var attempts = 0
    while (attempts < 3) {
      try {
        val element = fluentWait.until(ExpectedConditions.presenceOfElementLocated(noRadio))
        element.click()
        return this
      } catch {
        case _: StaleElementReferenceException =>
          attempts += 1
          if (attempts >= 3) throw new RuntimeException("Failed to click No radio after 3 attempts")
      }
    }
    this
  }

  def select(value: Boolean): YesNoPage =
    if (value) selectYes() else selectNo()
}
