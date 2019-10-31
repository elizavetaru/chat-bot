package by.bsu.samples.microservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "APP_USER")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotEmpty
  @Column(name = "NAME", nullable = false)
  private String name;

  @NotEmpty
  @Column(name = "PASSWORD", nullable = false)
  private String password;

  @NotEmpty
  @Column(name = "ROLE", nullable = false)
  private String role;

  @NotEmpty
  @Column(name = "ENABLE", nullable = false)
  private boolean enable;

}
