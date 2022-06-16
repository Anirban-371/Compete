package com.edifyine.competition.pojo;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.edifyine.competition.enums.Role;

import lombok.Data;

@Data
@Document
public class CompeteUser {
	@Id
	long id;
	@NotNull
	String userId;
	@NotNull
	String userName;
	@NotNull
	String contactNo;
	@NotNull
	String email;
	String education;
	String profession;
	List<Long> preferredTopicId;
	String password;
	String createdAt;
	String updatedAt;
	String role;
	
}
