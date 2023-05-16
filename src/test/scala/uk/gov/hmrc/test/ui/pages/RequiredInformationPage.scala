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
object RequiredInformationPage extends BasePage {

  import org.openqa.selenium.By

  val pageTitle =
    "Before you start your application"

  val ele_Checkbox1 = By.id("value_0")
  val ele_Checkbox2 = By.id("value_1")
  val ele_Checkbox3 = By.id("value_2")
  val ele_Checkbox4 = By.id("value_3")
  val ele_Checkbox5 = By.id("value_4")
  val ele_Checkbox6 = By.id("value_5")
  val ele_Continue  = By.id("govuk-button")

  private val allBoxes = Seq(
    ele_Checkbox1,
    ele_Checkbox2,
    ele_Checkbox3,
    ele_Checkbox4,
    ele_Checkbox5,
    ele_Checkbox6
  )

  def selectAllCheckbox(): this.type = {
    allBoxes.foreach {
      box => if (!driver.findElement(box).isSelected) driver.findElement(box).click()
    }
    this
  }
}
