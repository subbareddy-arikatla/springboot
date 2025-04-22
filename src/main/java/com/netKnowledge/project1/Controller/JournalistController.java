//package com.netKnowledge.project1.Controller;
//
//import com.netKnowledge.project1.Model.Journalist;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/journal")
//public class JournalistController {
//
//    private final Map<Long, Journalist> journalistEntries = new HashMap<>();
//
//    @GetMapping
//    public List<Journalist> getAll() {
//        return new ArrayList<>(journalistEntries.values());
//    }
//
//    @PostMapping
//    public boolean createEntry(@RequestBody Journalist myEntry) {
//        journalistEntries.put(myEntry.getMyid(), myEntry);
//        return true;
//    }
//
//    @GetMapping("/id/{myId}")
//    public Journalist getJournalById(@PathVariable Long myId) {
//        return journalistEntries.get(myId);
//    }
//
//    @DeleteMapping("/id/{myId}")
//    public Journalist deleteJournalById(@PathVariable Long myId) {
//        return journalistEntries.remove(myId);
//    }
//
//    @PutMapping("/id/{id}")
//    public Journalist updateJournalist(@PathVariable Long id, @RequestBody Journalist myEntry) {
//        return journalistEntries.put(id, myEntry);
//    }
//}
