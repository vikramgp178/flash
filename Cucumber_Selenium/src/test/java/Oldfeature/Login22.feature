Feature: Login page
	
Background: every sceanrio required login.
		Given User Launch the browser.
		When User Open the URL.
	
Scenario: Verify the title of the page
		Then Page title should be Google.
		And close the browser.

Scenario: Search the string
		Then search into the google Search box.
		And close the browser.

