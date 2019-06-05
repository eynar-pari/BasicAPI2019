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
    And I get the attribute Id and save on ID_VALUE
    And I get the attribute Content and save on NAME_VALUE
    And I expected the json response body equal to
    """
    {
      "Id": "ID_VALUE",
      "Content": "NAME_VALUE",
      "ItemsCount": 0,
      "Icon": <icon>,
      "ItemType": 2,
      "ParentId": null,
      "Collapsed": false,
      "ItemOrder": IGNORE,
      "Children": [],
      "IsProjectShared": false,
      "ProjectShareOwnerName": null,
      "ProjectShareOwnerEmail": null,
      "IsShareApproved": false,
      "IsOwnProject": true,
      "LastSyncedDateTime": "IGNORE",
      "LastUpdatedDate": "IGNORE",
      "Deleted": false,
      "SyncClientCreationId": null
    }
    """









    Examples:
    |nameProject|icon|
    |cucumber1  |  1  |
