package com.edifyine.competition.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.edifyine.competition.pojo.CompeteUser;

@Repository
public interface UserRepository extends MongoRepository<CompeteUser, Long>{

	Optional<CompeteUser> findByUserId(String userId);
	
	Optional<CompeteUser> findByUserName(String userName);

}
