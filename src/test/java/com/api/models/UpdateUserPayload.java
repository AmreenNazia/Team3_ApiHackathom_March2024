package com.api.models;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UpdateUserPayload {

	public void userpayload(Map<String, Object> user) throws JsonProcessingException {
		
		UserStatus status = new UserStatus(user.get("userRoleProgramBatchStatus"),user.get("batchId"));
		List<UserStatus> list = Arrays.asList(status);
		userUpdateRole role = new userUpdateRole(user.get("roleId"),user.get("userId"),user.get("programId"),list);
		
		
		ObjectMapper mapper = new ObjectMapper();
		String payload = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(mapper);
		 
		
	}
	
	
	 
}
