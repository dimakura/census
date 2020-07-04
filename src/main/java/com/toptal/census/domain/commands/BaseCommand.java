package com.toptal.census.domain.commands;

import java.util.ArrayList;
import java.util.List;

import com.toptal.census.functional.Validable;
import com.toptal.census.functional.ValidationError;

public abstract class BaseCommand implements Validable {
  public abstract Field[] getFields();

  @Override
  public boolean isValid() {
    for (var field : getFields()) {
      if (!field.getValue().isValid())
        return false;
    }

    return true;
  }

  @Override
  public ValidationError[] getErrors() {
    List<ValidationError> errors = new ArrayList<>();
    for (var field : getFields()) {
      for (var error : field.getValue().getErrors()) {
        errors.add(error.toField(field.getName()));
      }
    }

    return errors.toArray(new ValidationError[0]);
  }
}