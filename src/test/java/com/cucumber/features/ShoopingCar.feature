#language: en
Feature:Shooping car

  Scenario:Buy items in the car
    Given open the website successfully
    When the user enter the credentials
    Then the user should see the home page successfully
    Then the user add items to the shooping Car
    Then the user buy the items in the shopping car
    Then the user shold see the items bought
