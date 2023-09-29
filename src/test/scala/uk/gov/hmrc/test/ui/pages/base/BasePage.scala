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
import uk.gov.hmrc.test.ui.conf.TestConfiguration
import uk.gov.hmrc.test.ui.driver.BrowserDriver

import org.openqa.selenium.{By, WebDriver}
import org.scalatest.matchers.should.Matchers

trait BasePage extends BrowserDriver with Matchers {
  import BasePage._
  val pageTitle: String

  val continueButton          = "govuk-button"
  val ele_StartNewApplication = "csrfToken"
  val goToAppAndRuling        = "Apply for an Advance Valuation Ruling"
  val saveAsDraftButton       = "//button[contains(text(),'Save as draft')]"
  val link_cancelButton       = "cancel_application"

  def submitPage(): Unit =
    driver.findElement(By.className(continueButton)).click()

  def clickSaveAsDraftButton(): Unit =
    driver.findElement(By.xpath(saveAsDraftButton)).click()

  def clickGoToApplicationAndRulingButton(): Unit =
    driver.findElement(By.linkText(goToAppAndRuling)).click()

  def clickCancelApplicationLink(): Unit =
    driver.findElement(By.id(link_cancelButton)).click()

  def loadPage(): this.type = {
    onPage(this.pageTitle + titleSuffix)
    this
  }

  def onPage(pageTitle: String): Unit = {
    val actual: String = driver.getTitle.trim

    if (actual != pageTitle)
      throw PageNotFoundException(
        s"Expected '$pageTitle' page, but found '$actual' page."
      )
  }

  def selectFromAutocomplete(inputId: String, data: String): Unit = {
    driver.findElement(By.id(inputId)).sendKeys(data)
    driver.findElement(By.cssSelector(s"""#country > option[value="$data"]""")).click()
  }
}

case class PageNotFoundException(s: String) extends Exception(s)

object BasePage {
  lazy val baseUrl = TestConfiguration.environmentHost

  val publicEORINumber  = "GBE9XSDF10BCKEYAX"
  val privateEORINumber = "GB112SDF10BCKEYAX"
  val invalidEORINumber = "GB321888888041"
  val employeeOfOrg     = "An employee of the organisation"
  val agentOfOrg        = "Agent acting on behalf of an organisation"
  val agentForTrader    = "Agent acting on behalf of a trader"

  val EORINumber      = "GB333186844456"
  val continueButton  = "govuk-button"
  val titleSuffix     = " - Apply for an Advance Valuation Ruling - GOV.UK"
  val arsHomePageText = "Your applications" + titleSuffix
  val URL_ARSHomePage = s"$baseUrl/advance-valuation-ruling/applications-and-rulings"

  def signOut()(implicit driver: WebDriver): Unit =
    driver.findElement(By.className("hmrc-sign-out-nav__link")).click()

  def invokeURL(
    url: String,
    affinityGroup: String,
    credentialRole: String,
    hasEnrolment: Boolean = true
  )(implicit
    driver: WebDriver
  ): Unit = {
    driver.manage().deleteAllCookies()
    driver.navigate().to(url)
    val titlecheck = driver.getTitle
    if (titlecheck == "Authority Wizard") {
      driver.findElement(By.id("redirectionUrl")).clear()
      driver.findElement(By.id("redirectionUrl")).sendKeys(URL_ARSHomePage)
      driver.findElement(By.id("redirectionUrl"))
      driver.findElement(By.id("affinityGroupSelect")).sendKeys(affinityGroup)
      driver.findElement(By.id("credential-role-select")).sendKeys(credentialRole)
      if (hasEnrolment) {
        driver
          .findElement(By.cssSelector("input[name='enrolment[0].name']"))
          .sendKeys("HMRC-ATAR-ORG")
        driver
          .findElement(By.cssSelector("input[name='enrolment[0].taxIdentifier[0].name']"))
          .sendKeys("EORINumber")
        driver
          .findElement(By.cssSelector("input[name='enrolment[0].taxIdentifier[0].value']"))
          .sendKeys(EORINumber)
      } else {
        driver
          .findElement(By.cssSelector("input[name='enrolment[0].name']"))
          .clear()
        driver
          .findElement(By.cssSelector("input[name='enrolment[0].taxIdentifier[0].name']"))
          .clear()
        driver
          .findElement(By.cssSelector("input[name='enrolment[0].taxIdentifier[0].value']"))
          .clear()
      }

      driver.findElement(By.className(continueButton)).click()
    }
  }
}
