package com.toptal.census.finders;

import javax.enterprise.context.ApplicationScoped;

import com.toptal.census.domain.types.Survey;

@ApplicationScoped
public class SurveyFinderImpl {
  // TODO: constructor to inject deps
  // https://quarkus.io/guides/cdi-reference#simplified-constructor-injection
  // SurveyFinder(SurveyRepo repo) {}

  // TODO: use serializable surveys in output (special type for this?)
  public Survey[] getSurveys() {
    // TODO: use repo to find real surveys
    return new Survey[0];
  }
}