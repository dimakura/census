package com.toptal.census.domain.types;

import java.util.ArrayList;
import java.util.List;

abstract class SimpleType {
  private final List<ValidationError> errors = new ArrayList<>();
  private boolean validated;

  public final ValidationError[] getErrors() {
    if (!validated)
      validate();
    return errors.toArray(new ValidationError[0]);
  }

  protected final void add(ValidationError error) {
    errors.add(error);
  }

  protected final void add(String errorMessage) {
    this.add(new ValidationError(errorMessage));
  }

  public final boolean isValid() {
    if (!validated)
      validate();
    return errors.isEmpty();
  }

  protected final void validate() {
    errors.clear();
    validateType();
    validated = true;
  }

  protected abstract void validateType();
}