package com.toptal.census.domain.types;

import java.util.ArrayList;
import java.util.List;

import com.toptal.census.functional.Validable;
import com.toptal.census.functional.ValidationError;

abstract class SimpleType implements Validable {
  private final List<ValidationError> errors = new ArrayList<>();
  private boolean validated;

  @Override
  public final boolean isValid() {
    if (!validated)
      validate();
    return errors.isEmpty();
  }

  @Override
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

  protected final void validate() {
    errors.clear();
    validateType();
    validated = true;
  }

  protected abstract void validateType();
}