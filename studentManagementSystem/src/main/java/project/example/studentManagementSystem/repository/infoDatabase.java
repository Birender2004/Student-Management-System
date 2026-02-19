package project.example.studentManagementSystem.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import project.example.studentManagementSystem.entity.studentInfo;

@Repository
public interface infoDatabase extends MongoRepository<studentInfo, String> {

}
