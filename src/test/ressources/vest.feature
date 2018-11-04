Feature: Vest Item
  # a conjured item quality decreases 1

  Scenario: vest item update
    Given I have a new inventory
    Then the quality of the vest item is 20
    When I update the inventory
    Then the quality of the vest item is 19

