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

package uk.gov.hmrc.test.ui.pages

import org.openqa.selenium.{By, StaleElementReferenceException, WebDriver}
import org.openqa.selenium.support.ui.{ExpectedConditions, FluentWait}
import uk.gov.hmrc.test.ui.pages.base.BasePage

import java.time.Duration

object UploadedLetterOfAuthorityPage extends BasePage {

  val pageTitle          = "Uploaded letter of authority"
  val ele_UploadDocument = "file-input"

  def uploadAuthLetterPollingClick(): Unit = {
    fluentWait.until((driver: WebDriver) => {
      val button = fluentWait.until(ExpectedConditions.elementToBeClickable(By.className(continueButton)))
      button.click()

      val h1 = fluentWait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("h1")))
      h1.getText == pageTitle
    })
  }

}
