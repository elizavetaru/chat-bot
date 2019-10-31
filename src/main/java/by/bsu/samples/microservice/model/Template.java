package by.bsu.samples.microservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TEMPLATE")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Template implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotEmpty
  @Column(name = "NAME", nullable = false)
  private String name;

  @NotEmpty
  @Column(name = "DESCRIPTION", nullable = false)
  private String description;

  @OneToMany(targetEntity = TemplateItem.class, mappedBy = "templateId", cascade = CascadeType.ALL)
  private List<TemplateItem> items;

  public Template(Long id, String name, String description) {
    this.id = id;
    this.name = name;
    this.description = description;
  }

}