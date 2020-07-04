package com.toptal.census.domain.types;

public final class DraftSurvey {
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

  public SurveyId getId() {
    return id;
  }

  public SurveySlug getSlug() {
    return slug;
  }

  public SurveyName getName() {
    return name;
  }

  public SurveyDescription getDescription() {
    return description;
  }
}