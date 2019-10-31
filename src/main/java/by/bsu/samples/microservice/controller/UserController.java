package by.bsu.samples.microservice.controller;

import by.bsu.samples.microservice.generic.GenericController;
import by.bsu.samples.microservice.model.User;
import by.bsu.samples.microservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController extends GenericController<User> {

  @Autowired
  public UserController(UserService service) {
    super(service);
  }

}
