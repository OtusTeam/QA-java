Feature: I can run test-case many times

  Scenario: I can write a message
    Given I write to console "test"
    And I write to console "ABC"
    And I write to console "123"

  Scenario Outline: The same test in one step
    Given I write to console "<message>"

    Examples:
      | message  |
      | Java     |
      | Cucumber |
      | Spring   |
      | Selenium |

  Scenario: I can pass not only strings
    Given I want to write "test" 3 times

  Scenario: And float and text
    Given also I can write float 2.4 numbers and "long, very long texts"

