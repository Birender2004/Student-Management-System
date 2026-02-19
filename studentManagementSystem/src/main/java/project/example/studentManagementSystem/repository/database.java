package project.example.studentManagementSystem.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import project.example.studentManagementSystem.entity.student;

@Repository
@Component
public interface database extends MongoRepository<student, Integer> {

}
