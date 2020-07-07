package com.toptal.census.services;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import com.toptal.census.domain.commands.CreateSurveyCommand;
import com.toptal.census.dto.SurveyListItemDTO;
import com.toptal.census.functional.Result;
import com.toptal.census.functional.ValidationError;
import com.toptal.census.repo.SurveyRepo;

@ApplicationScoped
public class SurveyService {
  private SurveyRepo repo;

  SurveyService(SurveyRepo repo) {
    this.repo = repo;
  }

  @Transactional
  public Result<SurveyListItemDTO, ValidationError[]> create(CreateSurveyCommand command) {
    if (command.isValid()) {
      var model = command.toModel();
      repo.create(model);
      return Result.of(new SurveyListItemDTO(model));
    } else {
      return Result.error(command.getErrors());
    }
  }
}