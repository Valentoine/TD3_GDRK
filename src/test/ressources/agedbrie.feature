Feature: AgedBrie Item
  # a conjured item quality increase 1

  Scenario: agedbrie item update
    Given I have a new visitor
    Then the quality of the agedbrie item is 0
    When I update the inventory
    Then the quality of the agedbrie item is 1

