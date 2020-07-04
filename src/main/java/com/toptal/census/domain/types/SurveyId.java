package com.toptal.census.domain.types;

public final class SurveyId extends SimpleType {
  private final Integer id;

  public SurveyId(int id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  @Override
  protected void validateType() {
    // nothing to validate
  }
}