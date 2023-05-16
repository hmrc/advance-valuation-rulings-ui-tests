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
import uk.gov.hmrc.test.ui.pages.base.{BasePage, YesNoPage}

import org.openqa.selenium.By

object AgentSelectRole extends BasePage {

  override val pageTitle: String          = "Authority Wizard"
  private val employeeOfTheOrganisation   = "div:nth-of-type(1) > input[name='value']"
  private val agentActingOnAnOrganisation = "div:nth-of-type(2) > input[name='value']"

  def selectRole(Role: Boolean = true): Unit =
    if (Role) {
      driver.findElement(By.cssSelector(employeeOfTheOrganisation)).click
    } else {
      driver.findElement(By.cssSelector(agentActingOnAnOrganisation)).click
    }

}
