Feature: I can open topic page

  Scenario: Open 1st topic
    Given ATInfo is open
    When I open 1 topic
    Then topic title should be "Top topic"

  Scenario: Login button
    Given ATInfo is open
    * I click "Войти"
    Then Login modal is visible
