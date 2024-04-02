package com.api.models;

import com.api.stepdefinition.Batch_SD;

public class UserStatus {
private String userRoleProgramBatchStatus;
	public Batch_SD batch = new Batch_SD();
	private int batchId;
	
	
	public UserStatus() {
		
	}
	public UserStatus(Object userRoleProgramBatchStatus, Object batchId ) {
		setUserRoleProgramBatchStatus("Active");
		setBatchId(batch.batchID);
	}
	public int getBatchId() {
		return batchId;
	}
	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}
	public String getUserRoleProgramBatchStatus() {
		return userRoleProgramBatchStatus;
	}
	public void setUserRoleProgramBatchStatus(String userRoleProgramBatchStatus) {
		this.userRoleProgramBatchStatus = userRoleProgramBatchStatus;
	}
	

}


