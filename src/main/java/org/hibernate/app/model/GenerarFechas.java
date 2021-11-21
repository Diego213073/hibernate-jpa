package org.hibernate.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import java.time.LocalDateTime;
import lombok.Getter;

@Getter
@Embeddable
public class GenerarFechas {

  @Column(name ="fecha_creacion")
  private LocalDateTime fechaCreacion;

  @Column(name ="fecha_modificacion")
  private LocalDateTime fechaModificacion;


  @PrePersist
  public void insertFechaCreacion(){
    fechaCreacion = LocalDateTime.now();
  }

  @PreUpdate
  public void insertFechaModifiacion(){
    fechaModificacion = LocalDateTime.now();
  }

}
