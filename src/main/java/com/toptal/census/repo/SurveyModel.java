package com.toptal.census.repo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.toptal.census.domain.types.DraftSurvey;
import com.toptal.census.domain.types.Survey;
import com.toptal.census.domain.types.SurveyDescription;
import com.toptal.census.domain.types.SurveyId;
import com.toptal.census.domain.types.SurveyName;
import com.toptal.census.domain.types.SurveySlug;
import com.toptal.census.functional.Result;

@Entity
@Table(name = "surveys")
@SequenceGenerator(name = "surveys_seq", sequenceName = "surveys_id_seq", allocationSize = 1)
public class SurveyModel {
  public static final String STATUS_DRAFT = "draft";

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "surveys_seq")
  private int id;
  private String status;
  private String slug;
  private String name;
  private String description;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getSlug() {
    return slug;
  }

  public void setSlug(String slug) {
    this.slug = slug;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Result<Survey, String> toDomainModel() {
    if (STATUS_DRAFT.equals(status)) {
      var survey = new DraftSurvey(new SurveyId(id), new SurveySlug(slug), new SurveyName(name),
          new SurveyDescription(description));
      return Result.of(survey);
    } else {
      return Result.error("Unknown survey status: " + status);
    }
  }
}