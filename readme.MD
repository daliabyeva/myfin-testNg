This project contains scripts to test  myfin page.

## Preconditions
- Java version : 11
- Project uses [Lombok](https://projectlombok.org/) library to avoid repetitive code. To switch on Lombok support, Lombok plugin is to be installed (present in standard IntelliJ IDEA repository). Then restart the IDE 
- Allure commandline to be installed <br> 

For Windows ([npm](https://www.npmjs.com/get-npm) to be installed) : <br>
`npm install -g allure`<br> 
`npm install -g allure-commandline` <br>
Add ALLURE_HOME env variable (e.g. `C:\Users\%USER%\AppData\Roaming\npm\node_modules\allure`) <br>
Add allure-commandline to PATH (e.g. `C:\Users\%USER%\AppData\Roaming\npm\node_modules\allure-commandline\bin`) <br>
Run `allure --v` ([possible issue](https://dev.to/thetradecoder/how-to-fix-error-nodemon-ps1-cannot-be-loaded-because-running-scripts-is-disabled-on-this-system-34fe))

## Repository structure
- com.bank.utils.* - contains utility classes.
- com.bank.myfin.* - contains application logic.
- com.bank.guice.* - contains description of modules and dependencies providers. Project uses [Google Guice](https://github.com/google/guice).
- resources - contain project config files and test data.
- tests are located under test folder in dir com.bank.*

## Tests running

### command to launch tests :
`mvn clean test `

### command to generate allure report : 
`allure serve target/allure-results`

Steps, selenide elements and API requests/response can be found in the report detailed view
