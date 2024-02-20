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

import org.openqa.selenium.By
import org.openqa.selenium.support.ui.FluentWait
import uk.gov.hmrc.test.ui.pages.base.YesNoPage

import java.time.Duration

object DoYouWantThisFileToBeMarkedAsConfidential extends YesNoPage {

  val pageTitle =
    "Tell us if you want to make this document confidential"

  def pollingClickAttempt(): Unit = {
    val threeSeconds   = 3
    val fifteenSeconds = 15
    new FluentWait(
      driver.findElement(By.className(continueButton)).click()
    ).pollingEvery(Duration.ofSeconds(threeSeconds))
      .withTimeout(Duration.ofSeconds(fifteenSeconds))
      .until { _ =>
        driver.findElement(By.className(continueButton)).click()
        driver.findElement(By.tagName("h1")).getText == pageTitle
      }
  }
}
