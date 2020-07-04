package com.toptal.census.domain.types;

public final class ValidationError {
  private final String message;

  public ValidationError(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}