Feature: Login to bukalapak website

	@wrong-password
	Scenario: As a user i want to login with wrong password
	Given I go to login page
	When  I input correct email
	And   I click lanjut
	And   I input wrong password
	And   I click login
	Then  Error message should be displayed
	
	@wrong-username
	Scenario: As a user i want to login with wrong username
	Given I go to login page
	When  I input unregistered email
	And   I click lanjut
	Then  Error message should be displayed
	
	@empty-username
	Scenario: As a user i want to login without input username
	Given I go to login page
	When  I not input username
	And   I click lanjut
	Then  Error message should be displayed
	
	@empty-password
	Scenario: As a user i want to login without input password
	Given I go to login page
	When  I input correct email
	And   I click lanjut
	And   I not input password
	And   I click login
	Then  Error message should be displayed
	
	@success-login
	Scenario: As a user i want to login with valid credential
	Given I go to login page
	When  I input correct email
	And   I click lanjut
	And   I input correct password
	And   I click login
	Then  I can login into bukalapak page