package com.edifyine.competition.daoImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edifyine.competition.dao.UserDao;
import com.edifyine.competition.pojo.CompeteUser;
import com.edifyine.competition.repository.UserRepository;

@Repository
public class UserDaoImpl implements UserDao{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public CompeteUser getUserDetails(String id) {
		return userRepository.findById(Long.parseLong(id)).get();
	}

	@Override
	public void saveUser(CompeteUser user) {
		userRepository.save(user);
		
	}

	@Override
	public void deleteUser(long id) {
		userRepository.deleteById(id);
		
	}

	@Override
	public void updateUser(CompeteUser user) {
		userRepository.save(user);
	}

	@Override
	public Optional<CompeteUser> loadUserByUserId(String userId) {
		return userRepository.findByUserName(userId);
	}

}
