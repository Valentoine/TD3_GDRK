Feature: Sulfuras Item
  # a conjured item quality stay at the number at the creation

  Scenario: sulfuras item update
    Given I have a new strategy
    Then the quality of the sulfuras item is 80
    When I update the inventory
    Then the quality of the sulfuras item is 80

