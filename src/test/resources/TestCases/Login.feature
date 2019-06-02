Feature: Create Project with POST request

  @Regression @Acceptance
  Scenario: As client, I can send a POST request to create a project.

    Given I have a connection with Todo.Ly
    When I send a POST request to projects.json end point with the json
    """
   {
          "Content": "My New Project",
          "Icon": 4
   }
    """
    Then the response code should be 200