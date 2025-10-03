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

trait TextAreaPage extends BasePage {
  import uk.gov.hmrc.test.ui.pages._

  private val textArea = By.id("value")

  def enterText(content: String): TextAreaPage = {
    try {
      val element = fluentWait.until(ExpectedConditions.elementToBeClickable(textArea))
      element.clear()
      element.sendKeys(content)
    } catch {
      case e: StaleElementReferenceException =>
        println("StaleElementReferenceException caught. Retrying with fresh element...")
        val refreshedElement = fluentWait.until(ExpectedConditions.elementToBeClickable(textArea))
        refreshedElement.clear()
        refreshedElement.sendKeys(content)
    }
    this
  }

  def getText: String = {
    val element = fluentWait.until(ExpectedConditions.visibilityOfElementLocated(textArea))
    element.getText
  }
}
