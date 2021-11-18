package org.hibernate.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "facturas")
public class Factura {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name ="id_factura")
  private Integer id;

  private String descripcion;

  private Long total;

  @ManyToOne
  @JoinColumn(name = "id_cliente")
  private Cliente cliente;

}
