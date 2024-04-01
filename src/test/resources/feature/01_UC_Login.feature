@login
Feature: Validating user login

 
@login-Valid
Scenario: Check if user able to login with token and valid credential
 Given Admin creates request with valid credentials
When Admin calls Post Https method  with valid endpoint
Then Admin receives 200 created with auto generated token

#@login-Invalid
 #Scenario: Check if user able to login with token and invalid credential
 #Given Admin creates request with valid credentials
 #When Admin calls Post Https method  with invalid endpoint
 #Then Admin receives 401 unauthorized
 #
#@login-NoAuth
 #Scenario: Check if user able to login without token and valid credential
 #Given Admin creates request with invalid credentials
 #When Admin calls Post Https method  with valid endpoint
 #Then Admin receives 400 Bad request
 #
