Feature: I can write anything to Console

  As a developer I can write "sout"
  The IDE will replace it with System.out.println();
  I can pass any object as a parameter for println() method

  Scenario: I can write to console
    Given I write init message

  Scenario: Given is unnecessary
    Then I write the second message

  Scenario: I can type any keyword
    * I write A
    * I write B
    * I write C
    * I write D
