package org.hibernate.app.service;

import java.util.List;
import java.util.Optional;
import org.hibernate.app.model.Cliente;

public interface ClienteService {

  List<Cliente> findAll();

  void save(Cliente cliente);

  void deleteById(Integer id);

  Optional<Cliente> get(Integer id);

}
