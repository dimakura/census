package com.toptal.census.domain.commands;

import com.toptal.census.functional.Validable;

public final class Field {
  private String name;
  private Validable value;

  public Field(String name, Validable value) {
    this.name = name;
    this.value = value;
  }

  public String getName() {
    return name;
  }

  public Validable getValue() {
    return value;
  }
}