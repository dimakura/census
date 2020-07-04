package com.toptal.census.functional;

public interface Validable {
  boolean isValid();

  ValidationError[] getErrors();
}