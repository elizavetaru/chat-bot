package by.bsu.samples.microservice.service;

import by.bsu.samples.microservice.generic.GenericServiceImpl;
import by.bsu.samples.microservice.model.TemplateItem;
import by.bsu.samples.microservice.repository.TemplateItemRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("templateItemService")
@Transactional
public class TemplateItemServiceImpl extends GenericServiceImpl<TemplateItem> implements
    TemplateItemService {

  @Autowired
  private TemplateItemRepository templateItemRepository;

  @Override
  protected JpaRepository<TemplateItem, Long> getRepository() {
    return templateItemRepository;
  }

  @Override
  public List<TemplateItem> findByTemplateId(Long templateId) {
    return templateItemRepository.findByTemplateIdOrderByOrder(templateId);
  }

  @Override
  public void deleteByTemplateId(long templateId) {
    getRepository().deleteById(templateId);
  }
}
