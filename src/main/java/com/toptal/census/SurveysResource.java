package com.toptal.census;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.toptal.census.domain.types.Survey;
import com.toptal.census.finders.SurveyFinderImpl;

@Path("/surveys")
public class SurveysResource {
  @Inject
  SurveyFinderImpl finder;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Survey[] index() {
    return finder.getSurveys();
  }
}