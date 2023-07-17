Feature: demo our dummy app

#  Scenario: Switch view back and forth
#    Given First Page is loaded
#    When I click on element with text "To Next Fragment"
#    Then I see second text with value "Second text fragment"
#    When I click on element with text "Previous"
#    Then I see first text with value "First text fragment"
#
#  Scenario: Click email icon
#    Given First Page is loaded
#    When I click on "EMAIL" button
#    Then I see popup with text "Replace with your own action"

#  Scenario Outline:
#    When check number <int_param>
#    Examples:
#      | int_param   |
#      | 5           |
#      | 6           |

#  Scenario Outline: Parametrized scenario sample
#    Given First Page is loaded
#    When i set LOGIN_INPUT element value to "<login_value>"
#    When i set PASSWORD_INPUT element value to "<password_value>"
#    When check number <int_param>
#    When i click login button
#    Then I see popup with text "<expected_text>"
#    Examples:
#      | login_value | password_value | expected_text                  | int_param |
#      | test        | test-pwd       | Loggin in as test : test-pwd   | 5         |
#      | test2       | test2-pwd      | Loggin in as test2 : test2-pwd | 6         |

#  Scenario: List example
#    Given Print list content
#      | value_1 |
#      | value_2 |
#      | value_3 |
#      | value_4 |
#
#  Scenario: Map example
#    Given Test Cucumber map
#      | Моя Картка Для Виплат | 1234    |
#      | key_2                 | value_2 |
#      | key_3                 | value_3 |

  Scenario: demo cells
  Given Get cell CELL_NAME value in row 1
  Given Get cell CELL_NAME value in row 2
  Given Get cell CELL_NAME value in row 3
  Given Get cell CELL_SURNAME value in row 1
  Given Get cell CELL_SURNAME value in row 2
  Given Get cell CELL_SURNAME value in row 3
  Given Get cell CELL_CARD_NUMBER value in row 1
  Given Get cell CELL_CARD_NUMBER value in row 2
  Given Get cell CELL_CARD_NUMBER value in row 7

#  login
#  password
#  btn_login
#  Loggin in as %s : %s