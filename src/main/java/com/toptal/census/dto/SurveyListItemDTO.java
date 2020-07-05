package com.toptal.census.dto;

import com.toptal.census.repo.SurveyModel;

public final class SurveyListItemDTO {
  public String id;
  public String status;
  public String slug;
  public String name;
  public String description;

  public SurveyListItemDTO() {
  }

  public SurveyListItemDTO(SurveyModel model) {
    this.id = SurveyHashId.hashId(model.getId());
    this.status = model.getStatus();
    this.slug = model.getSlug();
    this.name = model.getName();
    this.description = model.getDescription();
  }
}