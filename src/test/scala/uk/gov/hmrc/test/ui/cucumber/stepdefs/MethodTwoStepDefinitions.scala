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

package uk.gov.hmrc.test.ui.cucumber.stepdefs

import uk.gov.hmrc.selenium.webdriver.Driver
import uk.gov.hmrc.test.ui.pages._
import uk.gov.hmrc.test.ui.pages.base.BasePage.baseUrl
import uk.gov.hmrc.test.ui.pages.base.ScenarioContext

trait MethodTwoStepDefinitions extends BaseStepDef {
  Then("I will be navigated to Outline Why Not Method One page") { () =>
    OutlineWhyNotMethodOne.loadPage()
  }

  And("I enter {string} as my reason why I did not select method 1") { (reason: String) =>
    OutlineWhyNotMethodOne
      .enterText(reason)
      .submitPage()
  }

  Then("I will be navigated to In the Past Have you used Method 1 to import any goods") { () =>
    HaveYouUsedMethodOneToImportInPast.loadPage()
  }

  And("I select that I have used Method 1 to import goods and press continue") { () =>
    HaveYouUsedMethodOneToImportInPast.selectYes().submitPage()
  }

  And("I select that I have not used Method 1 to import goods and press continue") { () =>
    HaveYouUsedMethodOneToImportInPast.selectNo().submitPage()
  }

  Then("I will be navigated to Describe the Identical Goods") { () =>
    DescribeTheIdenticalGoods
      .loadPage()
  }
  And("I enter {string} as the description of the identical goods and press continue") { (description: String) =>
    DescribeTheIdenticalGoods
      .enterText(description)
      .submitPage()
  }
  And("I enter {string} as the description of the identical goods") { (identicalGoods: String) =>
    DescribeTheIdenticalGoods.enterText(identicalGoods)
    ScenarioContext.setContext("identical goods", identicalGoods)
  }

  Then("I navigate to describe the identical goods page and compare the text") { () =>
    val url = s"$baseUrl/advance-valuation-ruling/" +
      ScenarioContext.getContext("draftId") +
      DescribeTheIdenticalGoods.redirectUrl
    Driver.instance.get(url)
    assert(ScenarioContext.getContext("identical goods") == DescribeTheIdenticalGoods.getText())
  }
}
