package by.bsu.samples.microservice.service;

import by.bsu.samples.microservice.generic.GenericServiceImpl;
import by.bsu.samples.microservice.model.User;
import by.bsu.samples.microservice.repository.UserRepository;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service("userService")
@Transactional
public class UserServiceImpl extends GenericServiceImpl<User> implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Override
  protected JpaRepository<User, Long> getRepository() {
    return userRepository;
  }
}
