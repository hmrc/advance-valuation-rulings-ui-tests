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

import uk.gov.hmrc.test.ui.pages.base.BasePage
import org.openqa.selenium.By
object WhatIsTheCommodityCode extends BasePage {

  val goodsNameDisplay  = "What is the commodity code for the goods?"
  val pageTitle         = "What is the commodity code for the goods?"
  val ele_CommodityCode = "value"
  val redirectUrl       = "/enter-commodity-code"

  override def loadPage(): this.type = {
    super.loadPage()
    assert(driver.findElement(By.tagName("h1")).getText() == goodsNameDisplay)
    this
  }

  def enterCommodityCode(Code: String): Unit = {
    driver.findElement(By.id(ele_CommodityCode)).clear()
    driver.findElement(By.id(ele_CommodityCode)).sendKeys(Code)
  }

  def getCommodityCode(): String = driver.findElement(By.id(ele_CommodityCode)).getAttribute("value")
}
