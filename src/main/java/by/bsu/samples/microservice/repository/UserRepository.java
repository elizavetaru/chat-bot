package by.bsu.samples.microservice.repository;

import by.bsu.samples.microservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
