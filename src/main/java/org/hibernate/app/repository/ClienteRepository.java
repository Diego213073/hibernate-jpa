package org.hibernate.app.repository;

import java.util.List;
import org.hibernate.app.model.Cliente;

public interface ClienteService {

  List<Cliente> findAllClientes();

  

}
