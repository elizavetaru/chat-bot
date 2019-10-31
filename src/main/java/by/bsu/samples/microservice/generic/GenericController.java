package by.bsu.samples.microservice.generic;

import java.io.Serializable;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

public abstract class GenericController<T extends Serializable> {

  private final GenericService<T> service;

  protected GenericController(GenericService<T> service) {
    this.service = service;
  }

  @GetMapping
  public List<T> list() {
    return service.list();
  }

  @GetMapping("/{id}")
  public T get(@PathVariable Long id) {
    return service.findById(id);
  }

  @PostMapping
  public T create(@RequestBody T item) {
    return service.create(item);
  }

  @PutMapping
  public T update(@RequestBody T item) {
    return service.update(item);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    service.delete(id);
  }



}
