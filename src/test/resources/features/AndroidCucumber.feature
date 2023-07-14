Feature: demo our dummy app

  Scenario: Switch view back and forth
    Given First Page is loaded
    When I click on element with text "To Next Fragment"
    Then I see second text with value "Second text fragment"
    When I click on element with text "Previous"
    Then I see first text with value "First text fragment"

  Scenario: Click email icon
    Given First Page is loaded
    When I click on "EMAIL" button
    Then I see popup with text "Replace with your own action"