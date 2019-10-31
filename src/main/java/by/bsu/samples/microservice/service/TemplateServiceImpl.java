package by.bsu.samples.microservice.service;

import by.bsu.samples.microservice.generic.GenericServiceImpl;
import by.bsu.samples.microservice.model.Template;
import by.bsu.samples.microservice.repository.TemplateRepository;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("templateService")
@Transactional
public class TemplateServiceImpl extends GenericServiceImpl<Template> implements TemplateService {

  @Autowired
  private TemplateRepository templateRepository;

  @Override
  protected JpaRepository<Template, Long> getRepository() {
    return templateRepository;
  }

}
