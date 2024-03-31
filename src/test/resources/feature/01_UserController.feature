
@user
Feature: Validating Get request for User API's

 Background: Admin sets Authorization  
Given Admin creates request with valid credentials
When Admin calls Post Https method  with valid endpoint
Then Admin receives 200 created with auto generated token

Scenario: Admin is able to get count of active and in active admins
Given Admin creates Get request 
When Admin sends https request with "getcountofactiveandinactive"
Then Admin receives 200 ok 


Scenario: Admin is able to get all active users
Given Admin creates Get request 
When Admin sends https request with "getallactiveusers"
Then Admin receives 200 ok 

Scenario: Admin is able to get admin by program batchId
Given Admin creates Get request 
When Admin sends https request with "getadminbyprogrambatchId"
Then Admin receives 200 ok 

Scenario: Admin is able to get admin by programId
Given Admin creates Get request 
When Admin sends https request with "getadminbyprogramId"
Then Admin receives 200 ok 

Scenario: Admin is able to get admin by roleId
Given Admin creates Get request 
When Admin sends https request with "getadminbyroleId"
Then Admin receives 200 ok 

Scenario: Admin is able to get all users
Given Admin creates Get request 
When Admin sends https request with "getallusers"
Then Admin receives 200 ok 

Scenario: Admin is able to get all roles
Given Admin creates Get request 
When Admin sends https request with "getallroles"
Then Admin receives 200 ok 

Scenario: Admin is able to get user by userId
Given Admin creates Get request 
When Admin sends https request with "getuserbyuserId"
Then Admin receives 200 ok 

Scenario: Admin is able to get all users with roles
Given Admin creates Get request 
When Admin sends https request with "getalluserswithroles"
Then Admin receives 200 ok 

Scenario: Admin is able to get users by roleId V2
Given Admin creates Get request 
When Admin sends https request with "getusersbyroleIdV2"
Then Admin receives 200 ok 

@updateuser
Scenario: Admin is able to assign update user role program batch
Given Admin creates request with valid response body "UserRoleProgramBatch"
When Admin sends https put request with "assignupdateuserroleprogrambatch"
Then Admins receives 200 ok 

@updateuser
Scenario: Admin is able to update user by userId
Given Admin creates request with valid response body "UpdateUser"
When Admin sends https put request with "updateuser"
Then Admins receives 200 ok 

@updateuser
Scenario: Admin is able to update user role status
Given Admin creates request with valid response body "UpdateUserRoleStatus"
When Admin sends https put request with "updateuserrolestatus"
Then Admins receives 200 ok 

@updateuser
Scenario: Admin is able to update user login status
Given Admin creates request with valid response body "UpdateUserLoginStatus"
When Admin sends https put request with "updateuserloginstatus"
Then Admins receives 200 ok 

@updateuser
Scenario: Admin is able to update user roleId
Given Admin creates request with valid response body "UpdateUserRoleId"
When Admin sends https put request with "updateuserroleId"
Then Admins receives 200 ok 



#@deleteuser
#Scenario: Admin is able to delete user 
#Given Admin creates delete request 
#When Admin sends delete request with "deleteuser"
#Then Admins receives 200 ok 

