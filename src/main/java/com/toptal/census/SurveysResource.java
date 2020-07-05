package com.toptal.census;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.toptal.census.dto.SurveyListItemDTO;
import com.toptal.census.finders.SurveyFinder;

@Path("/surveys")
public class SurveysResource {
  @Inject
  SurveyFinder finder;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public SurveyListItemDTO[] index() {
    return finder.getSurveys();
  }
}