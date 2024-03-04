$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/C_06Cucumber01.feature");
formatter.feature({
  "name": "To validate the login functionality of ICICI netbanking application",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@feature06"
    }
  ]
});
formatter.scenario({
  "name": "To validate login page with valid username and password",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@feature06"
    }
  ]
});
formatter.step({
  "name": "To launch the edge browser and maximize window",
  "keyword": "Given "
});
formatter.match({
  "location": "C_01CucumberChallenge01.to_launch_the_edge_browser_and_maximize_window()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "To launch the URL of the ICICI netbanking application",
  "keyword": "When "
});
formatter.match({
  "location": "C_01CucumberChallenge01.to_launch_the_url_of_the_icici_netbanking_application()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "To pass valid userId in input field",
  "keyword": "And "
});
formatter.match({
  "location": "C_01CucumberChallenge01.to_pass_valid_userId_in_input_field()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "To pass valid password in input field",
  "keyword": "And "
});
formatter.match({
  "location": "C_01CucumberChallenge01.to_pass_valid_password_in_input_field()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "To click login button",
  "keyword": "And "
});
formatter.match({
  "location": "C_01CucumberChallenge01.to_click_login_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "To close the browser",
  "keyword": "Then "
});
formatter.match({
  "location": "C_01CucumberChallenge01.to_close_the_browser()"
});
formatter.result({
  "status": "passed"
});
});