@tag
Feature: Communicate with enrolled clients

  @tag1
  Scenario Outline: Successfully send a message to an enrolled client
    Given User has logged in as instructor to communication
    When User send a message <message> to client with <Client ID>
    Then The message <message> should be sent to client with <Client ID> successfully

  Examples:
  | Client ID |  message  |
  |    10     |  "Hello, Please take care for your diet" |

  @tag2
  Scenario Outline: Successfully post a message to the discussion forums
    Given User has logged in as instructor to communication
    When User post a message <message> to the discussion forums with <Discussion ID>
    Then The message <message> should be post to the discussion forums successfully with <Discussion ID>

  Examples:
  | Discussion ID |  message  |
  |      96       | "Hello, We have zoom meeting today" |

   @tag3
   Scenario Outline: Fail to send a message to a client not enrolled
    Given User has logged in as instructor to communication
    When User tries to send a message to a client not enrolled <Client ID>
    Then The message should not be sent

   Examples:
   | Client ID |  message  |
   |   500     |  "Hello, Please take care for your diet" |

   @tag4
   Scenario Outline: Fail to post a message to the discussion forums but not have permission
    Given User has logged in as client to communicat
    When User tries to post a message <message> to the discussion forums with <Discussion ID>
    Then The message should not be sent

   Examples:
   | Discussion ID |  message  |
   |      96       | "Hello, We have zoom meeting today" |