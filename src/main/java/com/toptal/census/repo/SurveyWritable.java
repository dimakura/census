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
public class SurveyWritable {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "surveys_seq")
  private int id;
  private String status;
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
}