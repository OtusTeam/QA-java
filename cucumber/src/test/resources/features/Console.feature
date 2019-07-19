Feature: I can write anything to Console

  As a developer I can write "sout"
  The IDE will replace it with System.out.println();
  I can pass any object as a parameter for println() method

  Scenario: I can write to console
    Given I write init message

  Scenario: Given is not necessary
    Then I write the second message

  Scenario: I can type any keyword
    When I write A
    And I write B
    But I write C
    * I write D
