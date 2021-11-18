package org.hibernate.app;

import jakarta.persistence.EntityManager;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import org.hibernate.app.model.Cliente;
import org.hibernate.app.model.Direccion;
import org.hibernate.app.model.Factura;
import org.hibernate.app.util.JpaUtilPersistence;
import org.hibernate.app.util.Pagos;

public class Main {

  public static void main(String arg[]) {

    EntityManager entityManager = JpaUtilPersistence.getEntityManager();

    try {


      Direccion direccion = Direccion.builder().calle("San Francisco").numero("calle #21").build();

      Cliente cliente = getClienteById(1,entityManager).get();

      Factura factura = Factura.builder().descripcion("Libro de programación POO").cliente(cliente)
          .total(3500L)
          .build();

      cliente.getDireccionList().add(direccion);

      entityManager.getTransaction().begin();
      entityManager.merge(cliente);
      entityManager.persist(factura);
      entityManager.getTransaction().commit();
    } catch (Exception e) {
      entityManager.getTransaction().rollback();
      System.out.println(e.getMessage());
    } finally {
      entityManager.close();
    }

  }


  private static Optional<Cliente> getClienteById(Integer id, EntityManager entityManager) {
    return Optional.ofNullable(entityManager.find(Cliente.class, id));
  }

}
