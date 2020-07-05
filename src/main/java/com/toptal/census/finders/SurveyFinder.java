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
    return Arrays.stream(repo.getSurveys()).parallel().map(s -> new SurveyListItemDTO(s)).sequential()
        .toArray(SurveyListItemDTO[]::new);
  }
}