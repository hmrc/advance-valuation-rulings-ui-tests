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

package uk.gov.hmrc.test.ui

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

package object pages {
  implicit class ByExtension(val by: By) extends AnyVal {
    def find(implicit driver: WebDriver): WebElement = driver.findElement(by)
  }

  implicit class WebElementExtension(val element: WebElement) extends AnyVal {
    def click(): Unit = element.click()

    def enterText(text: String): WebElement = {
      element.clear()
      element.sendKeys(text)
      element
    }
  }
}
