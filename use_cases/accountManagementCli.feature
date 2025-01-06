@tag
Feature: Account Management for client

  @tag1
  Scenario Outline: Create new account
    Given User wants to create new account
    When The user provides the following details:
    |   Client name   |   Age   |  Birthdate   |   Email  |  PhoneNumber  |   Fitness Goals   |    Weight    |    Password   |
    |  <Client name>  |  <Age>  | <Birthdate>  |  <Email> | <PhoneNumber> |  <Fitness Goals>  |   <Weight>   |   <Password>  |
    Then The account should be created successfully

  Examples:
  |   Client name   |   Age   |  Birthdate   |   Email  |  PhoneNumber  |   Fitness Goals   |    Weight    |    Password   |
  |  Hiba Zawatieh  |    20   |  2004-12-12  | hbzawati@gmail.com | 0599956733 | Training in progress |  50  |  12345|

  @tag2
  Scenario Outline: Customize Client account
    Given The user already has an account
    When User put user name "<Email>" and password in true and has the following details:
    |   Client name   |   Age   |  Birthday   |   Email  |  PhoneNumber  |   Fitness Goals   |    Weight    |    Password   |
    |  <Client name>  |  <Age>  | <Birthday>  |  <Email> | <PhoneNumber> |  <Fitness Goals>  |   <Weight>   |   <Password>  |
    Then The account should be open and the details should be shown

  Examples:
    |   Client name   |   Age   |  Birthday   |   Email  |  PhoneNumber  |   Fitness Goals   |    Weight    |    Password   |
    |  Hiba Zawatieh  |    20   |  2004-12-12  | hbzawati@gmail.com | 0599956733 | Training in progress |  50  |  12345|

  @tag3
  Scenario Outline: View dietary preferences and restrictions
    Given User logged in as client
    When The user "<Email>" wants to view dietary preferences or restrictions with the following details:
    |    Email   |   Dietary preferences   |   Restrictions   |
    |   <Email>  |  <Dietary preferences>  |  <Restrictions>  |
    Then The system should display the details

  Examples:
  |    Email   |   Dietary preferences   |   Restrictions   |
  |hbzawati@gmail.com|Vegetarian|No tomato|