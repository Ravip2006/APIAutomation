Feature: API Testing

 Scenario :Retrieve the pet ID
   Given the API endpoint is "/pet/1"
   When I send a GET request
   Then the response status code should be 200
   And the response body should contain pet details

