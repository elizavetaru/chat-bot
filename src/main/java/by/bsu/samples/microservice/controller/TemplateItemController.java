package by.bsu.samples.microservice.controller;

import by.bsu.samples.microservice.generic.GenericController;
import by.bsu.samples.microservice.model.TemplateItem;
import by.bsu.samples.microservice.service.TemplateItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/template-items")
public class TemplateItemController extends GenericController<TemplateItem> {

  private TemplateItemService service;

  @Autowired
  public TemplateItemController(TemplateItemService service) {
    super(service);
    this.service = service;
  }
}
