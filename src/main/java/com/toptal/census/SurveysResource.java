package com.toptal.census;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.toptal.census.dto.SurveyListItemDTO;
import com.toptal.census.finders.SurveyFinder;
import com.toptal.census.services.SurveyCreateInput;
import com.toptal.census.services.SurveyService;

@Path("/surveys")
@Produces(MediaType.APPLICATION_JSON)
public class SurveysResource {
  @Inject
  SurveyFinder finder;

  @Inject
  SurveyService service;

  @GET
  public SurveyListItemDTO[] index() {
    return finder.getSurveys();
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  public Response create(SurveyCreateInput input) {
    var command = input.toCommand();
    var result = service.create(command);
    var builder = result.isSuccess() ? Response.ok(result.getSuccess()) : Response.status(Response.Status.BAD_REQUEST).entity(result.getError());
    return builder.build();
  }
}