Feature: better steps

#  Scenario: better apache stuff
#    Given A request to "google.com" as "GOOGLE_SERVICE"
#    Given A path "/search/" as "SEARCH_ENDPOINT"
#    Given A request to "randomuser.me" as "RANDOM_USER_SERVICE"
#    Given A path "/api/" as "GET_RANDOM_USER"
#    Given Query params "FIVE_USERS_QUERY":
#      | inc     | gender,name,nat |
#      | noinfo  |                 |
#      | results | 5               |
#    Given Query params "TEN_USERS_QUERY":
#      | inc     | gender,name,nat |
#      | noinfo  |                 |
#      | results | 10              |
#    When I make request to "RANDOM_USER_SERVICE" at "GET_RANDOM_USER" with "FIVE_USERS_QUERY" as "FIVE_USERS_RESPONSE"
#    When I make request to "RANDOM_USER_SERVICE" at "GET_RANDOM_USER" with "TEN_USERS_QUERY" as "TEN_USERS_RESPONSE"
#
#    Then Print response "FIVE_USERS_RESPONSE"
#    Then Print response "TEN_USERS_RESPONSE"

  Scenario: DataHolderV2 demo
    Given Store Name object with alias "name_1"
    Given Store String object with alias "name_1"
    Then Print name object "name_1"
    Then Print string object "name_1"
#    Given i generate access token for "user_1"
#    Given i generate access token for "user_2"
#    Given i retrieve banking data for "user_1"
#    Given i retrieve banking data for "user_2"
#    When user "user_1" sends money to "user_2"
#    Then i see account changed for "user_1"
#    Then i see account changed for "user_2"
