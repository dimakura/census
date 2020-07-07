package com.toptal.census.services;

import com.toptal.census.domain.commands.CreateSurveyCommand;

public class SurveyCreateInput {
  public String slug;
  public String name;
  public String description;

  public SurveyCreateInput() {
  }

  public CreateSurveyCommand toCommand() {
    return new CreateSurveyCommand(slug, name, description);
  }
}