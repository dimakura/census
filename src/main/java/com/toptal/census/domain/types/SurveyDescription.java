package com.toptal.census.domain.types;

public final class SurveyDescription extends SimpleType {
  private final String description;

  public SurveyDescription(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }

  @Override
  protected void validateType() {
    // nothing to validate
  }
}