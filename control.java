package project.example.studentManagementSystem.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.example.studentManagementSystem.entity.student;
import project.example.studentManagementSystem.exception.noResourceFound;
import project.example.studentManagementSystem.service.businessLogic;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/systemEntry")
public class control {

    @Autowired
    public businessLogic studentService;

    @GetMapping("/fetchAllStudents")
    public ResponseEntity<List<student>> getAllStudents() throws noResourceFound {
        List<student> data= studentService.getAll();

        if(data!=null && !data.isEmpty()) {
            return new ResponseEntity<>(data, HttpStatus.OK);
        }
        else{
            throw new noResourceFound("No data found");
        }
    }

    @GetMapping("/fetchStudentByRoll/{roll_no}")
    public ResponseEntity<student> fetchByRoll(@PathVariable int roll_no) throws noResourceFound{
        Optional<student> entry= studentService.getByRollNo(roll_no);

        if(entry.isPresent()){
            return new ResponseEntity<>(entry.get(),HttpStatus.OK);
        }
        else{
            throw new noResourceFound("No data found");

        }

    }


    @PostMapping("/createStudent")
    public ResponseEntity<String> createStudent(@RequestBody student temp){

        studentService.validate(temp);
        studentService.newEntry(temp);

        return new ResponseEntity<>("Entry created successfully",HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteStudent/{roll_no}")
    public ResponseEntity<String> deleteEntry(@PathVariable int roll_no) {

            studentService.deleteEntry(roll_no);

            return new ResponseEntity<>("Entry deleted successfully", HttpStatus.OK);

    }

    @PutMapping("/updateStudentEntry/{roll_no}")
    public ResponseEntity<String> updateEntry(@PathVariable int roll_no, @RequestBody student newEntry) {

        studentService.newEntry(newEntry, roll_no);

        return new ResponseEntity<>("Entry updated successfully", HttpStatus.OK);
    }

    }

