Feature: I can set my custom step argument type

  Scenario Outline: Tech stack
    Given Log "<name>" - <id>
    Examples:
      | name     | id |
      | Java     | 1  |
      | Cucumber | 2  |
      | Spring   | 3  |
      | Selenium | 4  |

  Scenario: Tech stack as list
    Given I can
      | name     | id |
      | Java     | 1  |
      | Cucumber | 2  |
      | Spring   | 3  |
      | Selenium | 4  |

