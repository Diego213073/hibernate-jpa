package org.hibernate.app.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name ="categorias")
public class Categoria {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String descripcion;

  private Integer puntos;


  @ManyToMany(mappedBy = "categoriasList")
  private List<Cliente> clienteList;

  public Categoria(String descripcion, Integer puntos) {
    this.descripcion = descripcion;
    this.puntos = puntos;
    this.clienteList = new ArrayList<>();
  }
}
