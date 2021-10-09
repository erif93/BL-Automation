Feature: Register to bukalapak website

	@invalid-username
	Scenario: As a user i want to register with invalid username
	Given I go to bukalapak register page
	When  I input invalid email
	And   I click daftar
	Then  Error message should be displayed
	
	@empty-username
	Scenario: As a user i want to register with empty username
	Given I go to bukalapak register page
	When  I input empty email
	And   I click daftar
	Then  Error message should be displayed
	
	@valid-username
	Scenario: As a user i want to register with valid username
	Given I go to bukalapak register page
	When  I input valid email
	And   I click daftar
	And   I click kirim kode
	Then  verification page should be displayed