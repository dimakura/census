package com.toptal.census.functional;

import java.util.Optional;

public final class ValidationError {
  private final Optional<String> field;
  private final String message;

  public ValidationError(String message) {
    this.field = Optional.empty();
    this.message = message;
  }

  public ValidationError(String field, String message) {
    this.field = Optional.of(field);
    this.message = message;
  }

  public Optional<String> getField() {
    return field;
  }

  public String getMessage() {
    return message;
  }

  public ValidationError toField(String field) {
    return new ValidationError(field, message);
  }
}