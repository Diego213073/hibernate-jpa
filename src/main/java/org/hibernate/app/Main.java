package org.hibernate.app;

import jakarta.persistence.EntityManager;
import org.hibernate.app.model.Cliente;
import org.hibernate.app.model.Factura;
import org.hibernate.app.util.JpaUtilPersistence;
import org.hibernate.app.util.Pagos;

public class Main {

  public static void main(String arg[]) {

    EntityManager entityManager = JpaUtilPersistence.getEntityManager();

    try {
      entityManager.getTransaction().begin();
      Cliente cliente = Cliente.builder().nombre("Diego").apellido("Alejandro").metodoPago(Pagos.CREDITO.getValue())
          .correo("diegorobles@gamil.com").build();
      entityManager.persist(cliente);
      Factura factura = Factura.builder().descripcion("Xioami Redmit note pro").cliente(cliente).total(5000L)
          .build();
      entityManager.persist(factura);
      entityManager.getTransaction().commit();
    } catch (Exception e) {
      entityManager.getTransaction().rollback();
      System.out.println(e.getMessage());
    } finally {
      entityManager.close();
    }

  }

}
