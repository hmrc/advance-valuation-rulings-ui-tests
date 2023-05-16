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

import org.openqa.selenium.By
object YouMustHaveACommodityCode extends BasePage {

  val pageTitle =
    "You must have a commodity code in order to carry on with your application"

  val ele_ImportingGoodsIntoUk            = "commodity_code_link_one"
  val ele_CustomValueOfYourImportedGoods  = "commodity_code_link_two"
  val ele_GetALegallyBindingDecision      = "commodity_code_link_three"
  val link_ImportingGoodsIntoUk           = "https://www.gov.uk/import-goods-into-uk"
  val link_CustomValueOfYourImportedGoods =
    "https://www.gov.uk/guidance/prepare-to-work-out-the-customs-value-of-your-imported-goods"
  val link_GetALegallyBindingDecision     =
    "https://www.gov.uk/guidance/apply-for-an-advance-tariff-ruling"
  val btn_FindYourCommodityCode           =
    "//a[@href='https://www.gov.uk/trade-tariff']"

  def linkNavigationValidation(): Unit = {
    assert(
      driver
        .findElement(By.id(ele_ImportingGoodsIntoUk))
        .getAttribute("href") == link_ImportingGoodsIntoUk
    )
    assert(
      driver
        .findElement(By.id(ele_CustomValueOfYourImportedGoods))
        .getAttribute("href") == link_CustomValueOfYourImportedGoods
    )
    assert(
      driver
        .findElement(By.id(ele_GetALegallyBindingDecision))
        .getAttribute("href") == link_GetALegallyBindingDecision
    )
    assert(driver.findElement(By.xpath(btn_FindYourCommodityCode)).isDisplayed)
  }
}
