package project.example.studentManagementSystem.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "Info")
@Data
public class studentInfo {

    @Id
    String id;

    int TGPA;
    String location;

    List<String> skills= new ArrayList<>();
    List<String> hobbies= new ArrayList<>();

}
