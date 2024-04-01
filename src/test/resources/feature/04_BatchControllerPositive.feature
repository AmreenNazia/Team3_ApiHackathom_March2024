Feature: Batch Module

  Background: Admin sets Authorization
    Given Admin creates request with valid credentials
    When Admin calls Post Https method  with valid endpoint
    Then Admin receives 200 created with auto generated token

  @CreateNewBatch
  Scenario: Check if admin able to create a Batch with valid endpoint and request body
    Given User creates request for the LMS API endpoint "Create New Batch".
    When User sends HTTPS post request for batch and request body with mandatory and additional fields.
    Then User receives 201 created status for batch.

  @GetBatchByBatchId
  Scenario: Check if admin able to retrieve a batch with valid Batch ID
    Given Admin creates GET Request with valid Batch ID.
    When Admin sends HTTPS get Request with endpoint.
    Then Admin receives 200 OK Status with response body for batch.

  @GetBatchbyBatchName
  Scenario: Check if admin able to retrieve a batch with valid BATCH NAME
    Given Admin creates GET Request with valid Batch Name.
    When Admin sends HTTPS Request with endpoint batchName.
    Then Admin receives 200 OK Status with the response body for batch.

  @GetBatchByValidPgmId
  Scenario: Check if admin able to retrieve a batch with valid Program ID
    Given Admin creates GET Request with the program id.
    When Admin sends HTTPS Request with the endpoint for programId.
    Then Admin receives 200 OK Status with response body.

  @CreateBatchMandatoryField
  Scenario: Check if admin able to create a batch with missing additional fields
    Given Admin creates POST Request with missing additional fields Create New Batch Missing Field.
    When Admin sends HTTPS Request with endpoint.
    Then Admin receives 201 Created Status with response body.

  @GetAllBatches
  Scenario: Check if admin able to retrieve all batches  with valid LMS API
    Given Admin creates GET Request.
    When Admin sends "HTTPS Request" with endpoint.
    Then Admin receives 200 OK Status with response body.

  @GetAllBatchesSearchString
  Scenario: Check if admin able to retrieve all batches with search string
    Given Admin creates GET Request with search string.
    When Admin sends "HTTPS Request" with endpoint.
    Then Admin receives 200 Ok status with response body.

  @UpdateBatchValid
  Scenario: Check if admin able to update a Batch with valid batchID and mandatory fields in request body
    Given Admin creates PUT Request with auth, valid BatchId and Update Valid Data.
    When Admin sends HTTPS Request  with update endpoint.
    Then Admin receives 200 OK Status with updated value in response body.
