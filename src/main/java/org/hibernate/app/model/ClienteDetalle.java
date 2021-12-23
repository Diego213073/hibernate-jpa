package org.hibernate.app.model;


import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "clientes_detalle")
public class ClienteDetalle extends SuperEntityClass{


  @Column(name = "puntos_acumulados")
  private Integer puntosAcumulados;

  @OneToOne
  @JoinColumn(name = "id_cliente")
  private Cliente cliente;

  @Embedded
  private GenerarFechas generarFechas = new GenerarFechas();

  public ClienteDetalle() {

  }


  public ClienteDetalle(Integer puntosAcumulados) {
    this.puntosAcumulados = puntosAcumulados;
  }
}
