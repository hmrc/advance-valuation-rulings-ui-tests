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

import uk.gov.hmrc.configuration.TestEnvironment
import uk.gov.hmrc.selenium.webdriver.Driver
import uk.gov.hmrc.test.ui.pages._
import uk.gov.hmrc.test.ui.pages.base.ScenarioContext

trait MethodThreeStepDefinitions extends BaseStepDef {

  Then("I will be navigated to Explain Why not select method one or two") { () =>
    ExplainWhyNotMethodOneOrTwo.loadPage()
  }

  Then("I will be navigated to Describe the Similar Goods page") { () =>
    DescribeTheSimilarGoodsPage.loadPage()
  }

  And("I select {booleanValue} and continue in Have You Used Method One In the Past 90 days") { (option: Boolean) =>
    HaveYouUsedMethodOneToImportSimilarGoods.loadPage()
    HaveYouUsedMethodOneToImportSimilarGoods.select(option)
    HaveYouUsedMethodOneToImportSimilarGoods.submitPage()
  }

  And("I enter a reason and continue in Explain why not method one or two page") { () =>
    ExplainWhyNotMethodOneOrTwo
      .enterText("Detailed explanation")
      .submitPage()
  }

  And("I enter a {string} in explain why not method one or two page") { (whyNotMethodOneOrTwo: String) =>
    ExplainWhyNotMethodOneOrTwo.enterText(whyNotMethodOneOrTwo)
    ScenarioContext.setContext("why not method one or two", whyNotMethodOneOrTwo)
  }

  Then("I navigate to explain why not select method one or two page and compare text") { () =>
    val url = TestEnvironment.url("advance-valuation-rulings-frontend") +
      ScenarioContext.getContext("draftId") +
      ExplainWhyNotMethodOneOrTwo.redirectUrl
    Driver.instance.get(url)
    assert(ScenarioContext.getContext("why not method one or two") == ExplainWhyNotMethodOneOrTwo.getText())
  }

  And("I enter a reason and continue in Describe the Similar Goods page") { () =>
    DescribeTheSimilarGoodsPage
      .enterText("Detailed explanation")
      .submitPage()
  }
  And("I enter a {string} in Describe the Similar Goods page") { (similarGoodsDescription: String) =>
    DescribeTheSimilarGoodsPage.enterText(similarGoodsDescription)
    ScenarioContext.setContext("similar goods description", similarGoodsDescription)
  }

  Then("I navigate to Describe the Similar Goods page and compare text") { () =>
    val url = TestEnvironment.url("advance-valuation-rulings-frontend") +
      ScenarioContext.getContext("draftId") +
      DescribeTheSimilarGoodsPage.redirectUrl
    Driver.instance.get(url)
    assert(ScenarioContext.getContext("similar goods description") == DescribeTheSimilarGoodsPage.getText())
  }

  Then("I will be navigated to have you used Valuation Method 1 to import similar goods") { () =>
    ExplainWhyNotMethodOneOrTwo.loadPage()
  }

  And("I select that I have used Method 1 to import similar goods in the past 90 days") { () =>
    ExplainWhyNotMethodOneOrTwo
      .enterText("Detailed explanation")
      .submitPage()
  }

  And("I select that I have not used Method 1 to import similar goods in the past 90 days") { () =>
    ExplainWhyNotMethodOneOrTwo
      .enterText("Detailed explanation")
      .submitPage()
  }

}
