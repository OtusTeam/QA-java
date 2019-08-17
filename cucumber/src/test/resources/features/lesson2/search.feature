Feature: I can search

  Scenario: I can search posts related to search term
    Given I am on main page
    When I search "otus"
    Then I am on result page with "otus"

