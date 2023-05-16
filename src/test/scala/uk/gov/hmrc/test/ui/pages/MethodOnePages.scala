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

package uk.gov.hmrc.test.ui.pages

import uk.gov.hmrc.test.ui.pages.base._

object IsThereASaleInvolved extends YesNoPage {
  override val pageTitle: String = "Is there a sale involved?"
}
object IsTheSaleBetweenRelatedParties extends YesNoPage {
  override val pageTitle: String =
    "Is the sale between related parties?"
}
object DescribeHowPartiesAreRelated extends TextAreaPage {
  override val pageTitle: String =
    "Describe how the parties are related"
}
object AreThereAnyRestrictionsOnGoods extends YesNoPage {
  override val pageTitle: String =
    "Are there any restrictions on the use or resale of the goods?"
}

object DescribeAnyRestrictions extends TextAreaPage {
  override val pageTitle: String =
    "Describe any restrictions on the use or resale of goods"
}
object IsSaleSubjectToConditions extends YesNoPage {
  override val pageTitle: String =
    "Is the sale subject to any conditions or circumstances that could restrict you from valuing the goods?"
}
object DescribeAnyConditions extends TextAreaPage {
  override val pageTitle: String =
    "Describe the conditions or circumstances which cannot be calculated"
}
