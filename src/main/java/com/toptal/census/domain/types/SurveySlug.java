package com.toptal.census.domain.types;

public final class SurveySlug extends SimpleType {
  private static final String SLUG_REGEXP = "[a-z][a-z0-9_]{0,49}";
  private final String slug;

  public SurveySlug(String slug) {
    this.slug = slug == null ? "" : slug.trim().toLowerCase();
  }

  public String getSlug() {
    return slug;
  }

  @Override
  protected void validateType() {
    if (slug.isBlank()) {
      add("cannot be blank");
    } else if (!slug.matches(SLUG_REGEXP)) {
      add("wrong format");
    }
  }
}