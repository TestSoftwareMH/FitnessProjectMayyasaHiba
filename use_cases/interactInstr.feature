@tag
Feature: Provide feedback or progress reports to clients

  @tag1
  Scenario Outline: Successfully provide feedback or progress reports to clients
    Given User has logged in as instructor to interact
    When User provides feedback or progress report to <Client ID>
    Then The feedback <Feedback> should be provided successfully to <Client ID>

  Examples:
  |  Client ID   |   Feedback   |
  |      10      |  "feedback"  |

  @tag2
  Scenario Outline: Fail to  provide feedback or progress reports to not in progress client
    Given User has logged in as instructor to interact
    When User tries to provide feedback or progress report to <Client ID> but not in progress
    Then The feedback should not be provided successfully

  Examples:
  |  Client ID   |   Feedback   |
  |      20      |  "feedback"  |

  @tag3
   Scenario Outline: Fail to  provide feedback or progress reports to clients but not have permission
    Given User has logged in as client to interact
    When User tries to provide feedback or progress report to <Client ID>
    Then The feedback should not be provided successfully

  Examples:
  |  Client ID   |   Feedback   |
  |      10      |  "feedback"  |

