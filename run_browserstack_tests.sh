#!/usr/bin/env bash

#
#sbt -Dbrowser=browserstack -Dlanguage=english -Denvironment=local -Dbrowserstack.username=lilotxnmonitorin_6nwDxY -Dbrowserstack.key=Bc9qsr5GYVAHgMvCoVBq -Dbrowserstack.browser_version="11" -Dbrowserstack.browser="Edge" -Dbrowserstack.os="Windows" -Dbrowserstack.os_version="10" 'testOnly uk.gov.hmrc.test.ui.cucumber.runner.Runner'
#Go to your machine terminal -Downloads and use this commands ./BrowserStackLocal Bc9qsr5GYVAHgMvCoVBq
#Run tests  using this command  ./run_browserstack_tests.sh

browserStackUsername="lilotxnmonitorin_6nwDxY"
browserStackAutomateKey="Bc9qsr5GYVAHgMvCoVBq"
while :
do
 clear
 echo " CHOOSE THE Browser/Device to run"
 echo "1. Win11-Edge"
 echo "2. Win11-Firefox"
 echo "3. Win11-Chrome"
 echo "4. Android-Samsung Galaxy S20"
 echo "5. BS_iOS_8_iPhone6_Safari8"
 echo "6: Exit"
 echo -n "Please enter option [1 - 6]  "
 read opt
 case $opt in
 # Cross Browsers
    1)echo "Running Win11-Edge......";
        sbt -Dbrowser=browserstack -Dlanguage=english -Denvironment=local -Dbrowserstack.username=${browserStackUsername} -Dbrowserstack.key=${browserStackAutomateKey} -Dbrowserstack.browser_version="109.0" -Dbrowserstack.browser="Edge" -Dbrowserstack.os="Windows" -Dbrowserstack.os_version="11" 'testOnly uk.gov.hmrc.test.ui.cucumber.runner.Runner';;
    2)echo "Running Win11-Firefox......";
        sbt -Dbrowser=browserstack -Dlanguage=english -Denvironment=local -Dbrowserstack.username=${browserStackUsername} -Dbrowserstack.key=${browserStackAutomateKey} -Dbrowserstack.browser_version="108.0" -Dbrowserstack.browser="Firefox" -Dbrowserstack.os="Windows" -Dbrowserstack.os_version="11" 'testOnly uk.gov.hmrc.test.ui.cucumber.runner.Runner';;
    3)echo "Running Win11-Chrome......";
        sbt -Dbrowser=browserstack -Dlanguage=english -Denvironment=local -Denvironment=local -Dbrowserstack.username=${browserStackUsername} -Dbrowserstack.key=${browserStackAutomateKey}  -Dbrowserstack.browser_version="103" -Dbrowserstack.browser="Chrome" -Dbrowserstack.os="Windows" -Dbrowserstack.os_version="11" 'testOnly uk.gov.hmrc.test.ui.cucumber.runner.Runner';;
   4)echo "Running Android-Samsung Galaxy S20......";
         sbt -Dbrowser=browserstack -Dlanguage=english -Denvironment=local -Dbrowserstack.username=${browserStackUsername} -Dbrowserstack.key=${browserStackAutomateKey} -Dbrowserstack.browserName="android" -Dbrowserstack.device="Samsung Galaxy S20" -Dbrowserstack.realMobile="true" -Dbrowserstack.os_version="10.0" 'testOnly uk.gov.hmrc.test.ui.cucumber.runner.Runner';;
    5)echo "Running BS_iOS_8_iPhone6_Safari8......";
         sbt -Dbrowser=browserstack -Dlanguage=english -Denvironment=local -Dbrowserstack.username=${browserStackUsername} -Dbrowserstack.key=${browserStackAutomateKey} -Dbrowserstack.browserName="BS_iOS_8_" -Dbrowserstack.device="iPhone6_Safari8" -Dbrowserstack.realMobile="true" -Dbrowserstack.os_version="10.0" 'testOnly uk.gov.hmrc.test.ui.cucumber.runner.Runner';;
      6) echo "Bye $USER";
         exit 1;;
    *) echo "$opt is an invaild option. Please select option between 1-9 only";
        echo "Press [enter] key to continue. . .";
        read enterKey;;
        esac
    done