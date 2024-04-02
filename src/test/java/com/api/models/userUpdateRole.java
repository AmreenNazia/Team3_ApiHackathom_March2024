package com.api.models;

import java.util.List;

import com.api.stepdefinition.Batch_SD;
import com.api.stepdefinition.UC_PostRequestStep;

public class userUpdateRole {
	private String roleId;
	private String userId;
	private List<UserStatus> userRoleProgramBatches;
	public UserStatus status = new UserStatus();
	public UC_PostRequestStep post = new  UC_PostRequestStep();
	public Batch_SD batch = new Batch_SD();
	private int programId;
	
	
	public userUpdateRole(Object rolieId, Object userId, Object programId,List<com.api.models.UserStatus> status) {
		setRoleId("R03");
		setUserId(post.userID);
		setUserRoleProgramBatches(status);
		setProgramId(batch.programID);
		
		
		
		
	}
//	 
//	public userUpdateRole(Object roleId, Object userId, Object programId) {
//		setRoleId("R03");
//		setUserId(post.userID);
//		setProgramId(batch.programID);
//		
//	}

	public int getProgramId() {
		return programId;
	}
	public void setProgramId(int programId) {
		this.programId = programId;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public List<UserStatus> getUserRoleProgramBatches() {
		return userRoleProgramBatches;
	}
	public void setUserRoleProgramBatches(List<UserStatus> status) {
		this.userRoleProgramBatches = status;
	}
	
}
