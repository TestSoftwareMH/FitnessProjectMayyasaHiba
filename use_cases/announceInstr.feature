@tag
Feature: Announcements

  @tag1
  Scenario Outline: Announce new program
    Given User has logged in as instructor to announce
    When User create new program with the following details and want clients to know that:
    |  Program ID |    Program title    |    Duration    |    Difficulty level    |    Goals    |    Description    |    Price    |    Schedule type    |    Schedule time    |
    | <Program ID>|   <Program title>   |   <Duration>   |   <Difficulty level>   |   <Goals>   |   <Description>   |   <Price>   |   <Schedule type>   |   <Schedule time>   |
    Then The announce should be delivered

    Examples:
    |  Program ID |    Program title    |    Duration    |    Difficulty level    |    Goals    |    Description    |    Price    |     Schedule type   |       Schedule time      |
    |    400      |    Zoomba class     |      60        |      Intermediate      | Burning fit |       image       |     50      |         Online      | Thursday , 6:00pm-7:00pm |

  @tag2
  Scenario Outline: Announce about offers
    Given User has logged in as instructor to announce
    When User announce about special offer <Offer ID> with following details:
    |  Offer ID  |  Offer title  |  Description  |   First date of the offer   |   Last date of the offer   |  price  |
    | <Offer ID> | <Offer title> | <Description> |  <First date of the offer>  |  <Last date of the offer>  | <price> |
    Then The announce of offer should be delivered

    Examples:
    |  Offer ID  |   Offer title    |  Description                              |  First date of the offer  |  Last date of the offer  |  price  |
    |     12     | December package | "Zoomba and cardio group sessions online" |          2025-12-01        |         2025-12-31       |   100   |

   @tag3
   Scenario Outline: Announce offer with invalid period
    Given User has logged in as instructor to announce
    When User announce about special offer <Offer ID> with invalid period with following details:
    |  Offer ID  |  Offer title  |  Description  |   First date of the offer   |   Last date of the offer   |  price  |
    | <Offer ID> | <Offer title> |  <Description> |  <First date of the offer>  |  <Last date of the offer>  | <price> |
    Then The announce should not be delivered

    Examples:
    |  Offer ID  |   Offer title    |  Description                              |  First date of the offer  |  Last date of the offer  |  price  |
    |     12     | December package | "Zoomba and cardio group sessions online" |          2024-12-01        |          2024-11-01       |   100   |
