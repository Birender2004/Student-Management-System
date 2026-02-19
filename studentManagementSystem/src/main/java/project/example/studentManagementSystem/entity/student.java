package project.example.studentManagementSystem.entity;


import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "Student")
@Data
public class student {

    @Valid

    @Id
    @Range(min=1, max=50, message = "Invalid roll_no range")
    int roll_no;

    @NotBlank(message = "Name cannot be blank")
    @Size(min=4, max=10, message = "Invalid name size")
    String name;

    @Email(message = "Invalid email")
    String email;

    @DBRef
    List<studentInfo> storage= new ArrayList<>();

}
