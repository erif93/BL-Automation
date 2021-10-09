Feature: Search item in bukalapak website

	@success-search
	Scenario: As a user i want search available item in bukalapak website
	Given I search a product
	When  I click search icon
	Then  I verify my search result
	
	@failed-search
	Scenario: As a user i want to search not available item in bukalapak website
	Given I search unavailable product
	When  I click search icon
	Then  I verify not found 
	