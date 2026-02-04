package project.example.studentManagementSystem.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.example.studentManagementSystem.entity.studentInfo;
import project.example.studentManagementSystem.service.infoService;

@RestController
@RequestMapping("/info")
public class infoController {

    @Autowired
    public infoService service;


    @GetMapping("/get/{id}")
    public ResponseEntity<studentInfo> fetchInfo(@PathVariable String id){
        studentInfo local=service.get(id);

        return new ResponseEntity<>(local, HttpStatus.OK);
    }

    @PostMapping("/create/{roll_no}")
    public ResponseEntity<String> createInfo(@RequestBody studentInfo newEntry, @PathVariable int roll_no){
        service.create(newEntry,roll_no);

        return new ResponseEntity<>("Data entered successfully", HttpStatus.CREATED);
    }
}
