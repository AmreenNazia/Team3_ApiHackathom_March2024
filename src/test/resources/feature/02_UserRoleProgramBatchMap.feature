
Feature: Validating user role program batch map API's

  
  Background: Admin sets Authorization  
Given Admin creates request with valid credentials
When Admin calls Post Https method  with valid endpoint
Then Admin receives 200 created with auto generated token

Scenario: Admin is able to get all admins with assigned program batches
Given Admin creates Get request 
When Admin sends https request with "getassignedprogrambatchifalluser"
Then Admin receives 200 ok 

Scenario: Admin is able to get program/batches for valid adminId
Given Admin creates Get request 
When Admin sends https request with "getassignedprogrambatchbyuserId"
Then Admin receives 200 ok 

#Scenario: Admin is able to delete program/batches for valid adminId
#Given Admin creates delete request 
#When Admin sends delete request with "deleteassignedprogrambatchbyuserId"
#Then Admin receives 200 ok 