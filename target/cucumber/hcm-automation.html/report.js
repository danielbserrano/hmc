$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("evaluation.feature");
formatter.feature({
  "line": 1,
  "name": "As a user, I want to be able to add comments regarding an interview",
  "description": "",
  "id": "as-a-user,-i-want-to-be-able-to-add-comments-regarding-an-interview",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 4,
  "name": "I log in into HMC Portal and I can see the information page displayed",
  "description": "",
  "id": "as-a-user,-i-want-to-be-able-to-add-comments-regarding-an-interview;i-log-in-into-hmc-portal-and-i-can-see-the-information-page-displayed",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@Critical"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "I am logged into HMC Portal",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I can see the Information Page displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinition.log_in()"
});
