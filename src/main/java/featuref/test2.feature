
@test2
Feature: Validate Response of CocktailDB.com

  @scenario-1
  Scenario: Validate get request
    Given I send get request to server
    And I validate the response code as 404
    Then I validate the reponse time
    