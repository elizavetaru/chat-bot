package by.bsu.samples.microservice.service;

import by.bsu.samples.microservice.generic.GenericService;
import by.bsu.samples.microservice.model.TemplateItem;
import java.util.List;

public interface TemplateItemService extends GenericService<TemplateItem> {

  List<TemplateItem> findByTemplateId(Long templateId);

  void deleteByTemplateId(long templateId);
}
