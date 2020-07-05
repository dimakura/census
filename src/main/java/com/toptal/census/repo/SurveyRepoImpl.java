package com.toptal.census.repo;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public final class SurveyRepoImpl implements SurveyRepo {
  @Inject
  EntityManager em;

  @Override
  public SurveyModel[] getSurveys() {
    var q = em.createQuery("SELECT s FROM SurveyModel s ORDER BY s.id", SurveyModel.class);
    return q.getResultList().toArray(new SurveyModel[0]);
  }

  @Override
  public void create(SurveyModel survey) {
    em.persist(survey);
  }
}