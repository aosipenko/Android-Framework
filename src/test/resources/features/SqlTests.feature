Feature: SQL tests

  Scenario: SQL CRUD demo
#    Given I add user with name "Jane" last name "Doe" title "Mrs" gender "female"
#    Given I read data from DB
    Given A request to "randomuser.me" as "RANDOM_USER_SERVICE"
    Given A path "/api/" as "GET_RANDOM_USER"
    Given Query params "FIVE_USERS_QUERY":
      | inc     | gender,name,nat |
      | noinfo  |                 |
      | results | 5               |
    When I make request to "RANDOM_USER_SERVICE" at "GET_RANDOM_USER" with "FIVE_USERS_QUERY" as "FIVE_USERS_RESPONSE"
    And I store "FIVE_USERS_RESPONSE" in DB
    Given I read data from DB