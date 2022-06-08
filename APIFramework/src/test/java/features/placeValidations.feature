Feature: Validating Place API's 

Scenario: Verify if place is being added succesfully 
	Given Add Place Payload 
	When User calls "AddPlaceAPI" with post http request 
	Then The API call got success with status code 200 
	And "status" in response body is "OK"
	