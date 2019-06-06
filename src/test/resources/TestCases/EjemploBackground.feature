Feature: Create Project with POST request

  Background: secccion en commun - before
    Given I have a connection with Todo.Ly

  @Regression @Acceptance
  Scenario: As client, I can send a POST request to create a project.
    When I send a POST request to projects.json end point with the json
    """
   {
          "Content": "MyCucumber",
          "Icon": 4
   }
    """
    Then the response code should be 200
    And I expected the json response body contains MyCucumber
    And I get the attribute Id and save on ID_VALUE
    And I get the attribute Content and save on NAME_VALUE


  @Regression @Acceptance
  Scenario: As client, I can send a POST request to create a project.
    When I send a POST request to projects.json end point with the json
    """
   {
          "Content": "MyCucumber1",
          "Icon": 4
   }
    """
    Then the response code should be 200
    And I expected the json response body contains MyCucumber1
    And I get the attribute Id and save on ID_VALUE
    And I get the attribute Content and save on NAME_VALUE
