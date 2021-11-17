package org.hibernate.app.util;

import lombok.Getter;

@Getter
public enum Pagos {

  DEBITO("debito"),
  CREDITO("credito");

  private final String value;

  Pagos(String value) {
    this.value = value;
  }

}
