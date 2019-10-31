package by.bsu.samples.microservice.generic;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public interface GenericService<T extends Serializable> {

  T findById(Long id);

  List<T> list();

  T create(T item);

  Collection<T> saveEntities(Collection<T> entities);

  T update(T item);

  void delete(Long id);

  void deleteEntities(Collection<T> entities);
}

