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
import org.scalatest.matchers.should.Matchers
import uk.gov.hmrc.configuration.TestEnvironment
import uk.gov.hmrc.selenium.webdriver.Driver

trait BasePage extends Matchers {
  import BasePage._
  val pageTitle: String

  val continueButton          = "govuk-button"
  val ele_StartNewApplication = "csrfToken"
  val goToAppAndRuling        = "Apply for an Advance Valuation Ruling"
  val saveAsDraftButton       = "//button[contains(text(),'Save as draft')]"
  val link_cancelButton       = "cancel_application"

  def submitPage(): Unit =
    Driver.instance.findElement(By.className(continueButton)).click()

  def clickSaveAsDraftButton(): Unit =
    Driver.instance.findElement(By.xpath(saveAsDraftButton)).click()

  def clickGoToApplicationAndRulingButton(): Unit =
    Driver.instance.findElement(By.linkText(goToAppAndRuling)).click()

  def clickCancelApplicationLink(): Unit =
    Driver.instance.findElement(By.id(link_cancelButton)).click()

  def loadPage(): this.type = {
    onPage(this.pageTitle + titleSuffix)
    this
  }

  def onPage(pageTitle: String): Unit = {
    val actual: String = Driver.instance.getTitle.trim

    if (actual != pageTitle) {
      throw PageNotFoundException(
        s"Expected '$pageTitle' page, but found '$actual' page."
      )
    }
  }

  def selectFromAutocomplete(inputId: String, data: String): Unit = {
    Driver.instance.findElement(By.id(inputId)).sendKeys(data)
    Driver.instance.findElement(By.cssSelector(s"""#country > option[value="$data"]""")).click()
  }

}

case class PageNotFoundException(s: String) extends Exception(s)

object BasePage {

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
  val URL_ARSHomePage = TestEnvironment.url("advance-valuation-rulings-frontend") + "/applications-and-rulings"

  def signOut(): Unit =
    Driver.instance.findElement(By.className("hmrc-sign-out-nav__link")).click()

  def invokeURL(
    url: String,
    affinityGroup: String,
    credentialRole: String,
    hasEnrolment: Boolean = true
  ): Unit = {
    Driver.instance.manage().deleteAllCookies()
    Driver.instance.navigate().to(url)
    val titlecheck = Driver.instance.getTitle
    if (titlecheck == "Authority Wizard") {
      Driver.instance.findElement(By.id("redirectionUrl")).clear()
      Driver.instance.findElement(By.id("redirectionUrl")).sendKeys(URL_ARSHomePage)
      Driver.instance.findElement(By.id("redirectionUrl"))
      Driver.instance.findElement(By.id("affinityGroupSelect")).sendKeys(affinityGroup)
      Driver.instance.findElement(By.id("credential-role-select")).sendKeys(credentialRole)
      if (hasEnrolment) {
        Driver.instance
          .findElement(By.cssSelector("input[name='enrolment[0].name']"))
          .sendKeys("HMRC-ATAR-ORG")
        Driver.instance
          .findElement(By.cssSelector("input[name='enrolment[0].taxIdentifier[0].name']"))
          .sendKeys("EORINumber")
        Driver.instance
          .findElement(By.cssSelector("input[name='enrolment[0].taxIdentifier[0].value']"))
          .sendKeys(EORINumber)
      } else {
        Driver.instance
          .findElement(By.cssSelector("input[name='enrolment[0].name']"))
          .clear()
        Driver.instance
          .findElement(By.cssSelector("input[name='enrolment[0].taxIdentifier[0].name']"))
          .clear()
        Driver.instance
          .findElement(By.cssSelector("input[name='enrolment[0].taxIdentifier[0].value']"))
          .clear()
      }

      Driver.instance.findElement(By.className(continueButton)).click()
    }
  }

}
