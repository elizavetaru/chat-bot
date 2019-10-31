package by.bsu.samples.microservice.exceptions;

import java.util.List;
import org.springframework.http.HttpStatus;

public class GeneralException extends Exception {

  private HttpStatus httpStatus;
  private List<String> messages;

  public GeneralException(String message, HttpStatus httpStatus) {
    super(message);
    this.httpStatus = httpStatus;
  }

  public GeneralException(List<String> messages, HttpStatus httpStatus) {
    this.messages = messages;
    this.httpStatus = httpStatus;
  }

  public GeneralException(String message) {
    super(message);
  }

  @Override
  public String toString() {
    if (messages != null && messages.size() > 0) {
      return "{\"code\" : \"" + httpStatus.value()
          + "\", \"message\" : [\"" + messages.stream()
          .reduce((firstMessage, secondMessage) ->
              firstMessage + "\", \"" + secondMessage)
          .orElse("")
          + "\"]}";
    }

    String message = this.getMessage();
    if (message == null) {
      message = "";
    }
    return "{\"code\" : \"" + httpStatus.value()
        + "\", \"message\" : \"" + message
        + "\"}";
  }

}
