package com.toptal.census.domain.types;

public interface Survey {
  SurveyId getId();

  SurveySlug getSlug();

  SurveyName getName();

  SurveyDescription getDescription();
}