package com.toptal.census.domain.types;

public final class SurveyName extends SimpleType {
  private static final int MAX_LENGTH = 50;
  private final String name;

  public SurveyName(String name) {
    this.name = name == null ? "" : name.trim();
  }

  public String getName() {
    return name;
  }

  @Override
  protected void validateType() {
    if (name.isBlank()) {
      add("cannot be blank");
    } else if (name.length() > MAX_LENGTH) {
      add("too long");
    }
  }
}