package by.bsu.samples.microservice.exceptions;

import java.util.List;
import org.springframework.http.HttpStatus;

public class BadRequestException extends GeneralException {

  public BadRequestException(String message) {
    super(message, HttpStatus.BAD_REQUEST);
  }

  public BadRequestException(List<String> messages) {
    super(messages, HttpStatus.BAD_REQUEST);
  }

  public BadRequestException(Exception ex) {
    this(ex.getMessage());
  }

}
