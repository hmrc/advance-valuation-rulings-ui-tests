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

package uk.gov.hmrc.test.ui.cucumber.stepdefs

import org.openqa.selenium.By

trait ChangeImporterRoleSteps extends BaseStepDef {

  And("I click on the 'Back' link") { () =>
    driver.findElement(By.partialLinkText("Back")).click()
  }

  And("The 'An employee of the organisation' radio has been previously selected") { () =>
    driver.findElement(By.id("value_0")).isSelected shouldBe true
  }

  And("The 'Agent acting on behalf of an organisation' radio has been previously selected") { () =>
    driver.findElement(By.id("value_1")).isSelected shouldBe true
  }

  And("The user clicks on the 'An employee of the organisation' radio") { () =>
    driver.findElement(By.id("value_0")).click()
  }

  And("The user clicks on the 'Agent acting on behalf of an organisation' radio") { () =>
    driver.findElement(By.id("value_1")).click()
  }

  And("I click the continue button") { () =>
    val continueButton = "govuk-button"
    driver.findElement(By.className(continueButton)).click()
  }

  And("^The page title is: (.*)$") { (titleExpected: String) =>
    val title: String = driver.getTitle
    title should include(titleExpected)
  }

  And("I click on the change link on the check your answers page") { () =>
    driver.findElement(By.id("change-role")).click()
  }

  And("I click on the service header") { () =>
    driver.findElement(By.className("hmrc-header__service-name")).click()
  }

  And("I click on the 'Continue application' link") { () =>
    driver.findElement(By.partialLinkText("Continue application")).click()
  }

  And("^I click the (.*) radio button$") { (yesNo: String) =>
    yesNo.toLowerCase() match {
      case "yes" => driver.findElement(By.cssSelector("#value")).click()
      case "no"  => driver.findElement(By.cssSelector("#value-no")).click()
      case s     => fail(s"[StepDefinitions] yes/no radio failed to recognise and click: $s")
    }
  }

}
