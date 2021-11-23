package org.hibernate.app.service.impl;

import jakarta.persistence.EntityManager;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.hibernate.app.model.Cliente;
import org.hibernate.app.repository.ClienteRepository;

public class ClienteServiceImplement implements ClienteRepository {

  private EntityManager entityManager;

  public ClienteServiceImplement(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Override
  public List<Cliente> findAll() {
    return entityManager.createQuery("select c from Cliente c", Cliente.class).getResultList();
  }

  @Override
  public void save(Cliente t) {
    if (Objects.isNull(t.getId())) {
      entityManager.getTransaction().begin();
      entityManager.persist(t);
      entityManager.getTransaction().commit();
    }else{
      entityManager.getTransaction().begin();
      entityManager.merge(t);
      entityManager.getTransaction().commit();
    }
  }

  @Override
  public void deleteById(Integer id) {
    Cliente cliente = get(id).orElseThrow(() -> new RuntimeException("El cliente no se encuentra en BD"));
    entityManager.getTransaction().begin();
    entityManager.remove(cliente);
    entityManager.getTransaction().commit();
  }

  @Override
  public Optional<Cliente> get(Integer id) {
    return Optional.ofNullable(entityManager.find(Cliente.class, id));
  }
}
