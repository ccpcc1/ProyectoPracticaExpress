#language: en
Feature:Log in Succesfull

Scenario: Log in Successfully
  Given open the website successfully
  When the user enter the credentials
  Then the user should see the home page successfully
