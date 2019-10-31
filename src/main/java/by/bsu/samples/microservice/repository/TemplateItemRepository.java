package by.bsu.samples.microservice.repository;

import by.bsu.samples.microservice.model.TemplateItem;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemplateItemRepository extends JpaRepository<TemplateItem, Long> {

  List<TemplateItem> findByTemplateIdOrderByOrder(long templateId);
}
