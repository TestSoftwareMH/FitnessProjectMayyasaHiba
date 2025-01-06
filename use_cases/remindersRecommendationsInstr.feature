@tag
Feature: Send motivational reminders or recommendations

  @tag1
  Scenario Outline: Send a motivational reminder or recommendations to a client <Client ID>
    Given User has logged in as instructor to send reminder or recommendations
    When User want to remind <Client ID> that there is a program <Program ID>
    Then The client <Client ID> should receive the message <Message>

    Examples:
    | Client ID | Client name | Message | Program ID|
    |     10    |Hiba Zawatieh|"Please don't forget that you have a yoga class tomorrow at 7:00am"| 100 |

  @tag2
  Scenario Outline: Automatic motivational reminders or recommendations for inactive clients
    Given User has logged in as instructor to send reminder or recommendations
    When The client <Client ID> has been inactive or not in progress
    Then Automatic motivational reminders or recommendations <Message> should be sent to <Client ID>

    Examples:
    | Client ID | Client name | Message |
    |     50    | Nahla Hasan |"Try increasing your session time to get great result"|
