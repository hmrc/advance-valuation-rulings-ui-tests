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

trait OptionSelectionPage extends BasePage {
  import uk.gov.hmrc.test.ui.pages._

  val optionOne   = By.id("value_0")
  val optionTwo   = By.id("value_1")
  val optionThree = By.id("value_2")
  val optionFour  = By.id("value_3")
  val optionFive  = By.id("value_4")
  val optionSix   = By.id("value_5")

  def selectOption(optionNumber: Int): OptionSelectionPage = {
    optionNumber match {
      case 1 => optionOne.find.click()
      case 2 => optionTwo.find.click()
      case 3 => optionThree.find.click()
      case 4 => optionFour.find.click()
      case 5 => optionFive.find.click()
      case 6 => optionSix.find.click()
      case _ => throw new Exception("Invalid option number")
    }
    this
  }
}
