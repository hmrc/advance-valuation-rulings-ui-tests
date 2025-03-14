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

package uk.gov.hmrc.test.ui.pages

import uk.gov.hmrc.test.ui.pages.base.BasePage

object YourEORIMustBeUpToDate extends BasePage {

  val pageTitle =
    "Your EORI number details must be correct to use this service"
}

object TradersEoriMustBeUpToDate extends BasePage {

  val pageTitle =
    "The trader’s details must be correct to use this service"
}

object TradersIncorrectPrivateEori extends BasePage {

  val pageTitle =
    "You cannot continue with this application"
}
