package com.edifyine.competition.service;

import java.util.Optional;

import com.edifyine.competition.pojo.CompeteUser;

public interface UserService {

	CompeteUser getUserDetails(String id);

	void saveUser(CompeteUser user);

	void deleteUser(long id);

	void updateUser(CompeteUser user);
	
	Optional<CompeteUser> loadUserByUserId(String userId);

}
