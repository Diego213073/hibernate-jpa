package org.hibernate.app;

import jakarta.persistence.EntityManager;
import java.util.Arrays;
import org.hibernate.app.model.Categoria;
import org.hibernate.app.model.Cliente;
import org.hibernate.app.model.ClienteDetalle;
import org.hibernate.app.model.Direccion;
import org.hibernate.app.model.Factura;
import org.hibernate.app.service.impl.ClienteServiceImplement;
import org.hibernate.app.util.JpaUtilPersistence;
import org.hibernate.app.util.Pagos;

public class Main {

  public static void main(String arg[]) {

    EntityManager entityManager = JpaUtilPersistence.getEntityManager();

    try {

      ClienteServiceImplement clienteServiceImplement = new ClienteServiceImplement(entityManager);

      Categoria categorias = Categoria.builder().descripcion("Entretenimiento").puntos(2000).build();
      Categoria categorias2 = Categoria.builder().descripcion("Calculo").puntos(2900).build();
      Categoria categorias3 = Categoria.builder().descripcion("Diversion").puntos(2500).build();



      Cliente cliente = new Cliente("Carlos", "Revolledo", "carlosrevo202@gmail.com",
          Pagos.CREDITO.getValue());

      Cliente cliente2 = new Cliente("Fabiano", "Caruana", "fabiCarun@gmail.com",
          Pagos.CREDITO.getValue());

      Cliente cliente3 = new Cliente("Magnus", "Carlsen", "magnusC@gmail.com",
          Pagos.CREDITO.getValue());

      Arrays.asList(cliente,cliente2,cliente3)
      .stream().map(c ->{
        c.addDreccion(Direccion.builder().calle("Permitral").numero("calle 64#").build());
        c.addFactura(new Factura("Teclado mecánico", 4300L));
        Arrays.asList(categorias, categorias2, categorias3).forEach(c::addCategorias);
        int puntosAcumulados = cliente.getCategoriasList().stream().map(Categoria::getPuntos)
            .reduce(Integer::sum).get();
        c.addClienteDetalle(new ClienteDetalle(puntosAcumulados
        ));
        return c;
      }).forEach(clienteServiceImplement::save);


    } catch (Exception e) {
      entityManager.getTransaction().rollback();
      System.out.println(e.getMessage());
    } finally {
      entityManager.close();
    }

  }


}
