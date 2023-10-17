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

import org.openqa.selenium.support.ui.{FluentWait, WebDriverWait}
import org.openqa.selenium.{By, WebDriver}
import uk.gov.hmrc.test.ui.pages.base.BasePage

import java.time.Duration

object UploadSupportingDocuments extends BasePage {

  val pageTitle = "Upload supporting documents"

  val ele_UploadDocument = "file-input"

  def pollingClick(): FluentWait[Unit] =
    new FluentWait(driver.findElement(By.className(continueButton)).click())
      .pollingEvery(Duration.ofSeconds(3))
      .withTimeout(Duration.ofSeconds(15))

  // Old method
//  def uploadDocument(uploadFilePath: String): Unit = {
//    driver
//      .findElement(By.id(ele_UploadDocument))
//      .sendKeys(uploadFilePath)
//    submitPage()
//    Thread.sleep(5000)
//  }

  def uploadDocument(uploadFilePath: String)(implicit driver: WebDriver): Unit = {
    driver
      .findElement(By.id(ele_UploadDocument))
      .sendKeys(uploadFilePath)
    pollingClick()
  }
}
