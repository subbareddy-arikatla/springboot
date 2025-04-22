package com.netKnowledge.project1.service;

import com.netKnowledge.project1.Model.Journalist;
import com.netKnowledge.project1.repo.repositoryEntity;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceEntity {
    @Autowired
    private repositoryEntity repo;

    public void saveEntity(Journalist entity){
        entity.setDate(LocalDateTime.now());
        repo.save(entity);
    }
    public List<Journalist> getAllEntity(){
       return repo.findAll();
    }
    public Optional<Journalist> getEntityById(ObjectId myId){
        return repo.findById(myId);
    }
    public void deleteById(ObjectId myId){
        repo.deleteById(myId);
    }
}
