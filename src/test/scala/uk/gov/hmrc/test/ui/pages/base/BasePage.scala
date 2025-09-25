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
import org.openqa.selenium.support.ui.{ExpectedConditions, FluentWait}
import uk.gov.hmrc.test.ui.conf.TestConfiguration
import uk.gov.hmrc.test.ui.driver.BrowserDriver
import org.openqa.selenium.*
import org.scalatest.concurrent.Eventually.eventually
import org.scalatest.concurrent.Futures.{interval, timeout}
import org.scalatest.matchers.should.Matchers

import java.time.Duration
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

  lazy val fluentWait: FluentWait[WebDriver] = new FluentWait[WebDriver](driver)
    .withTimeout(Duration.ofSeconds(15))
    .pollingEvery(Duration.ofMillis(500))
    .ignoring(classOf[StaleElementReferenceException])
    .ignoring(classOf[NoSuchElementException])
    .ignoring(classOf[ElementNotInteractableException])


  def findElementWithWait(by: By): WebElement = {
    val element = fluentWait.until(ExpectedConditions.presenceOfElementLocated(by))
    js.executeScript("arguments[0].scrollIntoView(true);", element)
    element
  }

  def findClickableElementWithWait(by: By): WebElement = {
    fluentWait.until(ExpectedConditions.elementToBeClickable(by))
  }

  def waitForElementToBeVisible(by: By): WebElement = {
    fluentWait.until(ExpectedConditions.visibilityOfElementLocated(by))
  }

  def submitPage(): Unit = {
    val currentUrl = driver.getCurrentUrl
    val submitBtn = findClickableElementWithWait(By.className(continueButton))
    submitBtn.click()

    // Wait for navigation to complete (URL change or page load)
    fluentWait.until((driver: WebDriver) => {
      val newUrl = driver.getCurrentUrl
      newUrl != currentUrl || js.executeScript("return document.readyState").toString == "complete"
    })

    waitForPageToLoad()
  }

  def clickGoToApplicationAndRulingButton(): Unit =
    val button = findClickableElementWithWait(By.linkText(goToAppAndRuling))
    button.click()
    waitForPageToLoad()

  def clickCancelApplicationLink(): Unit = {
    val link = findClickableElementWithWait(By.id(link_cancelButton))
    link.click()
    waitForPageToLoad()
  }

  def noChangeButton: List[String] = {
    fluentWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(fieldsWithNoActions))
    driver.findElements(fieldsWithNoActions).asScala.toList.map(_.getText)
  }

  def waitForPageTitleToMatch(): Unit = {
    val expectedTitle = this.pageTitle + titleSuffix
    fluentWait.until((driver: WebDriver) => {
      val currentTitle = driver.getTitle.trim
      currentTitle == expectedTitle
    })
  }

  def loadPage(): this.type = {
    try {
      waitForPageToLoad()
      waitForPageTitleToMatch()
      this
    } catch {
      case e: TimeoutException =>
        val currentTitle = driver.getTitle.trim
        val expectedTitle = this.pageTitle + titleSuffix
        throw PageNotFoundException(
          s"Page load timeout. Expected '$expectedTitle' but found '$currentTitle'. URL: ${driver.getCurrentUrl}"
        )
      case e: Exception =>
        throw PageNotFoundException(
          s"Error loading page: ${e.getMessage}. Current title: '${driver.getTitle}'. URL: ${driver.getCurrentUrl}"
        )
    }
  }

  def onPage(pageTitle: String): Unit = {
    fluentWait.until((driver: WebDriver) => {
      val actual: String = driver.getTitle.trim
      if (actual != pageTitle) {
        false // This will cause FluentWait to retry
      } else {
        true
      }
    })
  }

  def waitForPageToLoad(): Unit = {
      val completed = js
        .executeScript("return document.readyState")
        .toString
        .equals("complete")
      if (!completed) {
        throw new RuntimeException("Page not loaded yet")
      }

      val currentTitle = driver.getTitle.trim
      if (!currentTitle.contains(pageTitle)) {
        throw new RuntimeException(s"Expected title containing '$pageTitle', but got '$currentTitle'")
      }
  }



  private def cleanupAutoCompleteField(e: WebElement): Unit = {
    e.click()
    val currentText = Option(e.getAttribute("value")).getOrElse("").trim
    (1 to currentText.length + 10).foreach(_ => e.sendKeys(Keys.BACK_SPACE))
  }

  private def findElement(element: By): WebElement = {
    val webElement = findElementWithWait(element)
    js.executeScript("arguments[0].scrollIntoView(true);", webElement)
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

  def signOut()(using driver: WebDriver): Unit = {
    val fluentWait = new FluentWait[WebDriver](driver)
      .withTimeout(Duration.ofSeconds(10))
      .pollingEvery(Duration.ofMillis(500))
      .ignoring(classOf[Exception])

    val signOutLink = fluentWait.until(ExpectedConditions.elementToBeClickable(By.className("hmrc-sign-out-nav__link")))
    signOutLink.click()
  }

  def invokeURL(url: String, affinityGroup: String, credentialRole: String, hasEnrolment: Boolean = true)(using
                                                                                                          driver: WebDriver
  ): Unit = {
    val fluentWait = new FluentWait[WebDriver](driver)
      .withTimeout(Duration.ofSeconds(15))
      .pollingEvery(Duration.ofMillis(500))
      .ignoring(classOf[Exception])

    driver.manage().deleteAllCookies()
    driver.navigate().to(url)

    fluentWait.until((driver: WebDriver) => {
      driver.getTitle != null && driver.getTitle.nonEmpty
    })

    val titleCheck = driver.getTitle
    if (titleCheck == "Authority Wizard") {
      fluentWait.until(ExpectedConditions.presenceOfElementLocated(By.id("redirectionUrl"))).clear()
      driver.findElement(By.id("redirectionUrl")).sendKeys(URL_ARSHomePage)
      driver.findElement(By.id("affinityGroupSelect")).sendKeys(affinityGroup)
      driver.findElement(By.id("credential-role-select")).sendKeys(credentialRole)

      if (hasEnrolment) {
        driver.findElement(By.cssSelector("input[name='enrolment[0].name']")).sendKeys("HMRC-ATAR-ORG")
        driver.findElement(By.cssSelector("input[name='enrolment[0].taxIdentifier[0].name']")).sendKeys("EORINumber")
        driver.findElement(By.cssSelector("input[name='enrolment[0].taxIdentifier[0].value']")).sendKeys(EORINumber)
      } else {
        driver.findElement(By.cssSelector("input[name='enrolment[0].name']")).clear()
        driver.findElement(By.cssSelector("input[name='enrolment[0].taxIdentifier[0].name']")).clear()
        driver.findElement(By.cssSelector("input[name='enrolment[0].taxIdentifier[0].value']")).clear()
      }

      val continueBtn = fluentWait.until(ExpectedConditions.elementToBeClickable(By.className(continueButton)))
      continueBtn.click()
    }
  }

  def getLastDraftCreated()(using driver: WebDriver): String = {
    val fluentWait = new FluentWait[WebDriver](driver)
      .withTimeout(Duration.ofSeconds(10))
      .pollingEvery(Duration.ofMillis(500))
      .ignoring(classOf[Exception])

    fluentWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("table tr td:nth-child(1)")))
    driver.findElements(By.cssSelector("table tr td:nth-child(1)")).get(0).getText
  }
}
