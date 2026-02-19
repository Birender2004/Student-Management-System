package project.example.studentManagementSystem.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.example.studentManagementSystem.entity.student;
import project.example.studentManagementSystem.exception.customException;
import project.example.studentManagementSystem.exception.invalidInput;
import project.example.studentManagementSystem.repository.database;
import project.example.studentManagementSystem.repository.infoDatabase;

import java.util.List;
import java.util.Optional;

@Service
public class businessLogic {

    @Autowired
    public database repo;

    @Autowired
    public infoDatabase repo_info;

    public List<student> getAll(){
       return repo.findAll();
    }

    public Optional<student> getByRollNo(int roll_no){
        return repo.findById(roll_no);
    }


    public void newEntry(student newEntry, int roll_no) {
        validate(newEntry);
        Optional<student> oldEntry = repo.findById(roll_no);

        if (oldEntry.isPresent()) {
            if (newEntry.getName() != null && newEntry.getName().length()!=0) {
                oldEntry.get().setName(newEntry.getName());
            }
            if (newEntry.getEmail() != null && newEntry.getEmail().length()!=0) {
                oldEntry.get().setEmail(newEntry.getEmail());
            }
            repo.save(oldEntry.get());
        }

        else{
            throw new customException("No such entry");
        }
    }

    public void newEntry(student newEntry){
        repo.save(newEntry);
    }

    public void deleteEntry(int roll_no){
        try {
            student data = repo.findById(roll_no).get();

            String entry_id= data.getStorage().get(0).getId();
            repo_info.deleteById(entry_id);

            repo.deleteById(roll_no);
        }
        catch (Exception e){
            throw new customException("No such entry");
        }
    }

    public void validate(student entry){
            if(entry.getName().length()==0){
                throw new invalidInput("Student name cannot be empty");
            }

            else if(entry.getEmail()!=null && entry.getEmail().contains("@")==false){
                throw new invalidInput("Invalid email");
            }
    }
}
