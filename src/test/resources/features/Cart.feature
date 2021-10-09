Feature: Add to cart product

	@add-to-cart-without-login
	Scenario: As a user i want to add product to cart without login
	Given I am not login into buka lapak website
	When  I navigate to product detail page
	And   I click add to cart
	Then  Login page should be displayed
	
	@add-to-cart-with-login
	Scenario: As a user i want to add product to cart successfully
	Given I already login
	When  I navigate to product detail page
	And   I click add to cart
	Then  product successfully added into chart
	
	
	
	
	