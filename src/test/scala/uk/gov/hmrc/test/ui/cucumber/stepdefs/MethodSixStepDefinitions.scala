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

trait MethodSixStepDefintions extends BaseStepDef {
  Then("I will be navigated to explain why have you not selected Methods 1-5 to value your goods") {
    () => ExplainWhyNotMethodsOneToFive.loadPage()
  }

  And("I enter {string} as my reason why I did not select methods 1 through 5") {
    (reason: String) =>
      ExplainWhyNotMethodsOneToFive
        .enterText(reason)
        .submitPage()
  }

  Then("I will be navigated to which method do you wish to adapt") {
    () => WhichMethodWouldYouLikeToAdapt.loadPage()
  }
  And("I select Method {int} as the method I wish to adapt") {
    (methodNumber: Int) =>
      WhichMethodWouldYouLikeToAdapt
        .selectOption(methodNumber)
        .submitPage()
  }

  Then("I will be navigated to how have you used method six to value goods") {
    () => ExplainHowYouHaveUsedMethodSix.loadPage()
  }

  And("I enter {string} as my explanation of how I have used method six to value goods") {
    (reason: String) => ExplainHowYouHaveUsedMethodSix.enterText(reason).submitPage()
  }
}
