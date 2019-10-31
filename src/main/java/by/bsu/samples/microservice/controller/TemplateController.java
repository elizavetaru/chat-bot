package by.bsu.samples.microservice.controller;

import by.bsu.samples.microservice.generic.GenericController;
import by.bsu.samples.microservice.model.Template;
import by.bsu.samples.microservice.model.TemplateItem;
import by.bsu.samples.microservice.service.TemplateItemService;
import by.bsu.samples.microservice.service.TemplateService;
import io.micrometer.core.annotation.Timed;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Timed
@RestController
@RequestMapping("/api/v1/templates")
public class TemplateController extends GenericController<Template> {

  @Autowired
  private TemplateItemService templateItemService;

  @Autowired
  private TemplateService templateService;

  @Autowired
  public TemplateController(TemplateService service) {
    super(service);
  }

  @Timed
  @RequestMapping(value = "/{id}/items")
  public List<TemplateItem> getTemplateItems(@PathVariable Long id) {
    return templateItemService.findByTemplateId(id);
  }

  @PostMapping(value = "/items")
  public List<TemplateItem> setTemplateItems(@RequestBody List<TemplateItem> templateItems) {
    return (List<TemplateItem>) templateItemService.saveEntities(templateItems);
  }
}
