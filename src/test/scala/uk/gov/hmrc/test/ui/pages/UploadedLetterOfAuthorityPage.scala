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

  val pageTitle = "Uploaded letter of authority"
  val ele_UploadDocument = "file-input"

  def uploadAuthLetterPollingClick(): Unit = {
    println(s"=== uploadAuth: Starting on URL: ${driver.getCurrentUrl}")

    fluentWait.until((driver: WebDriver) => {
      println(s"=== uploadAuth: Looking for button...")
      val button = fluentWait.until(ExpectedConditions.elementToBeClickable(By.className(continueButton)))
      println(s"=== uploadAuth: Button found, clicking...")
      button.click()
      println(s"=== uploadAuth: After click, URL: ${driver.getCurrentUrl}, Title: ${driver.getTitle}")

      println(s"=== uploadAuth: Looking for h1...")
      val h1 = fluentWait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("h1")))
      val h1Text = h1.getText
      println(s"=== uploadAuth: H1 text: '$h1Text', Expected: '$pageTitle', Match: ${h1Text == pageTitle}")

      h1Text == pageTitle
    })

    println(s"=== uploadAuth: Success! Final URL: ${driver.getCurrentUrl}")
  }
}