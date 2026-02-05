package project.example.studentManagementSystem.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "Student")
@Data
public class student {

    @Id
    int roll_no;
    String name;
    String email;

    @DBRef
    List<studentInfo> storage= new ArrayList<>();

}
