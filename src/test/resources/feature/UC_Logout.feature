@logout
Feature: Validating user logout 

Background: Admin sets Authorization  
Given Admin creates request with valid credentials
When Admin calls Post Https method  with valid endpoint
Then Admin receives 200 created with auto generated token

@logout-withAuth
Scenario: Check if user able to logout with token and valid credential
 Given user creates GET request with valid emailid and password
 When user calls GET Http request with valid endpoint
 Then user receives 200 status.
 
#@logout-withNoAuth
#Scenario: Check if Unauthorized user able to logout with valid credential
 #Given Unauthorized user creates GET request with valid emailid and password
 #When Unauthorized user calls GET Http request with valid endpoint
 #Then user receives 401 status.