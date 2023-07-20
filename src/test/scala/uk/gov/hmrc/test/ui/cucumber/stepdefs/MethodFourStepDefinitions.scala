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

import uk.gov.hmrc.test.ui.pages._
import uk.gov.hmrc.test.ui.pages.base.BasePage.baseUrl
import uk.gov.hmrc.test.ui.pages.base.ScenarioContext

trait MethodFourStepDefintions extends BaseStepDef {
  Then("I will be navigated to explain why not methods one till three") { () =>
    ExplainWhyNotMethodsOneTwoOrThree.loadPage()
  }

  And("I enter {string} as my reason why I did not select methods one till three and continue") { (reason: String) =>
    ExplainWhyNotMethodsOneTwoOrThree
      .enterText(reason)
      .submitPage()
  }

  And("I enter {string} as my reason why I did not select methods one till three") { (reason: String) =>
    ExplainWhyNotMethodsOneTwoOrThree.enterText(reason)
    ScenarioContext.setContext("why not method one tll three", reason)
  }

  And("I navigate to explain why not methods one till three page and compare text") { () =>
    val url = s"$baseUrl/advance-valuation-ruling/" +
      ScenarioContext.getContext("draftId") +
      ExplainWhyNotMethodsOneTwoOrThree.redirectUrl
    driver.get(url)
    assert(ScenarioContext.getContext("why not method one tll three") == ExplainWhyNotMethodsOneTwoOrThree.getText())
  }

  Then("I will be navigated to Explain why you have selected Method 4") { () =>
    ExplainWhyMethodFour.loadPage()
  }

  And("I enter {string} as my reason for selecting method Method 4") { (reason: String) =>
    ExplainWhyMethodFour.enterText(reason).submitPage()
  }
}
