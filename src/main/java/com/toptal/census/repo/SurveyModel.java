package com.toptal.census.repo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "surveys")
@SequenceGenerator(name = "surveys_seq", sequenceName = "surveys_id_seq", allocationSize = 1)
public class SurveyModel {
  public static final String STATUS_DRAFT = "draft";

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "surveys_seq")
  private long id;
  private String status;
  private String slug;
  private String name;
  private String description;

  public long getId() {
    return id;
  }

  public void setId(long id) {
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

  // public Survey toDomainModel() {
  //   // XXX: this is not cool!
  //   // if we introduce a new survey status, we should rememeber to add handler here
  //   // can we enforce this on compile time?
  //   if (STATUS_DRAFT.equals(status)) {
  //     return new DraftSurvey(new SurveyId(id), new SurveySlug(slug), new SurveyName(name),
  //         new SurveyDescription(description));
  //   } else {
  //     throw new UnsupportedOperationException("Unknown status: " + status);
  //   }
  // }
}