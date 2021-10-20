#language:en
Feature: check google page

  Background:
    Given I open google search page

  Scenario: check 'hello'
    When I write text "hello selenide" to search input
    And I click button to search it
    Then Result page has 10 results

  Scenario Outline: check difference texts
    When I write text "<text>" to search input
    And I click button to search it
    Then Result page has <size> results
    Examples:
      | text            | size |
      | hello selenide  | 10   |
      | pizza pepperoni | 10   |
      | ninja           | 10   |
      | silver bullet   | 10   |
