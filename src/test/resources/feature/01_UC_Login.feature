@login
Feature: Validating user login

Background: Admin sets Authorization  
Given Admin creates request with valid credentials
When Admin calls Post Https method  with valid endpoint
Then Admin receives 200 created with auto generated token

@login-Valid
Scenario: Check if user able to login with token and valid credential
 Given Admin creates post request with valid emailid and password
 When Admin calls Post Http request with valid endpoint
 Then Admin receives 200 created with auto generated token

@login-Invalid
 Scenario: Check if user able to login with token and invalid credential
 Given user creates post request with invalid endpoint.
 When user hit invalid url.
 Then user receives 400 bad request 
 
@login-NoAuth
 Scenario: Check if user able to login without token and valid credential
 Given Unauthorized user creates post request with valid emailid and password
 When user calls Post Http request with valid endpoint
 Then user receives 401 status.
 
