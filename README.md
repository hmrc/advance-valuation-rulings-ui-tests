
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
docker run --rm -d --name mongo -d -p 27017:27017 mongo:5.0
```

```
sm2 --start ARS_ALL
```

The new UI test tooling requires an instance of selenium grid available at localhost:4444 to be able to create browsers.
HMRC has provided and maintain hmrc/docker-selenium-grid for that purpose which will point selenium to localhost:4444.
At the time of writing an easy way to run these tests is to use [HMRC docker selenium-grid](https://github.com/hmrc/docker-selenium-grid)
Clone this repo and follow the readme to start selenium-grid in a docker container.

For this project to run against a containerised remote webdriver browser instance:

```bash
./run-tests.sh chrome local
```

---

### Running the tests against a test environment

To run the tests against an environment set the corresponding `host` environment property as specified under
 `<env>.host.services` in the [application.conf](/src/test/resources/application.conf). 

For example, to execute the `run_journey_tests.sh` script using Chrome remote-webdriver against QA environment 

```bash
./run-tests.sh chrome qa
```    

For example, to execute the `run_journey_tests.sh` script using Chrome remote-webdriver against Staging environment

```bash
./run-tests.sh chrome staging
```

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

```bash
./run_zap_tests.sh chrome local
```

To execute ZAP tests locally using a chrome browser

```bash
./run_zap_tests.sh chrome local
``` 

`./run_browser_with_docker.sh` is **NOT** required when running in a CI environment.

---

### Running tests using BrowserStack
If you would like to run your tests via BrowserStack from your local development environment please refer to the [webdriver-factory](https://github.com/hmrc/webdriver-factory/blob/main/README.md/#user-content-running-tests-using-browser-stack) project.

---

### Run all formatting and dependency checks

Check all project files are formatted as expected as follows:

```bash
./run_format_and_deps.sh
```

### License

This code is open source software licensed under the [Apache 2.0 License]("http://www.apache.org/licenses/LICENSE-2.0.html").