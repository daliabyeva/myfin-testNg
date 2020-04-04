This project contains scripts to test  myfin page.
#Preconditions
- Java version : 11
- Project uses [Lombok] (https://projectlombok.org/) library to avoid repetitive code. To switch on Lombok support install Lombok plugin (present in standard IntelliJ IDEA repository) and restart the IDE 
- Allure commandline to be installed 
 _Winwows:_ 
` npm install -g allure
 npm install -g allure-commandline --save-dev`

# Repository structure
*********************to add structure

- com.bank.utils.* - contains utility classes.
- com.bank.myfin.* - contains application logic.
- com.bank.guice.* - contains description modules and dependencies providers. Project uses [Google Guice] (https://github.com/google/guice).
- resources - contain project config files and test data
- tests are located under test folder in dir com.bank.*

# Tests running

## command to launch tests :
`mvn clean test `

## command to generate allure report : 
`allure serve target/allure-results`
Steps, selenide steps and api requests/response details can be found in the report