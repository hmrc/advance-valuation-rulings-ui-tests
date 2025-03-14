/*
 * Copyright 2025 HM Revenue & Customs
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
import org.openqa.selenium.support.ui.ExpectedConditions
import uk.gov.hmrc.test.ui.conf.TestConfiguration
import uk.gov.hmrc.test.ui.driver.BrowserDriver
import org.openqa.selenium._
import org.scalatest.matchers.should.Matchers
import scala.jdk.CollectionConverters.*

trait BasePage extends BrowserDriver with Matchers {
  import BasePage._

  val pageTitle: String

  val continueButton    = "govuk-button"
  val goToAppAndRuling  = "Apply for an Advance Valuation Ruling"
  val link_cancelButton = "cancel_application"

  val nameField: By           = By.id("name")
  val emailField: By          = By.id("email")
  val contactField: By        = By.id("phone")
  val jobTitleField: By       = By.id("jobTitle")
  val fieldsWithNoActions: By = By.className("govuk-summary-list__row--no-actions")

  lazy val js: JavascriptExecutor = driver.asInstanceOf[JavascriptExecutor]

  def submitPage(): Unit =
    driver.findElement(By.className(continueButton)).click()

  def clickGoToApplicationAndRulingButton(): Unit =
    driver.findElement(By.linkText(goToAppAndRuling)).click()

  def clickCancelApplicationLink(): Unit =
    driver.findElement(By.id(link_cancelButton)).click()

  def noChangeButton: List[String] =
    driver.findElements(fieldsWithNoActions).asScala.toList.map(_.getText)

  def loadPage(): this.type = {
    onPage(this.pageTitle + titleSuffix)
    this
  }

  def onPage(pageTitle: String): Unit = {
    val actual: String = driver.getTitle.trim

    if (actual != pageTitle) {
      throw PageNotFoundException(
        s"Expected '$pageTitle' page, but found '$actual' page."
      )
    }
  }

  private def findElementWithWait(element: By): WebElement = {
    val webElement = webDriverWait().until(ExpectedConditions.visibilityOfElementLocated(element))
    js.executeScript("arguments[0].scrollIntoView()", webElement)
    webElement
  }

  private def cleanupAutoCompleteField(e: WebElement): Unit = {
    e.click()
    val currentText = Option(e.getAttribute("value")).getOrElse("").trim
    (1 to currentText.length + 10).foreach(_ => e.sendKeys(Keys.BACK_SPACE))
  }

  private def findElement(element: By): WebElement = {
    val webElement = driver.findElement(element)
    js.executeScript("arguments[0].scrollIntoView()", webElement)
    webElement
  }

  private def webDriverId(X: String): WebElement = findElement(By.id(X))

  def chooseInAutocomplete(id: String, lookup: String): Unit = {
    val e           = findElementWithWait(By.id(id))
    val currentText = Option(e.getAttribute("value")).getOrElse("").trim

    if (currentText != lookup) {
      // cleanup the fields before populating
      cleanupAutoCompleteField(e)
      e.sendKeys(lookup)
      if (id.equals("searchTerm")) {
        webDriverId("searchTerm__option--0").click()
      } else {
        webDriverId(s"${id}__option--0").click()
      }
    }
  }
}

case class PageNotFoundException(s: String) extends Exception(s)

object BasePage {
  lazy val baseUrl: String = TestConfiguration.environmentHost

  val titleSuffix: String     = " - Apply for an Advance Valuation Ruling - GOV.UK"
  val arsHomePageText: String = "Your applications" + titleSuffix
  val URL_ARSHomePage: String = s"$baseUrl/advance-valuation-ruling/applications-and-rulings"

  val publicEORINumber  = "GBE9XSDF10BCKEYAX"
  val privateEORINumber = "GB112SDF10BCKEYAX"
  val invalidEORINumber = "GB321888888041"
  val employeeOfOrg     = "An employee of the organisation"
  val agentOfOrg        = "Agent acting on behalf of an organisation"
  val agentForTrader    = "Agent acting on behalf of a trader"
  val EORINumber        = "GB333186844456"
  val continueButton    = "govuk-button"

  def signOut()(using driver: WebDriver): Unit =
    driver.findElement(By.className("hmrc-sign-out-nav__link")).click()

  def invokeURL(url: String, affinityGroup: String, credentialRole: String, hasEnrolment: Boolean = true)(using
    driver: WebDriver
  ): Unit = {
    driver.manage().deleteAllCookies()
    driver.navigate().to(url)
    val titleCheck = driver.getTitle
    if (titleCheck == "Authority Wizard") {
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

  def getLastDraftCreated()(using driver: WebDriver): String =
    driver.findElements(By.cssSelector("table tr td:nth-child(1)")).get(0).getText
}
