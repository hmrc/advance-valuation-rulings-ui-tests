/*
 * Copyright 2024 HM Revenue & Customs
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

import uk.gov.hmrc.test.ui.pages.base._

object WhyComputedValue extends TextAreaPage {
  val redirectUrl = "/explain-why-not-methods-1-4"
  val pageTitle   =
    "Explain why you have not used Methods 1 to 4"
}

object ExplainWhyComputedValue extends TextAreaPage {
  val pageTitle =
    "Explain why you have selected Method 5 to value your goods"
}
