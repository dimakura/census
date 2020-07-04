package com.toptal.census.domain.commands;

import com.toptal.census.domain.types.SurveyDescription;
import com.toptal.census.domain.types.SurveyName;
import com.toptal.census.domain.types.SurveySlug;
import com.toptal.census.repo.SurveyModel;

public final class CreateSurveyCommand extends BaseCommand {
  private final SurveySlug slug;
  private final SurveyName name;
  private final SurveyDescription description;

  public CreateSurveyCommand(String slug, String name, String description) {
    this.slug = new SurveySlug(slug);
    this.name = new SurveyName(name);
    this.description = new SurveyDescription(description);
  }

  @Override
  public Field[] getFields() {
    return new Field[] { new Field("slug", slug), new Field("name", name), new Field("description", description) };
  }

  public SurveyModel toModel() {
    var model = new SurveyModel();
    model.setSlug(slug.getSlug());
    model.setName(name.getName());
    model.setDescription(description.getDescription());

    return model;
  }
}