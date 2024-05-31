# Advance Valuation Rulings UI Tests

UI test suite for the `advance-valuation-rulings-frontend` using Selenium WebDriver and Cucumber.  

---

## Starting Services

To start the required services via [service manager](https://github.com/hmrc/sm2), run:

```shell
sm2 --start ARS_ALL
```

## Executing tests

### UI tests

The UI tests utilise automatic browser management facilitated by Selenium Manager for UI journey tests.
By default, the tests are configured to run in headless mode, providing efficiency and speed without launching
a visible browser window. However, if you prefer to observe the test execution visually, you can override this setting
by adding `-Dbrowser.option.headless=false` in the relevant script when running your tests.

#### Running tests - Local

To run the UI tests locally, execute the script:

```bash
./run-tests.sh chrome local
```

#### Running tests - Environment

To run the tests against an environment set the corresponding `host` environment property as specified under
 `<env>.host.services` in the [application.conf](/src/test/resources/application.conf). 

To run the UI smoke tests in staging environment, execute the script:

```bash
./run-tests.sh chrome staging
```

### ZAP tests

The `run_zap_tests.sh` script uses [dast-config-manager](https://github.com/hmrc/dast-config-manager) to run ZAP tests locally using the DAST Docker image.

To run the ZAP tests locally, execute the script:

```bash
./run_zap_tests.sh
```

## Run all formatting and dependency checks

Check all project files are formatted as expected as follows:

```bash
./run_format_and_deps.sh
```

## License

This code is open source software licensed under the [Apache 2.0 License]("http://www.apache.org/licenses/LICENSE-2.0.html").
