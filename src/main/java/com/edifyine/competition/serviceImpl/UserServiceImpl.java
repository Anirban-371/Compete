package com.edifyine.competition.serviceImpl;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edifyine.competition.dao.UserDao;
import com.edifyine.competition.pojo.CompeteUser;
import com.edifyine.competition.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDao userDao;
	
	@Override
	public CompeteUser getUserDetails(String id) {
		return userDao.getUserDetails(id);
	}

	@Override
	public void saveUser(CompeteUser user) {
		user.setId(new Date().getTime());
		userDao.saveUser(user);
	}

	@Override
	public void deleteUser(long id) {
		userDao.deleteUser(id);
	}

	@Override
	public void updateUser(CompeteUser user) {
		userDao.updateUser(user);
	}
	public Optional<CompeteUser> loadUserByUserId(String userId) {
		return userDao.loadUserByUserId(userId);
	}

}
