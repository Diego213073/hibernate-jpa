package org.hibernate.app.util;

public enum Pagos {

  DEBITO("debito"),
  CREDITO("credito");

  private final String value;

  Pagos(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
