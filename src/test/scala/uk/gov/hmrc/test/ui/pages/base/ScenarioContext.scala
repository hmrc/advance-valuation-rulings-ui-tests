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

package uk.gov.hmrc.test.ui.pages.base

import scala.collection.mutable

object ScenarioContext {
  var scenarioContext = new mutable.HashMap[String, String]()

  def setContext(key: String, value: String): Unit =
    scenarioContext.put(key, value)

  def getContext(key: String): String = scenarioContext.get(key).getOrElse("")

//  def isContains(key: Nothing): Boolean = scenarioContext.containsKey(key.toString)

}