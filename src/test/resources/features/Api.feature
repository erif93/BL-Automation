@tag
Feature: Api Posts Feature

  @Post
  Scenario Outline: As a user i can create new post with valid title, body and user id
  Given I set base url Api
  When send post request with valid <title>, valid <body> and valid <userId>
  Then I verify the <statuscode> from the respons
     Examples: 
      | title  | body | userId  | statuscode |
      |   recomendation     |  motorcycle    |  12       |  201          |
      
      
   @Validate-json-schema
    Scenario Outline: As a user i want to validate json schema
    Given I set base url Api
    When I send get request
    Then I verify json schema
