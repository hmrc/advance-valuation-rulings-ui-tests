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

object AgentSelectRole extends BasePage {

  override val pageTitle: String          = "How would you describe your role as an importer?"
  private val employeeOfTheOrganisation   = "div:nth-of-type(1) > input[name='value']"
  private val agentActingOnAnOrganisation = "div:nth-of-type(2) > input[name='value']"
  private val agentActingOnBehalfOfTrader = "div:nth-of-type(3) > input[name='value']"

  def selectRole(role: String): Unit =
    if (role == "An employee of the organisation") {
      driver.findElement(By.cssSelector(employeeOfTheOrganisation)).click
    } else if (role == "Agent acting on behalf of an organisation") {
      driver.findElement(By.cssSelector(agentActingOnAnOrganisation)).click
    } else if (role == "Agent acting on behalf of a trader") {
      driver.findElement(By.cssSelector(agentActingOnBehalfOfTrader)).click
    } else {
      throw new Exception("Invalid role selected")
    }
}
