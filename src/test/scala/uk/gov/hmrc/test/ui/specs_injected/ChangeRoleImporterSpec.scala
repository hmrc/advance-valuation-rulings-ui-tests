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

package uk.gov.hmrc.ui.specs

import uk.gov.hmrc.ui.specsteps.StepDefinitionsSteps._
import uk.gov.hmrc.ui.specsteps.AgentStepDefsSteps._
import uk.gov.hmrc.ui.specsteps.MethodTwoStepDefinitionsSteps._
import uk.gov.hmrc.ui.specsteps.MethodThreeStepDefinitionsSteps._
import uk.gov.hmrc.ui.specsteps.MethodFourStepDefinitionsSteps._
import uk.gov.hmrc.ui.specsteps.MethodSixStepDefinitionsSteps._
import uk.gov.hmrc.ui.specsteps.ChangeImporterRoleStepsSteps._

import uk.gov.hmrc.ui.specs.BaseSpec
import org.scalatest.matchers.should.Matchers
import org.scalatest.featurespec.AnyFeatureSpec

class ChangeRoleImporterSpec extends BaseSpec {

  Feature("A user attempts to change their importer role") {

    Scenario("User clicks change link but does not change the role") {
      Then("I click on the change link on the check your answers page")
        andIClickOnTheChangeLinkOnTheCheckYourAnswersPage()  // auto-chosen (score=1.00, ChangeImporterRoleStepsSteps.scala)

      Then("The page title is: Your role as an importer")
        andThePageTitleIsX("Your role as an importer")  // auto-chosen (score=1.00, ChangeImporterRoleStepsSteps.scala)

      And("The An employee of the organisation radio has been previously selected")
        andTheAnEmployeeOfTheOrganisationRadioHasBeenPreviouslySelected()  // auto-chosen (score=1.00, ChangeImporterRoleStepsSteps.scala)

      And("I click the continue button")
        andIClickTheContinueButton()  // auto-chosen (score=1.00, ChangeImporterRoleStepsSteps.scala)

      Then("The page title is: Check your answers before sending your application")
        andThePageTitleIsX("Check your answers before sending your application")  // auto-chosen (score=1.00, ChangeImporterRoleStepsSteps.scala)

    }

    Scenario("User clicks change link and changes the role but does not wish to actually change the role.") {
      Then("I click on the change link on the check your answers page")
        andIClickOnTheChangeLinkOnTheCheckYourAnswersPage()  // auto-chosen (score=1.00, ChangeImporterRoleStepsSteps.scala)

      Then("The page title is: Your role as an importer")
        andThePageTitleIsX("Your role as an importer")  // auto-chosen (score=1.00, ChangeImporterRoleStepsSteps.scala)

      And("The An employee of the organisation radio has been previously selected")
        andTheAnEmployeeOfTheOrganisationRadioHasBeenPreviouslySelected()  // auto-chosen (score=1.00, ChangeImporterRoleStepsSteps.scala)

      And("The user clicks on the Agent acting on behalf of an organisation radio")
        andTheUserClicksOnTheAgentActingOnBehalfOfAnOrganisationRadio()  // auto-chosen (score=1.00, ChangeImporterRoleStepsSteps.scala)

      And("I click the continue button")
        andIClickTheContinueButton()  // auto-chosen (score=1.00, ChangeImporterRoleStepsSteps.scala)

      Then("The page title is: Change your role as importer")
        andThePageTitleIsX("Change your role as importer")  // auto-chosen (score=1.00, ChangeImporterRoleStepsSteps.scala)

      And("I click the no radio button")
        andIClickTheXRadioButton("no")  // auto-chosen (score=1.00, ChangeImporterRoleStepsSteps.scala)

      And("I click the continue button")
        andIClickTheContinueButton()  // auto-chosen (score=1.00, ChangeImporterRoleStepsSteps.scala)

      Then("The page title is: Your role as an importer")
        andThePageTitleIsX("Your role as an importer")  // auto-chosen (score=1.00, ChangeImporterRoleStepsSteps.scala)

      And("The An employee of the organisation radio has been previously selected")
        andTheAnEmployeeOfTheOrganisationRadioHasBeenPreviouslySelected()  // auto-chosen (score=1.00, ChangeImporterRoleStepsSteps.scala)

      And("I click the continue button")
        andIClickTheContinueButton()  // auto-chosen (score=1.00, ChangeImporterRoleStepsSteps.scala)

      Then("The page title is: Check your answers before sending your application")
        andThePageTitleIsX("Check your answers before sending your application")  // auto-chosen (score=1.00, ChangeImporterRoleStepsSteps.scala)

    }

    Scenario("User clicks change link and changes the role and successfully changes their role to 'Agent acting on behalf of an organisation'") {
      Then("I click on the change link on the check your answers page")
        andIClickOnTheChangeLinkOnTheCheckYourAnswersPage()  // auto-chosen (score=1.00, ChangeImporterRoleStepsSteps.scala)

      Then("The page title is: Your role as an importer")
        andThePageTitleIsX("Your role as an importer")  // auto-chosen (score=1.00, ChangeImporterRoleStepsSteps.scala)

      And("The An employee of the organisation radio has been previously selected")
        andTheAnEmployeeOfTheOrganisationRadioHasBeenPreviouslySelected()  // auto-chosen (score=1.00, ChangeImporterRoleStepsSteps.scala)

      And("The user clicks on the Agent acting on behalf of an organisation radio")
        andTheUserClicksOnTheAgentActingOnBehalfOfAnOrganisationRadio()  // auto-chosen (score=1.00, ChangeImporterRoleStepsSteps.scala)

      And("I click the continue button")
        andIClickTheContinueButton()  // auto-chosen (score=1.00, ChangeImporterRoleStepsSteps.scala)

      Then("The page title is: Change your role as importer")
        andThePageTitleIsX("Change your role as importer")  // auto-chosen (score=1.00, ChangeImporterRoleStepsSteps.scala)

      And("I click the yes radio button")
        andIClickTheXRadioButton("yes")  // auto-chosen (score=1.00, ChangeImporterRoleStepsSteps.scala)

      And("I click the continue button")
        andIClickTheContinueButton()  // auto-chosen (score=1.00, ChangeImporterRoleStepsSteps.scala)

      Then("The page title is: Before you start your application")
        andThePageTitleIsX("Before you start your application")  // auto-chosen (score=1.00, ChangeImporterRoleStepsSteps.scala)

    }

    Scenario("User returns to a application via the start application/previous application page and changes the Role") {
      And("I click on the service header")
        andIClickOnTheServiceHeader()  // auto-chosen (score=1.00, ChangeImporterRoleStepsSteps.scala)

      Then("The page title is: Your applications")
        andThePageTitleIsX("Your applications")  // auto-chosen (score=1.00, ChangeImporterRoleStepsSteps.scala)

      And("I click on the Continue application link")
        andIClickOnTheContinueApplicationLink()  // auto-chosen (score=1.00, ChangeImporterRoleStepsSteps.scala)

      Then("The page title is: Your role as an importer")
        andThePageTitleIsX("Your role as an importer")  // auto-chosen (score=1.00, ChangeImporterRoleStepsSteps.scala)

      And("The An employee of the organisation radio has been previously selected")
        andTheAnEmployeeOfTheOrganisationRadioHasBeenPreviouslySelected()  // auto-chosen (score=1.00, ChangeImporterRoleStepsSteps.scala)

      And("I click the continue button")
        andIClickTheContinueButton()  // auto-chosen (score=1.00, ChangeImporterRoleStepsSteps.scala)

      Then("The page title is: Before you start your application")
        andThePageTitleIsX("Before you start your application")  // auto-chosen (score=1.00, ChangeImporterRoleStepsSteps.scala)

      Then("I click on the Back link")
        andIClickOnTheBackLink()  // auto-chosen (score=1.00, ChangeImporterRoleStepsSteps.scala)

      Then("The page title is: Your role as an importer")
        andThePageTitleIsX("Your role as an importer")  // auto-chosen (score=1.00, ChangeImporterRoleStepsSteps.scala)

      And("The An employee of the organisation radio has been previously selected")
        andTheAnEmployeeOfTheOrganisationRadioHasBeenPreviouslySelected()  // auto-chosen (score=1.00, ChangeImporterRoleStepsSteps.scala)

      And("The user clicks on the Agent acting on behalf of an organisation radio")
        andTheUserClicksOnTheAgentActingOnBehalfOfAnOrganisationRadio()  // auto-chosen (score=1.00, ChangeImporterRoleStepsSteps.scala)

      And("I click the continue button")
        andIClickTheContinueButton()  // auto-chosen (score=1.00, ChangeImporterRoleStepsSteps.scala)

      Then("The page title is: Change your role as importer")
        andThePageTitleIsX("Change your role as importer")  // auto-chosen (score=1.00, ChangeImporterRoleStepsSteps.scala)

      And("I click the no radio button")
        andIClickTheXRadioButton("no")  // auto-chosen (score=1.00, ChangeImporterRoleStepsSteps.scala)

      And("I click the continue button")
        andIClickTheContinueButton()  // auto-chosen (score=1.00, ChangeImporterRoleStepsSteps.scala)

      Then("The page title is: Your role as an importer")
        andThePageTitleIsX("Your role as an importer")  // auto-chosen (score=1.00, ChangeImporterRoleStepsSteps.scala)

      And("The An employee of the organisation radio has been previously selected")
        andTheAnEmployeeOfTheOrganisationRadioHasBeenPreviouslySelected()  // auto-chosen (score=1.00, ChangeImporterRoleStepsSteps.scala)

      And("The user clicks on the Agent acting on behalf of an organisation radio")
        andTheUserClicksOnTheAgentActingOnBehalfOfAnOrganisationRadio()  // auto-chosen (score=1.00, ChangeImporterRoleStepsSteps.scala)

      And("I click the continue button")
        andIClickTheContinueButton()  // auto-chosen (score=1.00, ChangeImporterRoleStepsSteps.scala)

      Then("The page title is: Change your role as importer")
        andThePageTitleIsX("Change your role as importer")  // auto-chosen (score=1.00, ChangeImporterRoleStepsSteps.scala)

      And("I click the yes radio button")
        andIClickTheXRadioButton("yes")  // auto-chosen (score=1.00, ChangeImporterRoleStepsSteps.scala)

      And("I click the continue button")
        andIClickTheContinueButton()  // auto-chosen (score=1.00, ChangeImporterRoleStepsSteps.scala)

      Then("The page title is: Before you start your application")
        andThePageTitleIsX("Before you start your application")  // auto-chosen (score=1.00, ChangeImporterRoleStepsSteps.scala)

    }
  }
}
