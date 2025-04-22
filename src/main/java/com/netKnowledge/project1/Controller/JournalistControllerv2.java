package com.netKnowledge.project1.Controller;

import com.netKnowledge.project1.Model.Journalist;
import com.netKnowledge.project1.service.ServiceEntity;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/v2journal")
public class JournalistControllerv2
{
    @Autowired
    private ServiceEntity service;


    @GetMapping

    public ResponseEntity<?> getAll()
    {
        List<Journalist>all= service.getAllEntity();
        if(all != null && !all.isEmpty()) {
            return new ResponseEntity<>(all, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND)
    }


    @PostMapping
    public ResponseEntity<Journalist> createEntry(@RequestBody Journalist myEntry){
            try{
                service.saveEntity(myEntry);
                return new ResponseEntity<>(myEntry,HttpStatus.CREATED);
            }catch(Exception e){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
    }

    @GetMapping("/id/{myId}")
    public ResponseEntity<?> getJournalById(@PathVariable ObjectId myId)
    {
        Optional<Journalist> journalistEntry = Optional.ofNullable(service.getEntityById(myId).orElse(null));
        if(journalistEntry.isPresent()){
            return new ResponseEntity<>(journalistEntry.get(),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND)
    }

    @DeleteMapping("/id/{myId}")
    public  ResponseEntity<?> deleteJournalById(@PathVariable ObjectId myId)
    {
        service.deleteById(myId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<?> updateJournalist(@PathVariable ObjectId id, @RequestBody Journalist myEntry) {
        Journalist old = service.getEntityById(id).orElse(null);
        if (old != null) {
            if (myEntry.getName() != null && !myEntry.getName().isEmpty()) {
                old.setName(myEntry.getName());
            }
            if (myEntry.getDescription() != null && !myEntry.getDescription().isEmpty()) {
                old.setDescription(myEntry.getDescription());
            }

            service.saveEntity(old);
            return new ResponseEntity<>(old, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
