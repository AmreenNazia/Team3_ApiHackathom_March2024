Feature: Batch Module

  Background: Admin sets Authorization
    Given Admin creates request with valid credentials
    When Admin calls Post Https method  with valid endpoint
    Then Admin receives 200 created with auto generated token

  @DeleteBatchwithValidBatchId
  Scenario: Check if admin able to delete a Batch with valid Batch ID
    Given Admin creates DELETE Request with valid BatchId
    When Admin sends HTTPS Request  with endpoint for batch
    Then Admin receives 200 Ok status with message

  @GetBatchAfterDeletById
  Scenario: Check if admin able to retrive a batch after deleting the batch
    Given Admin creates GET Request with valid Batch ID
    When Admin sends HTTPS get Request with endpoint
    Then Admin receives 200 OK Status with  batchStatus field "Inactive" in the response body.

  @GetBatchAfterDeleteByName
  Scenario: Check if admin able to retrive a deleted batch  using batch name
    Given Admin creates GET Request with valid Batch Name
    When Admin sends HTTPS Request with endpoint batchName
    Then Admin receives 200 OK Status with  batchStatus field "Inactive" in the response body.

  @UpdatewithDeletedBatchId
  Scenario: Check if admin able to update a Batch with a deleted batchID in the endpoint
    Given Admin creates PUT Request with auth, valid BatchId and "Update Valid Data"
    When Admin sends HTTPS Request  with endpoint and deleted batchID
    Then Admin receives 200 Ok status with message for update
