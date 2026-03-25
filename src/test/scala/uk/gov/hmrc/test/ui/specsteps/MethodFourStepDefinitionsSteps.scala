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

import uk.gov.hmrc.test.ui.pages._
import uk.gov.hmrc.test.ui.pages.base.BasePage.baseUrl
import uk.gov.hmrc.test.ui.pages.base.ScenarioContext
import uk.gov.hmrc.test.ui.driver.BrowserDriver

object MethodFourStepDefinitionsSteps extends BrowserDriver {

  // I will be navigated to explain why not methods one till three
  def thenIWillBeNavigatedToExplainWhyNotMethodsOneTillThree(): Unit = {
    ExplainWhyNotMethodsOneTwoOrThree.loadPage()
  }

  // I enter {string} as my reason why I did not select methods one till three and continue
  def andIEnterStringAsMyReasonWhyIDidNotSelectMethodsOneTillThreeAndContinue(reason: String): Unit = {
    ExplainWhyNotMethodsOneTwoOrThree
          .enterText(reason)
          .submitPage()
  }

  // I enter {string} as my reason why I did not select methods one till three
  def andIEnterStringAsMyReasonWhyIDidNotSelectMethodsOneTillThree(reason: String): Unit = {
    ExplainWhyNotMethodsOneTwoOrThree.enterText(reason)
        ScenarioContext.setContext("why not method one tll three", reason)
  }

  // I navigate to explain why not methods one till three page and compare text
  def andINavigateToExplainWhyNotMethodsOneTillThreePageAndCompareText(): Unit = {
    val url = s"$baseUrl/advance-valuation-ruling/" +
          ScenarioContext.getContext("draftId") +
          ExplainWhyNotMethodsOneTwoOrThree.redirectUrl
        driver.get(url)
        assert(ScenarioContext.getContext("why not method one tll three") == ExplainWhyNotMethodsOneTwoOrThree.getText)
  }

  // I will be navigated to Explain why you have selected Method 4
  def thenIWillBeNavigatedToExplainWhyYouHaveSelectedMethod4(): Unit = {
    ExplainWhyMethodFour.loadPage()
  }

  // I enter {string} as my reason for selecting method Method 4
  def andIEnterStringAsMyReasonForSelectingMethodMethod4(reason: String): Unit = {
    ExplainWhyMethodFour.enterText(reason).submitPage()
  }

}
