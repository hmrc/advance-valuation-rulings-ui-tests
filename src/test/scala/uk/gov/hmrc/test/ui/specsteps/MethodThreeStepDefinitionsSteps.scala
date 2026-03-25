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

object MethodThreeStepDefinitionsSteps extends BrowserDriver {

  // I will be navigated to Explain Why not select method one or two
  def thenIWillBeNavigatedToExplainWhyNotSelectMethodOneOrTwo(): Unit = {
    ExplainWhyNotMethodOneOrTwo.loadPage()
  }

  // I will be navigated to Describe the Similar Goods page
  def thenIWillBeNavigatedToDescribeTheSimilarGoodsPage(): Unit = {
    DescribeTheSimilarGoodsPage.loadPage()
  }

  // I select {booleanValue} and continue in Have You Used Method One In the Past 90 days
  def andISelectBooleanValueAndContinueInHaveYouUsedMethodOneInThePast90Days(option: Boolean): Unit = {
    HaveYouUsedMethodOneToImportSimilarGoods.loadPage()
        HaveYouUsedMethodOneToImportSimilarGoods.select(option)
        HaveYouUsedMethodOneToImportSimilarGoods.submitPage()
  }

  // I enter a reason and continue in Explain why not method one or two page
  def andIEnterAReasonAndContinueInExplainWhyNotMethodOneOrTwoPage(): Unit = {
    ExplainWhyNotMethodOneOrTwo
          .enterText("Detailed explanation")
          .submitPage()
  }

  // I enter a {string} in explain why not method one or two page
  def andIEnterAStringInExplainWhyNotMethodOneOrTwoPage(whyNotMethodOneOrTwo: String): Unit = {
    ExplainWhyNotMethodOneOrTwo.enterText(whyNotMethodOneOrTwo)
        ScenarioContext.setContext("why not method one or two", whyNotMethodOneOrTwo)
  }

  // I navigate to explain why not select method one or two page and compare text
  def thenINavigateToExplainWhyNotSelectMethodOneOrTwoPageAndCompareText(): Unit = {
    val url = s"$baseUrl/advance-valuation-ruling/" +
          ScenarioContext.getContext("draftId") +
          ExplainWhyNotMethodOneOrTwo.redirectUrl
        driver.get(url)
        assert(ScenarioContext.getContext("why not method one or two") == ExplainWhyNotMethodOneOrTwo.getText)
  }

  // I enter a reason and continue in Describe the Similar Goods page
  def andIEnterAReasonAndContinueInDescribeTheSimilarGoodsPage(): Unit = {
    DescribeTheSimilarGoodsPage
          .enterText("Detailed explanation")
          .submitPage()
  }

  // I enter a {string} in Describe the Similar Goods page
  def andIEnterAStringInDescribeTheSimilarGoodsPage(similarGoodsDescription: String): Unit = {
    DescribeTheSimilarGoodsPage.enterText(similarGoodsDescription)
        ScenarioContext.setContext("similar goods description", similarGoodsDescription)
  }

  // I navigate to Describe the Similar Goods page and compare text
  def thenINavigateToDescribeTheSimilarGoodsPageAndCompareText(): Unit = {
    val url = s"$baseUrl/advance-valuation-ruling/" +
          ScenarioContext.getContext("draftId") +
          DescribeTheSimilarGoodsPage.redirectUrl
        driver.get(url)
        assert(ScenarioContext.getContext("similar goods description") == DescribeTheSimilarGoodsPage.getText)
  }

  // I will be navigated to have you used Valuation Method 1 to import similar goods
  def thenIWillBeNavigatedToHaveYouUsedValuationMethod1ToImportSimilarGoods(): Unit = {
    ExplainWhyNotMethodOneOrTwo.loadPage()
  }

  // I select that I have used Method 1 to import similar goods in the past 90 days
  def andISelectThatIHaveUsedMethod1ToImportSimilarGoodsInThePast90Days(): Unit = {
    ExplainWhyNotMethodOneOrTwo
          .enterText("Detailed explanation")
          .submitPage()
  }

  // I select that I have not used Method 1 to import similar goods in the past 90 days
  def andISelectThatIHaveNotUsedMethod1ToImportSimilarGoodsInThePast90Days(): Unit = {
    ExplainWhyNotMethodOneOrTwo
          .enterText("Detailed explanation")
          .submitPage()
  }

}
