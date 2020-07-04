package com.toptal.census.domain.types;

public final class DraftSurvey implements Survey {
  private final SurveyId id;
  private final SurveySlug slug;
  private final SurveyName name;
  private final SurveyDescription description;

  public DraftSurvey(SurveyId id, SurveySlug slug, SurveyName name, SurveyDescription description) {
    this.id = id;
    this.slug = slug;
    this.name = name;
    this.description = description;
  }

  @Override
  public SurveyId getId() {
    return id;
  }

  @Override
  public SurveySlug getSlug() {
    return slug;
  }

  @Override
  public SurveyName getName() {
    return name;
  }

  @Override
  public SurveyDescription getDescription() {
    return description;
  }
}