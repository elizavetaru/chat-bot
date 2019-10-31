package by.bsu.samples.microservice.repository;

import by.bsu.samples.microservice.model.Template;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TemplateRepository extends JpaRepository<Template, Long> {

  @Override
  @Query("select new Template(t.id, t.name, t.description) from Template as t")
  List<Template> findAll();

}
