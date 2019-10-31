package by.bsu.samples.microservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "car")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Car implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(name = "feature_id", nullable = false)
    private Long featureId;

    @NotEmpty
    @Column(name = "value", nullable = false)
    private String value;

    @NotEmpty
    @Column(name = "link", nullable = false)
    private String link;

    public Car(String link) {
        this.link = link;
    }

    public String getLink() {
        return link;
    }
}
