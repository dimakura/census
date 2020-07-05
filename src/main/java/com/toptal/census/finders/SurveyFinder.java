package com.toptal.census.finders;

import java.util.Arrays;

import javax.enterprise.context.ApplicationScoped;

import com.toptal.census.dto.SurveyListItemDTO;
import com.toptal.census.repo.SurveyRepo;

@ApplicationScoped
public class SurveyFinder {
  private SurveyRepo repo;

  SurveyFinder(SurveyRepo repo) {
    this.repo = repo;
  }

  public SurveyListItemDTO[] getSurveys() {
    var data = repo.getSurveys();
    return Arrays.stream(data).parallel()
      .map(s -> new SurveyListItemDTO(s))
      .toArray(SurveyListItemDTO[]::new);
  }
}