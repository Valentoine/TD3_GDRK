Feature: Backstage Item
  # a conjured item quality increase

  Scenario: backstage item update
    Given I have a new strategy
    Then the quality of the backstage item is 20
    When I update the inventory
    Then the quality of the backstage item is 21

