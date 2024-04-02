Feature: Validating Delete Request

 Background: Admin sets Authorization  
Given Admin creates request with valid credentials
When Admin calls Post Https method  with valid endpoint
Then Admin receives 200 created with auto generated token



@deleteuser
Scenario: Admin is able to delete user 
Given Users creates delete request 
When Users sends delete request with deleteuser
Then Userss receives 200 ok. 

@DeleteBatchwithValidBatchId
  Scenario: Check if admin able to delete a Batch with valid Batch ID
  Given Admin creates DELETE Request with valid BatchId.
  When Admin sends HTTPS Request  with endpoint for batch.
  Then Admin receives 200 Ok status with message.

Scenario: Check if Admin able to delete a program with valid programName
Given Admins creates DELETE Request for the LMS API endpoint  and  valid programName
When Admins has sends  HTTPS Request with endpoint
Then Admins receives 200 Ok status with message


Scenario: Check if Admin able to delete a program with valid program ID
Given Admins creates DELETE Request for the LMS API endpoint  and  valid program ID
When Admins send HTTPS Request with endpoint.
Then Admins receive 200 Ok status with message    


Scenario: Admin is able to delete program/batches for valid adminId
Given Users creates delete request 
When Users sends delete request with deleteassignedprogrambatchbyuserId
Then Userss receives 200 ok.                                


