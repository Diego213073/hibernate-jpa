package org.hibernate.app;

import jakarta.persistence.EntityManager;
import java.util.Arrays;
import java.util.Optional;
import org.hibernate.app.model.Cliente;
import org.hibernate.app.model.Direccion;
import org.hibernate.app.model.Factura;
import org.hibernate.app.model.GenerarFechas;
import org.hibernate.app.util.JpaUtilPersistence;
import org.hibernate.app.util.Pagos;

public class Main {

  public static void main(String arg[]) {

    EntityManager entityManager = JpaUtilPersistence.getEntityManager();

    try {
      entityManager.getTransaction().begin();
      Direccion direccion = Direccion.builder().calle("El posón").numero("calle 54#").build();
      Direccion direccion2 = Direccion.builder().calle("San Francisco").numero("calle A64").build();

      Cliente cliente = new Cliente("Diego", "Roble", "Diegoalejandrorobles@gamil.com",
          Pagos.DEBITO.getValue());
      cliente.getDireccionList().add(direccion);
      cliente.getDireccionList().add(direccion2);

      Factura factura = Factura.builder().descripcion("Libro de programación POO")
          .total(3500L)
          .build();
      cliente.addFactura(factura);

      entityManager.persist(cliente);
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
