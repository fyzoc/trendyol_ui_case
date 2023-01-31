TRENDYOL_CASE

"https://www.trendyol.com/" login process was done with automation.
It was built using selenium-cucumber framework with BDD.
Tests were improved with java language, using selenium library.
For the login test, one of the cases run in a way to fail, 
and the screenshot of the failing moment is reported.
System is designed to run in a way to be parallel and cross-browser.
At the end of tests, a reporting screen displaying the results is added.
The home page of Trendyol's links are recorded in a csv file.
Also Tests is run with selenium-grid in docker containers through compose file.

HOW TO RUN

Inside the runners package there are 4 types runner class were built:
FailedScenarioRunner --> it used to only run failed scenario again,
GridRunner           --> it used to run test on cross-browser with docker containers.
Runner               --> it used to run all tests with "@all_test" tag.
TestRunner           --> this runner class was created to separate feature files for running parallel tests at local.
Lastly if you want to execute test case you need to change tags = "@Test01" in Runner class.


FAILED SCENERIO GIVES SCREENSHOOT

The framework has a Hooks class which gives us screenshot when the test is failed.
And when the tests are finished,it gives a cucumber-report includes this screenshot.
When the test is executed, the test-output is created.And also it includes a detailed extent report.


PARALLEL AND CROSS-BROWSER

The framework connected with docker and use selenium hub and node images.It works on remote driver to making test on multiple browser.
Chrome and firefox are used in test as a browser.And it is set 2 parallel chorme browser and 3 parallel firefox browser.
There is a Grid runner to exucute cross browser test.








