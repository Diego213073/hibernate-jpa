package org.hibernate.app.repository;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<T> {

  List<T> findAll();

  void save(T t);

  void deleteById(Integer id);

  Optional<T> get(Integer id);

}
