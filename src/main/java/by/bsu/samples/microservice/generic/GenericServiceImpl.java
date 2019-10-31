package by.bsu.samples.microservice.generic;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = false)
public abstract class GenericServiceImpl<T extends Serializable> implements GenericService<T> {

  @Override
  public T findById(Long id) {
    return getRepository().getOne(id);
  }

  @Override
  public List<T> list() {
    return getRepository().findAll();
  }

  @Override
  @Transactional
  public T create(T item) {
    return getRepository().save(item);
  }

  @Override
  @Transactional
  public Collection<T> saveEntities(Collection<T> entities) {
    return getRepository().saveAll(entities);
  }

  @Override
  @Transactional
  public T update(T item) {
    return getRepository().saveAndFlush(item);
  }

  @Override
  @Transactional
  public void delete(Long id) {
    getRepository().deleteById(id);
  }

  @Override
  @Transactional
  public void deleteEntities(Collection<T> entities) {
    getRepository().deleteAll();
  }

  protected abstract JpaRepository<T, Long> getRepository();
}
