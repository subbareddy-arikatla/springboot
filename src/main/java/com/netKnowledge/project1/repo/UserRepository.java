package com.netKnowledge.project1.repo;

import com.netKnowledge.project1.Model.Journalist;
import com.netKnowledge.project1.Model.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository <User, ObjectId>{
    User findByUserName(String userName);
}
