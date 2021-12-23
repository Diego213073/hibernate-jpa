package org.hibernate.app.model;


import jakarta.persistence.Embedded;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
public class SuperEntityClass {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;


}
