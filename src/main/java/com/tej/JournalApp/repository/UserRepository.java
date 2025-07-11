package com.tej.JournalApp.repository;

import com.tej.JournalApp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, ObjectId> {
           User findByUserName(String userName);

}
