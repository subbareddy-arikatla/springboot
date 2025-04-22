package com.netKnowledge.project1.repo;

import com.netKnowledge.project1.Model.Journalist;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface repositoryEntity extends MongoRepository <Journalist, ObjectId>{
}
