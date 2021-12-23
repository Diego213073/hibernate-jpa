package org.hibernate.app.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "clientes")

public class Cliente extends SuperEntityClass{

  private String nombre;

  private String apellido;

  @Column(name = "email")
  private String correo;

  @Column(name = "forma_pago")
  private String metodoPago;

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinTable(name = "clientes_direcciones", joinColumns = @JoinColumn(name = "id_cliente"),
      inverseJoinColumns = @JoinColumn(name = "id_direccion"),
      uniqueConstraints = @UniqueConstraint(columnNames = {
          "id_direccion"}))
  private List<Direccion> direccionList;

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "cliente")
  private List<Factura> facturaList;

  @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "cliente")
  private ClienteDetalle clienteDetalle;

  @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  @JoinTable(name = "clientes_categorias", joinColumns = @JoinColumn(name = "id_cliente"),
      inverseJoinColumns = @JoinColumn(name = "id_categoria"), uniqueConstraints = @UniqueConstraint(columnNames = {
      "id_cliente", "id_categoria"}))
  private List<Categoria> categoriasList;

  public Cliente() {
    direccionList = new ArrayList<>();
    facturaList = new ArrayList<>();
    categoriasList = new ArrayList<>();
  }

  public Cliente(String nombre, String apellido, String correo, String metodoPago) {
    this();
    this.nombre = nombre;
    this.apellido = apellido;
    this.correo = correo;
    this.metodoPago = metodoPago;
  }


  public void addClienteDetalle(ClienteDetalle clienteDetalle) {
    this.setClienteDetalle(clienteDetalle);
    clienteDetalle.setCliente(this);
  }

  public void addFactura(Factura factura) {
    this.facturaList.add(factura);
    factura.setCliente(this);
  }

  public void addCategorias(Categoria categorias) {
    this.categoriasList.add(categorias);
    categorias.getClienteList().add(this);
  }

  public void addDreccion(Direccion direccion) {
    this.direccionList.add(direccion);
  }

}
