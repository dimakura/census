package com.toptal.census.domain.types;

public final class SurveyId extends SimpleType {
  private final Long id;

  public SurveyId(long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  @Override
  protected void validateType() {
    // nothing to validate
  }
}