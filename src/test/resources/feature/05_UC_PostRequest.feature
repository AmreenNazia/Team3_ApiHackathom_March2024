@UserModule
Feature: Check Post request of user controller module.

Background: Admin sets Authorization  
Given Admin creates request with valid credentials
When Admin calls Post Https method  with valid endpoint
Then Admin receives 200 created with auto generated token
#
@01UserModule-PostValid
Scenario: Authorized admin is able to create a new user with valid url and request body with mandatory fields.
 Given Authorized Admin creates POST request with valid request body. 
 When Authorized admin send valid post api request
 Then Authorized admin receive 201 status with response body
     #
 #@02UserModule-PostInvalid        
 #Scenario: Authorized admin is able to create a new user with valid url and request body with missing mandatory fields. 
 #Given Authorized admin user create post request with invalid request body
 #When Authorized admin user send valid post api request 
 #Then Authorized admin user receive 400 status with message  
 #
 #@03UserModule-PostNoAuth  
 #Scenario: Unauthorized admin user create post request with valid request body      
 #Given Unauthorized admin user create post request with valid request body
 #When Unauthorized admin user send valid post api request 
 #Then Unauthorized admin user receive 401 status with message                          