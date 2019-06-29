$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/AddEmployee.feature");
formatter.feature({
  "name": "Add Employee",
  "description": "",
  "keyword": "Feature"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I see OrangeHrm logo",
  "keyword": "And "
});
formatter.match({
  "location": "LoginSteps.i_see_OrangeHrm_logo()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I log in into OrangeHrm site",
  "keyword": "And "
});
formatter.match({
  "location": "AddLocationSteps.i_logged_in_into_OrangeHrm_site()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on PIM link",
  "keyword": "When "
});
formatter.match({
  "location": "AddEmployeeSteps.i_click_on_PIM_link()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on Add Employee link",
  "keyword": "And "
});
formatter.match({
  "location": "AddEmployeeSteps.i_click_on_Add_Employee_link()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Add Employee with Excel File",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@test"
    }
  ]
});
formatter.step({
  "name": "I provide all details \"EmployeeDetails\" from excel file",
  "keyword": "And "
});
formatter.match({
  "location": "AddEmployeeSteps.when_I_provide_mandatory_fields_from(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});