package org.hibernate.app.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString(exclude = "Direccion")
@EqualsAndHashCode(exclude = "Direccion")
@Getter
@Setter
@AllArgsConstructor
@Builder
@Entity
@Table(name = "clientes")
public class Cliente {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String nombre;

  private String apellido;

  @Column(name = "email")
  private String correo;

  @Column(name = "forma_pago")
  private String metodoPago;

  //CascadeType.ALL da la ventaja de no
  // crear otro método para persistir la información en la base de datos. Lo hace automático
  //Crea tabla intermedia cuando se maneja la llave foranea automaticamente
  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name ="id_cliente")
  private List<Direccion> direccionList;


  public Cliente() {
  }

}
