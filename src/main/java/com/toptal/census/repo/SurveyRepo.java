package com.toptal.census.repo;

public interface SurveyRepo {
  SurveyModel[] getSurveys();

  void create(SurveyModel survey);
}