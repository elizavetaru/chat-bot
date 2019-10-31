package by.bsu.samples.microservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "TEMPLATE_ITEM")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TemplateItem implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "TEMPLATE_ID", nullable = false)
  private Long templateId;

  @Column(name = "ITEM_ORDER", nullable = false)
  private Double order;

}