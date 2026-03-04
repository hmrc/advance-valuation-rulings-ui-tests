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

import uk.gov.hmrc.test.ui.pages._
import uk.gov.hmrc.test.ui.pages.base.BasePage.baseUrl
import uk.gov.hmrc.test.ui.pages.base.ScenarioContext
import uk.gov.hmrc.test.ui.driver.BrowserDriver

object MethodTwoStepDefinitionsSteps extends BrowserDriver {

  // I will be navigated to Outline Why Not Method One page
  def thenIWillBeNavigatedToOutlineWhyNotMethodOnePage(): Unit = {
    OutlineWhyNotMethodOne.loadPage()
  }

  // I enter {string} as my reason why I did not select method 1
  def andIEnterStringAsMyReasonWhyIDidNotSelectMethod1(reason: String): Unit = {
    OutlineWhyNotMethodOne
          .enterText(reason)
          .submitPage()
  }

  // I will be navigated to In the Past Have you used Method 1 to import any goods
  def thenIWillBeNavigatedToInThePastHaveYouUsedMethod1ToImportAnyGoods(): Unit = {
    HaveYouUsedMethodOneToImportInPast.loadPage()
  }

  // I select that I have used Method 1 to import goods and press continue
  def andISelectThatIHaveUsedMethod1ToImportGoodsAndPressContinue(): Unit = {
    HaveYouUsedMethodOneToImportInPast.selectYes().submitPage()
  }

  // I select that I have not used Method 1 to import goods and press continue
  def andISelectThatIHaveNotUsedMethod1ToImportGoodsAndPressContinue(): Unit = {
    HaveYouUsedMethodOneToImportInPast.selectNo().submitPage()
  }

  // I will be navigated to Describe the Identical Goods
  def thenIWillBeNavigatedToDescribeTheIdenticalGoods(): Unit = {
    DescribeTheIdenticalGoods
          .loadPage()
  }

  // I enter {string} as the description of the identical goods and press continue
  def andIEnterStringAsTheDescriptionOfTheIdenticalGoodsAndPressContinue(description: String): Unit = {
    DescribeTheIdenticalGoods
          .enterText(description)
          .submitPage()
  }

  // I enter {string} as the description of the identical goods
  def andIEnterStringAsTheDescriptionOfTheIdenticalGoods(identicalGoods: String): Unit = {
    DescribeTheIdenticalGoods.enterText(identicalGoods)
        ScenarioContext.setContext("identical goods", identicalGoods)
  }

  // I navigate to describe the identical goods page and compare the text
  def thenINavigateToDescribeTheIdenticalGoodsPageAndCompareTheText(): Unit = {
    val url = s"$baseUrl/advance-valuation-ruling/" +
          ScenarioContext.getContext("draftId") +
          DescribeTheIdenticalGoods.redirectUrl
        driver.get(url)
        assert(ScenarioContext.getContext("identical goods") == DescribeTheIdenticalGoods.getText)
  }

}
