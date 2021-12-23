package org.hibernate.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "facturas")
public class Factura extends SuperEntityClass{

  private String descripcion;

  private Long total;

  @ManyToOne
  @JoinColumn(name = "id_cliente")
  private Cliente cliente;

  @Embedded
  private GenerarFechas generarFechas = new GenerarFechas();

  public Factura(){

  }


  public Factura(String descripcion, Long total){
    this.descripcion = descripcion;
    this.total = total;
  }

}
