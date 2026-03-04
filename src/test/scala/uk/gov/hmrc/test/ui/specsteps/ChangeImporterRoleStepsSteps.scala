/*
 * Copyright 2026 HM Revenue & Customs
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

package uk.gov.hmrc.ui.specsteps

import org.scalatest.matchers.should.Matchers.*
import org.scalatest.Assertions.fail

import org.openqa.selenium.support.ui.FluentWait
import org.openqa.selenium.{By, WebDriver}
import java.time.Duration
import uk.gov.hmrc.test.ui.driver.BrowserDriver

object ChangeImporterRoleStepsSteps extends BrowserDriver {

  // I click on the 'Back' link
  def andIClickOnTheBackLink(): Unit = {
    driver.findElement(By.partialLinkText("Back")).click()
  }

  // The 'An employee of the organisation' radio has been previously selected
  def andTheAnEmployeeOfTheOrganisationRadioHasBeenPreviouslySelected(): Unit = {
    driver.findElement(By.id("value_0")).isSelected shouldBe true
  }

  // The 'Agent acting on behalf of an organisation' radio has been previously selected
  def andTheAgentActingOnBehalfOfAnOrganisationRadioHasBeenPreviouslySelected(): Unit = {
    driver.findElement(By.id("value_1")).isSelected shouldBe true
  }

  // The user clicks on the 'An employee of the organisation' radio
  def andTheUserClicksOnTheAnEmployeeOfTheOrganisationRadio(): Unit = {
    driver.findElement(By.id("value_0")).click()
  }

  // The user clicks on the 'Agent acting on behalf of an organisation' radio
  def andTheUserClicksOnTheAgentActingOnBehalfOfAnOrganisationRadio(): Unit = {
    driver.findElement(By.id("value_1")).click()
  }

  // I click the continue button
  def andIClickTheContinueButton(): Unit = {
    val continueButton = "govuk-button"
        driver.findElement(By.className(continueButton)).click()
  }

  // ^The page title is: (.*)$
  def andThePageTitleIsX(titleExpected: String): Unit = {
    val fluentWait = new FluentWait[WebDriver](driver)
          .withTimeout(Duration.ofSeconds(15))
          .pollingEvery(Duration.ofMillis(500))
          .ignoring(classOf[Exception])

        fluentWait.until((driver: WebDriver) => {
          driver.getTitle.contains(titleExpected)
        })

        val title: String = driver.getTitle
        title should include(titleExpected)
  }

  // I click on the change link on the check your answers page
  def andIClickOnTheChangeLinkOnTheCheckYourAnswersPage(): Unit = {
    driver.findElement(By.id("change-role")).click()
  }

  // I click on the service header
  def andIClickOnTheServiceHeader(): Unit = {
    driver.findElement(By.className("govuk-service-navigation__service-name")).click()
  }

  // I click on the 'Continue application' link
  def andIClickOnTheContinueApplicationLink(): Unit = {
    driver.findElement(By.partialLinkText("Continue application")).click()
  }

  // ^I click the (.*) radio button$
  def andIClickTheXRadioButton(yesNo: String): Unit = {
    yesNo.toLowerCase() match {
          case "yes" => driver.findElement(By.cssSelector("#value")).click()
          case "no"  => driver.findElement(By.cssSelector("#value-no")).click()
          case s     => fail(s"[StepDefinitions] yes/no radio failed to recognise and click: $s")
        }
  }

}
