#Feature: ProgramController Module Test with Invalid Data
#
#Background: Admin sets Authorization  
#Given Admin creates request with valid credentials
#When Admin calls Post Https method  with valid endpoint
#Then Admin receives 200 created with auto generated token
#
#
#
#Scenario: Check if Admin able to delete a program with valid LMS API,invalid programName
#Given Admins creates DELETE Request for the LMS API endpoint  
#When Admins has sends  HTTPS Request with endpoint and  invalid  programName
#Then Admins receives 404 Not Found Status with message and boolean success details
#
#Scenario: Check if Admin able to delete a program without Authorization
#Given Admins creates DELETE Request for the LMS API endpoint  and  valid programName
#When Admins has sends  HTTPS Request with endpoint and  without Authorization
#Then Admins receives 401 Unauthorized
#
#
#Scenario: Check if Admin able to delete a program with valid program ID
#Given Admins creates DELETE Request for the LMS API endpoint 
#When Admins send HTTPS Request with endpoint  and  invalid program ID.
#Then Admins receives 404 Not Found Status with message and boolean success details
#
#
#Scenario: Check if Admin able to delete a program without Authorization
#Given Admins create DELETE Request for the LMS API endpoint 
#When Admins send HTTPS Request with endpoint withOut Authorization
#Then Admins receives 401 Unauthorized    
#
#Scenario: Check if Admin able to delete a program with valid programName
#Given Admins creates DELETE Request for the LMS API endpoint  and  valid programName
#When Admins has sends  HTTPS Request with endpoint
#Then Admins receives 200 Ok status with message
#
#
#Scenario: Check if Admin able to delete a program with valid program ID
#Given Admins creates DELETE Request for the LMS API endpoint  and  valid program ID
#When Admins send HTTPS Request with endpoint.
#Then Admins receive 200 Ok status with message                                   
 