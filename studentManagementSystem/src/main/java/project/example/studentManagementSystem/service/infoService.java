package project.example.studentManagementSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.example.studentManagementSystem.entity.student;
import project.example.studentManagementSystem.entity.studentInfo;
import project.example.studentManagementSystem.exception.customException;
import project.example.studentManagementSystem.exception.invalidInput;
import project.example.studentManagementSystem.repository.infoDatabase;

import java.util.Optional;

@Service
public class infoService {

    @Autowired
    public infoDatabase repo;

    @Autowired
    public businessLogic parentService;

    public studentInfo get(String id){
        Optional<studentInfo> data= repo.findById(id);

        if(data.isPresent()) return data.get();

        throw new customException("No such entry exists");
    }

    public void create(studentInfo temp, int roll_no){


            try {
                student entry = parentService.getByRollNo(roll_no).get();
                entry.getStorage().add(temp);

                parentService.newEntry(entry);
                repo.save(temp);
            }

        catch (Exception e){
            throw new invalidInput("Invalid Input");
        }
    }
}
