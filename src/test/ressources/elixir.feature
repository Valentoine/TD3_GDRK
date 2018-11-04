Feature: Elixir Item
  # a conjured item quality decreases 1

  Scenario: elixir item update
    Given I have a new visitor
    Then the quality of the elixir item is 7
    When I update the inventory
    Then the quality of the elixir item is 6

