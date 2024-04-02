
@user
Feature: Validating Get request for User API's

 Background: Admin sets Authorization  
Given Admin creates request with valid credentials
When Admin calls Post Https method  with valid endpoint
Then Admin receives 200 created with auto generated token

Scenario: Admin is able to get count of active and in active admins
Given Users creates Get user request 
When Users sends https request with "getcountofactiveandinactive"
Then Users receives 200 ok. 


Scenario: Admin is able to get all active users
Given Users creates Get user request 
When Users sends https request with "getallactiveusers"
Then Users receives 200 ok. 
@updateuser
Scenario: Admin is able to assign update user role program batch
Given Users creates request with valid response body UserRoleProgramBatch.
When Users sends https put request with assignupdateuserroleprogrambatch
Then users receives the 200 ok. 

Scenario: Admin is able to get admin by program batchId
Given Users creates Get user request 
When Users sends https request with getadminbyprogrambatchId
Then Users receives 200 ok. 
@updateuser
Scenario: Admin is able to update user roleId
Given Users creates request with valid response body "UpdateUserRoleId"
When Users sends https put request with updateuserroleId
Then users receives the 200 ok.

Scenario: Admin is able to get admin by programId
Given Users creates Get user request 
When Users sends https request with getadminbyprogramId
Then Users receives 200 ok. 

Scenario: Admin is able to get admin by roleId
Given Users creates Get user request 
When Users sends https request with "getadminbyroleId"
Then Users receives 200 ok. 

Scenario: Admin is able to get all users
Given Users creates Get user request 
When Users sends https request with "getallusers"
Then Users receives 200 ok. 

Scenario: Admin is able to get all roles
Given Users creates Get user request 
When Users sends https request with "getallroles"
Then Users receives 200 ok. 

Scenario: Admin is able to get user by userId
Given Users creates Get user request 
When Users sends https request with "getuserbyuserId"
Then Users receives 200 ok. 

Scenario: Admin is able to get all users with roles
Given Users creates Get user request 
When Users sends https request with "getalluserswithroles"
Then Users receives 200 ok. 

Scenario: Admin is able to get users by roleId V2
Given Users creates Get user request 
When Users sends https request with "getusersbyroleIdV2"
Then Users receives 200 ok. 


@updateuser
Scenario: Admin is able to update user by userId
Given Users creates request with valid response body "UpdateUser"
When Users sends https put request with updateuser
Then users receives the 200 ok. 

@updateuser
Scenario: Admin is able to update user role status
Given Users creates request with valid response body "UpdateUserRoleStatus"
When Users sends https put request with updateuserrolestatus
Then users receives the 200 ok. 

@updateuser
Scenario: Admin is able to update user login status
Given Users creates request with valid response body "UpdateUserLoginStatus"
When Users sends https put request with updateuserloginstatus
Then users receives the 200 ok. 





