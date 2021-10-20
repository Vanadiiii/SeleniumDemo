#language:en
Feature: check google page

  Background:
    Given I open google search page

  Scenario:
    When I write text "hello selenide" to search input
    And I click button to search it
    Then Result page has 10 results