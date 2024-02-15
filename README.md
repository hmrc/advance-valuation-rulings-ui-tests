
# advance-valuation-rulings-ui-tests
UI test suite for the `advance-valuation-rulings-frontend` using Selenium WebDriver and Cucumber.  

---

### Running tests locally against a containerised browser - on a developer machine

Prior to executing the tests ensure you have:
 - Docker - to run mongo and browser (Chrome, Firefox or Edge) inside a container 
 - Appropriate [drivers installed](#installing-local-driver-binaries) - to run tests against locally installed Browser
 - Installed/configured [service manager](https://github.com/hmrc/service-manager).  

Run the following command to start services locally:

```
docker run --rm -d --name mongo -d -p 27017:27017 mongo:4.0
```

```
sm2 --start ARS_ALL
``` 



The new UI test tooling requires an instance of selenium grid available at localhost:444 to be able to create browsers.
HMRC has provided and maintain hmrc/docker-selenium-grid for that purpose.
At the time of writing an easy way to run these tests is to use [HMRC docker selenium-grid](https://github.com/hmrc/docker-selenium-grid)
Clone this repo and follow the readme to start selenium-grid in a docker container.

For this project, to run against a containerised browser:

```bash
./run-tests.sh chrome local
```

---

### Running the tests against a test environment

To run the tests against an environment set the corresponding `host` environment property as specified under
 `<env>.host.services` in the [application.conf](/src/test/resources/application.conf). 

For example, to execute the `run_journey_tests.sh` script using Chrome remote-webdriver against QA environment 

    ./run_journey_tests.sh remote-chrome qa

---

### Running ZAP tests

ZAP tests can be automated using the HMRC Dynamic Application Security Testing approach. Running 
automated ZAP tests should not be considered a substitute for manual exploratory testing using OWASP ZAP.

### Tagging tests for ZAP

It is not required to proxy every journey test via ZAP. The intention of proxying a test through ZAP is to expose all the
 relevant pages of an application to ZAP. So tagging a subset of the journey tests or creating a 
 single ZAP focused journey test is sufficient.

### Configuring the browser to proxy via ZAP 

Setting the system property `zap.proxy=true` configures the browser specified in `browser` property to proxy via ZAP. 
This is achieved using [webdriver-factory](https://github.com/hmrc/webdriver-factory#proxying-trafic-via-zap).

### Executing a ZAP test

The shell script `run_zap_tests.sh` is available to execute ZAP tests. The script proxies a set of journey tests, 
tagged as `ZapTests`, via ZAP.  

For example, to execute ZAP tests locally using a Chrome browser

```
./run_zap_tests.sh chrome local
```

To execute ZAP tests locally using a remote-chrome browser

```
./run_zap_tests.sh remote-chrome local
``` 

`./run_browser_with_docker.sh` is **NOT** required when running in a CI environment.

---

### Running tests using BrowserStack
If you would like to run your tests via BrowserStack from your local development environment please refer to the [webdriver-factory](https://github.com/hmrc/webdriver-factory/blob/main/README.md/#user-content-running-tests-using-browser-stack) project.

---

### Installing local driver binaries

This project supports UI test execution using Firefox (Geckodriver) and Chrome (Chromedriver) browsers. 

See the `drivers/` directory for some helpful scripts to do the installation work for you.  They should work on both Mac and Linux by running the following command:

```
./installGeckodriver.sh <operating-system> <driver-version>
```
### or
```
./installChromedriver <operating-system> <driver-version>
```

- *<operating-system>* defaults to **linux64**, however it also supports **macos**
- *<driver-version>* defaults to **0.21.0** for Gecko/Firefox, and the latest release for Chrome.  You can, however, however pass any version available at the [Geckodriver](https://github.com/mozilla/geckodriver/tags) or [Chromedriver](http://chromedriver.storage.googleapis.com/) repositories.

**Note 1:** *You will need to ensure that you have a recent version of Chrome and/or Firefox installed for the later versions of the drivers to work reliably.*

**Note 2** *These scripts use sudo to set the right permissions on the drivers so you will likely be prompted to enter your password.*

---

### Run all formatting and dependency checks

Check all project files are formatted as expected as follows:

```bash
./run_format_and_deps.sh
```

### License

This code is open source software licensed under the [Apache 2.0 License]("http://www.apache.org/licenses/LICENSE-2.0.html").