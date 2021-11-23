package org.hibernate.app;

import jakarta.persistence.EntityManager;
import java.util.Optional;
import org.hibernate.app.model.Cliente;
import org.hibernate.app.model.ClienteDetalle;
import org.hibernate.app.model.Direccion;
import org.hibernate.app.model.Factura;
import org.hibernate.app.util.JpaUtilPersistence;
import org.hibernate.app.util.Pagos;

public class Main {

  public static void main(String arg[]) {

    EntityManager entityManager = JpaUtilPersistence.getEntityManager();

    try {
      entityManager.getTransaction().begin();

      Cliente cliente = new Cliente("Carlos", "Revolledo", "carlosrevo202@gmail.com", Pagos.CREDITO.getValue());

      cliente.addDreccion(Direccion.builder().calle("Permitral").numero("calle 64#").build());
      cliente.addClienteDetalle(new ClienteDetalle(5000));
      cliente.addFactura(new Factura("Teclado mecánico", 4300L));

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
