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
object ThisServiceIsDesignedForThose extends BasePage {

  val pageTitle =
    "This service is for importing goods into Great Britain"

  val ele_link_AdvanceTariffRulings = "advance_tariff_rulings_link"
  val ele_link_AdvanceOriginRulings = "advance_origin_rulings_link"
  val ele_link_StepByStepGuide      = "step_by_step_guide_link"
  val ele_link_GeneralInformation   = "general_information_link"
  val ele_link_HelpAndSupport       = "help_and_support_link"

  val link_AdvanceTariffRulings = "https://www.gov.uk/guidance/apply-for-an-advance-tariff-ruling"
  val link_AdvanceOriginRulings = "https://www.gov.uk/guidance/apply-for-an-advance-origin-ruling"
  val link_StepByStepGuide      = "https://www.gov.uk/import-goods-into-uk"
  val link_GeneralInformation   = "https://www.gov.uk/topic/business-tax/import-export"
  val link_HelpAndSupport       =
    "https://www.gov.uk/guidance/hmrc-email-alerts-videos-and-webinars-about-importing-and-exporting"

  def linkNavigationValidation() {
    assert(
      driver
        .findElement(By.id(ele_link_AdvanceTariffRulings))
        .getAttribute("href") == link_AdvanceTariffRulings
    )
    assert(
      driver
        .findElement(By.id(ele_link_AdvanceOriginRulings))
        .getAttribute("href") == link_AdvanceOriginRulings
    )
    assert(
      driver
        .findElement(By.id(ele_link_StepByStepGuide))
        .getAttribute("href") == link_StepByStepGuide
    )
    assert(
      driver
        .findElement(By.id(ele_link_GeneralInformation))
        .getAttribute("href") == link_GeneralInformation
    )
    assert(
      driver.findElement(By.id(ele_link_HelpAndSupport)).getAttribute("href") == link_HelpAndSupport
    )
  }
}
