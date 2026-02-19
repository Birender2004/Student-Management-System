package project.example.studentManagementSystem.entity;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @NotNull(message = "Location is required")
    @NotBlank(message = "Location is required")
    String location;

    List<String> skills= new ArrayList<>();
    List<String> hobbies= new ArrayList<>();

}
