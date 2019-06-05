Feature: Create Project with POST request

  @Regression @Acceptance
  Scenario Outline: As client, I can send a POST request to create a project.

    Given I have a connection with Todo.Ly
    When I send a POST request to projects.json end point with the json
    """
   {
          "Content": "<nameProject>",
          "Icon": <icon>
   }
    """
    Then the response code should be 200
    And I expected the json response body contains <nameProject>


    Examples:
    |nameProject|icon|
    |cucumber1  |  1  |
    |cucumber2  |  2  |
    |cucumber3  |  3  |