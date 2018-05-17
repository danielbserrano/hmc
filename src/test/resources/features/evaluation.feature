Feature: As a user, I want to be able to add comments regarding an interview

    @Critical
    Scenario: I log in into HMC Portal and I can see the information page displayed
        Given I am logged into HMC Portal
        Then I can see the Information Page displayed


    @Critical
    Scenario Outline: I log in into HMC Portal and I can see the information page displayed
        Given I am logged into HMC Portal
        When I rate the interview '<stars>' with a comment '<comment>' for candidate '<candidate>' over '<next_step>' for job '<job>'
        Then I see my comment '<comment>' for '<next_step>' with '<stars>'

        Examples:
            | comment | candidate | job | next_step | stars |
            | HMC Exercise 1 | TEST TEST | Test | invite for 1st interview | 2 |
            | HMC Exercise 2 | TEST TEST | Test | invite for 1st interview | 3 |