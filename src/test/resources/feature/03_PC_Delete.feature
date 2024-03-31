Feature: ProgramController Module Test with Invalid Data

Background: Admin sets Authorization  
Given Admin creates request with valid credentials
When Admin calls Post Https method  with valid endpoint
Then Admin receives 200 created with auto generated token



Scenario: Check if Admin able to delete a program with valid LMS API,invalid programName
Given Admin creates DELETE Request for the LMS API endpoint  
When Admin has sends  HTTPS Request with endpoint and  invalid  programName
Then Admin receives 404 Not Found Status with message and boolean success details

Scenario: Check if Admin able to delete a program without Authorization
Given Admin creates DELETE Request for the LMS API endpoint  and  valid programName
When Admin has sends  HTTPS Request with endpoint and  without Authorization
Then Admin receives 401 Unauthorized


Scenario: Check if Admin able to delete a program with valid program ID
Given Admin creates DELETE Request for the LMS API endpoint 
When Admin send HTTPS Request with endpoint  and  invalid program ID.
Then Admin receives 404 Not Found Status with message and boolean success details


Scenario: Check if Admin able to delete a program without Authorization
Given Admin create DELETE Request for the LMS API endpoint 
When Admin send HTTPS Request with endpoint withOut Authorization
Then Admin receives 401 Unauthorized    

Scenario: Check if Admin able to delete a program with valid programName
Given Admin creates DELETE Request for the LMS API endpoint  and  valid programName
When Admin has sends  HTTPS Request with endpoint
Then Admin receives 200 Ok status with message


Scenario: Check if Admin able to delete a program with valid program ID
Given Admin creates DELETE Request for the LMS API endpoint  and  valid program ID
When Admin send HTTPS Request with endpoint.
Then Admin receive 200 Ok status with message                                   
 