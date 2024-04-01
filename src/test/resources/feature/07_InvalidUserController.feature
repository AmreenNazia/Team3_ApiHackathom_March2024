

#Feature: Validating Invalid data for User API's
#
  #
#Background: Admin sets Authorization  
#Given Admin creates request with valid credentials
#When Admin calls Post Https method  with valid endpoint
#Then Admin receives 200 created with auto generated token
#
#Scenario: Admin is able to get all users with invalid endpoint
#Given Admin creates Get request 
#When Admin sends https request with "allusers"
#Then Admin receives 404 
#
#Scenario: Admin is able to get all admins with invalid endpoint
#Given Admin creates Get request 
#When Admin sends https request with "allroles"
#Then Admin receives 404 
#
#Scenario: Admin is able to get all active users with invalid endpoint
#Given Admin creates Get request 
#When Admin sends https request with "allactiveusers"
#Then Admin receives 404
#
#Scenario: Admin is able to get all active and inactive users with invalid endpoint
#Given Admin creates Get request 
#When Admin sends https request with "countofactiveandinactive"
#Then Admin receives 404
#
#Scenario: Admin is able to get user with invalid userId
#Given Admin creates Get request 
#When Admin sends https request with "userbyuserId"
#Then Admin receives 404 
#
#Scenario: Admin is able to get admin by invalid program batchId
#Given Admin creates Get request 
#When Admin sends https request with "adminbyprogrambatchId"
#Then Admin receives 404
#
#Scenario: Admin is able to get admin by invalid programId
#Given Admin creates Get request 
#When Admin sends https request with "adminbyprogramId"
#Then Admin receives 404
#
#Scenario: Admin is able to get admin by invalid roleId
#Given Admin creates Get request 
#When Admin sends https request with "adminbyroleId"
#Then Admin receives 404 
#
#Scenario: Admin is able to get admin with roles with invalid endpoint
#Given Admin creates Get request 
#When Admin sends https request with "alluserswithroles"
#Then Admin receives 404 
#
#Scenario: Admin is able to get users by roleId V2 with invalid endpoint
#Given Admin creates Get request 
#When Admin sends https request with "usersbyroleIdV2"
#Then Admin receives 404
#
#Scenario: Admin is able to update user with invalid roleId
#Given Admin creates request with valid response body "UserRoleId"
#When Admin sends https put request with "userroleId"
#Then Admin receives 404
#
#Scenario: Admin is able to update user with existing roleId
#Given Admin creates request with valid response body "UserRoleId"
#When Admin sends https put request with "userroleId"
#Then Admin receives 404
#
#Scenario: Admin is able to update user with invalid adminroleprogrambatch
#Given Admin creates request with valid response body "UserRoleProgramBatchInvalid"
#When Admin sends https put request with "userroleprogrambatch"
#Then Admin receives 404
#
#Scenario: Admin is able to update user with existing adminroleprogrambatch
#Given Admin creates request with valid response body "UserRoleProgramBatchInvalid"
#When Admin sends https put request with "userroleprogrambatch"
#Then Admin receives 404
#
#Scenario: Admin is able to update user with invalid userloginstatus
#Given Admin creates request with valid response body "UserLoginStatus"
#When Admin sends https put request with "userloginstatus"
#Then Admin receives 404